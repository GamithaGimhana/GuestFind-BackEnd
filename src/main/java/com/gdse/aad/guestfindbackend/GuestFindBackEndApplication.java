package com.gdse.aad.guestfindbackend;

import com.gdse.aad.guestfindbackend.dto.LostItemRequestDTO;
import com.gdse.aad.guestfindbackend.entity.LostItem;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GuestFindBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuestFindBackEndApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // Example: skip LostItem ID when mapping from request DTO
        modelMapper.typeMap(LostItemRequestDTO.class, LostItem.class)
                .addMappings(mapper -> mapper.skip(LostItem::setLostId));

        return modelMapper;
    }
}
