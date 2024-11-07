package br.com.rockha.adapter.outbound.database.entity;

import java.math.BigDecimal;
import java.util.List;

import br.com.rockha.adapter.outbound.database.common.CommonEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pedidos", indexes = {
	    @Index(name = "idx_create_at", columnList = "criadoEm")
	})
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Order extends CommonEntity {


	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<OrderItem> items;
	@Column(name = "valor")
	private BigDecimal value;

	
	
}
