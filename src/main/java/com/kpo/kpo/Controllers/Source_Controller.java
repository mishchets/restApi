package com.kpo.kpo.Controllers;

import com.kpo.kpo.Domains.Source_;
import com.kpo.kpo.Repositories.Source_Repository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("source_")
@CrossOrigin(origins = "http://localhost:9000")
public class Source_Controller {
    private final Source_Repository source_Repository;

    @Autowired
    public Source_Controller(Source_Repository source_Repository) {
        this.source_Repository = source_Repository;
    }

    @GetMapping
    public List<Source_> list() {
        return source_Repository.findAll();
    }

    @GetMapping("{id}")
    public Source_ getOne(@PathVariable("id") Source_ source_) {
        return source_;
    }

    @PostMapping
    public Source_ create(@RequestBody Source_ source_) {
        return source_Repository.save(source_);
    }

    @PutMapping("{id}")
    public Source_ update(@PathVariable("id") Source_ source_FromDB, @RequestBody Source_ source_) {
        BeanUtils.copyProperties(source_, source_FromDB, "id");
        return source_Repository.save(source_FromDB);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Source_ source_) {
        source_Repository.delete(source_);
    }
}