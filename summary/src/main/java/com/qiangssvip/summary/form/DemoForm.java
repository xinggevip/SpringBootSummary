package com.qiangssvip.summary.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemoForm implements Serializable {
    @NotBlank(message = "姓名不能为空")
    private String name;
    @NotBlank(message = "年龄不能为空")
    @Size(min = 1,message = "必须为正整数")
    private String age;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 前台传给后台时指定日期格式
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8") // 后台传给前台时指定日期格式
    private Date birth;
}
