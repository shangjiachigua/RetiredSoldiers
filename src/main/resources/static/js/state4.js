// 机动车
$(function(){
	// 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main13'));
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
