package tech.getarrays.bibliotheque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.bibliotheque.models.User;
import tech.getarrays.bibliotheque.Repo.UserRepo;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public Optional<User> getUserById(Long userId) {
        return userRepo.findById(userId);
    }

    public void addUser(User user) {
        userRepo.save(user);
    }

    public void updateUser(Long userId, User updatedUser) {
        Optional<User> existingUserOptional = userRepo.findById(userId);
        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();
            existingUser.setName(updatedUser.getName());
            existingUser.setAddress(updatedUser.getAddress());
            existingUser.setPhoneNumber(updatedUser.getPhoneNumber());
            existingUser.setLibraryCard(updatedUser.getLibraryCard());
            userRepo.save(existingUser);
        }
    }

    public void deleteUser(Long userId) {
        userRepo.deleteById(userId);
    }
}
