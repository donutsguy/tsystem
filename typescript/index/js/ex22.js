"use strict";
function add_items_to_list(items, ul_id) {
    const ul_element = document.getElementById(ul_id);
    if (!ul_element || !(ul_element instanceof HTMLUListElement)) {
        console.error(`Elemento <ul> com id "${ul_id}" não encontrado.`);
        return;
    }
    ul_element.innerHTML = '';
    items.forEach(item => {
        const li_element = document.createElement('li');
        // Define o texto do novo <li>
        li_element.textContent = item;
        // Adiciona o novo <li> ao <ul>
        ul_element.appendChild(li_element);
    });
}
const items = ['Item 1', 'Item 2', 'Item 3'];
add_items_to_list(items, 'myList');
