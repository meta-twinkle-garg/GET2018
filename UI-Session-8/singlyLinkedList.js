function Node(element) {

    this.element = element;
    this.next = null
}

function LinkedList() {

    this.size = 0;
    this.add = add;
    this.removeElement = removeElement;
    this.printList = printList;
}

function add(element) {
    var node = new Node(element);

    var current;

    if (this.head == null)
        this.head = node;
    else {
        current = this.head;

        while (current.next) {
            current = current.next;
        }

        current.next = node;
    }
    this.size++;
}

function removeElement(element) {
    var current = this.head;
    var prev = null;
    while (current != null) {

        if (current.element == element) {
            if (prev == null) {
                this.head = current.next;
            } else {
                prev.next = current.next;
            }
            this.size--;
            return current.element;
        }
        prev = current;
        current = current.next;
    }
}

function printList() {
    var curr = this.head;
    var str = "";
    while (curr) {
        str += curr.element + " ";
        curr = curr.next;
    }
    console.log(str);
}
