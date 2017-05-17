package com.yxtec.t4.repository;

import com.yxtec.t4.model.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * TODO 类描述
 *
 * @author : <a href="mailto:jerrielau@qq.com">刘杰</a>
 * @version : 0.0.1
 * @date : 2017-05-17 22:42
 */
@Repository
public class DbRepository {

    private static final String sql = "replace into scores(id,sname,course,score) values(?,?,?,?)";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveOrUpdate(Score score) {
        jdbcTemplate.update(sql, score.getId(), score.getSname(), score.getCourse(), score.getScore());
    }

}
