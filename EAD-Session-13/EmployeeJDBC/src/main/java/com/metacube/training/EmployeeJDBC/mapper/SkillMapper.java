package com.metacube.training.EmployeeJDBC.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.EmployeeJDBC.model.Skill;

public class SkillMapper  implements RowMapper<Skill> {

	public Skill mapRow(ResultSet rset, int i) throws SQLException {
		Skill skill=new Skill();
		skill.setId(rset.getInt("id"));
		skill.setName(rset.getString("name"));
		return skill;
	}

}
