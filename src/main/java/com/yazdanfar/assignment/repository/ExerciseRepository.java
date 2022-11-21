package com.yazdanfar.assignment.repository;

import com.yazdanfar.assignment.dao.ExerciseEntity;
import com.yazdanfar.assignment.dto.base.CustomAppException;
import com.yazdanfar.assignment.dto.csv.UploadCsvResponseDTO;
import com.yazdanfar.assignment.util.CsvParser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public interface ExerciseRepository extends CrudRepository<ExerciseEntity, Long> {

    ExerciseEntity findByCode(String code);
}
