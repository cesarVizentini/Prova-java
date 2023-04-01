package com.spring.familymanagement.parte2.parent;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ParentRowMapper implements RowMapper<Parent> {

    @Override
    public Parent mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Parent(
                resultSet.getInt("id"),
                resultSet.getString("name")
        );
    }
}
