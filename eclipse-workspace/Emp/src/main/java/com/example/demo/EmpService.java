package com.example.demo;

import java.util.List;
import java.util.Optional;

public interface EmpService {

    Emp saveData(Emp emp);

    List<Emp> getData();

    Optional<Emp> getById(int id);

    void deleteData(int id);
}
