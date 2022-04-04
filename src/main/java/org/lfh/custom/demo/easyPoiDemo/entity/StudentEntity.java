package org.lfh.custom.demo.easyPoiDemo.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author lfh
 * @version 1.0
 * @date 2022/4/4 15:09
 */
@Data
public class StudentEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(groups = {StudentEntity.class})
    private String id;
    @Excel(name = "学生姓名", height = 20, width = 30, isImportField = "true_st")
    private String name;
    @Excel(name = "学生性别", replace = {"男_1", "女_2"}, suffix = "生", isImportField = "true_st")
    private int sex;
    @Excel(name = "出生日期", databaseFormat = "yyyyMMddHHmmss", format = "yyyy-MM-dd", isImportField = "true_st", width = 20)
    private LocalDateTime birthday;
    @Excel(name = "进校日期", databaseFormat = "yyyyMMddHHmmss", format = "yyyy-MM-dd")
    private LocalDateTime registrationDate;
}
