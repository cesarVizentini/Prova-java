package com.spring.familymanagement.parte2.parent;

import com.spring.familymanagement.parte2.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ParentService {

    private final ParentDAO parentDAO;

    public ParentService(ParentDAO parentDAO) {
        this.parentDAO = parentDAO;
    }

    public void addNewParent(Parent parent) {
        int result = parentDAO.insertParent(parent);
        if (result != 1) {
            throw new IllegalStateException("oops something went wrong");
        }
    }

    public List<Parent> getParents() {
        return parentDAO.selectParents();
    }

    public Parent getParent(int id) {
        return parentDAO.selectParentById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Parent with id %s not found", id)));
    }

    public void deleteParent(Integer id) {
        Optional<Parent> parents = parentDAO.selectParentById(id);
        parents.ifPresentOrElse(parent -> {
            int result = parentDAO.deleteParent(id);
            if (result != 1) {
                throw new IllegalStateException("oops could not delete Parent");
            }
        }, () -> {
            throw new NotFoundException(String.format("Parent with id %s not found", id));
        });
    }

    public List<Map<String, Object>> getFathers() {
        return parentDAO.selectFathers();
    }

    public List<Map<String, Object>> getFathersWithMoreThanOneChild() {
        return parentDAO.selectFathersWithMoreThanOneChild();
    }

    public List<Map<String, Object>> getFatherAndMothers() {
        return parentDAO.selectFathersAndMothers();
    }

    public Map<String, Object> getNumberOfFatherChilds(String name) {
        return parentDAO.selectNumberOfFatherChilds(name);
    }

    public Map<String, Object> getNumberOfMotherChilds(String name) {
        return parentDAO.selectNumberOfMotherChilds(name);
    }
}
