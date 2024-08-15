"use strict";
class Animal {
    som() {
        return "o animal faz um som";
    }
}
class Cachorro extends Animal {
    som() {
        return "o cachorro faz auau";
    }
}
class Gato extends Animal {
    som() {
        return "o gato faz miau";
    }
}
console.log(new Gato().som());
console.log(new Cachorro().som());
