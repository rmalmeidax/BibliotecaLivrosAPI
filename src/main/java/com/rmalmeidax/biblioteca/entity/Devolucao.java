package com.rmalmeidax.biblioteca.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.rmalmeidax.biblioteca.enums.FinanceiroEnums;
import com.rmalmeidax.biblioteca.enums.SituacaoEnums;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_devolucao")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Devolucao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	@OneToOne
	@JoinColumn(name = "emprestimo_id")
	@JsonBackReference
	private Emprestimo emprestimo;

	@Enumerated(EnumType.STRING)
	private SituacaoEnums situacaoEnums;

	@Enumerated(EnumType.STRING)
	private FinanceiroEnums financeiroEnums;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataDevolvida;

	private Double multa;
}
