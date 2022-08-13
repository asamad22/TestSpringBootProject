package bd.com.dipti.testspring.repository;

import bd.com.dipti.testspring.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    public Long countById(Integer id);
}
