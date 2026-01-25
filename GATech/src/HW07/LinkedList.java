package HW07;

public class LinkedList<E> {
    private Node<E> head;
    private int size;

    private class Node<E> {
        private E data;
        private Node<E> next;

        private Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void clear() {
        this.head = null;
        this.size = 0;
    }

    public void add(int index, E newData) {
        Node<E> current = this.head;
        Node<E> newNode = null;
        int counter = 0;

        if(index < 0 || index > this.size)
                throw new IndexOutOfBoundsException("Index out of bounds: " +index);

        if(this.isEmpty() || index == 0) {
            this.head = new Node<E>(newData, this.head);
            this.size++;
        }
        else {
            while(counter != index - 1) {
                current = current.next;
                counter++;
            }
            current.next = new Node<E>(newData, current.next);
            this.size++;
        }
    }

    public void add(E newData) {
        add(this.size, newData);
    }

    public boolean contains(Object o) {
        boolean found = false;
        if(head == null)
            return found;
        else{
            Node<E> current = head;
            while(current != null) {
                if (current.data == null) {
                    if (o == null) 
                        return true;
                } 
                else if (current.data.equals(o))
                    return true;
                current = current.next;
            }
            
        }
        return found;
    }

    public E get(int index) {
        int counter = 0;
        E dataToReturn = null;
        Node<E> current = head;
        if(index < 0 || index >= size || isEmpty())
            throw new IndexOutOfBoundsException("Index out of bounds: " +index);
        while(current != null) {
            if(counter == index) {
                dataToReturn = current.data;
                break;
            }
            else {
                current = current.next;
                counter++;
            }
        }
        return dataToReturn;
    }

    public int indexOf(Object o) {
        int indexToReturn = -1;
        int counter = 0;
        Node<E> current = head;

        if(o == null && current.data == null)
            return indexToReturn;
        while(current != null) {
            if(current.data == null) {
                if(o == null) {
                    indexToReturn = counter;
                    break;
                }
            }
            else if(current.data.equals(o)) {
                indexToReturn = counter;
                break;
            }
            current = current.next;
            counter++;
        }
        return indexToReturn;
    }

    public E remove(int index) {
        if(index < 0 || index >= size || isEmpty())
            throw new IndexOutOfBoundsException("Index out of bounds: " +index);
        int counter = 0;
        Node<E> current = head;
        Node<E> removedNode = null;

        if(index == 0) {
            removedNode = head;
            head = current.next;
            size--;
        }
        else {
            while(current != null) {
                if(counter == index - 1) {
                    removedNode = current.next;
                    current.next = current.next.next;
                    size--;
                }
                current = current.next;
                counter++;
            }
        }
        return removedNode.data;
    }

    public boolean remove(Object o) {
        if(!contains(o) || isEmpty())
            return false;
        Node<E> current = head;
        if(head.data == null) {
            if(o == null) {
                head = head.next;
                size--;
                return true;
            }
        }
        else if(head.data.equals(o)) {
            if(size == 1)
                head = null;
            else
                head = head.next;
            size--;
            return true;
        }
        while(current.next != null) {
            if(o == null) {
                if(current.next.data == null) {
                    current.next = current.next.next == null ? null : current.next.next;
                    break;
                }
                else {
                    current = current.next;
                    continue;                    
                }
            }
            if(current.next.data.equals(o)) {
                current.next = current.next.next == null ? null : current.next.next;
                break;
            }
            current = current.next;
        }
        size--;
        return true;
    }

    public E set(int index, E newData) {
        if(index < 0 || index > size - 1 || isEmpty())
            throw new IndexOutOfBoundsException("Index out of bounds: " +index);
        Node<E> current = head;
        E oldData = null;
        int counter = 0;
        while(current != null) {
            if(counter != index) {
                counter++;
                current = current.next;
                continue;
            }
            else {
                oldData = current.data;
                current.data = newData;
                break;                
            }
        }
        return oldData;
    }

    public String toString() {
        String stringToReturn = "";
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            String stringElement = current.data == null ? "null" : current.data.toString();
            stringToReturn = stringToReturn + stringElement;
            if(i != (size - 1))
                stringToReturn += ", ";
            current = current.next;
        }

        stringToReturn = "[" + stringToReturn + "]";
        return stringToReturn;
    }

    public boolean equals(Object o) {
        return true;
    }
}
