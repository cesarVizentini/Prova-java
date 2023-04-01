package com.spring.familymanagement.parte2.parent;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ParentDAO {
    int insertParent(Parent parent);
    List<Parent> selectParents();
    Optional<Parent> selectParentById(int id);
    int deleteParent(int id);
    List<Map<String, Object>> selectFathers();
    List<Map<String, Object>> selectFathersWithMoreThanOneChild();
    List<Map<String, Object>> selectFathersAndMothers();
    Map<String, Object> selectNumberOfFatherChilds(String name);
    Map<String, Object> selectNumberOfMotherChilds(String name);
}
