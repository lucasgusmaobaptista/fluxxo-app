package me.lucasgusmao.fluxxo_app_api.service;

import lombok.RequiredArgsConstructor;
import me.lucasgusmao.fluxxo_app_api.mapper.UserMapper;
import me.lucasgusmao.fluxxo_app_api.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper;
}
