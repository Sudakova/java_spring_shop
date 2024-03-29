package sudakova.onlineshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sudakova.onlineshop.dto.request.UserRequest;
import sudakova.onlineshop.dto.response.DataResponse;
import sudakova.onlineshop.dto.response.UserResponse;
import sudakova.onlineshop.entity.User;
import sudakova.onlineshop.exception.WrongInputDataException;
import sudakova.onlineshop.repository.UserRepository;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public DataResponse<UserResponse> getAllUser() {
        return new DataResponse<>(userRepository.findAll().stream().map(UserResponse::new).collect(Collectors.toList()));

    }

    public UserResponse getById(Long id) {
        return new UserResponse(getEntityObjectById(id));
    }

    public UserResponse login(UserRequest userRequest) {
        User user = userRepository.getByEmail(userRequest.getEmail()).orElseThrow(()->new WrongInputDataException(""));
        if (user != null) {
            if (user.getPassword().equals(hashPassword(userRequest.getPassword()))) {
                return new UserResponse(user);
            } else throw new WrongInputDataException("User with email: " + userRequest.getEmail() + " not found.");
        } else throw new WrongInputDataException("User with email: " + userRequest.getEmail() + " not found.");
    }

    public UserResponse save(UserRequest userRequest) {
        User user = new User();
        user.setEmail(userRequest.getEmail());
        user.setType(userRequest.getType());
        user.setPassword(hashPassword(userRequest.getPassword()));
        return new UserResponse(userRepository.save(user));
    }


    public void update(Long id, UserRequest userRequest) {
        User user = getEntityObjectById(id);
        user.setEmail(userRequest.getEmail());
        userRepository.save(user);
    }

    public boolean delete(Long id) {
        User user = getEntityObjectById(id);
        userRepository.delete(user);
        return true;
    }

    private User getEntityObjectById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new WrongInputDataException("User with id: " + id + " not found."));
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(password.getBytes());
            byte[] digest = md5.digest();
            return DatatypeConverter
                    .printHexBinary(digest).toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            return password;
        }

    }

}
