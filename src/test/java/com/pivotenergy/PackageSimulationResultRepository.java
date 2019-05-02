package com.pivotenergy;

import com.pivotenergy.domain.simulation.model.PackageSimulationResult;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageSimulationResultRepository extends MongoRepository<PackageSimulationResult, String> {
}
