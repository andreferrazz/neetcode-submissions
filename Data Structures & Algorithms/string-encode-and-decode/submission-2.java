class Solution {

    public String encode(List<String> strs) {
        if (strs.isEmpty()) {
            return null;
        }
        return String.join(" | ", strs);
    }

    public List<String> decode(String str) {
        if (str == null) {  
            return Collections.emptyList();
        }
        return List.of(str.split(" \\| "));
    }
}
