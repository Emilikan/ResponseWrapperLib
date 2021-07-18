package com.example.responsewrapperdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Emil Nasyrov (Emilikan)
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Passport {
    private String series;
    private String number;
}
