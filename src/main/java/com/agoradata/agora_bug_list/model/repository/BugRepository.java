package com.agoradata.agora_bug_list.model.repository;

import com.agoradata.agora_bug_list.model.entity.Bug;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
 * BUG REPOSITORY FOR HANDLING THE DB TRANSACTIONS
 **/
@Repository
public interface BugRepository extends CrudRepository<Bug, Long> {
}
