package Model;

import java.util.*;

public class Model {
    //private int size;
    private int[] array;

    public Model() {
    }

    public Model(int[] array) {
        this.array = array;
    }

    // public int getSize() {
    //     return size;
    // }

    // public void setSize(int size) {
    //     this.size = size;
    // }

    public int[] getArray() {
        return array;
    }

    public void setArray(int array[]) {
        this.array = array;
    }
}
