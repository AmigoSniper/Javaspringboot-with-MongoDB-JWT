package com.bezkoder.spring.data.mongodb.Repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bezkoder.spring.data.mongodb.model.PelangganModel;

public interface PelangganRepo extends MongoRepository<PelangganModel, String> {
    List<PelangganModel> findByNamaContaining(String nama);
}
