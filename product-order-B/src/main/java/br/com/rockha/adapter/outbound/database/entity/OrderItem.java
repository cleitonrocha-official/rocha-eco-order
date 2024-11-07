package br.com.rockha.adapter.outbound.database.entity;

import br.com.rockha.adapter.outbound.database.common.CommonEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "items")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class OrderItem extends CommonEntity {

	@OneToOne(cascade = CascadeType.PERSIST)
	private Product product;
	@Column(name = "quantidade")
	private Integer quantity;


}
