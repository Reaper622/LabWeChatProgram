//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    introduce:"前端开发是创建Web页面或app等前端界面呈现给用户的过程。前端开发通过HTML，CSS及JavaScript以及衍生出来的各种技术、框架、解决方案，来实现互联网产品的用户界面交互。它从网页制作演变而来，名称上有很明显的时代特征。在互联网的演化进程中，网页制作是Web1.0时代的产物，早期网站主要内容都是静态，以图片和文字为主，用户使用网站的行为也以浏览为主。随着互联网技术的发展和HTML5、CSS3的应用，现代网页更加美观，交互效果显著，功能更加强大。",
  //内容是否已经展开
  spread:false,
  //图标状态
  iconState:true,
  //标签页当前展示页
  tabCurrent:'member',
  memberList:[],
  stackList:[
    { id: 0, title: 'HTML', url: 'https://s1.ax1x.com/2018/09/29/il0Rg0.png' },
    { id: 1, title: 'CSS', url: 'https://s1.ax1x.com/2018/09/29/il0gCn.png' },
    { id: 2, title: 'JavaScript', url: 'https://s1.ax1x.com/2018/09/29/il023q.png' },
    { id: 3, title: 'Angular', url: 'https://s1.ax1x.com/2018/09/29/il0yNj.png' },
    { id: 4, title: 'React', url: 'https://s1.ax1x.com/2018/09/29/il0sEQ.jpg' },
    { id: 5, title: 'Vue', url: 'https://s1.ax1x.com/2018/09/29/il064s.png' },
  ],
  },
  //按钮展开事件
  spreadTap:function(){
    this.setData({
      'spread': !this.data.spread
    })
    //旋转动画
    var spinAnimation = wx.createAnimation({
      duration:500,
      timingFunction:'linear'
    })
    this.spinAnimation = spinAnimation;
    if(this.data.iconState){
      this.spinAnimation.rotate(180).step()
      this.setData({
        'spinAnimation':this.spinAnimation.export(),
        'iconState':!this.data.iconState
      })
    }else{
      this.spinAnimation.rotate(360).step()
      this.setData({
        'spinAnimation': this.spinAnimation.export(),
        'iconState': !this.data.iconState
      })
    }
  },
  //改变标签页
  handleChange({ detail }) {
    this.setData({
      tabCurrent: detail.key
    });
  },
  onLoad: function () {
    var downAnimation = wx.createAnimation({
      duration: 500,
      timingFunction: 'ease',
    })
    this.downAnimation = downAnimation;
    var next = true;
    //连续动画
    setInterval(function () {
      if (next) {
        this.downAnimation.scale(0.95).step()
        next = !next;
      } else {
        this.downAnimation.scale(1.1).step()
        next = !next;
      }
      this.setData({
        'downAnimation': this.downAnimation.export()
      })
    }.bind(this), 500)
    //根据方向获取内容
    wx.request({
      url: 'http://172.22.1.176:8081/user/getUserByMajor' ,
      method:'GET',
      data:{
        major: app.globalData.userInfo.direction
      },
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      success:res =>{
        console.log(res);
        this.setData({
          memberList:res.data.data
        })
      }

    })
  }
})
