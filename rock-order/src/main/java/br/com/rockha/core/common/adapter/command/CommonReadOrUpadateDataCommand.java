package br.com.rockha.core.common.adapter.command;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@MappedSuperclass
@EqualsAndHashCode(callSuper=false)
@SuperBuilder
public class CommonReadOrUpadateDataCommand extends CommonCreateDataCommand {
  private String uuid;
}
