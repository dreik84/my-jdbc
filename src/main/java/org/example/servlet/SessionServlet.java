package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dto.UserDto;
import org.example.entity.Gender;
import org.example.entity.Role;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {
    private final static String USER = "user";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var session = req.getSession();
        var user = session.getAttribute(USER);

        if (user == null)
            user = UserDto.builder()
                    .id(1L)
                    .name("john")
                    .birthday(LocalDate.now())
                    .email("john@mail.ru")
                    .password("1234")
                    .role(Role.USER)
                    .gender(Gender.MALE)
                    .build();

        session.setAttribute(USER, user);
    }
}
