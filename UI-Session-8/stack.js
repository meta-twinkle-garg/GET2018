class Stack {
    constructor() {
        this.items = [];
    }
}

Stack.prototype.push = function (element) {
    this.items.push(element);
}
Stack.prototype.pop = function () {

    if (this.isEmpty()) {
        return "Underflow";
    }
    return this.items.pop();
}
Stack.prototype.isEmpty = function () {
    return this.items.length == 0;
}

Stack.prototype.printStack = function () {
    var str = "";
    for (var i = 0; i < this.items.length; i++)
        str += this.items[i] + " ";
    return str;
}
