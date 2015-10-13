package DataStructures.linked_list;

/**
 * Created by IvanLis on 13/10/15.
 */
public class Link <T> {

    public T link;

    public Link <T> next;



    public Link (T link) {
        this.link = link;

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
