package com.bezkoder.spring.data.mongodb.Repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bezkoder.spring.data.mongodb.model.BarangModel;

public interface BarangRepo extends MongoRepository<BarangModel, String> {
    List<BarangModel> findByNamaContaining(String nama);
}
