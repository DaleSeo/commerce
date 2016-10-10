package seo.dale.commerce.record.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import seo.dale.commerce.record.repository.RecordRepository;

@RestController
@RequestMapping("/record")
public class RecordController {

    private RecordRepository repository;

    @Autowired
    public RecordController(RecordRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String get() {
        return "GET";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String post() {
        return "POST";
    }

}
