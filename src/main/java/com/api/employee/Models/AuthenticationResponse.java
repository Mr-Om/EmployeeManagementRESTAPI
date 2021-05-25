package com.api.employee.Models;

public class AuthenticationResponse {
    private final String jwt;

    /**
     * @return the jwt
     */
    public String getJwt() {
        return jwt;
    }

    /**
     * @param jwt
     */
    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

}
