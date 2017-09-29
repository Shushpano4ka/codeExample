package com.vadymusyk.code_example.repository.company;

import com.vadymusyk.code_example.entity.company.Department;
import com.vividsolutions.jts.geom.Geometry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by vadymusyk on 16.08.17.
 */
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query(nativeQuery = true, value = "SELECT  * FROM Department d WHERE _st_within(d.location, :filter) = true")
    List<Department> findInRegion(@Param("filter") Geometry filter);

    List<Department> findByCompanyId(long companyId);
}
