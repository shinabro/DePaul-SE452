package edu.depaul.cdm.se452.concept.persistence.relational_nosql;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import lombok.Data;
import lombok.ToString;

/**
 * Demo of setting up collection
 */
@Data
@Entity
@TypeDefs({
    @TypeDef(name = "json", typeClass = JsonStringType.class),
    @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
public class Course {
    @Id
    @GeneratedValue
    private long id;

    private String dept;

    private int num;

    // To display list of course for students, need to start session or fetch eager
    @OneToMany // (fetch = FetchType.EAGER)
    @JoinTable(name = "COURSE_STUDENTS", joinColumns = { @JoinColumn(name = "course_id", referencedColumnName = "id") })
    /*
     * @Type(type="hstore")
     * 
     * @Column(columnDefinition = "hstore") private List<Student> students;
     * 
     * @Type(type="jsonb")
     * 
     * @Column(columnDefinition = "jsonb") private CourseReviews reviews;
     */

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private List<CourseReview> reviews;
}