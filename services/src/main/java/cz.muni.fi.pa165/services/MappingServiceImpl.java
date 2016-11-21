package cz.muni.fi.pa165.services;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author MonikaMociarikova
 */
public class MappingServiceImpl implements MappingService {

    @Autowired
    private Mapper mapper;

    public Mapper getMapper(){
        return mapper;
    }

    public  <T> List<T> mapCollection(Collection<?> collection, Class<T> classToBeMapped) {
        List<T> mappedCollection = new ArrayList<>();
        for (Object object : collection) {
            mappedCollection.add(mapper.map(object, classToBeMapped));
        }
        return mappedCollection;
    }

    public  <T> T mapObject(Object object, Class<T> classToBeMapped)
    {
        return mapper.map(object,classToBeMapped);
    }

}
