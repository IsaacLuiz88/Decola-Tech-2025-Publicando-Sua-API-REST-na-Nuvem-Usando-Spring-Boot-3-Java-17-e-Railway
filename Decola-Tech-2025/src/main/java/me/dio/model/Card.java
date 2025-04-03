package me.dio.model;

import java.math.BigDecimal;
import java.security.SecureRandom;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

@Entity(name = "tb_card")
public class Card {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String number;
	
	@Column(name = "available_limit", precision = 13, scale = 2)
	private BigDecimal limit;
	
	 // Método para gerar um número de cartão fictício de 16 dígitos
    private String generateCardNumber() {
        SecureRandom random = new SecureRandom();
        long cardNumber = Math.abs(random.nextLong()) % 1_0000_0000_0000_0000L; // Gerar até 16 dígitos
        return String.format("%016d", cardNumber); // Formatar com 16 dígitos
    }

    // Método para garantir que o limite não seja negativo
    public void setLimit(BigDecimal limit) {
        if (limit != null && limit.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("O limite do cartão não pode ser negativo.");
        }
        this.limit = limit;
    }

    // Método que será chamado antes de persistir o cartão, caso precise ajustar antes de salvar
    @PrePersist
    public void prePersist() {
        if (this.number == null) {
            this.number = generateCardNumber(); // Gerar número se não foi atribuído
        }
    }
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public BigDecimal getLimit() {
		return limit;
	}
	
}
