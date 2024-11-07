package br.com.rockha.entity;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.rest.core.annotation.RestResource;

import com.fasterxml.jackson.annotation.JsonProperty;

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
	    @Index(name = "idx_create_at", columnList = "createAt")
	})
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Order extends CommonEntity {

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	 @JsonProperty("items")
	@RestResource(path = "items", rel = "orderItems") 
	private List<OrderItem> items;
	@Column(name = "valor")
	private BigDecimal value;

	
	public String getUuid() {
		return super.getId();
	}
	
}
