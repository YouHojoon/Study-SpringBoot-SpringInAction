package ac.kr.smu.tacos.web.service;

import ac.kr.smu.tacos.domain.User;
import ac.kr.smu.tacos.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public void registerUser(User user){
        user.setPasswd(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
