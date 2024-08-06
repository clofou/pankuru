package org.odk.g1.pankuru.dto;

import lombok.Data;
import org.odk.g1.pankuru.Entity.Humain.Personnel;

import java.time.LocalDate;

@Data
public class PersonnelDTO {
    private String adresse;
    private Personnel personnel;
}
