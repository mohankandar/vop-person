package com.wynd.vop.person;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * Controller for the root URL - redirects to the Swagger UI.
 */
@Controller
public class HomeController {

  /**
   * Handles the request to the root URL with no path and redirects to the Swagger UI.
   *
   * @param request  The HTTP request object containing client request information.
   * @param response The HTTP response object used to send the redirect.
   * @throws IOException If an input or output exception occurs while sending the redirect.
   */
  @GetMapping("/")
  public void home(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.sendRedirect(ServletUriComponentsBuilder.fromCurrentContextPath().path("/swagger-ui.html").build().toUriString());
  }
}
