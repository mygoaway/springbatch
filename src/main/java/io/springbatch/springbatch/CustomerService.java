package io.springbatch.springbatch;

public class CustomerService<T> {

    public int cnt = 0;

    public T customRead() {
        return (T) ("item" + cnt++);
    }
}
