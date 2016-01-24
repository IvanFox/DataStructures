package dataStructures.trees.binary.immutable;

import java.util.function.BiFunction;
import java.util.function.Consumer;

/**
 * @author IvanLis
 * @version 1.0
 * @since 24/01/2016.
 * <p>
 * labs
 */
public interface INode<T> {

    public INode add(final T value);

    public void forEach(final Consumer<T> consumer);

    public int count();


}
