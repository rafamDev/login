package com.ms.login.daos;

import java.util.List;


import java.util.Optional;

//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;


import org.springframework.stereotype.Repository;
import com.ms.login.entities.UserEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Repository
public class UserDaoImpl implements UserDao{ 

    @PersistenceContext
    private EntityManager entityManager;

	@Override
	public Optional<UserEntity> findUserByName(final String username) {
		
		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<UserEntity> criteriaQuery = criteriaBuilder.createQuery(UserEntity.class);
		final Root<UserEntity> root = criteriaQuery.from(UserEntity.class);

		final Predicate predicate = criteriaBuilder.equal(root.get("username"), username);

		criteriaQuery.where(predicate);

		final List<UserEntity> resultList = entityManager.createQuery(criteriaQuery).getResultList();
		
		return isResultListWithRecords(resultList) ? Optional.of(resultList.get(0)) : Optional.empty();
	}

	private boolean isResultListWithRecords(final List<UserEntity> resultList) {
	   return resultList != null && !resultList.isEmpty();
	}
	
}
