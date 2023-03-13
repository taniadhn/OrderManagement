package com.dehghan.service;

import com.dehghan.model.UserEntity;
import com.dehghan.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> getAllUser() {

        return  userRepository.findAll();

    }

    public UserEntity saveOneUser(UserEntity newUser) {
        return userRepository.save(newUser);
    }

    public UserEntity getOneUserById(Long uId) {

        return userRepository.findById(uId).orElse(null);
    }

    public UserEntity updateOneUser(Long uId, UserEntity newUser) {

        /**Update etmek için ilk olarak repository o User bulmamız gerekiyor*/
        Optional<UserEntity> user = userRepository.findById(uId);
        //Optional isPresent yani Object var
        if(user.isPresent()){

            UserEntity foundUser = user.get();
            foundUser.setUsername(newUser.getUsername());
            foundUser.setPassword(newUser.getPassword());
            userRepository.save(foundUser); //Update edilmiş haLini gidip data base kayıt ediyoruz

            return foundUser;
        }else
            return null;
    }

    public void deleteById(Long uId) {

        userRepository.deleteById(uId);
    }
}
