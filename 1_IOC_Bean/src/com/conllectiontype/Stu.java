package com.conllectiontype;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Stu {

    //数组类型的属性
    private String[] courses;

    //List集合类型的属性
    private List<String> list;

    public void setSet(Set<String> set) {
        this.set = set;
    }

    //Map集合类型属性
    private Map<String,String> maps;

    //set集合类型的属性
    private Set<String> set;

    public void setCourselist(List<Course> courselist) {
        this.courselist = courselist;
    }

    //CourseList对象类型属性
    private List<Course> courselist;

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }
    public void test(){
        System.out.println(Arrays.toString(courses));
        System.out.println(list);
        System.out.println(maps);
        System.out.println(set);
        System.out.println(courselist);
    }
}
