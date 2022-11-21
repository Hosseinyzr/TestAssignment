package com.yazdanfar.assignment.util;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.yazdanfar.assignment.dao.ExerciseEntity;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvParser {

    static final String[] HEADER_STR = new String[]{"source", "codeListCode", "code", "displayValue", "longDescription", "fromDate", "toDate", "sortingPriority"};

    public static List<ExerciseEntity> entitiesFromCsvText(String csvText) throws Exception {
        List<ExerciseEntity> exerciseEntityList = new ArrayList<>();

        CSVReader csvReader = new CSVReader(new StringReader(csvText));
        String[] nextRecord;

        int i = 0;
        while ((nextRecord = csvReader.readNext()) != null) {
            i++;
            if (i == 1)
                continue;
            ExerciseEntity entity = new ExerciseEntity();
            entity.setSource(nextRecord[0] == null ? null : nextRecord[0]);
            entity.setCodeListCode(nextRecord[1] == null ? null : nextRecord[1]);
            entity.setCode(nextRecord[2] == null ? null : nextRecord[2]);
            entity.setDisplayValue(nextRecord[3] == null ? null : nextRecord[3]);
            entity.setLongDescription(nextRecord[4] == null ? null : nextRecord[4]);
            entity.setFromDate(nextRecord[5] == null ? null : nextRecord[5]);
            entity.setToDate(nextRecord[6] == null ? null : nextRecord[6]);
            entity.setSortingPriority(nextRecord[7] == null || nextRecord[7].isEmpty() ? null : Integer.valueOf(nextRecord[7]));


            exerciseEntityList.add(entity);

        }


        return exerciseEntityList;
    }

    public static String entitiesToCsv(List<ExerciseEntity> exerciseEntityList) {
        List<String[]> list = new ArrayList<>();
        list.add(HEADER_STR);
        for (ExerciseEntity entity : exerciseEntityList) {
            String[] stringArray = new String[8];
            stringArray[0] = entity.getSource();
            stringArray[1] = entity.getCodeListCode();
            stringArray[2] = entity.getCode();
            stringArray[3] = entity.getDisplayValue();
            stringArray[4] = entity.getLongDescription();
            stringArray[5] = entity.getFromDate();
            stringArray[6] = entity.getToDate();
            stringArray[7] = entity.getSortingPriority() == null ? null : "" + entity.getSortingPriority();

            list.add(stringArray);
        }

        var s = new StringWriter();
        CSVWriter csvWriter = new CSVWriter(s);
        csvWriter.writeAll(list);

        return s.toString();
    }


}
