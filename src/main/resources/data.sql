INSERT INTO tabela_tarifaria
(
    nome,
    data_vigencia_inicio
)
VALUES
    (
        'Tabela Tarifária 2026',
        '2026-01-01'
    );


INSERT INTO categorias
(
    nome,
    descricao,
    tabela_tarifaria_id
)
VALUES
    (
        'COMERCIAL',
        'Estabelecimentos comerciais',
        1
    );

INSERT INTO faixa_consumo
(
 faixa_inicial, faixa_final, valor_unitario, categoria_id
)
VALUES
    (
     0,10,1.50,1
    ),
    (
     11,20,2.30,1
    ),
    (
     21,30,3.80,1
    ),
    (
     31,999999,5.20,1
    );


INSERT INTO categorias
(
    nome,
    descricao,
    tabela_tarifaria_id
)
VALUES
    (
        'INDUSTRIAL',
        'Indústrias e fábricas',
        1
    );

INSERT INTO faixa_consumo
(
 faixa_inicial, faixa_final,valor_unitario,categoria_id
)
VALUES
    (
     0,10,1.00,2
    ),
    (
     11,20,2.00,2
    ),
    (
     21,30,3.50,2
    ),
    (
     31,999999,6.00,2
    );

INSERT INTO categorias
(
    nome,
    descricao,
    tabela_tarifaria_id
)
VALUES
    (
        'PARTICULAR',
        'Residências',
        1
    );

INSERT INTO faixa_consumo
(
 faixa_inicial, faixa_final,valor_unitario,categoria_id
)
VALUES
    (
     0,10,0.90,3
    ),
    (
     11,20,1.50,3
    ),
    (
     21,30,2.80,3
    ),
    (
     31,999999,4.30,3
    );


INSERT INTO categorias
(
    nome,
    descricao,
    tabela_tarifaria_id
)
VALUES
    (
        'PUBLICO',
        'Órgãos públicos',
        1
    );

INSERT INTO faixa_consumo
(
    faixa_inicial, faixa_final,valor_unitario,categoria_id
)
VALUES
    (
     0,10,0.80,4
    ),
    (
     11,20,1.20,4
    ),
    (
     21,30,2.20,4
    ),
    (
     31,999999,3.90,4
    );