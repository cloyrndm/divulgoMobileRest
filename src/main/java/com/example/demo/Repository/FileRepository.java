package com.example.demo.Repository;

import com.example.demo.Entity.FileModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Cloie Andrea on 15/07/2018.
 */


@Repository
public interface FileRepository extends JpaRepository<FileModel,Long> {

}
