package com.okzampo.coffehour.controller;

import com.okzampo.coffehour.dto.InputUserDTO;
import com.okzampo.coffehour.dto.ResponseDTO;
import com.okzampo.coffehour.dto.UserDTO;
import com.okzampo.coffehour.exception.BadRequestException;
import com.okzampo.coffehour.mapper.InputUserMapper;
import com.okzampo.coffehour.mapper.UserMapper;
import com.okzampo.coffehour.service.UserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService service;
    private final UserMapper outputMapper;
    private final InputUserMapper inputMapper;

    UserController(UserService service, UserMapper outputMapper, InputUserMapper inputMapper){
        this.service = service;
        this.outputMapper = outputMapper;
        this.inputMapper = inputMapper;
    }

    @SneakyThrows
    @PostMapping()
    public ResponseEntity<ResponseDTO> createUser(@RequestBody InputUserDTO user){
        if(user.getId() != null){
            throw new BadRequestException();
        }

        return ResponseEntity.ok(outputMapper.toResponse(service.createUser(inputMapper.toEntity(user)),"User successfully created"));
    }

    @SneakyThrows
    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO> editUser(@PathVariable("id") String id, @RequestBody InputUserDTO user){
        if(!id.equals(user.getId())){
            throw new BadRequestException();
        }

        return ResponseEntity.ok(outputMapper.toResponse(service.editUser(id,inputMapper.toEntity(user)),"User successfully modified"));
    }

    @SneakyThrows
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteUser(@PathVariable("id") String id){
        return ResponseEntity.ok(outputMapper.toResponse(service.deleteUser(id),"User successfully deleted"));
    }

    @SneakyThrows
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable("id") String id){
        return ResponseEntity.ok(outputMapper.toDto(service.getUser(id)));
    }

    @SneakyThrows
    @GetMapping()
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        return ResponseEntity.ok(outputMapper.toDto(service.getAllUsers()));
    }

}
