package com.scaler.Splitwise.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
// SINCE WE ARE NOT CREATING TABLE, AS IT IS NOT AN ENTITY FOR US WE WILL MAKE IT AS SUPER CLASS
@MappedSuperclass
public class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @CreatedDate
    @Temporal(value = TemporalType.TIMESTAMP) // how do you want to store data i.e DATE/TIME/DATEANDTIME
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Temporal(value = TemporalType.TIMESTAMP)
    private LocalDateTime lastupdatedAt;

}
