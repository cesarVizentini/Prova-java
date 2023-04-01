package com.spring.familymanagement.parte1;

import com.spring.familymanagement.parte2.parent.ParentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/lists")
public class ListsController {

    private final ListsService listsService;

    public ListsController(ListsService listsService) {
        this.listsService = listsService;
    }

    @GetMapping("invertarray")
    public Student[] getInvertedArray(@RequestBody Student[] studentList) {
        return listsService.invertArray(studentList);
    }

    @GetMapping("invertarrayinplace")
    public Student[] getInvertedArrayInPlace(@RequestBody Student[] studentList) {
        return listsService.invertArrayInPlace(studentList);
    }

    @GetMapping("invertlistinplace")
    public List<Student> getInvertedListInPlace(@RequestBody List<Student> studentList) {
        return listsService.invertListInPlace(studentList);
    }

    @GetMapping("csv")
    public List<String[]> getCSVArray() {
        return listsService.convertCSV();
    }
}
