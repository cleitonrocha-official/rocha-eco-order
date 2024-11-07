package br.com.rockha.core.common;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class CommonDTO {
    private String id;
    private boolean deleted;

    public void setDeleted(){
        this.deleted = true;
    }
    

}
