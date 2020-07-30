// 户籍情况
$(function(){
	// 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main16'));
	
    // 指定图表的配置项和数据
    var option = {
	    color:['#0176FE', '#E77E6F'],
	    legend:{
	    	selectedMode:false,//取消图例上的点击事件
	    	left:20,
            itemHeight:8,//改变圆圈大小
            itemWidth:10,
            itemGap:10,
	        data:['户籍人口','非户籍人口'],
	        textStyle: { //图例文字的样式
            	fontSize:16,
            	padding:[0,20,0,5]
            },
	    },
	    series: [
	        {
	            name:'数据',
	            type:'pie',
	            radius: ['33%', '58%'],
	            center: ['center', '50%'],
	            avoidLabelOverlap: false,
	            hoverAnimation:false,   //  防止点击变大事件   
	            itemStyle: {
		            normal:{
			            label:{
			            	formatter: "{d}%   {c} ",
				            textStyle:{
								fontSize:18,
								fontWeight : 'normal',
							}
				        },
			            labelLine: { 
					//指示线状态 
							show: true, 
							smooth: 0.2, 
						},
						
		            },
                	
	            },
	            data:[
	                {value:335, name:'户籍人口'},
	                {value:310, name:'非户籍人口'},
	            ],
	            
	        }
	    ]
	};
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
})



// 各居委性别分布
$(function(){
	// 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main17'));
    // 指定图表的配置项和数据
    var option = {
    	color:['#0176FE', '#E77E6F'],
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
        	data: ['户籍人口', '非户籍人口'],
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
	            name: '户籍人口',
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
	            name: '非户籍人口',
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
