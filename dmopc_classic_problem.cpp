#include <bits/stdc++.h>
 
using namespace std;
 
typedef long long ll;
typedef pair<int, int> pi;

#define pb push_back
#define fi first
#define se second

int main() {
    ios::sync_with_stdio(0); cin.tie(0);

    int n, k;
    cin >> n >> k;

    int a[n+1];
    for (int i = 1; i <= n; i++) cin >> a[i];

    deque<int> max, min;

    ll ans = 0;
    for (int L = 1, R = 1; R <= n; R++) {
        while (!max.empty() && max.back() < a[R]) max.pop_back();
        while (!min.empty() && min.back() > a[R]) min.pop_back();
        max.push_back(a[R]); min.push_back(a[R]); // get used to typing it before using template def
        while (max.front() - min.front() > k) {
            if (max.front() == a[L]) max.pop_front();
            if (min.front() == a[L]) min.pop_front();
            L++;
        }
        ans += (R-L+1);
    }
    
    cout << ans << "\n";

    return 0;
}