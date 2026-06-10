package com.univago.service;

import com.univago.dto.UserDto;
import com.univago.mapper.UserMapper;
import com.univago.model.User;
import com.univago.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;


    public UserDto create (UserDto dto) {
        User user = userMapper.toEntity(dto);
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    public UserDto put (Long id, UserDto dto){
        User user = userRepository.findById(id).orElseThrow();
        dtoToEntity(user, dto);
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    public List<UserDto> findALl(){
        return userRepository.findAll().stream().map(userMapper::toDto).collect(Collectors.toList());
    }

    public UserDto findById(Long id){
        return userRepository.findById(id).map(userMapper::toDto).orElseThrow();
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }

    public void dtoToEntity (User entity, UserDto dto){
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
    }
}
