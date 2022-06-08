package pe.edu.upc.stumatch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ejemplodos")
public class ExampleControllerTwo {
	@GetMapping
	public String ejemplo2() {
		return "exampletwo";
	}
}
