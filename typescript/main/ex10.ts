class Funcionario {
    protected nome: string
    protected salario: number

    constructor(nome: string, salario: number) {
        this.nome = nome
        this.salario = salario
    }

    protected calcular_salario() { }
}

class FuncionarioAssalariado extends Funcionario {
    constructor(nome: string, salario: number) {
        super(nome, salario)
    }

    public override calcular_salario(): number {
        return this.salario * 2
    }
}

class FuncionarioHorista extends Funcionario {
    constructor(nome: string, salario: number) {
        super(nome, salario)
    }

    public override calcular_salario(): number {
        return this.salario * 3
    }
}

const func_1: FuncionarioAssalariado = new FuncionarioAssalariado("muliro", 100)
const func_2: FuncionarioHorista = new FuncionarioHorista("mulirao", 100)

console.log(func_1.calcular_salario())
console.log(func_2.calcular_salario())
