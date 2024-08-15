function add_div_to_body(text: string): void {
    const new_div = document.createElement('div');

    new_div.textContent = text;

    document.body.appendChild(new_div);
}

add_div_to_body('Este é um texto');
