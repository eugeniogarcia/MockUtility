const express = require('express');
const conf = require('./proxy.conf.json');
const proxy = require('http-proxy-middleware');


const app = express();

for (const proxyConf in conf) {
    if(!conf.hasOwnProperty(proxyConf)) continue;

    const config = conf[proxyConf];
    config.target = config.targetDev1;
    const middleware = proxy(proxyConf, config);
    app.use(middleware);

}

app.listen(process.env.PORT || 3000);