package tn.coconsultbackend.Configuration;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import tn.coconsultbackend.User.UserServices.UserService;

import java.io.IOException;




@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private final JwtUtils jwtUtils;
    private final UserService userService;

    public JwtAuthorizationFilter(JwtUtils jwtUtils, UserService userService) {
        this.jwtUtils = jwtUtils;
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        System.out.println("Processing request for method: " + request.getMethod() + ", URL: " + request.getRequestURI());

        // Skip JWT processing for OPTIONS requests (CORS preflight) and unauthenticated login/register
        String requestURI = request.getRequestURI();
        if (request.getMethod().equals("OPTIONS") ||
                (request.getMethod().equals("POST") && (requestURI.equals("/api/auth/login") || requestURI.equals("/api/auth/register")))) {
            System.out.println("Skipping " + request.getMethod() + " request for CORS preflight or registration/login...");
            filterChain.doFilter(request, response);
            return;
        }

        String header = request.getHeader("Authorization");
        if (header == null || !header.startsWith("Bearer ")) {
            System.out.println("No Authorization header or not Bearer token, passing through...");
            filterChain.doFilter(request, response);
            return;
        }

        String token = header.substring(7);
        String username = jwtUtils.extractUsername(token);

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = userService.loadUserByUsername(username);
            System.out.println("Filter: Token username = " + username);
            System.out.println("Filter: Loaded authorities = " + userDetails.getAuthorities());
            if (jwtUtils.validateToken(token, userDetails.getUsername())) {
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);
                System.out.println("Authenticated user: " + username + " with roles: " + userDetails.getAuthorities());
            } else {
                System.out.println("Token validation failed for user: " + username);
            }
        } else {
            System.out.println("Username is null or context already has authentication.");
        }
        filterChain.doFilter(request, response);
    }
}