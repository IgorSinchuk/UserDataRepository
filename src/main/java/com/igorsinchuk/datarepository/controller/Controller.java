package com.igorsinchuk.datarepository.controller;

import com.igorsinchuk.datarepository.model.UserData;
import com.igorsinchuk.datarepository.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/data")
public class Controller {

    @Autowired
    private DataRepository dataRepository;

    @GetMapping("/disk")
    public List<UserData> getAllData() {
        return dataRepository.findAll();
    }

    @PostMapping("/disk")
    public UserData createData(@Valid @RequestBody UserData data) {
        return dataRepository.save(data);
    }

    @GetMapping("/disk/{id}")
    public ResponseEntity<Object> getDataById (@PathVariable(value = "id") Long dataId) {
        UserData data = dataRepository.findOne(dataId);
        if (data==null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(data);
    }

    @PutMapping("/disk/{id}")
    public ResponseEntity<UserData> updateData(@PathVariable(value = "id") Long dataId,
                                             @Valid @RequestBody UserData dataDetails) {

        UserData data = dataRepository.findOne(dataId);
        if (data==null) {
            return ResponseEntity.notFound().build();
        }

        data.setName(dataDetails.getName());
        data.setData(dataDetails.getData());
        data.setData2(dataDetails.getData2());
        data.setData3(dataDetails.getData3());

        UserData updateData = dataRepository.save(data);
        return ResponseEntity.ok(updateData);

    }

    @DeleteMapping("disk/{id}")
    public ResponseEntity<UserData> deleteData(@PathVariable(value = "id") Long dataId) {
        UserData data = dataRepository.findOne(dataId);
        if (data == null) {
            return ResponseEntity.ok().build();
        }

        dataRepository.delete(dataId);
        return ResponseEntity.ok().build();
    }
}
