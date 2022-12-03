package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepository {
    List<Student> all_students;
    List<Teacher> all_teachers;
    static int s_id=0;
    static int t_id=0;
    public StudentRepository(){
        all_students = new ArrayList<>();
        all_teachers = new ArrayList<>();
    }

    //    add student
    public Student saveStudent(Student s){
        s_id++;
        s.setId(s_id);
        all_students.add(s);
        return s;
    }

    //    add teacher
    public Teacher saveTeacher(Teacher t){
        t_id++;
        t.setId(t_id);
        all_teachers.add(t);
        return t;
    }

    //get student by student name
    public Student findStudentByName(String name){
        for(Student s: all_students){
            if(s.getName().equals(name)) return s;
        }
        return null;
    }

    //    get teacher by teacher name
    public Teacher findTeacherByName(String name){
        for(Teacher t: all_teachers){
            if(t.getName().equals(name)) return t;
        }
        return null;
    }

    public void PairStudentAndTeacher(String sname, String tname){
        Student find_student = null;
        Teacher find_teacher = null;

        for(Student s: all_students){
            if(s.getName().equals(sname)) {
                find_student = s;
                break;
            }
        }

        for(Teacher t: all_teachers){
            if(t.getName().equals(tname)){
                find_teacher = t;
                break;
            }
        }
        if(find_student == null || find_teacher == null) return;
        find_student.setTeacher(find_teacher);
    }

    public List<String> getStudentByTeacherName(String t_name){
        List<String> teacher_students = new ArrayList<>();
        for(Student s: all_students){
            if(s.getTeacher() != null && s.getTeacher().getName() != null){
                if(s.getTeacher().getName().equals(t_name))
                    teacher_students.add(s.getName());
            }
        }
        return teacher_students;
    }
    public void deleteTeacherAndItsStudents(String t_name){
        for(int i=0; i<all_students.size(); i++){
            if(all_students.get(i).getTeacher().getName().equals(t_name))
                all_students.remove(i);
        }
        return;
    }

    public void deleteAllTeachersAndTheirStudents(){
        for(Teacher t: all_teachers){
            for(int i=0; i<all_students.size(); i++){
                Student curr = all_students.get(i);
                if(t.getName() != null && curr.getTeacher() != null && curr.getTeacher().getName() != null){
                    if(t.getName().equals(curr.getTeacher().getName()))
                        all_students.remove(i);
                }
            }
        }
        all_teachers.clear();
        return;
    }
    public List<String> getAllStudent(){
        List<String> all_student_names = new ArrayList<>();
        for(Student s: all_students){
            all_student_names.add(s.getName());
        }
        return all_student_names;
    }
    public List<Teacher> getAllTeacher(){
        return all_teachers;
    }

}
