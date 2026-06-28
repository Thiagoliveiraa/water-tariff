package com.challenge.water.tariff.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "faixa_consumo")
public class FaixaConsumo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "faixa_inicial", nullable = false)
    private Integer faixaInicial;
    @Column(name = "faixa_final", nullable = false)
    private Integer faixaFinal;
    @Column(name = "valor_unitario", nullable = false, precision = 10, scale = 4)
    private BigDecimal valorUnitario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public FaixaConsumo() {
    }

    public FaixaConsumo(Long id, Integer faixaInicial, Integer faixaFinal, BigDecimal valorUnitario, Categoria categoria) {
        this.id = id;
        this.faixaInicial = faixaInicial;
        this.faixaFinal = faixaFinal;
        this.valorUnitario = valorUnitario;
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Integer getFaixaFinal() {
        return faixaFinal;
    }

    public void setFaixaFinal(Integer faixaFinal) {
        this.faixaFinal = faixaFinal;
    }

    public Integer getFaixaInicial() {
        return faixaInicial;
    }

    public void setFaixaInicial(Integer faixaInicial) {
        this.faixaInicial = faixaInicial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
