package com.anjali.spring.spring.data.jpa.repository;

import com.anjali.spring.spring.data.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public List<Student> findByFirstName(String name);
    public List<Student> findByFirstNameContaining(String name);
    public List<Student> findByLastNameIsNotNull();

//    JPQL
    @Query("select s from Student s where s.emailId = ?1")
    public Student getTheStudentByEmailAddress(String email);
    @Query("select s.firstName from Student s where s.emailId = ?1")
    public String getFirstNameByEmailAddress(String email);
//    Native query
    @Query(
            value = "SELECT * FROM tbl_student s WHERE s.email_address=?1",
            nativeQuery = true
            )
    public Student getTheStudentByEmailAddressNative(String email);

    @Query(value = "SELECT * FROM tbl_student s WHERE s.first_name=:name", nativeQuery = true)
    public Student getStudentByFirstName(@Param("name") String name);

    @Modifying
    @Transactional
    @Query(value = "UPDATE tbl_student s SET s.first_name = :name WHERE s.email_address = :email", nativeQuery = true)
    public int updateStudentFirstNameByEmailId(@Param("name") String firstName, @Param("email") String emailId);
}
