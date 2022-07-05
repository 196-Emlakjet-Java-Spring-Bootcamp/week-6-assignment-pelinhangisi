package com.pelinhangisi.userauthservice.controller;


import com.pelinhangisi.userauthservice.entity.User;
import com.pelinhangisi.userauthservice.service.AuthenticationService;
import com.pelinhangisi.userauthservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private AuthenticationService authenticationService;
    private UserService userService;


    //Kullanıcı kayıt yaptırırken ismini girdiğinde daha önceden var ise bunu belirten, eğer yeni bir kullanıcı ise
    //yeni bir kullanıcı oluşturup kaydeden bölüm.
    @PostMapping("/signup")
    public ResponseEntity<?> signUp(User user){
        if(userService.findByUserName(user.getUsername()).isPresent()){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity<>(UserService.saveUser(user), HttpStatus.CREATED);
        }
    }

    //Kullanıcı giriş yaptığında kullanıcıya token döndüren bölüm.
    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody User user){
        return new ResponseEntity<>(authenticationService.signInAndReturnJWT(user), HttpStatus.OK);
    }




}
