package br.com.matheuscsant.estudando_spring.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.matheuscsant.estudando_spring.models.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

	Optional<Person> findByEmail(String email);

	// Index parameters
	@Query("select p from Person p where p.firstName = ?1 and p.lastName = ?2")
	Person findByJPQL(String firstName, String lastName);

	// Named parameters
	@Query("select p from Person p where p.firstName = :firstName and p.lastName = :lastName")
	Person findByJPQLNamedParameters(@Param("firstName") String firstName, @Param("lastName") String lastName);

	// Native SQL with index parameters
	@Query(value = "select * from tb_person p where p.first_name = ?1 and p.last_name = ?2", nativeQuery = true)
	Person findByNativeSQL(String firstName, String lastName);

	// Native SQL with named parameters
	@Query(value = "select * from tb_person p where p.first_name = :firstName and p.last_name = :lastName", nativeQuery = true)
	Person findByNativeSQLNamedParameters(@Param("firstName") String firstName, @Param("lastName") String lastName);

}
