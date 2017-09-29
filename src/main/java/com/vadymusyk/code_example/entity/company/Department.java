package com.vadymusyk.code_example.entity.company;

import com.vadymusyk.code_example.entity.company.contacts.PhoneNumber;
import com.vadymusyk.code_example.entity.company.schedule.DailyChart;
import com.vadymusyk.code_example.entity.secutity.UserFavoriteDepartment;
import com.vividsolutions.jts.geom.Point;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vadymusyk on 11.08.17.
 */

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {

    @Id
    @GeneratedValue(generator = "kaugen")
    @GenericGenerator(name = "kaugen", strategy = "increment")
    private long id;

    @ManyToOne
    @NotNull
    private Company company;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "department_type_id")
    private DepartmentType type;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private DepartmentStatus status;

    @Column(name = "status_description")
    private String statusDescription;

    @Column(name = "site_url")
    private String siteUrl;

    private String address;

    private Double rating;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
    List<DailyChart> schedule = new ArrayList<>();

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "location", columnDefinition = "Geometry")
    private Point location;

    @JoinColumn(name = "create_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime createDate;

    @JoinColumn(name = "update_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime updateDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
    private List<DepartmentBrand> departmentBrands = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
    private List<DepartmentCategory> categories = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
    private List<SimilarDepartment> similarDepartments = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
    private List<UserFavoriteDepartment> favoriteDepartments = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
    private List<PhoneNumber> phoneNumbers = new ArrayList<>();
}
