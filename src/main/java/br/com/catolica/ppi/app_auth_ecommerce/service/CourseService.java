package br.com.catolica.ppi.app_auth_ecommerce.service;

import br.com.catolica.ppi.app_auth_ecommerce.client.CourseClient;
import br.com.catolica.ppi.app_auth_ecommerce.dto.CourseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class CourseService {

    private final CourseClient courseFunc;

    public CourseService(CourseClient courseFunc) {
        this.courseFunc = courseFunc;
    }

    public List<CourseDTO> listCourse(){
        return courseFunc.listCourse();
    }

    public List<CourseDTO> listCourseByTeacher(Long id){
        return courseFunc.listCourseTeacher(id);
    }
}
