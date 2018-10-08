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
    var currentNode = this.head;
    while (currentNode.element != item) { 
        currentNode = currentNode.next; 
    } 
    if (!(currentNode.next == null)) { 
        currentNode.previous.next = currentNode.next; 
        currentNode.next.previous = currentNode.previous; 
        currentNode.next = null; 
        currentNode.previous = null; 
    } 
} 

function display() { 
    var currentNode = this.head; 
    while (!(currentNode.next == null)) { 
        console.log(currentNode.next.element); 
        currentNode = currentNode.next; 
    } 
} 

function insert(newElement) { 
    var newNode = new Node(newElement); 
    var currentNode = this.head;
    while (currentNode.next != null) { 
        currentNode = currentNode.next; 
    } 
    newNode.previous = currentNode; 
    currentNode.next = newNode; 
} 
