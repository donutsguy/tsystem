"use strict";
class Produto {
    constructor(preco, quantidade) {
        this.preco = preco;
        this.quantidade = quantidade;
    }
}
const produto_1 = new Produto(29.99, 100);
const produto_2 = new Produto(9.99, 200);
const produto_3 = new Produto(49.99, 50);
const produtos_1 = [produto_1, produto_2, produto_3];
const junta_precos = (produtos) => {
    return produtos.reduce((acc, pro) => pro.preco * pro.quantidade + acc, 0);
};
console.log(junta_precos(produtos_1));
