package com.yxtec.t4.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * TODO 类描述
 *
 * @author : <a href="mailto:jerrielau@qq.com">刘杰</a>
 * @version : 0.0.1
 * @date : 2017-05-17 22:43
 */
@Data
@ToString
public class Score implements Serializable {

    private static final long serialVersionUID = 7614293838845782729L;

    private Long id;

    private String sname;

    private String course;

    private float score;

}
