package com.java.web_travel.service.impl;

import com.java.web_travel.entity.Role;
import com.java.web_travel.entity.User;
import com.java.web_travel.enums.ErrorCode;
import com.java.web_travel.enums.RoleCode;
import com.java.web_travel.exception.AppException;
import com.java.web_travel.model.request.ChangePassDTO;
import com.java.web_travel.model.request.UserCreateDTO;
import com.java.web_travel.model.request.UserLoginDTO;
import com.java.web_travel.model.request.UserUpdateRequest;
import com.java.web_travel.model.response.PageResponse;
import com.java.web_travel.repository.RoleRepository;
import com.java.web_travel.repository.SearchRepository;
import com.java.web_travel.repository.UserRepository;
import com.java.web_travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private SearchRepository searchRepository;

    @Override
    public User createUser(UserCreateDTO userCreateDTO) {
        // CHECK MATCH PASSWORD
        if(!userCreateDTO.getPassword().equals(userCreateDTO.getPasswordConfirm())){
            throw new AppException(ErrorCode.PASSWORD_MISMATCH) ;
        }
        // check exist phone
        if(userRepository.existsByPhone(userCreateDTO.getPhone())) {
            throw new AppException(ErrorCode.USER_EXISTS) ;
        }

        User user = new User();

        user.setPhone(userCreateDTO.getPhone());
        user.setPassword(userCreateDTO.getPassword());
        user.setFullName(userCreateDTO.getFullName());
        user.setEmail(userCreateDTO.getEmail());
        user.setBirthday(userCreateDTO.getBirthday());

        Role role = roleRepository.findByRoleCode(RoleCode.USER)
                        .orElseThrow(()->new AppException(ErrorCode.ROLE_NOT_FOUND)) ;
        user.setRole(role);

        user.setStatus(true);
        return userRepository.save(user);
    }

    @Override
    public User loginUser(UserLoginDTO userLoginDTO) {
        User user = userRepository.findByPhone(userLoginDTO.getPhone())
                .orElseThrow(() -> new AppException(ErrorCode.PHONE_NOT_EXISTS));

        if(!user.isStatus()){
            throw new AppException(ErrorCode.ACCOUNT_NOT_ACTIVE);
        }
        String password = userLoginDTO.getPassword();
        if(!user.getPassword().equals(password)){
           throw new AppException(ErrorCode.PASSWORD_MISMATCH) ;
        }else{
            return user;
        }
    }

    @Override
    public void changePassword(ChangePassDTO changePassDTO) {
        if(!changePassDTO.getNewPassword().equals(changePassDTO.getConfirmPassword())){
            throw new AppException(ErrorCode.PASSWORD_MISMATCH) ;
        }

        User user = userRepository.findByPhone(changePassDTO.getPhone()).
                    orElseThrow(()-> new AppException(ErrorCode.USER_NOT_EXISTS));

        if(!user.getPassword().equals(changePassDTO.getPassword())){
            throw new AppException(ErrorCode.WRONG_PASSWORD) ;
        }

        user.setPassword(changePassDTO.getNewPassword());
        userRepository.save(user);
    }

    @Override
    public PageResponse getAllUsers(int pageNo , int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<User> users = userRepository.findAll(pageable);

        return PageResponse.builder()
                .pageNo(pageNo)
                .pageSize(pageSize)
                .totalPages(users.getTotalPages())
                .items(users.getContent())
                .build();
    }

    @Override
    public User changeStatus(Long id) {
        User user = userRepository.findById(id).orElseThrow(()-> new AppException(ErrorCode.USER_NOT_EXISTS));
        if(user.getRole().getRoleCode().equals(RoleCode.ADMIN)){
            throw new AppException(ErrorCode.NOT_CHANGE_STATUS_ADMIN) ;
        }
        user.setStatus(!user.isStatus());
        return userRepository.save(user);
    }

    @Override
    public PageResponse findUserBySearch(int pageNo, int pageSize, String search) {
        return searchRepository.findBySearch(pageNo,pageSize,search) ;
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(()-> new AppException(ErrorCode.USER_NOT_EXISTS));
    }

    @Override
    public User updateUser(Long id, UserUpdateRequest userUpdateRequest) {
        User user = userRepository.findById(id).orElseThrow(()-> new AppException(ErrorCode.USER_NOT_EXISTS));
        user.setFullName(userUpdateRequest.getFullName());
        user.setEmail(userUpdateRequest.getEmail());
        user.setPhone(userUpdateRequest.getPhone());
        user.setBirthday(userUpdateRequest.getBirthday());
        return userRepository.save(user);
    }

    @Override
    public User createAdmin(UserCreateDTO userCreateDTO) {
        // CHECK MATCH PASSWORD
        if(!userCreateDTO.getPassword().equals(userCreateDTO.getPasswordConfirm())){
            throw new AppException(ErrorCode.PASSWORD_MISMATCH) ;
        }
        // check exist phone
        if(userRepository.existsByPhone(userCreateDTO.getPhone())) {
            throw new AppException(ErrorCode.USER_EXISTS) ;
        }
        User user = new User();
        user.setPhone(userCreateDTO.getPhone());
        user.setPassword(userCreateDTO.getPassword());
        user.setFullName(userCreateDTO.getFullName());
        user.setEmail(userCreateDTO.getEmail());
        user.setBirthday(userCreateDTO.getBirthday());
        user.setStatus(true);
        user.setRole(roleRepository.findByRoleCode(RoleCode.ADMIN).orElseThrow(()-> new AppException(ErrorCode.ROLE_NOT_FOUND)));
        return userRepository.save(user);
    }
}
