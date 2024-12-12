package br.com.catolica.ppi.app_auth_ecommerce.controller;


import br.com.catolica.ppi.app_auth_ecommerce.dto.CourseDTO;
import br.com.catolica.ppi.app_auth_ecommerce.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class ProductController {

    private final CourseService courseService;

    public ProductController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/")
    @PreAuthorize("hasRole('USER')")
    public String list() {
        return "Listando produtos";
    }

    @PostMapping("/")
    @PreAuthorize("hasRole('TEACHER')")
    public String create() {
        return "Cadastrando produtos";
    }

    @GetMapping("/listCourse")
    public ResponseEntity<List<CourseDTO>> listCourse(){
        return ResponseEntity.status(HttpStatus.OK).body(courseService.listCourse());
    }

    @GetMapping("/listCourseByTeacher/{id}")
    @PreAuthorize("hasRole('TEACHER')")
    public ResponseEntity<List<CourseDTO>> listCourseByTeacher(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(courseService.listCourseByTeacher(id));
    }

}