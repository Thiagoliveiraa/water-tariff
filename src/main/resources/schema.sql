DROP TABLE IF EXISTS faixa_consumo;
DROP TABLE IF EXISTS categorias;
DROP TABLE IF EXISTS tabela_tarifaria;

-- ==========================================================
-- TABELA: tabela_tarifaria
-- Representa uma tabela tarifária completa.
-- ==========================================================

CREATE TABLE tabela_tarifaria (
     id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,

     nome VARCHAR(255) NOT NULL,

     data_vigencia_inicio DATE NOT NULL,

     data_vigencia_fim DATE
);

-- ==========================================================
-- TABELA: categorias
-- Categorias pertencentes a uma tabela tarifária.
-- ==========================================================

CREATE TABLE categorias (
       id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,

       nome VARCHAR(50) NOT NULL,

       descricao VARCHAR(255),

       tabela_tarifaria_id INT NOT NULL,

       CONSTRAINT fk_categoria_tabela
           FOREIGN KEY (tabela_tarifaria_id)
               REFERENCES tabela_tarifaria(id)
               ON DELETE CASCADE
);

-- ==========================================================
-- TABELA: faixa_consumo
-- Faixas progressivas utilizadas no cálculo tarifário.
-- ==========================================================

CREATE TABLE faixa_consumo (
      id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,

      faixa_inicial INT NOT NULL,

      faixa_final INT NOT NULL,

      valor_unitario DECIMAL(10,4) NOT NULL,

      categoria_id INT NOT NULL,

      CONSTRAINT fk_faixa_categoria
          FOREIGN KEY (categoria_id)
              REFERENCES categorias(id)
              ON DELETE CASCADE
);



