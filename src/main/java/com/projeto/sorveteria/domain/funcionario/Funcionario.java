package com.projeto.sorveteria.domain.funcionario;

import com.projeto.sorveteria.util.StringUtils;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "tb_funcionario")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Funcionario implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome não pode ser vazio")
    @Size(max = 80, message = "O nome é muito grande")
    private String name;

    @NotBlank(message = "O email não pode ser vazio")
    @Size(max = 60, message = "O email é muito grande")
    @Email(message = "O email é inválido")
    private String email;

    @NotBlank(message = "A senha não pode ser vazio")
    @Size(max = 80, message = "A senha é muito grande")
    private String password;

    @NotBlank(message = "A função não pode ser vazia")
    @Size(max = 80, message = "A função é muito grande")
    private String funcao;

    private boolean adm;

    public void encryptPassword() {
        this.password = StringUtils.encrypt(this.password);
    }

}
