"use strict";
const conta_vogal = (palavra) => {
    return palavra.split("").reduce((count, letra) => {
        switch (letra.toLowerCase()) {
            case "a":
            case "e":
            case "i":
            case "o":
            case "u":
                count++;
                break;
        }
        return count;
    }, 0);
};
console.log(conta_vogal("banana"));
