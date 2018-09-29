// pages/start/start.js
const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    canIlogin : wx.canIUse('button.open-type.getUserInfo')
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    
  },
  bindGetUserInfo(e){
    console.log(e.detail.userInfo);
    app.globalData.userInfo.gender = e.detail.userInfo.gender;
    app.globalData.userInfo.avatarUrl = e.detail.userInfo.avatarUrl;
    // 登录
    wx.login({
      success: res => {
        if (res.code) {
          // 发送 res.code 到后台换取 openId, sessionKey, unionId
          var globalData = app.globalData;
          var codeUrl = 'https://api.weixin.qq.com/sns/jscode2session?appid=' + globalData.appid + '&secret=' + globalData.secret + '&js_code=' + res.code + '&grant_type=authorization_code';
          wx.request({
            url: codeUrl,
            data: {},
            method: 'GET',
            success: res => {
              console.log(res);
              //全局储存openid
              app.globalData.openid = res.data.openid;
              console.log(app.globalData.openid);
              var openidUrl = 'http://172.22.1.176:8081/user/getUserInfo?openId=' + app.globalData.openid;
              wx.request({
                url: openidUrl,
                data:{},
                header:{
                  'content-type': 'application/x-www-form-urlencoded'
                },
                method:'GET',
                success:res =>{
                  if(res.data.data !== null){
                    console.log(res.data.data);
                      app.globalData.userInfo.name = res.data.data.studentName,
                      app.globalData.userInfo.id = res.data.data.studentId,
                      app.globalData.userInfo.avatarUrl = res.data.data.avatarUrl,
                      app.globalData.userInfo.direction = res.data.data.major,
                    wx.switchTab({
                      url: '../home/home',
                    })
                  }else{
                    wx.redirectTo({
                      url: '../bind/bind',
                    })
                  }
                }
              })
            }
          });
        } else {
          console.log('获取登录态失败！');
        }
      }
    });
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
  
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
  
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
  
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
  
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
  
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
  
  },
  
})