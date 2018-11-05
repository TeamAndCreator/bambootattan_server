package com.ahau.service;

import com.ahau.entity.bamboo.base.Genus;
import com.ahau.repository.GenusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * 描述：用户服务层接口
 *
 * @author 张理
 * 2018-11-3 19:22
 */
@Transactional
@Service
public class GenusService {

    private final GenusRepository genusRepository;

    @Autowired
    public GenusService(GenusRepository genusRepository) {
        this.genusRepository = genusRepository;
    }

    public List<Genus> findAll() {
        return genusRepository.findAll();
    }

    public Genus findById(Long id){

        Optional<Genus> genusOptional = genusRepository.findById(id);
        Genus genus = new Genus();
        if (genusOptional.isPresent()) {
            genus= genusOptional.get();
        } else {
            // handle not found, return null or throw
            System.out.println("no exit!");
        }
        return genus;
    }



    public Genus save(Genus genus) {
        return genusRepository.save(genus);
    }

    public void delete(Long id) {
        genusRepository.deleteById(id);
    }
}
