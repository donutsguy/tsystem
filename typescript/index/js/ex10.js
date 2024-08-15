"use strict";
class Funcionario {
    constructor(nome, salario) {
        this.nome = nome;
        this.salario = salario;
    }
    calcular_salario() { }
}
class FuncionarioAssalariado extends Funcionario {
    constructor(nome, salario) {
        super(nome, salario);
    }
    calcular_salario() {
        return this.salario * 2;
    }
}
class FuncionarioHorista extends Funcionario {
    constructor(nome, salario) {
        super(nome, salario);
    }
    calcular_salario() {
        return this.salario * 3;
    }
}
const func_1 = new FuncionarioAssalariado("muliro", 100);
const func_2 = new FuncionarioHorista("mulirao", 100);
console.log(func_1.calcular_salario());
console.log(func_2.calcular_salario());
