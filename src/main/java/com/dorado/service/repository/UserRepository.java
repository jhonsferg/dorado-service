package com.dorado.service.repository;

import com.dorado.service.model.security.Role;
import com.dorado.service.model.security.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;

@Repository
public class UserRepository {
    private Map<Long, User> users = new HashMap<>();
    private Map<String, User> usersByUsername = new HashMap<>();
    private Long nextId = 1L;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserRepository() {
        // Crear usuarios por defecto
        createDefaultUsers();
    }

    private void createDefaultUsers() {
        // Administrador
        User admin = new User("admin", "admin@polleria.com",
                passwordEncoder.encode("admin123"),
                "Administrador Sistema",
                Set.of(Role.ADMIN));
        admin.setBranchId(1L);
        save(admin);

        // Gerente
        User manager = new User("gerente", "gerente@polleria.com",
                passwordEncoder.encode("gerente123"),
                "Carlos Mendoza",
                Set.of(Role.MANAGER));
        manager.setBranchId(1L);
        save(manager);

        // Cajero
        User cashier = new User("cajero", "cajero@polleria.com",
                passwordEncoder.encode("cajero123"),
                "Ana López",
                Set.of(Role.CASHIER));
        cashier.setBranchId(1L);
        save(cashier);

        // Cocinero
        User cook = new User("cocinero", "cocinero@polleria.com",
                passwordEncoder.encode("cocinero123"),
                "José Ramírez",
                Set.of(Role.COOK));
        cook.setBranchId(1L);
        save(cook);
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(nextId++);
        }
        users.put(user.getId(), user);
        usersByUsername.put(user.getUsername(), user);
        return user;
    }

    public Optional<User> findByUsername(String username) {
        return Optional.ofNullable(usersByUsername.get(username));
    }

    public Optional<User> findById(Long id) {
        return Optional.ofNullable(users.get(id));
    }

    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    public List<User> findByRole(Role role) {
        return users.values().stream()
                .filter(user -> user.getRoles().contains(role))
                .toList();
    }

    public List<User> findByBranchId(Long branchId) {
        return users.values().stream()
                .filter(user -> Objects.equals(user.getBranchId(), branchId))
                .toList();
    }

    public boolean existsByUsername(String username) {
        return usersByUsername.containsKey(username);
    }

    public boolean existsByEmail(String email) {
        return users.values().stream()
                .anyMatch(user -> user.getEmail().equals(email));
    }

    public void updateLastLogin(String username) {
        User user = usersByUsername.get(username);
        if (user != null) {
            user.setLastLogin(LocalDateTime.now());
            save(user);
        }
    }
}
