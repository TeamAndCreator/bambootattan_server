package com.ahau.repository.file;


import com.ahau.entity.file.Files;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface FilesRepository extends JpaRepository<Files, Long>, JpaSpecificationExecutor<Files> {
    void deleteByIdIn(List<Long> ids);
    void findByIdIn(List<Long> ids);
}
