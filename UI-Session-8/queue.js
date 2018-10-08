
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
    var queueItems = ""; 
    for(var count = 0; count < this.items.length; count++) 
        queueItems += this.items[count] +" "; 
    return queueItems; 
} 

