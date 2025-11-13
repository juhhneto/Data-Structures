import java.util.*;

public class MainLab {

    // ===== BLOCO A: Collections & List =====
    static void blocoA() {
        System.out.println("== BLOCO A: Collections & List ==");
        
        // Tarefa A1
        System.out.println("\n--- Tarefa A1 ---");
        List<Integer> l = new LinkedList<>(Arrays.asList(5, 2, 8, 1, 9));
        Collections.sort(l); System.out.println("A1 - Ordenada: " + l);
        System.out.println("A1 - Índice 8: " + Collections.binarySearch(l, 8));
        Collections.reverse(l); System.out.println("A1 - Reverse: " + l);
        Collections.shuffle(l); System.out.println("A1 - Shuffle: " + l);

        // Tarefa A2
        System.out.println("\n--- Tarefa A2 ---");
        List<String> l1 = new LinkedList<>(Arrays.asList("Java", "Python", "C++")),
                     l2 = new LinkedList<>(Arrays.asList("C#", "Java", "Go"));
        Collections.addAll(l1, "Kotlin", "Swift");
        System.out.println("A2 - l1 pós addAll: " + l1);
        System.out.println("A2 - Freq 'Java': " + Collections.frequency(l1, "Java"));
        System.out.println("A2 - Disjuntos? " + Collections.disjoint(l1, l2));
        System.out.println("A2 - min/max: " + Collections.min(l) + "/" + Collections.max(l) + "\n");
    }

    // ===== BLOCO B: Stack (LIFO) =====
    static void blocoB() {
        System.out.println("== BLOCO B: Stack (LIFO) ==");
        
        // Tarefa B1
        System.out.println("\n--- Tarefa B1 ---");
        String[] exp = {"((2+3)*(4-1))", ")(2+3)(", "(1+(2*3))"};
        for (String s : exp)
            System.out.printf("B1 - '%s': %s\n", s, verificaParenteses(s) ? "Balanceada" : "Desbalanceada");
        
        // Tarefa B2
        System.out.println("\n--- Tarefa B2 ---");
        System.out.println("B2 - Invertendo 'ALGORITMO': " + inverterPilha("ALGORITMO") + "\n");
    }

    static boolean verificaParenteses(String s) {
        Stack<Character> p = new Stack<>();
        for (char c : s.toCharArray())
            if (c == '(') p.push(c);
            else if (c == ')' && p.isEmpty()) return false;
            else if (c == ')') p.pop();
        return p.isEmpty();
    }

    static String inverterPilha(String s) {
        Stack<Character> p = new Stack<>();
        for (char c : s.toCharArray()) p.push(c);
        StringBuilder sb = new StringBuilder();
        while (!p.isEmpty()) sb.append(p.pop());
        return sb.toString();
    }

    // ===== BLOCO C: Queue & PriorityQueue =====
    static void blocoC() {
        System.out.println("== BLOCO C: Queue & PriorityQueue ==");
        
        // Tarefa C1
        System.out.println("\n--- Tarefa C1 ---");
        Queue<String> f = new LinkedList<>();
        f.offer("Doc1"); f.offer("Doc2"); f.offer("Doc3");
        System.out.println("C1 - Após enfileirar: " + f);
        f.poll(); f.poll();
        System.out.println("C1 - Após remover 2: " + f);
        f.offer("Doc4"); System.out.println("C1 - Após Doc4: " + f);
        System.out.println("C1 - Peek/Size: " + f.peek() + "/" + f.size());
        f.clear(); System.out.println("C1 - Após clear: " + f);

        // Tarefa C2
        System.out.println("\n--- Tarefa C2 ---");
        PriorityQueue<Integer> pq = new PriorityQueue<>(Arrays.asList(30, 10, 20, 40));
        System.out.println("C2 - PriorityQueue: " + pq);
        System.out.println("C2 - Peek: " + pq.peek());
        System.out.print("C2 - Remoção: ");
        while (!pq.isEmpty()) System.out.print(pq.poll() + " ");
        System.out.println("\n");
    }

