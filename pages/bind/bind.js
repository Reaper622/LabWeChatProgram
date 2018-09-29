// pages/bind/bind.js
const app = getApp();

Page({

  /**
   * 页面的初始数据
   */
  data: {
    username:"",
    id:"",
    directionItems:[
      { id: 0, text: '前端', url: '../../images/recruit/web.png' ,toSend:'qianDuan' },
      { id: 1, text: '后台', url: '../../images/recruit/java.png', toSend: 'houTai' },
      { id: 2, text: '安卓', url: '../../images/recruit/andriod.png',toSend:'andriod' },
    ],
    current:'qianDuan',
  },
  //切换方向
  changeDirection:function(e){
    this.setData({
      'current':e.currentTarget.dataset.content,
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var titleAnimation = wx.createAnimation({
      duration:500,
      timingFunction:'ease',
    })
    this.titleAnimation = titleAnimation;
    var next = true;
    //连续动画
    setInterval(function(){
      if(next){
        this.titleAnimation.scale(0.95).step()
        next = !next;
      }else{
        this.titleAnimation.scale(1).step()
        next = !next;
      }
      this.setData({
        'titleAnimation': this.titleAnimation.export()
      })
    }.bind(this),500)
  },
  //输入姓名时存储输入的数据
  usernameInput:function(e){
    this.setData({
      username:e.detail.value
    })
  },
  //输入学号时存储输入的数据
  idInput:function(e){
    this.setData({
      id:e.detail.value
    })
  },
  bindEvent:function(){
    let user = {
      username: this.data.username,
      id:this.data.id,
      direction:this.data.current,
      avatarUrl:app.globalData.userInfo.avatarUrl
    };
    console.log(user);
    console.log(app.globalData.openid);
    wx.request({
      url: 'http://172.22.1.176:8081/user/bind',
      data:{
        "studentName":user.username,
        "studentId":user.id,
        "openId":app.globalData.openid,
        "major":this.data.current,
        "avatarUrl": user.avatarUrl
      },
      header:{
        'content-type':'application/json'
      },
      method:'POST',
      success: res =>{
        app.globalData.userInfo.id = user.id;
        app.globalData.userInfo.name = user.username;
        app.globalData.userInfo.direction = user.direction;
        console.log(res.data.message);
      }
    })
    wx.switchTab({
      url: '../home/home',
    })
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
  
  }
})