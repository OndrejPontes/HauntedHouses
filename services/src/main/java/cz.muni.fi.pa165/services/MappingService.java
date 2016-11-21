package cz.muni.fi.pa165.services;

import java.util.Collection;
import java.util.List;

import org.dozer.Mapper;

/**
 * copied from example project
 */
public interface MappingService {

     <T> List<T> mapTo(Collection<?> objects, Class<T> mapToClass);

     <T> T mapTo(Object u, Class<T> mapToClass);

    Mapper getMapper();
}
