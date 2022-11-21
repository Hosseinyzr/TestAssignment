package com.yazdanfar.assignment.service;

import com.yazdanfar.assignment.dao.ExerciseEntity;
import com.yazdanfar.assignment.dto.base.CustomAppException;
import com.yazdanfar.assignment.dto.csv.ExerciseBean;
import com.yazdanfar.assignment.dto.csv.ExerciseRequestDTO;
import com.yazdanfar.assignment.dto.csv.ExerciseResponseDTO;
import com.yazdanfar.assignment.dto.csv.UploadCsvResponseDTO;
import com.yazdanfar.assignment.repository.ExerciseRepository;
import com.yazdanfar.assignment.util.CsvParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CsvService {


    @Autowired
    private ExerciseRepository exerciseRepository;

    public UploadCsvResponseDTO handleUploadedCsv(MultipartFile file) {
        UploadCsvResponseDTO uploadCsvResponseDTO = new UploadCsvResponseDTO();
        try {
            if (file.isEmpty()) {
                throw new CustomAppException("file is empty");
            }

            var inputStream = file.getInputStream();

            //todo make it util
            StringBuilder textBuilder = new StringBuilder();
            try (Reader reader = new BufferedReader(new InputStreamReader
                    (inputStream, Charset.forName(StandardCharsets.UTF_8.name())))) {
                int c = 0;
                while ((c = reader.read()) != -1) {
                    textBuilder.append((char) c);
                }
            }

            var csvText = textBuilder.toString();
            var exerciseEntityList = CsvParser.entitiesFromCsvText(csvText);

            exerciseRepository.saveAll(exerciseEntityList);

            uploadCsvResponseDTO.setSuccess();
        } catch (Exception e) {
            //todo handle exception better. we do not allow show some exception in client
            uploadCsvResponseDTO.setFailure(e);
        }
        return uploadCsvResponseDTO;
    }


    public byte[] getAllRecordsAsByteArray() {
        var exerciseEntities = exerciseRepository.findAll();
        List<ExerciseEntity> exerciseEntityList = new ArrayList<>();
        exerciseEntities.forEach(exerciseEntityList::add);

        var csvText = CsvParser.entitiesToCsv(exerciseEntityList);
        return csvText.getBytes(StandardCharsets.UTF_8);
    }


    public ExerciseResponseDTO getByCode(String code) {
        //todo have some validation on code value
        var exerciseEntity = exerciseRepository.findByCode(code);
        var exerciseBean = ExerciseBean.fromEntity(exerciseEntity);

        ExerciseResponseDTO exerciseResponseDTO = new ExerciseResponseDTO();
        exerciseResponseDTO.setExerciseBean(exerciseBean);
        return exerciseResponseDTO;

    }

    public ExerciseResponseDTO get(ExerciseRequestDTO exerciseRequestDTO) {
        var exerciseBean=exerciseRequestDTO.getExerciseBean();
        var code=exerciseBean.getCode();
        //todo have some validation on code value
        var exerciseEntity = exerciseRepository.findByCode(code);
        var exerciseBeanResult = ExerciseBean.fromEntity(exerciseEntity);

        ExerciseResponseDTO exerciseResponseDTO = new ExerciseResponseDTO();
        exerciseResponseDTO.setExerciseBean(exerciseBeanResult);
        return exerciseResponseDTO;

    }

    public ExerciseResponseDTO deleteAll() {
        exerciseRepository.deleteAll();
        ExerciseResponseDTO exerciseResponseDTO=new ExerciseResponseDTO();
        return exerciseResponseDTO;

    }


}
