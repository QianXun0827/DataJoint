const http = require("http");
const https = require('https');
const fs = require('fs');
const url = require("url");
// const qs = require("querystring");

//用node中的http创建服务器 并传入两个形参
http.createServer(function(req , res) {
    //设置请求头  允许所有域名访问 解决跨域
    res.setHeader("Access-Control-Allow-Origin" , "*");
    var path=req.url;
    //获取请求参数
    var formData='';
    if (req.method === 'GET'){
        //获取地址中的参数
        formData = url.parse(req.url).query;
        requestServer(path, formData);
    }else{
        req.on('data', function (chunk) {
            // chunk 默认是一个二进制数据，和 data 拼接会自动 toString
            formData += chunk;
        });

        //当接收表单提交的数据完毕之后，就可以进一步处理了,注册end事件，所有数据接收完成会执行一次该方法
        req.on('end', function () {
            //对url进行解码（url会对中文进行编码）
            formData = decodeURI(formData);
            //向真实服务器发送请求
            requestServer(path, decodeURI(formData));
        });

    }
    //请求云平台服务器获取获取
    function requestServer(path, formData){
        var options = {
            hostname: 'www.hik-express.com',
            port: 443,
            path: path,
            method: 'post',
            requestCert: true,  //请求客户端证书
            rejectUnauthorized: false, //不拒绝不受信任的证书
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
                'Content-Length': Buffer.byteLength(formData)
            },
            cert: fs.readFileSync('public.pem')

        };
        options.agent = new https.Agent(options);
        var data='';
        var request = https.request(options, function(response) {
            response.setEncoding('utf-8');
            response.on('data', function(d) {
                data += d;
            });
            response.on('end', function() {
                //把data数据返回前端
                res.end(data);
            });
        });

        request.on('error', function(e) {
            console.log(e);
        });
        // write data to request body
        request.write(formData);
        request.end();
    }


}).listen(8989, function(err){
    if(!err){
        console.log("服务器启动成功，正在监听8989...");
    }
});