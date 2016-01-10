package dataStructures.fun;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author IvanLis
 * @version 1.0
 * @since 10/01/2016.
 * <p>
 * labs
 */
public class University implements Iterable<Student>{

    private final Student[] students;

    public University(Student[] students) {
        this.students = students;
    }


    @Override
    public Iterator<Student> iterator() {
        return Arrays.asList(students).iterator();
    }


}
