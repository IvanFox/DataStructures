package dataStructures.linked_list;


/**
 * Created by IvanLis on 13/10/15.
 */
public class LinkedList<T> {
    public Link firstLink;


    public boolean isEmpty(){
        return firstLink == null;
    }

    public void insertNewLink(T object){
        if (firstLink == null){
            firstLink = new Link(object);
        }
        else{
            Link newLink = new Link(object);
            newLink.next = firstLink;
            firstLink = newLink;
        }
    }

    public Link removeFirst(){
        Link deletedLink = firstLink;

        if(!isEmpty()){
            firstLink = firstLink.next;
        }
        else
            System.out.println("Empty link list");

        return deletedLink;
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
            if (theLink.getLink().toString().equals(object.toString())){
                return theLink;
            }
            while (!theLink.getLink().toString().equals(object.toString()) && theLink.next != null ){
                if (theLink.next.getLink().toString().equals(object.toString())){
                    return theLink.next;
                }
                else{
                    theLink = theLink.next;
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
                previousLink.next = currentLink.next;
                return currentLink;
            }

            previousLink = currentLink;
            currentLink = currentLink.next;


        }
        return null;

    }

}
