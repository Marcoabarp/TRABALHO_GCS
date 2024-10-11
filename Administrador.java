import java.util.ArrayList;
import java.util.List;
import java.util.Date;
public class Administrador extends Usuario {
    public Administrador(int id, String nome) {
        super(id, nome);
    }

    public void avaliarPedido(Pedido pedido, boolean aprovado) {
        if (pedido.getStatus() == StatusPedido.ABERTO) { // Só pode avaliar pedidos abertos
            if (aprovado) {
                pedido.setStatus(StatusPedido.APROVADO);
                System.out.println("Pedido " + pedido.getId() + " aprovado.");}
            else {
                pedido.setStatus(StatusPedido.REPROVADO);
                System.out.println("Pedido " + pedido.getId() + " reprovado.");}
        } else{
            System.out.println("Erro: O pedido já foi avaliado.");}
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

    public void visualizarDetalhesPedido(Pedido pedido) {
        System.out.println("Detalhes do Pedido " + pedido.getId() + ":");
        System.out.println("Solicitante: " + pedido.getFuncionarioSolicitante().getNome());
        System.out.println("Departamento: " + pedido.getFuncionarioSolicitante().getDepartamento().getNome());
        System.out.println("Status: " + pedido.getStatus());
        System.out.println("Valor Total: " + pedido.getValorTotal());
        for (Item item : pedido.getItens()) {
            System.out.println("- " + item.getDescricao() + ": " + item.getQuantidade() + " x " + item.getValorUnitario() + " = " + item.calcularTotal(getId(), getId()));
        }
    }

    public void verEstatisticas(List<Pedido> todosPedidos) {
        int totalPedidos = 0;
        int pedidosAprovados = 0;
        int pedidosReprovados = 0;
        double valorTotalUltimos30Dias = 0;
        int pedidosUltimos30Dias = 0;
        Date hoje = new Date();
        Pedido maiorPedidoAberto = null;

        //ainda preciso adicionar mais mas to meio perdido do q fazer :( )
        //já to vendo q isso n vai funcionar :O :O :O

        for (Pedido pedido : todosPedidos) {
            totalPedidos++;
            if (pedido.getStatus() == StatusPedido.APROVADO) {
                pedidosAprovados++;
            } else if (pedido.getStatus() == StatusPedido.REPROVADO) {
                pedidosReprovados++;
            }

            long diffInMillies = Math.abs(hoje.getTime() - pedido.getDataPedido().getTime());
            long diffInDays = diffInMillies / (1000 * 60 * 60 * 24);
            if (diffInDays <= 30) {
                valorTotalUltimos30Dias += pedido.getValorTotal();
                pedidosUltimos30Dias++;
            }

            if (pedido.getStatus() == StatusPedido.ABERTO && (maiorPedidoAberto == null || pedido.getValorTotal() > maiorPedidoAberto.getValorTotal())) {
                maiorPedidoAberto = pedido;
            }
        }

        System.out.println("Estatísticas:");
        System.out.println("Total de pedidos: " + totalPedidos);
        System.out.println("Pedidos aprovados: " + pedidosAprovados + " (" + ((double) pedidosAprovados / totalPedidos * 100) + "%)");
        System.out.println("Pedidos reprovados: " + pedidosReprovados + " (" + ((double) pedidosReprovados / totalPedidos * 100) + "%)");
        System.out.println("Pedidos nos últimos 30 dias: " + pedidosUltimos30Dias);
        System.out.println("Valor médio dos pedidos nos últimos 30 dias: " + (pedidosUltimos30Dias > 0 ? valorTotalUltimos30Dias / pedidosUltimos30Dias : 0));
        if (maiorPedidoAberto != null) {
            System.out.println("Maior pedido aberto: " + maiorPedidoAberto.getId() + " com valor de " + maiorPedidoAberto.getValorTotal());
        } else {
            System.out.println("Nenhum pedido aberto encontrado.");
        }

    
    }


}