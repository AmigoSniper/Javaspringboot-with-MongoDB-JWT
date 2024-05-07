package com.bezkoder.spring.data.mongodb.Controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.data.mongodb.Repo.PelangganRepo;
import com.bezkoder.spring.data.mongodb.model.PelangganModel;

@CrossOrigin(origins = "http://localhost:8082")
@RestController
@RequestMapping("api/pelanggan")
public class PelangganControler {
    @Autowired
    PelangganRepo pelangganRepo;

    @PostMapping("/tambah")
    public ResponseEntity<PelangganModel> createTutorial(@RequestBody PelangganModel pelangganModel) {
        try {
            PelangganModel _PelangganModel = pelangganRepo
                    .save(new PelangganModel(pelangganModel.getNama(), pelangganModel.getNo(),
                            pelangganModel.getJeniskelamin(), pelangganModel.getAlamat()));
            return new ResponseEntity<>(_PelangganModel, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
