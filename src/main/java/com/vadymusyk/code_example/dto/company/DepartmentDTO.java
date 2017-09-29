package com.vadymusyk.code_example.dto.company;

import com.vadymusyk.code_example.dto.company.comment.NewCommentDTO;
import com.vadymusyk.code_example.entity.company.DepartmentStatus;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vadymusyk on 11.08.17.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class DepartmentDTO {

    private long departmentId;
    private long ownerId;
    private long departmentTypeId;
    private String address, name;
    private String siteUrl;
    private Double rating;
    private String imageUrl;
    private List<NewCommentDTO> comments = new ArrayList<>();
    private List<BrandDTO> brands = new ArrayList<>();
    private List<PhoneNumberDTO> phoneNumbers = new ArrayList<>();
    private List<DailyChartDTO> schedule = new ArrayList<>();
    private List<CategoryDTO> categories = new ArrayList<>();
    private DepartmentStatus status;
    private String statusDescription;
    private double latitude;
    private double longitude;

    private Boolean isFavorite;
    private Boolean isOwner;
    private Boolean hasUserVoted;
}
