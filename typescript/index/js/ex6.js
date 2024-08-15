"use strict";
const produtos = [
    {
        nome: 'Cadeira',
        preco: 150.00,
        categoria: 'Móveis'
    },
    {
        nome: 'Mesa',
        preco: 300.00,
        categoria: 'Móveis'
    },
    {
        nome: 'Laptop',
        preco: 1200.00,
        categoria: 'Eletrônicos'
    },
    {
        nome: 'Smartphone',
        preco: 800.00,
        categoria: 'Eletrônicos'
    },
    {
        nome: 'Caderno',
        preco: 15.00,
        categoria: 'Papeleria'
    },
    {
        nome: 'Caneta',
        preco: 2.50,
        categoria: 'Papeleria'
    }
];
const retorna_produto_categoria = (array, categoria) => { return array.filter(p => p.categoria === categoria); };
console.log(retorna_produto_categoria(produtos, "Papeleria"));
