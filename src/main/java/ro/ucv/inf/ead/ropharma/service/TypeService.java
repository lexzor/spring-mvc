package ro.ucv.inf.ead.ropharma.service;

import java.util.List;

import ro.ucv.inf.ead.ropharma.model.Type;

public interface TypeService {
	public List<Type> findAllTypes();
	public void delete(Long typeId);
	public Type add(Type type);
	public Type findType(long typeid);
	public Type update(Type task);
}
