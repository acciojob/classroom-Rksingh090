package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {
    @Autowired
    StudentRepository sr;

    public Student createStudent(Student s){
        return sr.saveStudent(s);
    }
    public Teacher createTeacher(Teacher t){
        return sr.saveTeacher(t);
    }
    public Student getStudentByName(String name){
        return sr.findStudentByName(name);
    }
    public Teacher getTeacherByName(String name){
        return sr.findTeacherByName(name);
    }
    public void pairStudentTeacher(String s_name, String t_name){
        sr.PairStudentAndTeacher(s_name, t_name);
    }
    public List<String> getStudentByTeacherName(String t_name){
        return sr.getStudentByTeacherName(t_name);
    }
    public List<String> getAllStudents(){
        return sr.getAllStudent();
    }
    public void deleteTeacherAndStudents(String t_name){
        sr.deleteTeacherAndItsStudents(t_name);
    }
    public void deleteAll(){
        sr.deleteAllTeachersAndTheirStudents();
    }



}
