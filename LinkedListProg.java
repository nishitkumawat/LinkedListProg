class LinkedListProg {
    public static void main(String[] args) {
        List l = new List();
        l.insertFromRear(1);
        l.insertFromRear(2);
        l.insertFromRear(3);
        l.insertFromRear(4);
        l.insertFromFront(10);
        l.insertFromFront(20);
        System.out.println(l.areAllElemnets());
        System.out.println("Nishit");
    }
}

class List {
    class Node {
        int data;
        Node next;

        Node(int y) {
            data = y;
        }
    }

    Node head;

    boolean areAllElemnets() {
        if (head == null) {
            System.out.println("return");
            return true;
        } else {
            boolean check = true;
            Node temp1 = head;
            Node temp2 = head;
            while (temp1 != null) {
                while (temp2 != null) {
                    if (temp1.data == temp2.data) {
                        check = false;
                        break;
                    }
                    temp2 = temp2.next;
                }

                temp1 = temp1.next;
                temp2 = head;
            }
            return check;
        }
    }

    void reverse(Node first) {
        if (head == null) {
            System.out.println("empty list");
        } else {
            if (first == null) {
                return;
            } else {
                reverse(first.next);
                System.out.print(first.data + " ");
            }
        }
    }

    void insertFromRear(int y) {
        if (head == null) {
            head = new Node(y);
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(y);
        }
    }

    void insertFromFront(int y) {
        if (head == null) {
            head = new Node(y);
        } else {
            Node temp = new Node(y);
            temp.next = head;
            head = temp;
        }
    }

    int deleteFromFront() {
        if (head == null) {
            System.out.println("List is empty!!!!!");
            return 0;
        } else {
            int y = head.data;
            Node temp = head.next;
            head.next = null;
            head = temp;
            return y;
        }
    }

    int deleteFromRear() {
        if (head == null) {
            System.out.println("List is empty!!!!!");
            return 0;
        } else {
            Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            int y = temp.next.data;
            temp.next = null;

            return y;
        }
    }

    void insertAtAfter(int after, int y) {
        if (head == null) {
            System.out.println("List is empty!!!!!");
            return;
        } else {
            boolean check = false;
            Node temp = head;
            while (temp != null) {
                if (temp.data == after) {
                    check = true;
                    break;
                }
                temp = temp.next;
            }
            if (check) {
                Node ToAdd = new Node(y);
                Node temp1 = temp.next;
                temp.next = ToAdd;
                ToAdd.next = temp1;
            } else {
                System.out.println("Element not found");
            }
        }
    }

    void insertAtBefore(int before, int y) {
        if (head == null) {
            System.out.println("List is empty!!!!!");
            return;
        } else if (head.data == before) {
            insertFromFront(y);
        } else {
            boolean check = false;
            Node temp = head;
            while (temp.next != null) {
                if (temp.next.data == before) {
                    check = true;
                    break;
                }
                temp = temp.next;
            }
            if (check) {
                Node ToAdd = new Node(y);
                Node temp1 = temp.next;
                temp.next = ToAdd;
                ToAdd.next = temp1;
            } else {
                System.out.println("Element not found");
            }
        }
    }

    void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
