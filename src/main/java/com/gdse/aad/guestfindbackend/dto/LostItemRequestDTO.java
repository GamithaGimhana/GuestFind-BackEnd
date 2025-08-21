package com.gdse.aad.guestfindbackend.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LostItemRequestDTO {
    private Long guestId;
    private String title;
    private String description;
    private String imagePath;
}
