package servers;

import java.util.NoSuchElementException;


public class Optional <T>{

    T value;

    public Optional (T value){
        this.value = value;
    }

    public T get(){

        if (value == null) throw new NoSuchElementException();

        return value;
    }

    public T orElse (T other) {return value == null ? other : value;}

    public boolean isPresent() {return value != null;}



}
