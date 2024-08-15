"use strict";
class Carro {
    constructor(marca, modelo, ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }
    retorna_descricao(carro) {
        return `
            marca: ${carro.marca} 
            modelo: ${carro.modelo}
            ano: ${carro.ano}
        `;
    }
}
const carro1 = new Carro('Toyota', 'Corolla', 2020);
const carro2 = new Carro('Honda', 'Civic', 2021);
const carro3 = new Carro('Ford', 'Mustang', 2019);
console.log(carro1.retorna_descricao(carro1));
console.log(carro2.retorna_descricao(carro2));
console.log(carro3.retorna_descricao(carro3));
