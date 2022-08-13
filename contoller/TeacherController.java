package bd.com.dipti.testspring.contoller;

import bd.com.dipti.testspring.entity.Teacher;
import bd.com.dipti.testspring.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TeacherController {
    @Autowired
    private  TeacherService teacherService;
    @GetMapping("/teacher")
    public String allTeacher(Model model){
        List<Teacher>list=teacherService.allTeacher();
        model.addAttribute("list",list);
        return "teacherlist";
    }
    @GetMapping("/newteacher")
    public String showTeacherForm(Model model,Teacher t){
        model.addAttribute("teacher", new Teacher());
        return "teachersave";
    }
    @PostMapping("/saveteacher")
    public String saveTeacher(Teacher t){
        teacherService.teaacherSave(t);
        return "redirect:/teacher";
    }

}
