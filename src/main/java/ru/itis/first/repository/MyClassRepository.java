package ru.itis.first.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyClassRepository extends CrudRepository<MyClass,Long> {

}
