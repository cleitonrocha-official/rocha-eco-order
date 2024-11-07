package br.com.rockha.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
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

	@Embedded
	private Product product;
	@Column(name = "quantidade")
	private Integer quantity;

	public String getUuid() {
		return super.getId();
	}

}
