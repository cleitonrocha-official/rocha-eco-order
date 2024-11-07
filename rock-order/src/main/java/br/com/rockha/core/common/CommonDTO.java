package br.com.rockha.core.common;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class CommonDTO {
    private String uuid;
    private boolean deleted;

    public void setDeleted(){
        this.deleted = true;
    }
    

}
