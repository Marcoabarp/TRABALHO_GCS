import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Administrador extends Usuario {
   
    public Administrador(int id, String nome) {
        super(id, nome, TipoUsuario.ADMINISTRADOR);
    }

    public void avaliarPedido(Pedido pedido, boolean aprovado) {
        if (pedido.getStatus() == StatusPedido.ABERTO) { // Só pode avaliar pedidos abertos
            if (aprovado) {
                pedido.setStatus(StatusPedido.APROVADO);
                System.out.println("Pedido " + pedido.getId() + " aprovado.");
            } else {
                pedido.setStatus(StatusPedido.REPROVADO);
                System.out.println("Pedido " + pedido.getId() + " reprovado.");
            }
        } else {
            System.out.println("Erro: O pedido já foi avaliado.");
        }
    }

    public List<Pedido> listarPedidosPorData(List<Pedido> todosPedidos, Date dataInicio, Date dataFim) {
        List<Pedido> pedidosPorData = new ArrayList<>();
        for (Pedido pedido : todosPedidos) {
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

    public List<Pedido> buscarPedidosPorDescricao(List<Pedido> todosPedidos, String descricao) {
        List<Pedido> pedidosDescricao = new ArrayList<>();
        for (Pedido pedido : todosPedidos) {
            for (Item item : pedido.getItens()) {
                if (item.getDescricao().contains(descricao)) {
                    pedidosDescricao.add(pedido);
                    break;
                }
            }
        }
        return pedidosDescricao;
    }



}