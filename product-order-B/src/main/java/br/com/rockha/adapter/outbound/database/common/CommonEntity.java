package br.com.rockha.adapter.outbound.database.common;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

import static java.util.Optional.ofNullable;
import static java.util.UUID.randomUUID;

@Data
@NoArgsConstructor
@MappedSuperclass
@SuperBuilder
public abstract class CommonEntity {
	
    @Id
    private String id;
    private String externalId;
    private LocalDateTime criadoEm;
    private LocalDateTime modificadoEm;
    private LocalDateTime excluidoEm;
    private boolean excluido ;
    private boolean ativo ;

    @PrePersist
    protected void onCreate() {
        id = ofNullable(id).orElse(randomUUID().toString());
        criadoEm = LocalDateTime.now();
        excluido = false;
        ativo = true;
    }

    @PreUpdate
    protected void onUpdate() {
        modificadoEm = LocalDateTime.now();
    }

    @PreRemove
    protected void onDelete() {
        excluido = true;
        excluidoEm = LocalDateTime.now();
    }
    
    protected void inativar() {
    	ativo = false;
    }
    
    protected void reativar() {
    	ativo = true;
    }
}
