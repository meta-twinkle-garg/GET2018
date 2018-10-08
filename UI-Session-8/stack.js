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
    var string = "";
    for (var count = 0; count < this.items.length; count++)
        string += this.items[count] + " ";
    return string;
}
