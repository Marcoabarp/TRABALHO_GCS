import java.util.ArrayList;
import java.util.List;

public class Administrador extends Usuario {
    //o construtor vai ser mudado ainda
    //public Administrador(int id, String nome) {
    //    super(id, nome, TipoUsuario.ADMINISTRADOR);
    //}

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


}