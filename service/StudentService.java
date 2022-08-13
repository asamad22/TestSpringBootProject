package bd.com.dipti.testspring.service;

import bd.com.dipti.testspring.entity.Student;
import bd.com.dipti.testspring.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository sr;

    public void save(Student s){

        sr.save(s);
    }
    public List<Student> sList(){

        return (List<Student>) sr.findAll();
    }
    public Student get (Integer id)throws StudentNotFoundException {
        Optional<Student> result=sr.findById(id);
        if (result.isPresent()){
            return result.get();
        }throw new StudentNotFoundException("No Student Found"+id);
    }

    public void delete(Integer id) throws StudentNotFoundException{

        Long count=sr.countById(id);
        if (count==null || count==0){
            throw new StudentNotFoundException("No Student Found"+id);
        }
        sr.deleteById(id);
    }
}
