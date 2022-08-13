package bd.com.dipti.testspring.service;

import antlr.StringUtils;
import bd.com.dipti.testspring.entity.Teacher;
import bd.com.dipti.testspring.repository.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepo teacherRepo;

    public void teaacherSave(Teacher t){
        teacherRepo.save(t);
    }
    public List<Teacher> allTeacher(){
        return teacherRepo.findAll();
    }
}
