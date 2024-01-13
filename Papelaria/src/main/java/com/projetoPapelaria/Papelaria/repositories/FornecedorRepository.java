package com.projetoPapelaria.Papelaria.repositories;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.projetoPapelaria.Papelaria.entities.Fornecedor;

@Repository
public interface FornecedorRepository extends JpaRepositoryImplementation<Fornecedor, Long> {

}
