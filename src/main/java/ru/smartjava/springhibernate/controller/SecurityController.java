package ru.smartjava.springhibernate.controller;

import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
@RequiredArgsConstructor
public class SecurityController {

    @GetMapping("/read")
    @Secured("ROLE_READ")
    ResponseEntity<String> read() {
        return ResponseEntity.ok("READ");
    }
    @GetMapping("/write")
    @RolesAllowed({"WRITE"})
    ResponseEntity<String> write() {
        return ResponseEntity.ok("WRITE");
    }
    @GetMapping("/delete")
    @PreAuthorize("hasAnyRole('WRITE','DELETE')")
    ResponseEntity<String> delete() {
        return ResponseEntity.ok("DELETE");
    }

    @GetMapping("/user")
    @PreAuthorize("#username == authentication.principal.username")
    ResponseEntity<String> user(String username) {
        return ResponseEntity.ok("acces allowed " + username);
    }

}
