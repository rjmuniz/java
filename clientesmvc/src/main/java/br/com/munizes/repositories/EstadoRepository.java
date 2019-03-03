package br.com.munizes.repositories;

import org.springframework.stereotype.Repository;
import br.com.munizes.Models.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}
