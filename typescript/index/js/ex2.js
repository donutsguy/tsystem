"use strict";
class Livro {
    constructor(titulo, autor, numero_paginas, esta_disponivel) {
        this.titulo = titulo;
        this.autor = autor;
        this.numero_paginas = numero_paginas;
        this.esta_disponivel = esta_disponivel;
    }
}
const recebe_livro = (livro) => {
    return `Este ${livro.titulo} é muito legal`;
};
console.log(recebe_livro(new Livro("livro 22", "muliro", 500, true)));
