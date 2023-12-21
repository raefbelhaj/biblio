package tech.getarrays.bibliotheque.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.bibliotheque.models.User;
import tech.getarrays.bibliotheque.Repo.UserRepo;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Service
public class UserService {

    private final UserRepo userRepo;



    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public Optional<User> getUserById(Long userId) {
        return userRepo.findById(userId);
    }

    public void addUser(User user) {
        userRepo.save(user);
    }

    public User updateUser(Long userId, User updatedUser) {
        Optional<User> existingUserOptional = userRepo.findById(userId);
        System.out.println("useradd"+userId);

        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();

            // Update the fields of the existing user with the values from updatedUser
            existingUser.setName(updatedUser.getName());
            existingUser.setAddress(updatedUser.getAddress());
            existingUser.setPhoneNumber(updatedUser.getPhoneNumber());
            existingUser.setLibraryCard(updatedUser.getLibraryCard());

            // Save the updated user to the repository
            System.out.println("adddd");
             userRepo.save(existingUser);
             return existingUser;
        } else {
            System.out.println("errrrrrr");           // Handle the case where the user with the given id is not found
            // You may choose to throw an exception or handle it as needed
            return null; // or throw an exception
        }
    }


    public void deleteUser(Long userId) {
        userRepo.deleteById(userId);
    }






}




