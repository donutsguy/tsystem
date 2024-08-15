const recebe_tupla = (tupla: [number, number]): string => {
    return `
        ponto x : ${tupla[0]}
        ponto y : ${tupla[1]}
    `
}

console.log(recebe_tupla([10, 20]))