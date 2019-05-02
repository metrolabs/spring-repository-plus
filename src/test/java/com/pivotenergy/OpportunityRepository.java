package com.pivotenergy;

import com.pivotenergy.domain.opportunity.Opportunity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpportunityRepository extends CrudRepository<Opportunity, String> {
}
