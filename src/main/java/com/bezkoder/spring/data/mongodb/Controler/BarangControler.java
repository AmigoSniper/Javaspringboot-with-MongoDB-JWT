package com.bezkoder.spring.data.mongodb.Controler;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.data.mongodb.Repo.BarangRepo;
import com.bezkoder.spring.data.mongodb.model.BarangModel;

@CrossOrigin(origins = "http://localhost:8082")
@RestController
@RequestMapping("/api/barang")
public class BarangControler {
    @Autowired
    BarangRepo barangRepo;

    @PostMapping("/tambah")
    public ResponseEntity<BarangModel> createTutorial(@RequestBody BarangModel barangModel) {
        try {
            BarangModel _barangModel = barangRepo
                    .save(new BarangModel(barangModel.getNama(), barangModel.getDeskripsi(), barangModel.getStock(),
                            barangModel.getHarga(), barangModel.getKategori()));
            return new ResponseEntity<>(_barangModel, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/barangs")
    public ResponseEntity<List<BarangModel>> getAllTutorials(@RequestParam(required = false) String title) {
        try {
            List<BarangModel> barangModels = new ArrayList<BarangModel>();

            if (title == null)
                barangRepo.findAll().forEach(barangModels::add);
            else
                barangRepo.findByNamaContaining(title).forEach(barangModels::add);

            if (barangModels.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(barangModels, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/barangs/{id}")
    public ResponseEntity<BarangModel> getTutorialById(@PathVariable("id") String id) {
        Optional<BarangModel> BarangModel = barangRepo.findById(id);

        if (BarangModel.isPresent()) {
            return new ResponseEntity<>(BarangModel.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/barangs/{id}")
    public ResponseEntity<BarangModel> updateBarang(@PathVariable("id") String id,
            @RequestBody BarangModel barangModel) {
        Optional<BarangModel> BarangData = barangRepo.findById(id);

        if (BarangData.isPresent()) {
            BarangModel _BarangModel = BarangData.get();
            _BarangModel.setNama((barangModel.getNama()));
            _BarangModel.setDeskripsi((barangModel.getDeskripsi()));
            _BarangModel.setStock((barangModel.getStock()));
            _BarangModel.setHarga((barangModel.getHarga()));
            _BarangModel.setKategori((barangModel.getKategori()));
            return new ResponseEntity<>(barangRepo.save(_BarangModel), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/barangs/{id}")
    public ResponseEntity<HttpStatus> deleteBarang(@PathVariable("id") String id) {
        try {
            barangRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/barangs")
    public ResponseEntity<HttpStatus> deleteAllTutorials() {
        try {
            barangRepo.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
