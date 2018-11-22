package com.ahau.service.bamboo.base;

import com.ahau.entity.bamboo.base.Spec;
import com.ahau.repository.bamboo.base.SpecRepository;
import com.ahau.repository.bamboo.base.SpecRepository1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 竹种服务层接口
 * Created by: 张理
 * 2018-11-12
 */
@Transactional
@Service
public class SpecService1 {

    private final SpecRepository1 specRepository1;

    @Autowired
    public SpecService1(SpecRepository1 specRepository1) {
        this.specRepository1 = specRepository1;
    }

    /**
     * 查询所有种列表
     *
     * @return
     */
    public List<Spec> search() {
        return (List<Spec>) specRepository1.findAll();
    }


}
