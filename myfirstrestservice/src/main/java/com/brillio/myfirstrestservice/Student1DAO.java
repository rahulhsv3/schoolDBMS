package com.brillio.myfirstrestservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Student1DAO extends JpaRepository<Student1DTO,String> {
    @Query(value = "Select t1.sid, t1.fname, t1.lname, t3.statecode FROM sdetails t1 JOIN connectcity t2 on t1.sid=t2.sid JOIN city t3 on t2.citycode=t3.citycode", nativeQuery = true)
    public List<String> getJoinDetails();

}
