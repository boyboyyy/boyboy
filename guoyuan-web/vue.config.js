/*
 * @Author: Oh...Yeah!!! 614988210@qq.com
 * @Date: 2024-05-31 08:40:02
 * @LastEditors: Oh...Yeah!!! 614988210@qq.com
 * @LastEditTime: 2024-05-31 22:17:25
 * @FilePath: \guoyuan-web\vue.config.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */

const { defineConfig } = require("@vue/cli-service");
module.exports = defineConfig({
<<<<<<< HEAD
  devServer: {
    open: true,
    proxy: {
      '/api': {
        target: 'http://47.96.226.103:8007',//要代理的本地api地址，也可以换成线上测试地址
        changeOrigin: true,//允许跨域
        pathRewrite: { "^/api": "/api" }//将/api开头替换为/api
      }
    }
  },
  lintOnSave: false,// 屏蔽EsLint
  transpileDependencies: true,
  lintOnSave: false
=======

  // 配置代理跨域
  devServer: {     
    proxy: {     
      "/api": {     
        target: "http://localhost:8080",     
        pathRewrite: {     
          "^/api": "/",     
        },     
        // ws:true     
      },     
    },
  },

  publicPath: "/",
  lintOnSave: false,// 屏蔽EsLint 
  transpileDependencies: true
  
>>>>>>> origin/main
});
