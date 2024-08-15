"use strict";
function getValue(obj, key) {
    return obj[key];
}
const user = {
    id: 1,
    name: 'Alice Smith',
    email: 'alice.smith@example.com'
};
const userId = getValue(user, 'id');
const userName = getValue(user, 'name');
const userEmail = getValue(user, 'email');
console.log(userId);
console.log(userName);
console.log(userEmail);
