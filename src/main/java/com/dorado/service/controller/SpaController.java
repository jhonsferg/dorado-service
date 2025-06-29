package com.dorado.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpaController {
    @RequestMapping({
            "/",
            "/login",
            "/dashboard",
            "/productos",
            "/ventas",
            "/empleados",
            "/reportes",
            "/configuracion",
            "/perfil",
            "/{path:[^\\.]*}/**"
    })
    public String spa() {
        return "forward:/index.html";
    }
}
