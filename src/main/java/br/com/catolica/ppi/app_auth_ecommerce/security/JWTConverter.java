package br.com.catolica.ppi.app_auth_ecommerce.security;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JWTConverter implements Converter<Jwt, AbstractAuthenticationToken> {
    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {

        Map<String, Map<String, Object>> resourceAccess = jwt.getClaim("resource_access");
        Collection<String> roles = null;

        if (resourceAccess != null && resourceAccess.containsKey("Code-Cursos-Client")) {
            Map<String, Object> clientRoles = resourceAccess.get("Code-Cursos-Client");
            roles = (Collection<String>) clientRoles.get("roles");
        }

        if (roles == null) {
            roles = List.of();
        }

        List<SimpleGrantedAuthority> authorities = roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                .collect(Collectors.toList());

        return new JwtAuthenticationToken(jwt, authorities);
    }

}
