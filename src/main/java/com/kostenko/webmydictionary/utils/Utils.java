package com.kostenko.webmydictionary.utils;

import com.kostenko.webmydictionary.controllers.users.utils.UserDetailImpl;
import com.kostenko.webmydictionary.dao.domain.users.User;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class Utils implements Serializable {
    private static final long serialVersionUID = 4181604947630989917L;

    public User getUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = null;
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetailImpl userDetails = (UserDetailImpl) auth.getPrincipal();
            user = userDetails.getUser();
        }
        return user;
    }
}
