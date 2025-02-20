package com.example.user_service.config;

import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakConfig {

    @Value("${keycloak.auth-server-url}")
    private String keycloakServerUrl;

    @Value("${keycloak.realm}")
    private String keycloakRealm;

    @Value("${keycloak.client-id}")
    private String authClientId;

    @Value("${keycloak.username}")
    private String authUsername;

    @Value("${keycloak.password}")
    private String authPassword;

    @Value("${keycloak.user-management-client-id}")
    private String userManagementClientId;

    @Value("${keycloak.user-management-client-secret}")
    private String userManagementClientSecret;

    // Keycloak instance for fetching tokens
    @Bean
    public Keycloak keycloakAuthClient() {
        return KeycloakBuilder.builder()
                .serverUrl(keycloakServerUrl)
                .realm(keycloakRealm)
                .clientId(authClientId)
                .grantType(OAuth2Constants.PASSWORD)
                .username(authUsername)
                .password(authPassword)
                .build();
    }

    // Keycloak instance for user management
    @Bean
    public Keycloak keycloakUserManagementClient() {
        return KeycloakBuilder.builder()
                .serverUrl(keycloakServerUrl)
                .realm(keycloakRealm)
                .clientId(userManagementClientId)
                .clientSecret(userManagementClientSecret)
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
                .build();
    }
}
