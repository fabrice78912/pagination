package com.code.service;

import com.code.domain.User;
import org.springframework.data.domain.Page;

/**
 * @author Get Arrays (https://www.getarrays.io/)
 * @version 1.0
 * @since 6/26/2022
 */

public interface UserService {
    Page<User> getUsers(String name, int page, int size);
}
