package br.com.rockha.core.common.adapter.command;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.domain.Pageable;

@Data
@NoArgsConstructor
@MappedSuperclass
@EqualsAndHashCode(callSuper=false)
@SuperBuilder
public class CommonSearchDataCommand extends CommonCreateDataCommand {
  private Pageable pageable;

}
