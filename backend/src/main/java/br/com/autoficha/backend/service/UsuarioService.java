package br.com.autoficha.backend.service;

import br.com.autoficha.backend.dto.auth.CadastroRequest;
import br.com.autoficha.backend.dto.auth.LoginRequest;
import br.com.autoficha.backend.dto.auth.LoginResponse;
import br.com.autoficha.backend.dto.auth.UsuarioResponse;
import br.com.autoficha.backend.entity.Usuario;
import br.com.autoficha.backend.exception.CredenciaisInvalidasException;
import br.com.autoficha.backend.exception.UsernameJaExisteException;
import br.com.autoficha.backend.repository.UsuarioRepository;
import br.com.autoficha.backend.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public UsuarioService(
            UsuarioRepository usuarioRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService
    ) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public UsuarioResponse cadastrar(CadastroRequest request) {

        String username =
                request.getUsername().trim();

        if (usuarioRepository.existsByUsername(username)) {
            throw new UsernameJaExisteException(username);
        }

        String senhaCriptografada =
                passwordEncoder.encode(
                        request.getSenha()
                );

        Usuario usuario = new Usuario(
                request.getNome().trim(),
                username,
                senhaCriptografada
        );

        Usuario usuarioSalvo =
                usuarioRepository.save(usuario);

        return UsuarioResponse.from(usuarioSalvo);
    }

    public LoginResponse login(LoginRequest request) {

        Usuario usuario = usuarioRepository
                .findByUsername(
                        request.getUsername().trim()
                )
                .orElseThrow(
                        CredenciaisInvalidasException::new
                );

        boolean senhaCorreta =
                passwordEncoder.matches(
                        request.getSenha(),
                        usuario.getSenha()
                );

        if (!senhaCorreta) {
            throw new CredenciaisInvalidasException();
        }

        String token =
                jwtService.gerarToken(usuario);

        return new LoginResponse(token);
    }
}