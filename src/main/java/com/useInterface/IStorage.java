package com.useInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by agra on 3/17/2017.
 */
public interface IStorage {
    List<String> store();
    void read(List<String> savedValues);
}
