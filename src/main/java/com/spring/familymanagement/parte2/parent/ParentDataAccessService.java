package com.spring.familymanagement.parte2.parent;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class ParentDataAccessService implements ParentDAO {

    private final JdbcTemplate jdbcTemplate;

    public ParentDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertParent(Parent parent) {
        var sql = """
                INSERT INTO parent(name)
                VALUES (?);
                 """;
        return jdbcTemplate.update(
                sql,
                parent.getName()
        );
    }

    @Override
    public List<Parent> selectParents() {
        var sql = """
                SELECT id, name
                FROM parent;
                 """;
        return jdbcTemplate.query(sql, new ParentRowMapper());
    }

    @Override
    public Optional<Parent> selectParentById(int id) {
        var sql = """
                SELECT id, name
                FROM parent
                WHERE id = ?
                 """;
        return jdbcTemplate.query(sql, new ParentRowMapper(), id)
                .stream()
                .findFirst();
    }

    @Override
    public int deleteParent(int id) {
        var sql = """
                DELETE FROM parent
                WHERE id = ?
                """;
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Map<String, Object>> selectFathers() {
        var sql = """
                SELECT DISTINCT p.Name AS Father_Name
                FROM parent p
                JOIN child c ON p.Id = c.Father_Id;
                 """;
        return jdbcTemplate.queryForList(sql);
    }

    @Override
    public List<Map<String, Object>> selectFathersWithMoreThanOneChild() {
        var sql = """
                SELECT p.Name AS Father_Name
                FROM parent p
                JOIN child c ON p.Id = c.Father_Id
                GROUP BY p.Name
                HAVING COUNT(c.Id) > 1;
                 """;
        return jdbcTemplate.queryForList(sql);
    }

    @Override
    public List<Map<String, Object>> selectFathersAndMothers() {
        var sql = """
                SELECT c.Name AS Child_Name, p1.Name AS Father_Name, p2.Name AS Mother_Name
                FROM child c
                LEFT JOIN parent p1 ON c.Father_Id = p1.Id
                LEFT JOIN parent p2 ON c.Mother_Id = p2.Id;
                 """;
        return jdbcTemplate.queryForList(sql);
    }

    @Override
    public Map<String, Object> selectNumberOfFatherChilds(String name) {
        var sql = """
                SELECT COUNT(*) AS Number_of_Childs
                    FROM child c
                    JOIN parent p ON c.Father_Id = p.Id
                    WHERE p.Name = ?;
                 """;
        return jdbcTemplate.queryForMap(sql, name);
    }

    @Override
    public Map<String, Object> selectNumberOfMotherChilds(String name) {
        var sql = """
                SELECT COUNT(*) AS Number_of_Childs
                    FROM child c
                    JOIN parent p ON c.Mother_Id = p.Id
                    WHERE p.Name = ?;
                 """;
        return jdbcTemplate.queryForMap(sql, name);
    }

}
