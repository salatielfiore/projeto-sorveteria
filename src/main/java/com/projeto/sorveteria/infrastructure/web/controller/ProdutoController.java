package com.projeto.sorveteria.infrastructure.web.controller;

import com.projeto.sorveteria.application.service.ProdutoService;
import com.projeto.sorveteria.domain.produto.Produto;
import com.projeto.sorveteria.dto.ProdutoDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import javax.validation.ValidationException;


@Controller
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping(path = "/produtos")
    public String produtos(Model model) {

        model.addAttribute("produtos", produtoService.getProdutos());

        return "estoque";
    }

    @GetMapping(path = "/produto/novo")
    public String novoProduto(Model model) {
        model.addAttribute("produto", new ProdutoDto());
        return "cadastro-produto";
    }

    @PostMapping(path = "/produto/salvar")
    public String SalvarProduto(
            @ModelAttribute("produto") @Valid ProdutoDto dto, Errors errors) {

        if (!errors.hasErrors()) {
            try {
                Produto produto = new Produto();
                BeanUtils.copyProperties(dto, produto);
                produtoService.salvarProduto(produto);
            } catch (ValidationException e) {
                errors.rejectValue("produto", null, e.getMessage());
            }

        }

        return "redirect:/produtos";
    }

}
