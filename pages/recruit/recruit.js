// pages/recruit/recruit.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    infoList:[
      { id: 0, content: '工作室负责人--刘岽' },
      { id: 1, content: '宣讲会地址变动为2450' },
      { id: 2, content: '前端最后一次作业提交截止时间为' }
    ],
    major:"web",//默认位前端页面
    majorWord:"前端",
    useFunction:"signIn",//默认为签到功能
    directions:[
      { url: "../../images/recruit/web.png", title: "web",word:"前端",id:0 },
      { url: "../../images/recruit/java.png", title: "java",word:"后台",id:1 },
      { url: "../../images/recruit/andriod.png", title: "andriod",word:"安卓",id:2 }
    ],
    signInCode:'',
    homeworkList:[
      { id: 0, title: '第一次作业', content: '写一个html页面哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈', deadline: '2018-9-24' },
      { id: 1, title: '第二次作业', content: '写一个css', deadline: '2018-9-30' },
      { id: 2, title: '第三次作业', content: '写一个js', deadline: '2018-10-1' }
    ],
    gradeList:[
      { id: 0, title: '第一次作业', score: 94, comment: '有待提高' },
      { id: 1, title: '第二次作业', score: 70, comment: '太差' },
      { id: 2, title: '第三次作业', score: 100, comment: 'very good' }
    ],
    board:{
      url:'../../images/recruit/front-end2.jpg',
      title:'HTML标签的使用',
      time:'2018-10-20',
      address:'3201教室'
    }
  
  },
  //绑定方向
  bindDirection:function(e){
    this.setData({
      major:e.currentTarget.dataset.title,
      majorWord:e.currentTarget.dataset.word
    })
  },
  //签到
  toSignIn:function(){
    this.setData({
      useFunction :"signIn"
    })
  },
  //查作业
  toCheckTask:function(){
    this.setData({
      useFunction: "checkTask"
    })
  },
  //查成绩
  toCheckGrade:function(){
    this.setData({
      useFunction: "checkGrade"
    })
  },
  //输入签到码
  inputSignInCode:function(e){
      this.setData({
        signInCode:e.detail.value
      })
  },
  sendSignInCode:function(){
    console.log(this.data.signInCode)
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