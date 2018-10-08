
class Queue {
    constructor() {
        this.items = [];
    }
}

Queue.prototype.enqueue=function(element) {
        this.items.push(element);
    }
Queue.prototype.dequeue=function() 
{ 

    if(this.isEmpty()) 
        return "Underflow"; 
    return this.items.shift(); 
} 
Queue.prototype.isEmpty=function() 
{ 
    return this.items.length == 0; 
} 

Queue.prototype.printQueue=function() 
{ 
    var str = ""; 
    for(var i = 0; i < this.items.length; i++) 
        str += this.items[i] +" "; 
    return str; 
} 

