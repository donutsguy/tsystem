"use strict";
let basico_1 = "palavra";
let basico_2 = 2;
let basico_3 = true;
let basico_4 = ["oi"];
const recebe_tipos = (dado) => {
    let res = "";
    if (Array.isArray(dado)) {
        res = dado.join(", ");
    }
    else {
        res = dado.toString();
    }
    return res;
};
console.log(recebe_tipos(11));
