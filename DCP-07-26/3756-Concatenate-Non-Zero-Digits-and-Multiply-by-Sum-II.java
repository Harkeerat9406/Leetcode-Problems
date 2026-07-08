class Solution {
    public int[] sumAndMultiply(String s, int[][] q) {
        int qlen = q.length, slen = s.length();
        final int mod = 1_000_000_007;

        long[] prefixSum = new long[slen + 1];
        long[] prefixNum = new long[slen + 1];
        int[] nonZeroCount = new int[slen + 1]; 

        for (int i = 0; i < slen; i++) {
            int dig = s.charAt(i) - '0';
            prefixSum[i + 1] = prefixSum[i] + dig;

            if (dig != 0) {
                prefixNum[i + 1] = (prefixNum[i] * 10 + dig) % mod;
                nonZeroCount[i + 1] = nonZeroCount[i] + 1;
            } else {
                prefixNum[i + 1] = prefixNum[i];
                nonZeroCount[i + 1] = nonZeroCount[i];
            }
        }

        // precompute 10^k mod p, k = 0..slen (k = count of nonzero digits, at most slen)
        long[] pow10 = new long[slen + 1];
        pow10[0] = 1;
        for (int i = 1; i <= slen; i++) pow10[i] = (pow10[i - 1] * 10) % mod;

        int[] ans = new int[qlen];
        for (int i = 0; i < qlen; i++) {
            int l = q[i][0], r = q[i][1];

            long sum = prefixSum[r + 1] - prefixSum[l];

            int cnt = nonZeroCount[r + 1] - nonZeroCount[l]; 
            long shift = pow10[cnt];
            long num = ((prefixNum[r + 1] - prefixNum[l] * shift % mod) % mod + mod) % mod;

            ans[i] = (int) ((sum % mod) * num % mod);
        }
        return ans;
    }
}