
// 房屋类型
$(function(){
	// 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main12'));
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
	        data: ['怒二','梅一','东旺','花苑','嘉广','建德','建二','金沙雅苑'],
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
	            data: [20, 2, 30, 34,55,33,56,77]
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
	            data: [45,85,65,74,32,23,66,15]
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
	            data: [74,56,80,45,89,45,34,23]
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
	            data: [65,74,56,80,34,45,45,67]
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
	            data: [85,56,80,45,56,23,23,45,]
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
	            data: [45,85,80,45,23,12,34,56]
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
	            data: [66,99,44,45,34,24,67,86]
	        },
	    ]
	};
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
})
