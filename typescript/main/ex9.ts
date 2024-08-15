class Animal {
    protected som(): string {
        return "o animal faz um som";
    }
}

class Cachorro extends Animal {
    public override som(): string {
        return "o cachorro faz auau"
    }
}

class Gato extends Animal {
    public override som(): string {
        return "o gato faz miau"
    }
}

console.log(new Gato().som())
console.log(new Cachorro().som())