package cz.muni.fi.pa165.services;

import java.util.Collection;
import java.util.List;

import org.dozer.Mapper;

/**
 * @author MonikaMociarikova
 */
public interface MappingService {

     <T> List<T> mapCollection(Collection<?> collection, Class<T> classToBeMapped);

     <T> T mapObject(Object object, Class<T> classToBeMapped);

}
