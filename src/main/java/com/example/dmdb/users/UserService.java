package com.example.dmdb.users;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> temp = repo.findByUsername(username);

        if (temp.isEmpty()) {
            throw new UsernameNotFoundException("User with this username not found");
        } else {
            User user = temp.get();
            Set<GrantedAuthority> authorities = Set.of(new SimpleGrantedAuthority("USER"));
            return new org.springframework.security.core.userdetails.User(username, user.getPassword(), authorities);
        }
    }

    public Optional<User> findByUsername(String username) {
        return repo.findByUsername(username);
    }

    public void createAndSave(String username, String password) {
        User user = new User(username,password);
        repo.save(user);
    }
}
