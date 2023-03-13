package com.dehghan.controller;

import com.dehghan.model.UserEntity;
import com.dehghan.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;

    }

    @GetMapping
    public List<UserEntity> getAllUsers(){
        return userService.getAllUser();

    }

    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity newUser){ /**gelen istekteki(bodydeki ) bilgileri User Objesine map et
     ve bana user objesini dön*/
        return userService.saveOneUser(newUser);
    }

    @PutMapping("/{userId}")
    public UserEntity updateOneUser(@PathVariable Long uId, @RequestBody UserEntity newUser){

        /**Ben sana bir userId ve bir yeni user verecem bunu update et*/
        return userService.updateOneUser(uId, newUser);

    }
    @DeleteMapping("/{userId}")
    //Sadece Id'sını aldığı kişiyi silecek
    public void deleteOneUser(@PathVariable Long uId){

        userService.deleteById(uId);
    }

}
