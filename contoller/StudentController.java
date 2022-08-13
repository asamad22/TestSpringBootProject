package bd.com.dipti.testspring.contoller;

import bd.com.dipti.testspring.entity.Student;
import bd.com.dipti.testspring.repository.StudentRepository;
import bd.com.dipti.testspring.service.StudentNotFoundException;
import bd.com.dipti.testspring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/student")
    public String allStudent(Model model,RedirectAttributes ra){
        List<Student> list=studentService.sList();
        model.addAttribute("list",list);
        ra.addFlashAttribute("title","Student Save");
        return "studentlist";
    }
    @GetMapping("/studentnew")

    public String studentForm(Model model,RedirectAttributes ra){
        model.addAttribute("student",new Student());
        ra.addFlashAttribute("title","Student Save");
        return "studentform";
    }
    @PostMapping("/saveStudent")
    public String saveStudent(Student s, RedirectAttributes ra){
        studentService.save(s);
        ra.addFlashAttribute("message","Save Successfully.");
        return "redirect:/student";
    }
    @GetMapping("/update/{id}")
    public String showEditStudent(@PathVariable ("id") Integer id,Model model,RedirectAttributes ra){
        try {
            Student student=studentService.get(id);
            model.addAttribute("student",student);
            return "studentform";
        } catch (StudentNotFoundException e) {
            ra.addFlashAttribute("message",e.getMessage());
            return "redirect:/student";
        }
    }
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Integer id, Model model,RedirectAttributes ra ){
        try {
            studentService.delete(id);
            ra.addFlashAttribute("message","Data Deleted");
        } catch (StudentNotFoundException e) {
            ra.addFlashAttribute("message",e.getMessage());
        }
        return "redirect:/student";
    }
}
