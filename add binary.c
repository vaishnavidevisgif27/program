#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* addBinary(char* a, char* b) {
    int i = strlen(a) - 1;
    int j = strlen(b) - 1;
    int carry = 0;
    int maxlen = (i > j ? i : j) + 2; 
    char *res = (char*)malloc(maxlen + 1);
    if (!res) return NULL;
    int k = 0;

    while (i >= 0 || j >= 0 || carry) {
        int da = (i >= 0) ? (a[i--] - '0') : 0;
        int db = (j >= 0) ? (b[j--] - '0') : 0;
        int sum = da + db + carry;
        res[k++] = (char)('0' + (sum & 1));
        carry = sum >> 1;
    }

    res[k] = '\0';
    
    for (int l = 0, r = k - 1; l < r; ++l, --r) {
        char tmp = res[l];
        res[l] = res[r];
        res[r] = tmp;
    }
    return res;
}
