package org.lfh.custom.demo.easyPoiDemo.service;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import org.apache.poi.ss.usermodel.Workbook;
import org.lfh.custom.demo.easyPoiDemo.entity.StudentEntity;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lfh
 * @version 1.0
 * @date 2022/4/4 15:13
 */
public class OutPutService {
    public static void main(String[] args) throws IOException {
        //1.简单导出
        out1();
    }

    private static void out1() throws IOException {
        List<StudentEntity> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            StudentEntity studentEntity = new StudentEntity();
            studentEntity.setId(i + "");
            studentEntity.setName("name" + i);
            studentEntity.setSex(i % 2+1);
            studentEntity.setBirthday(LocalDateTime.now().minusYears(i));
            studentEntity.setRegistrationDate(LocalDateTime.now().minusYears(i));
            list.add(studentEntity);
        }
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("计算机一班学生", "学生"),
                StudentEntity.class, list);
        System.out.println("workbook = " + workbook);
        //
        String url = "F:test.xlsx";
        FileOutputStream output = new FileOutputStream(url);
        output.flush();
        workbook.write(output);
    }
}
