package com.logistica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EntregasDAO {
	
	public void insert(Connection conn, EntregasModel entrega) throws SQLException{
		String sql = "insert into entregas (numero_pedido, id_cliente, nome_recebedor, cpf_recebedor, data_hora_entrega) values (?, ?, ?, ?, ?);";
		PreparedStatement pstm;
		pstm = conn.prepareStatement(sql);
		pstm.setString(1, entrega.getNumeroPedido());
		pstm.setInt(2, entrega.getIdCliente());
		pstm.setString(3, entrega.getNomeRecebedor());
		pstm.setString(4, entrega.getCpfRecebedor());
		pstm.setString(5, entrega.getDataHoraEntrega());
		pstm.execute();
	}
	
	public EntregasModel getById(Connection conn, String numeroPedido) throws SQLException{
		String sql = "select * from entregas where numero_pedido = ?";
		PreparedStatement pstm;
		pstm = conn.prepareStatement(sql);
		pstm.setString(1, numeroPedido);
		ResultSet rs = pstm.executeQuery();
		EntregasModel entrega = new EntregasModel();
		while (rs.next())
		{
			int id = rs.getInt("id");
			int idCliente = rs.getInt("id_cliente");
			String nomeRecebedor = rs.getString("nome_recebedor");
			String cpfRecebedor = rs.getString("cpf_recebedor");
			String dataHoraEntrega = rs.getString("data_hora_entrega");
			entrega = new EntregasModel(id, numeroPedido, idCliente, nomeRecebedor, cpfRecebedor, dataHoraEntrega);
		}
		return entrega;
	}
}
