package com.oddcn.screensharetobrowser.server.webServer;

import android.content.res.AssetManager;

import com.yanzhenjie.andserver.AndServer;
import com.yanzhenjie.andserver.Server;
import com.yanzhenjie.andserver.website.AssetsWebsite;

/**
 * Created by OddCN on 2017/11/14.
 */

public class WebServer {
    private static final String TAG = "WebServer";

    public static final int ERROR_TYPE_NORMAL = 0;
    public static final int ERROR_TYPE_PORT_IN_USE = 1;

    public static Server init(AssetManager assetManager, int port, Server.Listener listener) {
        AndServer andServer = new AndServer.Build()
                .port(port)
                .timeout(10 * 1000)
                .website(new AssetsWebsite(assetManager, "web"))
                .listener(listener)
                .build();

        return andServer.createServer();
    }
}