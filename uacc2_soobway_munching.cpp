/*
algorithm/thoughts:

*/

#include <bits/stdc++.h>

using namespace std;

typedef long long ll;
typedef pair<int, int> pi;

#define pb push_back
#define fi first
#define se second

const int INF = 0x3f3f3f3f;

int main() {
    ios::sync_with_stdio(0); cin.tie(0);

//    freopen("input.in", "r", stdin);
//    freopen("output.out", "w", stdout);

    int n, q, t; cin >> n >> q >> t;
    vector<ll> psa(n + 1), val;
    ll ans = 0;
    for (int i = 1; i <= n; i++) {
        int a; cin >> a;
        psa[i] = psa[i - 1] + a;
    }
    while (q--) {
        int l, r; cin >> l >> r;
        val.pb(psa[r] - psa[l - 1]);
    }
    sort(val.begin(), val.end(), greater<ll>());
    for (int i = 0; i < t; i++) ans += val[i];
    cout << ans << "\n";

    return 0;
}