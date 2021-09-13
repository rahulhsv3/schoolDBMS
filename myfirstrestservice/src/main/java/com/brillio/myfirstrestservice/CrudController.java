package com.brillio.myfirstrestservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.brillio.myfirstrestservice.StudentDAO;

@RestController
@RequestMapping("/sdetails")
public class CrudController {

    @Autowired
    StudentDAO studentDAO;

    @PostMapping("/insert")
    //Add @RequestBody for the parameter of the function which has a @PostMapping Annotation to fetch values from the request.
    //For this to work remove @GeneratedMapping in the DTO
    public String insertStudent(@RequestBody StudentDTo sDTO){
        try{
            studentDAO.save(sDTO);
            return "Data is Inserted";
        }catch (Exception e){
            return (e.getMessage());
        }
    }

    @PutMapping("/update")
    public String updateStudent(@RequestBody StudentDTo sDTO){
        try{
            studentDAO.save(sDTO);
            return "Data is Updated";
        }catch (Exception e){
            return (e.getMessage());
        }
    }

    @PatchMapping("/patch")
    public String patchStudent(@RequestBody StudentDTo sDTO){
        try{
            studentDAO.save(sDTO);
            return "Data is Patched";
        }catch (Exception e){
            return (e.getMessage());
        }
    }

    @DeleteMapping("/delete/{sid}")
    public String deleteStudent(@PathVariable String sid){
        try{
            studentDAO.deleteById(sid);
            return "Data is Deleted";
        }catch (Exception e){
            return (e.getMessage());
        }
    }
}