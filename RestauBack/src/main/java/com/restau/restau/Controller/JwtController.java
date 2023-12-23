package com.restau.restau.Controller;

import com.restau.restau.Model.JwtRequest;
import com.restau.restau.Model.JwtResponse;
import com.restau.restau.Model.Role;
import com.restau.restau.Services.JwtService;
import com.restau.restau.Services.RoleService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin("http://localhost:4200")
@RestController
public class JwtController {

    @Autowired
    private JwtService jwtService;

    @PostMapping("/Authenticate")
    public JwtResponse CreateJwtToken(@RequestBody JwtRequest jwtRequest)throws  Exception{
        return jwtService.createJwtToken(jwtRequest);
    }

}
