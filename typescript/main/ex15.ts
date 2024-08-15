const retorna_maior = (array: number[]): [number] => {
    array.sort()
    return [array[array.length - 1]]
}

console.log(retorna_maior([3, 2, 1]))