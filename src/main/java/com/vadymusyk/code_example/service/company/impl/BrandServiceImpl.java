package com.vadymusyk.code_example.service.company.impl;

import com.vadymusyk.code_example.entity.company.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

/**
 * Created by vadymusyk on 15.08.17.
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    @Override
    public Brand findBrand(Long brandId) {
        return Optional.ofNullable(brandRepository.findOne(brandId))
                .orElseThrow(() -> new EntityNotFoundException("Brand with id " + brandId + " not found"));
    }

    @Override
    public Brand addNewBrand(String name) {
        return brandRepository.save(Brand.builder()
                .name(name.toLowerCase())
                .build());
    }

    @Override
    public void deleteBrand(long brandId) {
        brandRepository.delete(brandId);
    }

    @Override
    public Brand updateBrand(long brandId, String name) {
        Brand brand = brandRepository.findOne(brandId);
        brand.setName(name);
        return brandRepository.save(brand);
    }
}
