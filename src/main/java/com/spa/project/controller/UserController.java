package com.spa.project.controller;

import com.spa.project.model.User;
import com.spa.project.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Página de inicio (mapeada a '/')
    @GetMapping("/")
    public String index() {
        return "index";  // Debe devolver la vista 'index.html'
    }
    
    @GetMapping("/loginRecep")
    public String loginRecepcion() {
        return "loginRecep";  // Debe devolver la vista 'index.html'
    }
    
    @GetMapping("/loginEspe")
    public String loginEspecialista() {
        return "loginEspe";  // Debe devolver la vista 'index.html'
    }

    // Página de inicio de sesión (mapeada a '/login')
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";  // Debe devolver la vista 'login.html'
    }
    
    @GetMapping("/admin")
    public String adminPage() {
        return "admin"; // Este archivo debe estar en templates o static
    }
    
    @GetMapping("/vista-especialista")
    public String mostrarVistaEspecialista() {
        return "especialista"; // nombre del archivo sin ".html"
    }
    
    @GetMapping("/vista-recepcionista")
    public String vistaRecepcionista() {
        return "recepcionista"; // nombre de la plantilla (ej: src/main/resources/templates/vista-recepcionista.html)
    }
    
    @GetMapping("/loginUsu")
    public String vistaUsu() {
        return "loginUsu"; // nombre de la plantilla (ej: src/main/resources/templates/vista-recepcionista.html)
    }
    
    @GetMapping("/regisUsu")
    public String vistaRegisUsu() {
        return "regisUsu"; // nombre de la plantilla (ej: src/main/resources/templates/vista-recepcionista.html)
    }
    
    @GetMapping("/vista-usuario")
    public String mostrarVistaUsuario() {
        return "usuario"; // nombre del archivo sin ".html"
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username,
                            @RequestParam String password,
                            Model model) {

        User user = userRepository.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            if ("admin".equalsIgnoreCase(user.getUsername())) {
                return "redirect:/admin";
            }else if("barney".equalsIgnoreCase(user.getUsername())) {
            	return "redirect:/admin";
            }else {
                return "redirect:/home";
            }
        } else {
            model.addAttribute("error", "Error al ingresar solo administrativos");
            return "login";
        }
    }

    // Página de registro (mapeada a '/registro')
    @GetMapping("/registro")
    public String showRegisterPage() {
        return "registro";  // Debe devolver la vista 'registro.html'
    }

    @PostMapping("/registro")
    public String registerUser(@RequestParam String username, @RequestParam String password) {
        User user = new User(username, password);
        userRepository.save(user);
        return "redirect:/login";  // Redirige a '/login' después de registrar
    }

    // Página de inicio de usuario después de login (mapeada a '/home')
    @GetMapping("/home")
    public String home() {
        return "home";  // Debe devolver la vista 'home.html'
    }
}
