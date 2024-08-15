"use strict";
const retorna_maior = (array) => {
    array.sort();
    return [array[array.length - 1]];
};
console.log(retorna_maior([3, 2, 1]));
