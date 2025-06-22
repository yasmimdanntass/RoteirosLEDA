package vetor;

import java.util.Comparator;

public class ComparatorAluno implements Comparator<Aluno>{

    @Override
    public int compare(Aluno a1, Aluno a2) {
        if (a1 == null && a2 == null) return 0;
        if (a1 == null) return -1;
        if (a2 == null) return 1;

        return Double.compare(a1.getMedia(), a2.getMedia());
    }
  
}
