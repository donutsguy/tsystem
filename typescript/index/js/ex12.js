"use strict";
class Caixa {
    set_valor(valor_adicionar) {
        this.valor = valor_adicionar;
    }
    get_valor() {
        return this.valor;
    }
}
const caixaDeString = new Caixa();
caixaDeString.set_valor('Olá, Mundo!');
const valorString = caixaDeString.get_valor();
console.log(`Valor armazenado: ${valorString}`);
const caixaDeNumero = new Caixa();
caixaDeNumero.set_valor(12345);
const valorNumero = caixaDeNumero.get_valor();
console.log(`Valor armazenado: ${valorNumero}`);
const caixaDeObjeto = new Caixa();
const pessoa = { nome: 'Maria', idade: 30 };
caixaDeObjeto.set_valor(pessoa);
const valorObjeto = caixaDeObjeto.get_valor();
console.log(`Valor armazenado:`, valorObjeto);
