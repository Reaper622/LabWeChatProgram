// pages/home/home.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    topImgs:[
      { id: 0, url: 'https://s1.ax1x.com/2018/09/26/iM2O8H.png', },
      { id: 1, url: 'https://s1.ax1x.com/2018/09/26/iM2O8H.png', },
      { id: 2, url: 'https://s1.ax1x.com/2018/09/26/iM2LPe.jpg', }
    ]
  },
  //点击前往招新
  tapToRedirect:function(e){
    wx.navigateTo({
      url: '../'+e.currentTarget.dataset.url,
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

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