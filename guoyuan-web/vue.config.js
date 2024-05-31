
const { defineConfig } = require("@vue/cli-service");
module.exports = defineConfig({
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
});
