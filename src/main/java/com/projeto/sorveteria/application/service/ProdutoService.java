package com.projeto.sorveteria.application.service;

import com.projeto.sorveteria.domain.produto.Produto;
import com.projeto.sorveteria.domain.produto.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    @Transactional
    public void salvarProduto(Produto produto) {

        produtoRepository.save(produto);
    }

    @Transactional(readOnly = true)
    public List<Produto> getProdutos() {
        return produtoRepository.findAll();
    }

}
