package dataStructures.linked_list;


import java.util.Iterator;
import java.util.ListIterator;

/**
 * @author IvanLis
 * @version 1.0
 * @since 13/10/15.
 *
 * labs
 */
public class LinkedList<T> implements Iterable<T> {
    public Link firstLink;


    public boolean isEmpty(){
        return firstLink == null;
    }

    public void  insertNewLink(T object){
        if (firstLink == null){
            firstLink = new Link(object);
        }
        else{
            Link<T> curr = firstLink;
            while (curr.getNext() != null){
                curr = curr.getNext();
            }
            curr.setNext(new Link<T>(object));

        }
    }

    public Link removeFirst(){
        Link deletedLink = firstLink;

        if(!isEmpty()){
            firstLink = firstLink.getNext();
        }
        else
            System.out.println("Empty link list");

        return deletedLink;
    }

    public Link find(T object){

        Link theLink = firstLink;

        if (!isEmpty()){
            if (theLink.getLink().toString().equals(object.toString())){
                return theLink;
            }
            while (!theLink.getLink().toString().equals(object.toString()) && theLink.getNext() != null ){
                if (theLink.getNext().getLink().toString().equals(object.toString())){
                    return theLink.getNext();
                }
                else{
                    theLink = theLink.getNext();
                }
            }

        }
        return null;
    }

    public Link removeLink(T object){
        Link currentLink = firstLink;
        Link previousLink = firstLink;

        // if it is a first element
        if (currentLink.getLink().toString().equals(object.toString())){
            removeFirst();
        }

        while (currentLink != null){
            if (currentLink.getLink().toString().equals(object.toString())){
                previousLink.setNext(currentLink.getNext());
                return currentLink;
            }

            previousLink = currentLink;
            currentLink = currentLink.getNext();


        }
        return null;

    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    public class LinkedListIterator implements Iterator<T> {
        Link<T> curr = firstLink;

        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public T next() {
            Link<T> element = curr;
            curr = curr.getNext();
            return element.getLink();
        }
    }
}
