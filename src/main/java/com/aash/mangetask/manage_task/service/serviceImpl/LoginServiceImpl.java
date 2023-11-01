package com.aash.mangetask.manage_task.service.serviceImpl;

import com.aash.mangetask.manage_task.dto.LoginDTO;
import com.aash.mangetask.manage_task.dto.RegisterDTO;
import com.aash.mangetask.manage_task.model.User;
import com.aash.mangetask.manage_task.repository.UserRepository;
import com.aash.mangetask.manage_task.service.LoginService;
import com.aash.mangetask.manage_task.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;


@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    JwtUtil jwtUtil;

    @Override
    public ResponseEntity<?> register(RegisterDTO registerDTO) {
        if(registerDTO.getFirstName().equals("")){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Please enter first name");
        } else if(registerDTO.getLastName().equals("")){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Please enter last name");
        } else if(registerDTO.getEmail().equals("")){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Please enter email");
        }else if(registerDTO.getMobile().equals("")){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Please enter mobile");
        }else if(registerDTO.getPassword().equals("")){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Please enter password");
        }else if (userRepository.findByEmail(registerDTO.getEmail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email Already Exist");
        }else{
        User user = new User();
        user.setFirstName(registerDTO.getFirstName());
        user.setLastName(registerDTO.getLastName());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(registerDTO.getPassword());
        user.setMobile(registerDTO.getMobile());
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User Registered successfully!");
        }
    }

    @Override
    public ResponseEntity<?> login(LoginDTO loginDTO) {
        if(loginDTO.getEmail().equals("")){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email not found");
        }else if(loginDTO.getPassword().equals("")){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Password not found");
        }else{
            User user = userRepository.findByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword());
            if (user==null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid credential");
            }
            if(user.isActive()){
                String accessToken = jwtUtil.generateAccessToken(user);
                HashMap<String, String> data = new HashMap<>();
                data.put("accessToken",accessToken);
                return ResponseEntity.status(HttpStatus.OK).body(data);
            }
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Your account has been deleted!");
        }
    }

}
