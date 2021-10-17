package com.flaminiovilla.client.repository;

import com.flaminiovilla.client.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface ClientRepository extends JpaRepository<Client,Long> {

}
