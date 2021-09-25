/**Auther:FDF
 * Date:2021/9/25*/
import java.util.ArrayList;
import java.util.List;

class TestThread {
    static List<mem> me = new ArrayList<>();

    public static void main(String args[]) {
        int i = 0;
        while (true) {
            RunnableDemo R = new RunnableDemo(String.valueOf(i));
            R.start();
        }
    }

    static class mem {
        static int a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, u, v, w, x, y, z;
        static String A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z;
        static char aa, bb, cc, dd, ee, ff, gg, hh, ii, jj, kk, ll, mm, nn, oo;

        public mem() {
            a = b = c = d = e = f = g = h = i = j = k = l = m = n = o = p = q = r = s = u = v = w = x = y = z = 1;
            A = B = C = D = E = F = G = H = I = J = K = L = M = N = O = P = Q = R = S = T = U = V = W = X = Y = Z = "null";
            aa = bb = cc = dd = ee = ff = gg = hh = ii = jj = kk = ll = mm = nn = oo = 'a';
        }
    }

}

class RunnableDemo implements Runnable {
    private Thread t;
    private String threadName;


    RunnableDemo(String name) {
        threadName = name;
        System.out.println("Creating " + threadName);

    }

    @Override
    public void run() {
        System.out.println("Running " + threadName);
        try {
            for (int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // 让线程睡眠一会
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        for (int z = 0; z < 500; z++) {
            TestThread.me.add(new TestThread.mem());
        }
        System.out.println("Thread " + threadName + " exiting.");
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}
