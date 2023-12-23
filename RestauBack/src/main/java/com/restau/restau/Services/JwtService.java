package com.restau.restau.Services;


import com.restau.restau.Dao.LivreurDao;
import com.restau.restau.Dao.OwnerDao;
import com.restau.restau.Dao.UserDao;
import com.restau.restau.Model.*;
import com.restau.restau.Utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class JwtService implements UserDetailsService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private LivreurDao livreurDao;
    @Autowired
    private OwnerDao ownerDao;
    @Autowired
    private AuthenticationManager authenticationManager;

    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
        String userName = jwtRequest.getUserName();
        String userPassword = jwtRequest.getUserPassword();
        authenticate(userName, userPassword);
        final  UserDetails userDetails = loadUserByUsername(userName);
        String newGeneratedToken = jwtUtil.generateToken(userDetails);
               /* User user = userDao.findById(userName).get();
                return new JwtResponse(user,newGeneratedToken);
                */
                Owner owner = ownerDao.findById(userName).get();
                return new JwtResponse(owner,newGeneratedToken);



        /*
        Livreur livreur = livreurDao.findById(userName).get();
                return new JwtResponse(livreur,newGeneratedToken);
         */
    }

    @Override
    public UserDetails loadUserByUsername(String username){

          /* User user=userDao.findById(username).get();
           return new org.springframework.security.core.userdetails.User(user.getUsername(),
                   user.getMotpasse(),
                   getAuthoroties(user));
*/
        Owner owner=ownerDao.findById(username).get();
        return new org.springframework.security.core.userdetails.User(owner.getUsername(),
                owner.getMotpasse(),
                getAuthorotiesown(owner));



        /*
        Livreur livreur=livreurDao.findById(username).get();
        return new org.springframework.security.core.userdetails.User(livreur.getUsername(),
                livreur.getMotpasse(),
                getAuthorotiesLiv(livreur));
                */

       }

    private Set<SimpleGrantedAuthority> getAuthoroties(User user) {
        Set<SimpleGrantedAuthority> authoroties = new HashSet<>();
        user.getRole().forEach(role -> {
          authoroties.add(new SimpleGrantedAuthority("ROLE_"+role.getNom()))  ;
        });
        return authoroties;
    }

    private Set<SimpleGrantedAuthority> getAuthorotiesown(Owner user) {
        Set<SimpleGrantedAuthority> authoroties = new HashSet<>();
        user.getRole().forEach(role -> {
            authoroties.add(new SimpleGrantedAuthority("ROLE_"+role.getNom()))  ;
        });
        return authoroties;
    }

    private Set<SimpleGrantedAuthority> getAuthorotiesLiv(Livreur livreur) {
        Set<SimpleGrantedAuthority> authoroties = new HashSet<>();
        livreur.getRole().forEach(role -> {
            authoroties.add(new SimpleGrantedAuthority("ROLE_"+role.getNom()))  ;
        });
        return authoroties;
    }

    private void authenticate(String userName, String userPassword) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, userPassword));
        } catch (DisabledException e) {
            throw new Exception("user is disabled");
        } catch (BadCredentialsException e) {
            throw new Exception("Bad credential from user");
        }
    }
}