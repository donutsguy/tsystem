"use strict";
const recebe_tupla = (tupla) => {
    return `
        ponto x : ${tupla[0]}
        ponto y : ${tupla[1]}
    `;
};
console.log(recebe_tupla([10, 20]));
