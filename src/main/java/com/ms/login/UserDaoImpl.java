package com.ms.login;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class UserDaoImpl implements UserDao { 

	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public Optional<UserEntity> findUserByName(String username) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserEntity> criteriaQuery = criteriaBuilder.createQuery(UserEntity.class);
        Root<UserEntity> root = criteriaQuery.from(UserEntity.class);

        Predicate predicate = criteriaBuilder.equal(root.get("username"), username);
        
        criteriaQuery.where(predicate);

        List<UserEntity> resultList = entityManager.createQuery(criteriaQuery).getResultList();

        if (resultList.isEmpty()) {
        	return Optional.empty();
        } else {
        	return Optional.of(resultList.get(0));
        }
	}

}
