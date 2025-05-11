package com.diocesisdecarupano.sgp.modules.user.infrastructure.controller;

import com.diocesisdecarupano.sgp.modules.user.application.dto.UserRequestDTO;
import com.diocesisdecarupano.sgp.modules.user.application.dto.UserResponseDTO;
import com.diocesisdecarupano.sgp.modules.user.application.usecase.*;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "User", description = "Controller for User")
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;
    private final GetUserByIdUseCase getUserByIdUseCase;
    private final GetAllUsersUseCase getAllUsersUseCase;

    public UserController(
            CreateUserUseCase createUserUseCase,
            UpdateUserUseCase updateUserUseCase,
            DeleteUserUseCase deleteUserUseCase,
            GetUserByIdUseCase getUserByIdUseCase,
            GetAllUsersUseCase getAllUsersUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.updateUserUseCase = updateUserUseCase;
        this.deleteUserUseCase = deleteUserUseCase;
        this.getUserByIdUseCase = getUserByIdUseCase;
        this.getAllUsersUseCase = getAllUsersUseCase;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO dto) {
        return ResponseEntity.ok(createUserUseCase.execute(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id, @RequestBody UserRequestDTO dto) {
        return ResponseEntity.ok(updateUserUseCase.execute(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        deleteUserUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(getUserByIdUseCase.execute(id));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        return ResponseEntity.ok(getAllUsersUseCase.execute());
    }
}