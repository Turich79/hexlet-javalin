package org.example.hexlet.dto.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.hexlet.model.User;

import java.util.List;

@AllArgsConstructor
@Getter
public class UsersPage {
//    private String[] users;
    private List<User> users;
}