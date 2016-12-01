package cz.muni.fi.pa165.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author MonikaMociarikova
 */
@Service
public class MappingServiceImpl implements MappingService {

    @Autowired
    private Mapper mapper;

    public Mapper getMapper(){
        return mapper;
    }

    public  <T> List<T> mapCollection(Collection<?> collection, Class<T> classToBeMapped) {
        if (collection == null) {
            return null;
        }
        List<T> mappedCollection = new ArrayList<>();
        for (Object object : collection) {
            mappedCollection.add(mapper.map(object, classToBeMapped));
        }
        return mappedCollection;
    }

    public  <T> T mapObject(Object object, Class<T> classToBeMapped)
    {
        if (object == null) {
            return null;
        }
        return mapper.map(object,classToBeMapped);
    }

}
