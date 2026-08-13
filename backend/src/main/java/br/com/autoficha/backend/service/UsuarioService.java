package br.com.autoficha.backend.service;

import br.com.autoficha.backend.dto.auth.CadastroRequest;
import br.com.autoficha.backend.dto.auth.UsuarioResponse;
import br.com.autoficha.backend.entity.Usuario;
import br.com.autoficha.backend.exception.UsernameJaExisteException;
import br.com.autoficha.backend.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(
            UsuarioRepository usuarioRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UsuarioResponse cadastrar(CadastroRequest request) {

        String username = request.getUsername().trim();

        if (usuarioRepository.existsByUsername(username)) {
            throw new UsernameJaExisteException(username);
        }

        String senhaCriptografada =
                passwordEncoder.encode(request.getSenha());

        Usuario usuario = new Usuario(
                request.getNome().trim(),
                username,
                senhaCriptografada
        );

        Usuario usuarioSalvo =
                usuarioRepository.save(usuario);

        return UsuarioResponse.from(usuarioSalvo);
    }
}