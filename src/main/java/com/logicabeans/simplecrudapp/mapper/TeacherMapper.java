package com.logicabeans.simplecrudapp.mapper;

import com.logicabeans.simplecrudapp.dto.TeacherDto;
import com.logicabeans.simplecrudapp.model.Teacher;


public class TeacherMapper {

    public static TeacherDto mapToDto(Teacher teacher) {
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setTeacherId(teacher.getTeacherId());
        teacherDto.setTeacherName(teacher.getTeacherName());
        teacherDto.setAddress(teacher.getAddress());
        teacherDto.setEmail(teacher.getEmail());
        teacherDto.setPhoneNumber(teacher.getPhoneNumber());
        return  teacherDto;
    }

    public static Teacher mapToEntity(TeacherDto teacherDto) {
        Teacher teacher = new Teacher();
        teacher.setTeacherId(teacherDto.getTeacherId());
        teacher.setTeacherName(teacherDto.getTeacherName());
        teacher.setAddress(teacherDto.getAddress());
        teacher.setEmail(teacherDto.getEmail());
        teacher.setPhoneNumber(teacherDto.getPhoneNumber());
        return teacher;
    }
}
