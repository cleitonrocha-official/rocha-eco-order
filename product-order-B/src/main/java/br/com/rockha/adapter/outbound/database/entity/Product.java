package br.com.rockha.adapter.outbound.database.entity;

import java.math.BigDecimal;

import br.com.rockha.adapter.outbound.database.common.CommonEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Product extends CommonEntity {

	@Column(name = "nome")
	private String name;
	@Column(name = "valor")
	private BigDecimal value;

}
