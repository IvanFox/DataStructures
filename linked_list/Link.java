package dataStructures.linked_list;

/**
 * @author IvanLis
 * @version 1.0
 * @since 13/10/15.
 * <p>
 * labs
 */
public class Link<T> {

    private T link;

    private Link<T> next;


    public Link(T link) {
        this.link = link;

    }

    public Link<T> getNext() {
        return next;
    }

    public void setNext(Link<T> next) {
        this.next = next;
    }

    public void setLink(T link) {
        this.link = link;
    }

    public T getLink() {
        return link;
    }

    @Override
    public String toString() {
        return link.toString();
    }
}
