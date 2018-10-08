function Node(element) { 
    this.element = element; 
    this.next = null; 
    this.previous = null; 
} 

function LinkedList() { 
    this.head = new Node("head"); 
    this.insert = insert; 
    this.display = display; 
    this.remove = remove; 
} 

function remove(item) { 
    var currNode = this.head;
    while (currNode.element != item) { 
        currNode = currNode.next; 
    } 
    if (!(currNode.next == null)) { 
        currNode.previous.next = currNode.next; 
        currNode.next.previous = currNode.previous; 
        currNode.next = null; 
        currNode.previous = null; 
    } 
} 

function display() { 
    var currNode = this.head; 
    while (!(currNode.next == null)) { 
        console.log(currNode.next.element); 
        currNode = currNode.next; 
    } 
} 

function insert(newElement) { 
    var newNode = new Node(newElement); 
    var currNode = this.head;
    while (currNode.next != null) { 
        currNode = currNode.next; 
    } 
    newNode.previous = currNode; 
    currNode.next = newNode; 
} 