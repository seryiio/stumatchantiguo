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
import pe.edu.upc.stumatch.business.crud.SectionService;
import pe.edu.upc.stumatch.business.crud.TeacherService;
import pe.edu.upc.stumatch.model.entity.Course;
import pe.edu.upc.stumatch.model.entity.Section;
import pe.edu.upc.stumatch.model.entity.Teacher;

@Controller
@RequestMapping("/courses")
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private SectionService sectionService;

	@GetMapping	
	public String listCourses(Model model) {
		
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
		
		return "courses/list-courses";
	}
	
	@GetMapping("new")
	public String newCourse(Model model) {
		Course course = new Course();
		model.addAttribute("course", course);
		try {
			List<Course> courses = courseService.getAll();
			model.addAttribute("courses", courses);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "courses/new-course";
	}
	
	@PostMapping("savenew")
	public String saveCourse(Model model, @ModelAttribute("deliveryman") Course course) {
		try {
			Course courseSaved = courseService.create(course);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/courses";
	}
	
	@GetMapping("{id}/edit")
	public String editCourse(Model model, @PathVariable("id") String id) {
			try {
				if(courseService.existById(id)) {
					Optional<Course> optional = courseService.findById(id);
					model.addAttribute("course", optional.get());
					List<Course> courses = courseService.getAll();
					model.addAttribute("courses", courses);
				} else {
					return "redirect:/courses";
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return "courses/edit-course";
	}
	
	@PostMapping("{id}/update")
	public String updateCourse(Model model, @ModelAttribute("course") Course course, @PathVariable("id") String id) {
		try {
			if(courseService.existById(id)) {
				courseService.update(course);
			} else {
				return "redirect:/courses";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/courses";
	}
	
	@GetMapping("{id}/delete")
	public String deleteCourse(Model model, @PathVariable("id") String id) {
		try {
			if(courseService.existById(id)) {
				courseService.deleteById(id);
			} else {
				return "redirect:/courses";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/courses";
	}
}
