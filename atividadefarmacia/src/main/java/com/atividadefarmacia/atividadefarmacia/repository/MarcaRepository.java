package com.atividadefarmacia.atividadefarmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atividadefarmacia.atividadefarmacia.model.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long>
{
}
