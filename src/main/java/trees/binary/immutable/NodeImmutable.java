package trees.binary.immutable;

import java.util.function.BiFunction;
import java.util.function.Consumer;

/**
 * @author IvanLis
 * @version 1.0
 * @since 24/01/2016.
 * <p>
 * labs
 */
public class NodeImmutable<T extends Comparable> implements INode<T> {

    private final T value;

    private final INode<T> left;

    private final INode<T> right;

    public NodeImmutable(final T value,final INode<T> left,final INode<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    @Override
    public INode add(final T value) {
        if (value.equals(this.value)) return this;
        if (this.value.compareTo(value) > 0) {
            if (left == null) {
                return new NodeImmutable<>(this.value,
                        new NodeImmutable<>(value, null, null)
                        , right);
            }
            return new NodeImmutable<>(this.value, left.add(value), right);
        }
        if (right == null) {
            return new NodeImmutable<>(this.value, left ,new NodeImmutable<>(value, null, null));
        }
        return new NodeImmutable<>(this.value, left, right.add(value));
    }

    @Override
    public void forEach(Consumer<T> consumer) {
        if (left != null) left.forEach(consumer);
        consumer.accept(this.value);
        if (right != null) right.forEach(consumer);


    }

    @Override
    public int count() {
        int leftCount = left != null ? left.count() : 0;
        int rightCount = right != null ? right.count() : 0;
        return  leftCount + rightCount + 1;
    }

    @Override
    public T getValue() {
        return value;
    }
}
