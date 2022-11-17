package tup.prestamos.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tup.prestamos.models.Prestamos;


@Repository
public interface PrestamosRepository extends CrudRepository<Prestamos, Long> {
}