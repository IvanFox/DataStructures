package DataStructures.linked_list;

import java.util.List;

/**
 * Created by IvanLis on 13/10/15.
 */
public class LinkedList<T> {
    public Link<T> firstLink;


    public boolean isEmpty(){
        return firstLink == null;
    }

    public void insertNewLink(T object){
        if (firstLink == null){
            firstLink = new Link<>(object);
        }
        else{
            Link newLink = new Link(object);
            newLink.next = firstLink;
            firstLink = newLink;
        }
    }

    public Link removeFirst(){
        Link linkReference = firstLink;

        if(!isEmpty()){
            firstLink = firstLink.next;
        }
        else
            System.out.println("Empty link list");

        return linkReference;
    }

    public void display(){
        Link theLink = firstLink;
        System.out.println(theLink.toString());

        while(theLink.next != null){
            System.out.println(theLink.next.toString());
            theLink = theLink.next;
        }
    }

    public Link find(T object){

        Link theLink = firstLink;

        if (!isEmpty()){
            while (theLink.getLink() != object){
                if (theLink.next == null){
                    break;
                }
                else{
                    theLink = theLink.next;
                }
            }
        }
        return theLink;
    }

    public Link removeLink(T object){
        Link currentLink = firstLink;
        Link previousLink = firstLink;

        while (currentLink.getLink() != object){
            if (currentLink.next == null){
                return null;
            }
            else{
                previousLink = currentLink;
                currentLink = currentLink.next;
            }

            if (currentLink == firstLink){
                firstLink = firstLink.next;
            }
            else {
                previousLink.next = currentLink;
            }
        }
        return currentLink;
    }

}
