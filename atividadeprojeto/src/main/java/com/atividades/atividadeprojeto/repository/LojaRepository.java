package com.atividades.atividadeprojeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atividades.atividadeprojeto.model.Loja;

@Repository
public interface LojaRepository extends JpaRepository<Loja, Long>
{
}