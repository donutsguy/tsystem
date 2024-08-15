class Livro {
    titulo: string
    autor: string
    numero_paginas: number
    esta_disponivel: boolean

    constructor(titulo: string, autor: string, numero_paginas: number, esta_disponivel: boolean) {
        this.titulo = titulo
        this.autor = autor
        this.numero_paginas = numero_paginas
        this.esta_disponivel = esta_disponivel
    }
}

const recebe_livro = (livro: Livro): string => {
    return `Este ${livro.titulo} é muito legal`
}

console.log(recebe_livro(new Livro("livro 22", "muliro", 500, true)))