package com.ahau.service.bamboo.base;

import com.ahau.entity.bamboo.base.Spec;
import com.ahau.repository.bamboo.base.EsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * 描述：搜索引擎服务层
 * Created by: zhangli
 * 2019-2-17
 */
@Transactional
@Service
public class EsService {

    private final EsRepository esRepository;

    @Autowired
    public EsService(EsRepository esRepository) {
        this.esRepository = esRepository;
    }

    public List<Spec> search() {
        return (List<Spec>) esRepository.findAll();
    }

}
