package com.vadymusyk.code_example.entity.company;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by vadymusyk on 16.08.17.
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@ToString
@Table(name = "similar_departments")
public class SimilarDepartment {

    @Id
    @GeneratedValue(generator = "kaugen")
    @GenericGenerator(name = "kaugen", strategy = "increment")
    private long id;

    @ManyToOne
    private Department department;

    @ManyToOne
    @JoinColumn(name = "category_tag_id")
    private CategoryTag categoryTag;
}
