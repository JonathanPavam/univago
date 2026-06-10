package com.univago.controller;

import com.univago.dto.UserDto;
import com.univago.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/{id}")
    public ResponseEntity <UserDto> findbyid(@PathVariable Long id){
        return ResponseEntity.ok().body(userService.findById(id));
    }

    @RequestMapping
    public ResponseEntity<List<UserDto>> findAll(){
        List<UserDto> list = userService.findALl();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/")
    public ResponseEntity <UserDto> post (@RequestBody UserDto user){
        return ResponseEntity.ok().body(userService.create(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity <UserDto> update (@PathVariable Long id,@RequestBody UserDto dto){
        dto = userService.put(id, dto);
        return ResponseEntity.ok().body(dto);
    }

}
