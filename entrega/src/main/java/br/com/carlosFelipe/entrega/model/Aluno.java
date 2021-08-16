package br.com.carlosFelipe.entrega.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Getter
@Setter
public class Aluno {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Long matricula;
	private String diretorioArquivo;

	public Aluno(String name, Long matricula, String diretorioArquivo) {
		super();
		this.name = name;
		this.matricula = matricula;
		this.diretorioArquivo = diretorioArquivo;
	}

}
