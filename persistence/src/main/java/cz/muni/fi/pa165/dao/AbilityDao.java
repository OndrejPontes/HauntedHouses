package cz.muni.fi.pa165.dao;

import cz.muni.fi.pa165.entity.Ability;

import java.util.List;

/**
 * Created by vojta on 10/25/16.
 */
public interface AbilityDao {
    public Ability findById(Long id);
    public void create(Ability c);
    public void delete(Ability c);
    public void update(Ability c);
    public List<Ability> findAll();
    public Ability findByName(String name);
}
