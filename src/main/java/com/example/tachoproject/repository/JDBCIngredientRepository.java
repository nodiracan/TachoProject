package com.example.tachoproject.repository;

import com.example.tachoproject.domains.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class JDBCIngredientRepository implements IngredientRepository{

    private JdbcTemplate jdbcTemplate;


    @Autowired
    public JDBCIngredientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return jdbcTemplate.query(
                "select id, name, type from Ingredient", this::mapRowToIngredient
        );
    }

//    @Override
//    public Ingredient findById(String id) {
//        return jdbcTemplate.query(
//                "select id, name, type from Ingredient where id = ?",
//                (rs, row) -> new Ingredient(
//                        rs.getString("id"),
//                        rs.getString("name"),
//                        Ingredient.Type.valueOf(rs.getString("type"))), id );
//    }

    private Ingredient mapRowToIngredient(ResultSet resultSet, int i) throws SQLException {
        return new Ingredient(
                resultSet.getString("id"),
                resultSet.getString("name"),
                Ingredient.Type.valueOf(resultSet.getString("type"))
        );
    }

    @Override
    public Optional<Ingredient> findById(String id) {
        List<Ingredient> list = jdbcTemplate.query(
                "select id, name, type from Ingredient where id = ?", this::mapRowToIngredient, id
        );

        return list.size() == 0 ?
                Optional.empty() :
                Optional.of(list.get(0));
    }



    @Override
    public Ingredient save(Ingredient ingredient) {
        jdbcTemplate.update("insert into Ingredient (id, name, type) values (?, ?, ?)",
        ingredient.getId(),
        ingredient.getName(),
        ingredient.getType().toString());
        return ingredient;
    }

}
