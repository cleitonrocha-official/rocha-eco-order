package br.com.rockha.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import static java.util.Optional.ofNullable;
import static java.util.UUID.randomUUID;

@Data
@NoArgsConstructor
@MappedSuperclass
@SuperBuilder
public abstract class CommonEntity {
	
    @Id
    @JsonProperty
    private String id;
    private LocalDateTime createAt;
    private LocalDateTime modifyedAt;
    private LocalDateTime deletedAt;
    private boolean deleted ;
    private boolean active ;

    @PrePersist
    protected void onCreate() {
        id = ofNullable(id).orElse(randomUUID().toString());
        createAt = LocalDateTime.now();
        deleted = false;
        active = true;
    }

    @PreUpdate
    protected void onUpdate() {
        modifyedAt = LocalDateTime.now();
    }

    @PreRemove
    protected void onDelete() {
        deleted = true;
        deletedAt = LocalDateTime.now();
    }
    
    protected void inativar() {
    	active = false;
    }
    
    protected void reativar() {
    	active = true;
    }
}
