package com.challenge.water.tariff.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tabela_tarifaria")
public class TabelaTarifaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(name = "data_vigencia_inicio", nullable = false)
    private LocalDate dataVigenciaInicio;

    @Column(name = "data_vigencia_fim")
    private LocalDate dataVigenciaFim;

//    @OneToMany(mappedBy = "tabelaTarifaria")
    @OneToMany(mappedBy = "tabelaTarifaria", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Categoria> categorias = new ArrayList<>();

    public TabelaTarifaria(Long id, String nome, LocalDate dataVigenciaInicio, LocalDate dataVigenciaFim) {
        this.id = id;
        this.nome = nome;
        this.dataVigenciaInicio = dataVigenciaInicio;
        this.dataVigenciaFim = dataVigenciaFim;
    }

    public TabelaTarifaria() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataVigenciaInicio() {
        return dataVigenciaInicio;
    }

    public void setDataVigenciaInicio(LocalDate dataVigenciaInicio) {
        this.dataVigenciaInicio = dataVigenciaInicio;
    }

    public LocalDate getDataVigenciaFim() {
        return dataVigenciaFim;
    }

    public void setDataVigenciaFim(LocalDate dataVigenciaFim) {
        this.dataVigenciaFim = dataVigenciaFim;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void addCategoria(Categoria categoria) {
        this.categorias.add(categoria);
        categoria.setTabelaTarifaria(this);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TabelaTarifaria that = (TabelaTarifaria) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
