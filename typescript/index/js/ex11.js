"use strict";
function retorna_primeiro(valor) {
    return valor[0];
}
const strings = ['Olá', 'Mundo', 'TypeScript', 'Array', 'Exemplo'];
console.log(retorna_primeiro(strings));
const numeros = [10, 20, 30, 40, 50];
console.log(retorna_primeiro(numeros));
class Cone {
    constructor(tamanho, cor) {
        this.tamanho = tamanho;
        this.cor = cor;
    }
}
const cones = [
    new Cone('Toyota', 'Corolla'),
    new Cone('Honda', 'Civic'),
    new Cone('Ford', 'Mustang')
];
console.log(retorna_primeiro(cones));
