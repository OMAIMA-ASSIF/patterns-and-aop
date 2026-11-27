package net.omaima.aspect;

import org.springframework.stereotype.Component;

@Component
public class SimpleAuthorizationService implements AuthorizationService {

    private String currentRole = "USER";

    public void setCurrentRole(String currentRole) {
        this.currentRole = currentRole;
    }

    @Override
    public boolean hasRole(String role) {
        return "ADMIN".equals(currentRole) || currentRole.equals(role);
    }
}