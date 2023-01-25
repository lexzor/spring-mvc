package ro.ucv.inf.ead.ropharma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import ro.ucv.inf.ead.ropharma.model.Type;


@Repository("typeRepository")
public interface TypeRepository extends JpaRepository<Type, Long>, JpaSpecificationExecutor<Type> {
  public Type findById(long typeid);
}