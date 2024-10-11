import java.util.*;

public class Main {

    private static List<Departamento> departamentos = new ArrayList<>();
    private static List<Funcionario> funcionarios = new ArrayList<>();
    private static List<Pedido> pedidos = new ArrayList<>();
    private static Usuario usuarioAtual;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        inicializarDados();

        while (true) {
            System.out.println("=== Sistema de Controle de Aquisições ===");
            System.out.println("Usuário Atual: " + (usuarioAtual != null ? usuarioAtual.getNome() : "Nenhum"));
            System.out.println("1. Alterar Usuário");
            System.out.println("2. Registrar Pedido");
            System.out.println("3. Listar Pedidos");
            if (usuarioAtual instanceof Administrador) {
                System.out.println("4. Avaliar Pedido");
                System.out.println("5. Ver Estatísticas");
            }
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    alterarUsuario(scanner);
                    break;
                case 2:
                    registrarPedido(scanner);
                    break;
                case 3:
                    listarPedidos();
                    break;
                case 4:
                    if (usuarioAtual instanceof Administrador) {
                        avaliarPedido(scanner);
                    } else {
                        System.out.println("Acesso negado! Apenas administradores podem avaliar pedidos.");
                    }
                    break;
                case 5:
                    if (usuarioAtual instanceof Administrador) {
                        ((Administrador) usuarioAtual).verEstatisticas(pedidos);
                    } else {
                        System.out.println("Acesso negado! Apenas administradores podem ver estatísticas.");
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void inicializarDados() {
        // Inicializa Departamentos
        Departamento financeiro = new Departamento(1, "Financeiro", 10000.0);
        Departamento rh = new Departamento(2, "RH", 8000.0);
        Departamento engenharia = new Departamento(3, "Engenharia", 15000.0);
        Departamento manutencao = new Departamento(4, "Manutenção", 5000.0);
        Departamento ti = new Departamento(5, "TI", 12000.0);

        departamentos.addAll(Arrays.asList(financeiro, rh, engenharia, manutencao, ti));

        // Inicializa Funcionários
        Funcionario joao = new Funcionario(1, "João", financeiro);
        Funcionario maria = new Funcionario(2, "Maria", rh);
        Funcionario carlos = new Funcionario(3, "Carlos", engenharia);
        Funcionario ana = new Funcionario(4, "Ana", manutencao);
        Funcionario pedro = new Funcionario(5, "Pedro", ti);

        funcionarios.addAll(Arrays.asList(joao, maria, carlos, ana, pedro));

        // Define o usuário inicial como administrador
        usuarioAtual = new Administrador(6, "Admin");

        System.out.println("Dados de exemplo inicializados.");
    }

    private static void alterarUsuario(Scanner scanner) {
        System.out.println("Escolha o usuário:");
        System.out.println("0. Admin");
        for (int i = 0; i < funcionarios.size(); i++) {
            System.out.println((i + 1) + ". " + funcionarios.get(i).getNome());
        }

        int opcao = scanner.nextInt();
        if (opcao == 0) {
            usuarioAtual = new Administrador(6, "Admin");
        } else if (opcao > 0 && opcao <= funcionarios.size()) {
            usuarioAtual = funcionarios.get(opcao - 1);
        } else {
            System.out.println("Usuário inválido.");
        }
    }

    private static void registrarPedido(Scanner scanner) {
        if (!(usuarioAtual instanceof Funcionario)) {
            System.out.println("Apenas funcionários podem registrar pedidos.");
            return;
        }
    
        Funcionario funcionario = (Funcionario) usuarioAtual;
        System.out.print("Quantos itens o pedido terá? ");
        int quantidadeItens = scanner.nextInt();
        List<Item> itens = new ArrayList<>();
    
        for (int i = 0; i < quantidadeItens; i++) {
            scanner.nextLine();  // Consome o newline
            System.out.print("Descrição do item: ");
            String descricao = scanner.nextLine();
            System.out.print("Valor unitário: ");
            double valorUnitario = scanner.nextDouble();
            System.out.print("Quantidade: ");
            int quantidade = scanner.nextInt();
    
            Item item = new Item(descricao, valorUnitario, quantidade, 0, funcionario, funcionario.getDepartamento());
            itens.add(item);
        }
    
        Pedido pedido = new Pedido(pedidos.size() + 1, funcionario, itens);  // Correção aqui
        if (pedido.getValorTotal() <= funcionario.getDepartamento().getLimitePedido()) {
            pedidos.add(pedido);
            System.out.println("Pedido registrado com sucesso!");
        } else {
            System.out.println("Erro: O valor total do pedido excede o limite permitido pelo departamento.");
        }
    }

    private static void listarPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido registrado.");
            return;
        }

        for (Pedido pedido : pedidos) {
            System.out.println(pedido);
        }
    }

    private static void avaliarPedido(Scanner scanner) {
        System.out.print("Digite o ID do pedido a ser avaliado: ");
        int id = scanner.nextInt();
        Pedido pedido = buscarPedidoPorId(id);

        if (pedido != null && pedido.getStatus() == StatusPedido.ABERTO) {
            System.out.print("Aprovar pedido? (1 - Sim, 0 - Não): ");
            boolean aprovado = scanner.nextInt() == 1;
            ((Administrador) usuarioAtual).avaliarPedido(pedido, aprovado);
        } else {
            System.out.println("Pedido inválido ou já avaliado.");
        }
    }

    private static Pedido buscarPedidoPorId(int id) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == id) {
                return pedido;
            }
        }
        return null;
    }
}
