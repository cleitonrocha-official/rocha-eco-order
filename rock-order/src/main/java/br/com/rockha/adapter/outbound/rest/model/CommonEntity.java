package br.com.rockha.adapter.outbound.rest.model;

import java.time.LocalDateTime;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@MappedSuperclass
@SuperBuilder
public abstract class CommonEntity {
	
    private String uuid;
    private LocalDateTime createAt;
    private LocalDateTime modifyedAt;
    private LocalDateTime deletedAt;
    private boolean deleted ;
    private boolean active ;


}
