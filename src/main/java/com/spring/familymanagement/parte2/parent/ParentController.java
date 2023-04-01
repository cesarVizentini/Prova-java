package com.spring.familymanagement.parte2.parent;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/parent")
public class ParentController {

    private final ParentService parentService;

    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }

    @PostMapping
    public void addParent(@RequestBody Parent parent) {
        parentService.addNewParent(parent);
    }

    @GetMapping
    public List<Parent> listParents() {
        return parentService.getParents();
    }

    @GetMapping("{id}")
    public Parent getParentId(@PathVariable("id") Integer id) {
        return parentService.getParent(id);
    }

    @DeleteMapping("{id}")
    public void deleteParent(@PathVariable("id") Integer id) {
        parentService.deleteParent(id);
    }

    @GetMapping("/fathers")
    public List<Map<String, Object>> listFathers() {
        return parentService.getFathers();
    }

    @GetMapping("/fathers/morethanonechild")
    public List<Map<String, Object>> listFathersWithMoreThanOneChild() {
        return parentService.getFathersWithMoreThanOneChild();
    }

    @GetMapping("/fathersandmothers")
    public List<Map<String, Object>> listFathersAndMothers() {
        return parentService.getFatherAndMothers();
    }

    @GetMapping("numberoffatherchilds/{name}")
    public Map<String, Object> getNumberOfFatherChilds(@PathVariable("name") String name) {
        return parentService.getNumberOfFatherChilds(name);
    }

    @GetMapping("numberofmotherchilds/{name}")
    public Map<String, Object> getNumberOfMotherChilds(@PathVariable("name") String name) {
        return parentService.getNumberOfMotherChilds(name);
    }
}
