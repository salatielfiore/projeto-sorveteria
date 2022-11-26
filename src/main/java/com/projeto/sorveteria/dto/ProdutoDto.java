package com.projeto.sorveteria.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Getter
@Setter
public class ProdutoDto {

    @NotBlank(message = "O sabor não pode ser vazio")
    @Size(max = 80, message = "O sabor é muito grande")
    private String sabor;

    @NotNull(message = "A quantidade não pode ser vazia")
    private Integer quantidade;

    @NotNull(message = "O preço não pode ser vazio")
    private BigDecimal preco;

}