    // ===== BLOCO D: Set & Map =====
    static void blocoD() {
        System.out.println("== BLOCO D: Set & Map ==");
        
        // Tarefa D1
        System.out.println("\n--- Tarefa D1 ---");
        HashSet<String> hs = new HashSet<>(Arrays.asList("Java", "Python", "C++", "Java"));
        System.out.println("D1 - HashSet: " + hs);
        TreeSet<Integer> ts = new TreeSet<>(Arrays.asList(10, 5, 8, 1));
        System.out.println("D1 - TreeSet: " + ts);
        System.out.println("D1 - headSet(8)/tailSet(8): " + ts.headSet(8) + "/" + ts.tailSet(8));

        // Tarefa D2
        System.out.println("\n--- Tarefa D2 ---");
        HashMap<String, Integer> notas = new HashMap<>();
        notas.put("Ana", 90);
        System.out.println("D2 - HashMap após Ana: " + notas);
        notas.put("Carlos", 80);
        System.out.println("D2 - HashMap após Carlos: " + notas);
        notas.put("Bianca", 85);
        System.out.println("D2 - HashMap após Bianca: " + notas);
        System.out.println("D2 - Nota Ana: " + notas.get("Ana"));
        System.out.println("D2 - KeySet/Size: " + notas.keySet() + "/" + notas.size());
        System.out.println("D2 - TreeMap (ordenado): " + new TreeMap<>(notas) + "\n");
    }

    // ===== BLOCO E: Lista Encadeada & BST =====
    static void blocoE() {
        System.out.println("== BLOCO E: Lista Encadeada & BST ==");
        
        // Tarefa E1
        System.out.println("\n--- Tarefa E1 ---");
        ListaEncadeada lista = new ListaEncadeada();
        lista.insertAtBack(2); lista.insertAtBack(3); lista.insertAtFront(1);
        lista.insertAtFront(4); lista.insertAtBack(5);
        System.out.print("E1 - Após inserções: "); lista.print();
        lista.removeFromFront(); lista.removeFromBack();
        System.out.print("E1 - Após remoções: "); lista.print();

        // Tarefa E2
        System.out.println("\n--- Tarefa E2 ---");
        BST bst = new BST();
        for (int v : new int[]{8, 3, 10, 1, 6, 14, 4, 7, 13}) bst.insert(v);
        System.out.print("E2 - In-order: "); bst.inOrder();
        System.out.print("E2 - Pre-order: "); bst.preOrder();
        System.out.print("E2 - Post-order: "); bst.postOrder();
    }

    static class ListaEncadeada {
        static class Node { int d; Node n; Node(int d) { this.d = d; } }
        Node h;
        void insertAtFront(int d) { Node x = new Node(d); x.n = h; h = x; }
        void insertAtBack(int d) {
            Node x = new Node(d);
            if (h == null) { h = x; return; }
            Node a = h;
            while (a.n != null) a = a.n;
            a.n = x;
        }
        void removeFromFront() { if (h != null) h = h.n; }
        void removeFromBack() {
            if (h == null || h.n == null) { h = null; return; }
            Node a = h;
            while (a.n.n != null) a = a.n;
            a.n = null;
        }
        void print() {
            Node a = h;
            while (a != null) {
                System.out.print(a.d);
                if (a.n != null) System.out.print("->");
                a = a.n;
            }
            System.out.println();
        }
    }

    static class BST {
        static class Node { int v; Node l, r; Node(int v) { this.v = v; } }
        Node r;
        void insert(int v) { r = insert(r, v); }
        Node insert(Node n, int v) {
            if (n == null) return new Node(v);
            if (v < n.v) n.l = insert(n.l, v);
            else if (v > n.v) n.r = insert(n.r, v);
            return n;
        }
        void inOrder() { inOrder(r); System.out.println(); }
        void preOrder() { preOrder(r); System.out.println(); }
        void postOrder() { postOrder(r); System.out.println(); }
        void inOrder(Node n) { if (n != null) { inOrder(n.l); System.out.print(n.v + " "); inOrder(n.r); } }
        void preOrder(Node n) { if (n != null) { System.out.print(n.v + " "); preOrder(n.l); preOrder(n.r); } }
        void postOrder(Node n) { if (n != null) { postOrder(n.l); postOrder(n.r); System.out.print(n.v + " "); } }
    }

    public static void main(String[] args) {
        blocoA(); blocoB(); blocoC(); blocoD(); blocoE();
    }
}