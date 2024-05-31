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
  
});
