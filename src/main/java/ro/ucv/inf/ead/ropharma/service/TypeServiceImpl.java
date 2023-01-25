package ro.ucv.inf.ead.ropharma.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.ucv.inf.ead.ropharma.exception.RecordNotFoundException;
import ro.ucv.inf.ead.ropharma.model.Type;
import ro.ucv.inf.ead.ropharma.repository.TypeRepository;

@Service("typeService")
public class TypeServiceImpl implements TypeService {
	private static final Logger logger = LoggerFactory.getLogger(TypeServiceImpl.class);
	
	@Autowired
	private TypeRepository typeRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Type> findAllTypes() {
	    return typeRepository.findAll();
	}
	
	@Override
	@Transactional
	public void delete(Long typeId) {
		Type type = typeRepository.findById(typeId).orElse(null);
		logger.debug("Deleting product with id: " + typeId);
		
		if(type != null) {
			typeRepository.deleteById(typeId);
		} else {
			String errorMessage = "Type with id " + typeId + " not found";
			logger.error(errorMessage);
			throw new RecordNotFoundException(errorMessage);
		}
	}

	
	@Override
	@Transactional
	public Type add(Type type) {
	typeRepository.save(type);
		return type;
	}
	
	@Override
	@Transactional
	public Type findType(long typeid) {
		return typeRepository.findById(typeid);
	}
	
	@Override
	@Transactional
	public Type update(Type type) {

		Type existingTask = typeRepository.findById(type.getId()).orElse(null);
		
		if (existingTask == null) {
			String errorMessage = "Type with id " + type.getId() + " not found";
			logger.error(errorMessage);
		    throw new RecordNotFoundException(errorMessage);
	    }
		return typeRepository.save(type);
	}
}
