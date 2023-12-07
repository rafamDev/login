package com.ms.login.bussines;

import java.util.Optional;

public interface Transformer<E, B> {

	Optional<B> getBussinesObject(final E entity);
	
	Optional<E> getEntityObject(final B bussines);
}
