package com.ahau.service.rattan.base;

import com.ahau.entity.rattan.base.RattanSpec;
import com.ahau.repository.rattan.base.RattanSpecRepository1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class RattanSpecService1 {

    private final RattanSpecRepository1 rattanSpecRepository1;

    @Autowired
    public RattanSpecService1(RattanSpecRepository1 rattanSpecRepository1) {
        this.rattanSpecRepository1 = rattanSpecRepository1;
    }

    /**
     * 查询所有种列表
     *
     * @return
     */
    public List<RattanSpec> search() {
        return (List<RattanSpec>) rattanSpecRepository1.findAll();
    }
}
