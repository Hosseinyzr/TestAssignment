package com.yazdanfar.assignment.controller;

import com.yazdanfar.assignment.dto.csv.ExerciseRequestDTO;
import com.yazdanfar.assignment.dto.csv.ExerciseResponseDTO;
import com.yazdanfar.assignment.dto.csv.UploadCsvResponseDTO;
import com.yazdanfar.assignment.service.CsvService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.InputStream;

@RestController
public class CsvController {

    @Autowired
    private CsvService csvService;

    @PostMapping(value = "/uploadCsv", produces = "application/json")
    private UploadCsvResponseDTO uploadCsv(@RequestParam("file") MultipartFile file) {
        return csvService.handleUploadedCsv(file);
    }

    @GetMapping(value = "/download")
    @ResponseBody
    private HttpEntity<byte[]> getAll() {
        var bytes = csvService.getAllRecordsAsByteArray();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDisposition(ContentDisposition.builder("attachment").filename("file" + ".csv").build());

        headers.setContentLength(bytes.length);
        return new HttpEntity<byte[]>(bytes, headers);

    }

    //usual way of get method
    /*@GetMapping(value = "/get/{code}")
    private ExerciseResponseDTO getByCode(@PathVariable("code") String code) {
        return csvService.getByCode(code);
    }*/

    @PostMapping(value = "/getByCode")
    private ExerciseResponseDTO getExercise(@RequestBody ExerciseRequestDTO exerciseRequestDTO) {
        return csvService.get(exerciseRequestDTO);
    }

    @DeleteMapping(value = "/deleteAll")
    private ExerciseResponseDTO deleteAll() {
        return csvService.deleteAll();
    }
}
