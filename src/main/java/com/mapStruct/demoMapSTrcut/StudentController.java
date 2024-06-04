package com.mapStruct.demoMapSTrcut;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;

    private static final Logger log = LoggerFactory.getLogger(StudentController.class);

    @PostMapping("/save")
    public Student savedStudent(@RequestBody Student student){
       Student savedStudent = studentRepository.save(student);
       log.debug("Student was not saved");
        return  savedStudent;
    }
    @GetMapping("/get/{id}")
    public StudentDto getStudent(@PathVariable("id") Long studentId ){
      Student student =  studentRepository.findById(studentId)
              .orElseThrow(( )-> new ResourceNotFound("student","id",studentId));
      StudentDto studentDto = modelMapper.map(student, StudentDto.class);
      return studentDto;
    }

    @ExceptionHandler(ResourceNotFound.class)
    public ErrorDetails resourceNotFOundException(ResourceNotFound exception , WebRequest webRequest){

       ErrorDetails errorDetails = new ErrorDetails(exception.getMessage()
               ,webRequest.getDescription(false),"user not found", LocalDateTime.now());

        return errorDetails;
    }

}
