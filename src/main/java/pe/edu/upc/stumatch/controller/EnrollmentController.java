package pe.edu.upc.stumatch.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.stumatch.business.crud.CourseService;
import pe.edu.upc.stumatch.business.crud.EnrollmentService;
import pe.edu.upc.stumatch.business.crud.SectionService;
import pe.edu.upc.stumatch.model.entity.Course;
import pe.edu.upc.stumatch.model.entity.Enrollment;
import pe.edu.upc.stumatch.model.entity.Section;


@Controller
@RequestMapping("/enrollments")
public class EnrollmentController {
	@Autowired
	private EnrollmentService enrollmentService;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private SectionService sectionService;

	@GetMapping	
	public String listEnrollment(Model model) {
		
		try {
			List<Enrollment> enrollments= enrollmentService.getAll();
			model.addAttribute("enrollments", enrollments);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			List<Course> courses = courseService.getAll();
			model.addAttribute("courses", courses);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			List<Section> sections = sectionService.getAll();
			model.addAttribute("sections", sections);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "enrollments/list-enrollments";
	}
	
	@GetMapping("{id}/select_section")
	public String selectSection(Model model, @PathVariable("id") String id) {
			try {
				if(courseService.existById(id)) {
					Optional<Course> optional = courseService.findById(id);
					model.addAttribute("course", optional.get());
					List<Section> sections = sectionService.getAll();
					model.addAttribute("sections", sections);
				} else {
					return "redirect:/enrollments";
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return "enrollments/list-course_sections";
	}
	
	@PostMapping("{id}/update")
	public String updateEnrollment(Model model, @ModelAttribute("enrollment") Enrollment enrollment, @PathVariable("id") String id) {
		try {
			if(sectionService.existById(id)) {
				enrollmentService.update(enrollment);
			} else {
				return "redirect:/enrollments";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/enrollments";
	}
	
}
