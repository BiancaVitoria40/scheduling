package br.com.scheduling.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "cliente")
public class Cliente{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
    

	@NotBlank(message = "O campo nome é obrigatório!")
	@Column(name = "nome", length = 200, nullable = false)
	private String nome;
    
	@Email(message = "Insira um e-mail válido!")
	@NotBlank(message = "Informe um e-mail!")
	@Column(name = "email", length = 50, nullable = false)
	private String email;
    
	@NotBlank(message =  "A senha é obrigatória!")
	@Column(name = "senha", columnDefinition = "TEXT", nullable = false)
	private String senha;
    
	@NotBlank(message = "O campo telefone é obrigatório!")
	@Column(name = "telefone", length = 15, nullable = false)
	private String telefone;
	


}
