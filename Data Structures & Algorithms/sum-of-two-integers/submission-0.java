class Solution {
    public int getSum(int a, int b) {
        int result = 0;
        int carry = 0;
        
        // Loop through all 32 bit positions one by one
        for (int i = 0; i < 32; i++) {
            // Extract the i-th bit of a and b (either 0 or 1)
            int bitA = (a >> i) & 1;
            int bitB = (b >> i) & 1;
            
            // Calculate the sum for the current bit position
            // 1 ^ 1 ^ 1 = 1, 1 ^ 1 ^ 0 = 0, etc.
            int sumBit = bitA ^ bitB ^ carry;
            
            // Write the sumBit into the correct position of the result
            result |= (sumBit << i);
            
            // Determine the carry for the next bit position
            // A carry happens if at least two of (bitA, bitB, carry) are 1
            carry = (bitA & bitB) | (bitA & carry) | (bitB & carry);
        }
        
        return result;
    }
}
