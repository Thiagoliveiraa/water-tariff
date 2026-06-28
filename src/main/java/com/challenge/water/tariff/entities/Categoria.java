package com.challenge.water.tariff.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String nome;

    @Column(length = 255)
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tabela_tarifaria_id")
    private TabelaTarifaria tabelaTarifaria;

    @OneToMany(mappedBy = "categoria")
    private List<FaixaConsumo> faixas = new ArrayList<>();

    public Categoria() {
    }

    public Categoria(Long id, String nome, String descricao, TabelaTarifaria tabelaTarifaria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.tabelaTarifaria = tabelaTarifaria;
    }

    public TabelaTarifaria getTabelaTarifaria() {
        return tabelaTarifaria;
    }

    public void setTabelaTarifaria(TabelaTarifaria tabelaTarifaria) {
        this.tabelaTarifaria = tabelaTarifaria;
    }

    public List<FaixaConsumo> getFaixas() {
        return faixas;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(id, categoria.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
