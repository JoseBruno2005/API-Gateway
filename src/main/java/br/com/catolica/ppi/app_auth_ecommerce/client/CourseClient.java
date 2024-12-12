package br.com.catolica.ppi.app_auth_ecommerce.client;

import br.com.catolica.ppi.app_auth_ecommerce.dto.CourseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
@FeignClient(name = "courseFunc", url = "${feign.course.func-course.url}")
public interface CourseClient {

    @GetMapping("/course/listCourse")
    List<CourseDTO> listCourse();

    @GetMapping("/course/listCourseTeacher/{id}")
    List<CourseDTO> listCourseTeacher(@PathVariable("id") Long id);
}
