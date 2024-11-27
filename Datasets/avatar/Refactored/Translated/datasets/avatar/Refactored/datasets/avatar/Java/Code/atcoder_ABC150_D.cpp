#include <iostream>
#include <vector>

using namespace std;

long gcd(long a, long b) {
    return b == 0 ? a : gcd(b, a % b);
}

long lcm(long a, long b) {
    return a * (b / gcd(a, b));
}

int main() {
    int n, m;
    cin >> n >> m;
    vector<int> a(n);
    
    for (int i = 0; i < n; i++) {
        cin >> a[i];
        a[i] /= 2;
    }
    
    long lcd = 1;
    for (int i = 0; i < n; i++) {
        lcd = lcm(lcd, a[i]);
        if (lcd > m) {
            cout << 0 << endl;
            return 0;
        }
    }
    
    for (int i = 0; i < n; i++) {
        if ((lcd / a[i]) % 2 == 0) {
            cout << 0 << endl;
            return 0;
        }
    }
    
    cout << (m / lcd + 1) / 2 << endl;
    return 0;
}