package ru.mariaccord.votingsystem.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import static java.util.Objects.requireNonNull;

public class SecurityUtil {
    private SecurityUtil() {
    }

    public static String getCurrentUserName() {
      Authentication auth = SecurityContextHolder.getContext().getAuthentication();
      return auth.getName();
  }
}
