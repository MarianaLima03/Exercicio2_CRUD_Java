package com.mariana.ex2.Repository;

import com.mariana.ex2.Model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository <ProdutoModel, Long> {
}
