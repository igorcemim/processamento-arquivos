package br.com.cemim.analisevendas.repository;

import br.com.cemim.analisevendas.entity.ArquivoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArquivoRepository extends JpaRepository<ArquivoEntity, Long> {
    ArquivoEntity findByCaminho(String caminho);
}
