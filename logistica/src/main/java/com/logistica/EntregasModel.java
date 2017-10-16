package com.logistica;

public class EntregasModel {
	private int id;
	private String numeroPedido;
	private int idCliente;
	private String nomeRecebedor;
	private String cpfRecebedor;
	private String dataHoraEntrega;
	
	public EntregasModel(int id, String numeroPedido, int idCliente, String nomeRecebedor, String cpfRecebedor,
			String dataHoraEntrega) {
		this.id = id;
		this.numeroPedido = numeroPedido;
		this.idCliente = idCliente;
		this.nomeRecebedor = nomeRecebedor;
		this.cpfRecebedor = cpfRecebedor;
		this.dataHoraEntrega = dataHoraEntrega;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(String numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeRecebedor() {
		return nomeRecebedor;
	}

	public void setNomeRecebedor(String nomeRecebedor) {
		this.nomeRecebedor = nomeRecebedor;
	}

	public String getCpfRecebedor() {
		return cpfRecebedor;
	}

	public void setCpfRecebedor(String cpfRecebedor) {
		this.cpfRecebedor = cpfRecebedor;
	}

	public String getDataHoraEntrega() {
		return dataHoraEntrega;
	}

	public void setDataHoraEntrega(String dataHoraEntrega) {
		this.dataHoraEntrega = dataHoraEntrega;
	}
	
	
}
