package com.code.service.implementation;

import com.code.service.UserService;
import com.code.domain.User;
import com.code.repostitory.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.common.exception.OrderNotFoundException;
import org.example.common.exception.UserNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static org.springframework.data.domain.PageRequest.of;

/**
 * @author Get Arrays (https://www.getarrays.io/)
 * @version 1.0
 * @since 6/26/2022
 */

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public Page<User> getUsers(String name, int page, int size) {
        log.info("Fetching users for page {} of size {}", page, size);
        Page<User> userPage = userRepository.findByNameContaining(name, of(page, size));
        if(userPage.getTotalElements() > 0 )
        {return userPage;}

        else {
            throw new UserNotFoundException("user not found");
        }
    }
}
