import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Administrador extends Usuario {
   
    public Administrador(int id, String nome) {
        super(id, nome, TipoUsuario.ADMINISTRADOR);
    }

    public void avaliarPedido(Pedido pedido, boolean aprovado) {
        if (aprovado) {
            pedido.setStatus(StatusPedido.APROVADO);
        } else {
            pedido.setStatus(StatusPedido.REPROVADO);
        }
    }

    public List<Pedido> listarPedidosPorData(Date dataInicio, Date dataFim) {
        List<Pedido> pedidosPorData = new ArrayList<>();
        for (Pedido pedido : Pedido.getTodosPedidos()) {
            if (pedido.getDataPedido().after(dataInicio) && pedido.getDataPedido().before(dataFim)) {
                pedidosPorData.add(pedido);
            }
        }
        return pedidosPorData;
    }

    public List<Pedido> buscarPedidosPorFuncionario(List<Pedido> todosPedidos, Funcionario funcionario) {
        List<Pedido> pedidosFuncionario = new ArrayList<>();
        for (Pedido pedido : todosPedidos) {
            if (pedido.getFuncionarioSolicitante().equals(funcionario)) {
                pedidosFuncionario.add(pedido);
            }
        }
        return pedidosFuncionario;
    }


}