package com.lionel.library_management_v1.service;

import com.lionel.library_management_v1.dao.UserRepository;
import com.lionel.library_management_v1.dto.user.UserRequest;
import com.lionel.library_management_v1.dto.user.UserResponse;
import com.lionel.library_management_v1.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CurrentUserService currentUserService;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository,CurrentUserService currentUserService) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.currentUserService = currentUserService;
    }

    @Override
    public List<UserResponse> findAll() {
        List<User> users = userRepository.findAll();

        ArrayList<UserResponse> responsesUsers = new ArrayList<>();
        for(User user : users){
            responsesUsers.add(mapUserResponse(user));
        }
        return responsesUsers;
    }

    @Override
    public UserResponse findByID(int id) {
        Optional<User> dbUser = userRepository.findById(id);
        System.out.println("lakshmanan: "+dbUser);
        if(dbUser.isEmpty()){
            throw new RuntimeException("User id not found");
        }
        return mapUserResponse(dbUser.get());
//        return dbUser.get();
    }

    @Override
    public UserResponse save(UserRequest reqUser) {
        System.out.println("lakshmanan: from service");

        // 2. ENCODE THE PASSWORD
        String encodedPassword =
                passwordEncoder.encode(reqUser.getPassword());
        reqUser.setPassword(encodedPassword);

        // 3. SETTING CREATED_BY AND CREATED_AT
        String authorizedUserName = currentUserService.getCurrentUserEmail();
        User authorizedUser = userRepository.findByEmail(authorizedUserName);
        Instant currentTime = Instant.now();

        // 3.CONSTRUCT USER ENTITY
        boolean enabled = true;
        User userEntity = new User(null,reqUser.getUserName(), reqUser.getPassword(),reqUser.getEmail(),
                reqUser.getWalletAmount(),enabled,currentTime,currentTime,authorizedUser,authorizedUser);

        User dbUser = userRepository.save(userEntity);
        return mapUserResponse(dbUser);
//        return dbUser;
    }

    @Override
    public User update(User user) {
        String encodedPassword =
                passwordEncoder.encode(user.getPassword());

        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    @Override
    public void deleteByID(int id) {
        userRepository.deleteById(id);
    }

    private UserResponse mapUserResponse(User user){
        return new UserResponse(
                user.getUserName(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getUpdatedAt(),
                user.getCreatedBy() != null ?user.getCreatedBy().getEmail():null,
                user.getUpdatedBy() != null ?user.getUpdatedBy().getEmail():null);
    }

}
