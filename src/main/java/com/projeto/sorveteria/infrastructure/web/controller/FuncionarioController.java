package com.projeto.sorveteria.infrastructure.web.controller;

import com.projeto.sorveteria.util.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class FuncionarioController {

    @GetMapping(path = "/conta")
    public String funcionario(Model model){

        model.addAttribute("funcionario", SecurityUtils.loggedCliente());

        return "funcionario";
    }

}
