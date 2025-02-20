package com.example.user_service.service;

import com.example.user_service.dto.UserRequest;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService {

    private final Keycloak keycloakUserManagementClient;

    public UserService(Keycloak keycloakUserManagementClient) {
        this.keycloakUserManagementClient = keycloakUserManagementClient;
    }

    public ResponseEntity<String> createUser(UserRequest request) {
        UserRepresentation user = new UserRepresentation();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setEnabled(true);
        user.setRealmRoles(Collections.singletonList(request.getRole()));

        CredentialRepresentation credential = new CredentialRepresentation();
        credential.setType(CredentialRepresentation.PASSWORD);
        credential.setValue(request.getPassword());
        credential.setTemporary(false);
        user.setCredentials(Collections.singletonList(credential));

        try {
            int statusCode = keycloakUserManagementClient
                    .realm("springboot-microservice-realm")
                    .users()
                    .create(user)
                    .getStatus();
            if (statusCode == 201) {
                return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User creation failed: " + statusCode);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }
}
