package com.tsys.aula.repositories;

import com.tsys.aula.models.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface PostRepository extends JpaRepository<PostModel, Long>, JpaSpecificationExecutor<PostModel> {
    List<PostModel> findByViewsGreaterThan(Integer views);

    List<PostModel> findByViewsLessThan(Integer views);
}
