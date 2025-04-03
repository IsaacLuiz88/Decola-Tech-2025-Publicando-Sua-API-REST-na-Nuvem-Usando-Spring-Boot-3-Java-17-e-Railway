package me.dio.model;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "tb_account")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	
	@Column(unique = true)
	private String number;
	
    private String agency;
     
    @Column(precision = 13, scale = 2)
    private BigDecimal balance;
     
    @Column(name = "additional_limit", precision = 13, scale = 2)
    private BigDecimal limit;
	public Long getId() {
		return id;
	}
	
	 // Construtor sem argumentos para gerar o número automaticamente
    public Account() {
        // Gerar o número da conta ao criar um objeto
        this.number = generateAccountNumber();
    }

 // Método para gerar o número de conta aleatório com até 12 caracteres
    private String generateAccountNumber() {
        // Criando um gerador seguro para números aleatórios
        SecureRandom random = new SecureRandom();
        
        // Gerando um número aleatório de até 12 dígitos (exclusivamente numérico)
        long accountNumber = Math.abs(random.nextLong()) % 1_000_000_000_000L;  // Máximo de 12 dígitos
        
        // Formatando para garantir que o número tenha exatamente 12 dígitos com leading zeros
        return String.format("%012d", accountNumber);
    }

    // Método adicional para garantir que o número de conta seja único
    public static String generateUniqueAccountNumber(Set<String> existingNumbers) {
        String accountNumber;
        do {
            // Gerar um novo número de conta
            accountNumber = new Account().generateAccountNumber();
        } while (existingNumbers.contains(accountNumber)); // Verificar duplicidade com a lista existente
        
        return accountNumber;
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
	public String getAgency() {
		return agency;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public BigDecimal getLimit() {
		return limit;
	}
	public void setLimit(BigDecimal limit) {
		this.limit = limit;
	}
     
     
}
