package com.paulovictor.cursomc.repositories;

import com.paulovictor.cursomc.domain.Estado;
import com.paulovictor.cursomc.dto.EstadoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
    @Transactional(readOnly = true)
    List<Estado> findAllByOrderByNome();
}

