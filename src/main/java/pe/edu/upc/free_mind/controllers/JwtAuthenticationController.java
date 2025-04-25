package pe.edu.upc.free_mind.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.free_mind.securities.JwtRequest;
import pe.edu.upc.free_mind.securities.JwtResponse;
import pe.edu.upc.free_mind.securities.JwtTokenUtil;
import pe.edu.upc.free_mind.serviceimplements.JwtUserDetailsService;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest req) throws Exception {
        authenticate(req.getCorreo(), req.getContrasena());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(req.getCorreo());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String correo, String contrasena) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(correo, contrasena));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

}
