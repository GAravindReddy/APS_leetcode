import java.util.*;

class Solution {

    class UnionFind {
        Map<String, String> parent = new HashMap<>();

        public String find(String s) {
            if (!parent.get(s).equals(s)) {
                parent.put(s, find(parent.get(s)));  // Path compression
            }
            return parent.get(s);
        }

        public void union(String a, String b) {
            String rootA = find(a);
            String rootB = find(b);
            if (!rootA.equals(rootB)) {
                parent.put(rootA, rootB);
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        UnionFind uf = new UnionFind();
        Map<String, String> emailToName = new HashMap<>();

        // Step 1: Initialize parent and union emails
        for (List<String> account : accounts) {
            String name = account.get(0);

            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                uf.parent.putIfAbsent(email, email);
                emailToName.put(email, name);
                uf.union(account.get(1), email); // union with first email
            }
        }

        // Step 2: Group emails by root
        Map<String, List<String>> groups = new HashMap<>();

        for (String email : uf.parent.keySet()) {
            String root = uf.find(email);
            groups.computeIfAbsent(root, k -> new ArrayList<>()).add(email);
        }

        // Step 3: Build result
        List<List<String>> result = new ArrayList<>();

        for (String root : groups.keySet()) {
            List<String> emails = groups.get(root);
            Collections.sort(emails);

            List<String> account = new ArrayList<>();
            account.add(emailToName.get(root));
            account.addAll(emails);

            result.add(account);
        }

        return result;
    }
}