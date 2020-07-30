// 房屋类型
$(function(){
	// 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main10'));
    // 指定图表的配置项和数据
    var option = {
	    grid: {
	    	top:'0',
            left: '20',   //图表距边框的距离
            right: '20',
            bottom: '0',
            containLabel: true
        },
	    xAxis: {
	        type: 'value',
	        boundaryGap: [0, 0.01],
	        
	        axisTick:{
                show:false  //去掉y轴刻度线
            },
            splitLine:{
                show:false
            },
            axisLine:{
            	show:false
				/*lineStyle:{
					color:'#F4F4F3', // x坐标轴的轴线颜色
					width:0, //这里是坐标轴的宽度,为0就是不显示
				}*/
			},
			axisLabel : {
				show:false
                /*textStyle: {
                    fontSize: 16,
                    color:'#666'
                }*/
            },
	    },
	    yAxis: {
	        type: 'category',
	        data: ['党员','优抚家庭','孤老家庭','失孤家庭','单亲家庭','低保家庭','犯罪前科'],
	        axisTick:{
                show:false  //去掉y轴刻度线
            },
            axisLine:{
            	show:false
				/*lineStyle:{
					color:'#F4F4F3', // y坐标轴的轴线颜色
					width:1, //这里是坐标轴的宽度,为0就是不显示
				}*/
			},
			axisLabel : {
                textStyle: {
                    fontSize:16,
                    color:'#333'
                }
            },
	    },
	    series: [
	        {
	            /*name: '2011年',
	            nameTextStyle:{
	            	color:'#666'
	            },*/
	            type: 'bar',
	            barWidth: '16',
	            
	            data: [100, 200, 300, 400,150,550,360],
	            itemStyle : {
	            	/*emphasis: {
	                    barBorderRadius:3,
	                },*/
					normal : {
						barBorderRadius:[8,8,8,8],
						color: new echarts.graphic.LinearGradient(0, 0, 1, 0, [{
                            offset: 0,
                            color: '#4DD0E1'
                        }, {
                            offset: 1,
                            color: '#007AFF'
                        }]),
						label: {		                       
							show: true,//是否展示
							position: 'right',
							textStyle: {
								fontSize: 16,		                            
								fontFamily : '微软雅黑',	
								color:'#007AFF'
							}		                    
						},
					}
				},
	        }
	    ]
	};

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
})


// 各居委房屋类型堆积图
$(function(){
	// 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main11'));
    // 指定图表的配置项和数据
    var option = {
    	color:['#2196F3','#7986CB','#4DD0E1','#80CBC4','#C5E1A5','#FCE68D','#FFAB91'],
    	grid: {
	    	top:'40',
            left: '20',   //图表距边框的距离
            right: '40',
            bottom: '0',
            containLabel: true
        },
        legend:{
        	selectedMode:false,//取消图例上的点击事件
        	icon:'rect',
	    	left:'15',
            itemHeight:8,//改变圆圈大小
            itemWidth:10,
            itemGap: 25, // 设置间距
            textStyle: { 
            	fontSize:16,
            	padding: [0, 0, 0, 5]
            },
        	data: ['商品房', '售后公房', '公租房', '动迁房', '经适房', '廉租房', '使用权房'],
        },
	    xAxis: {
	        type: 'value',
	        min:'0',
	        interval:50,
	        splitLine: {
                show: false ,
            },
            axisLabel: {
                show: false ,
            },
            axisLine:{
                show: false ,
            },
            axisTick:{
                show:false  //去掉y轴刻度线
            },
	    },
	    yAxis: {
	        type: 'category',
	        data: ['瑶成湾','怒江苑（255）','梅川鑫苑','怒江苑（285）'],
	        axisLabel: {
                textStyle: {
                    color: '#333',//坐标值得具体的颜色
                    fontSize:16
				},
            },
            axisTick:{
                show:false  //去掉y轴刻度线
            },
            axisLine:{
                show: false
            },
	    },
	    series: [
	        {
	            name: '商品房',
	            type: 'bar',
	            barWidth: '16',
	            stack: '总量',
	            itemStyle : {
					normal : {
						barBorderRadius:[8, 0, 0, 8],
						label: {		                       
							show: false,//是否展示
							position: 'insideRight',
							textStyle: {
								fontSize: 16,		                            
								fontFamily : '微软雅黑',	
								color:'#4DD0E1',
							}		                    
						},

					}
				},
	            data: [20, 2, 30, 34]
	        },
	        {
	            name: '售后公房',
	            type: 'bar',
	            barWidth: '16',
	            stack: '总量',
	            itemStyle : {
					normal : {
						label: {		                       
							show: false,//是否展示
							position: 'insideRight',
							textStyle: {
								fontSize: 16,		                            
								fontFamily : '微软雅黑',	
								color:'#4DD0E1',
							}		                    
						},

					}
				},
	            data: [45,85,65,74]
	        },
	        {
	            name: '公租房',
	            type: 'bar',
	            barWidth: '16',
	            stack: '总量',
	            itemStyle : {
					normal : {
						label: {		                       
							show: false,//是否展示
							position: 'insideRight',
							textStyle: {
								fontSize: 16,		                            
								fontFamily : '微软雅黑',	
								color:'#4DD0E1',
							}		                    
						},

					}
				},
	            data: [74,56,80,45]
	        },
	        {
	            name: '动迁房',
	            type: 'bar',
	            barWidth: '16',
	            stack: '总量',
	            itemStyle : {
					normal : {
						label: {		                       
							show: false,//是否展示
							position: 'insideRight',
							textStyle: {
								fontSize: 16,		                            
								fontFamily : '微软雅黑',	
								color:'#4DD0E1',
							}		                    
						},

					}
				},
	            data: [65,74,56,80]
	        },
	        {
	            name: '经适房',
	            type: 'bar',
	            barWidth: '16',
	            stack: '总量',
	            itemStyle : {
					normal : {
						label: {		                       
							show: false,//是否展示
							position: 'insideRight',
							textStyle: {
								fontSize: 16,		                            
								fontFamily : '微软雅黑',	
								color:'#4DD0E1',
							}		                    
						},

					}
				},
	            data: [85,56,80,45]
	        },
	        {
	            name: '廉租房',
	            type: 'bar',
	            barWidth: '16',
	            stack: '总量',
	            itemStyle : {
					normal : {
						label: {		                       
							show: false,//是否展示
							position: 'insideRight',
							textStyle: {
								fontSize: 16,		                            
								fontFamily : '微软雅黑',	
								color:'#4DD0E1',
							}		                    
						},

					}
				},
	            data: [45,85,80,45]
	        },
	        {
	            name: '使用权房',
	            type: 'bar',
	            barWidth: '16',
	            stack: '总量',
	            itemStyle : {
					normal : {
						barBorderRadius:[0, 8, 8, 0],
						label: {		                       
							show: false,//是否展示
							position: 'insideRight',
							textStyle: {
								fontSize: 16,		                            
								fontFamily : '微软雅黑',	
								color:'#4DD0E1',
							}		                    
						},

					}
				},
	            data: [66,99,44,45]
	        },
	    ]
	};
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
})
