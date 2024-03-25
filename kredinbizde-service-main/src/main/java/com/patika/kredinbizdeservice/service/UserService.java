package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.User;
import com.patika.kredinbizdeservice.repository.UserRepository;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UserService implements IUserService {

    private UserRepository userRepository = new UserRepository();

    @Override
    public User save(User user) {
        System.out.println("userRepository: " + userRepository.hashCode());

        userRepository.save(user);

        return user;
    }

    @Override
    public List<User> getAll() {
        System.out.println("userRepository: " + userRepository.hashCode());
        return userRepository.getAll();
    }

    @Override
    public User getByEmail(String email) {

        Optional<User> foundUser = userRepository.findByEmail(email);

        User user = null;

        //User user = foundUser.orElseThrow(RuntimeException::new);

        if (foundUser.isPresent()) {
            user = foundUser.get();
        }

        return user;

    }

    @Override
    public User update(String email, User user) {

        Optional<User> foundUser = userRepository.findByEmail(email);

        foundUser.get().setName(user.getName());

        foundUser.get().setSurname(user.getSurname());

        userRepository.delete(user);

        userRepository.save(foundUser.get());

        return foundUser.get();
    }
}
