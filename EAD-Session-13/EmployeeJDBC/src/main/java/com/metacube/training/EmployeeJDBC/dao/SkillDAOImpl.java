package com.metacube.training.EmployeeJDBC.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.EmployeeJDBC.mapper.SkillMapper;
import com.metacube.training.EmployeeJDBC.model.Skill;

@Repository
public class SkillDAOImpl implements SkillDAO {
private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public SkillDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private final String SQL_FIND_SKILL = "select * from skill where id = ?";
	private final String SQL_GET_ALL = "select * from skill";
	private final String SQL_INSERT_SKILL = "insert into skill(name) values(?)";
	private final String SQL_UPDATE_SKILL="update skill set name=? WHERE id=?";
	private final String SQL_DELETE_SKILL="Delete from skill where id=?";
	@Override
	public Skill getSkillById(int id) {
		return jdbcTemplate.queryForObject(SQL_FIND_SKILL, new Object[] { id }, new SkillMapper());
	}

	@Override
	public List<Skill> getAllSkills() {
		return jdbcTemplate.query(SQL_GET_ALL, new SkillMapper());
	}

	@Override
	public boolean createSkill(Skill skill) {
		return jdbcTemplate.update(SQL_INSERT_SKILL, skill.getName()) > 0;
	}

	@Override
	public boolean updateSkill(Skill skill) {
		return jdbcTemplate.update(SQL_UPDATE_SKILL, skill.getName(), skill.getId()) > 0;
	}

	@Override
	public boolean deleteSkill(Skill skill) {
		return jdbcTemplate.update(SQL_DELETE_SKILL, skill.getId()) > 0;
	}
}
