package org.fastlane.stats.repository;

import org.fastlane.stats.model.DataValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataValuesRepository extends JpaRepository<DataValue, Long> {

}
