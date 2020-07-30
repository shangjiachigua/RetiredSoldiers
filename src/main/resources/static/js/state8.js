// 重点关注标签分布
$(function(){
	// 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main20'));
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
	        data: ['教师','中介','医疗','法律','其他'],
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
	var myChart = echarts.init(document.getElementById('main21'));
	var xCon = ['犯罪前科', '寻衅滋事', '违章搭建', '吸毒人员', '闲散人员', '精神病人', '涉黄人员', '房屋空关','打架','斗殴','其他'];
	var yCon = ['建一', '建二', '梅一', '梅四', '梅六', '怒一', '怒二'];
	var data = [[5,1,7],[2,1,10],[0,2,21],[1,3,55],[0,4,15],[0,5,0],[1,0,3],[1,1,0],[1,2,0],[1,3,0],[1,4,0],[1,5,0],[2,0,22],[2,1,22],[2,2,0],[2,3,0],[2,4,0],[2,5,0],[3,0,62],[3,1,38],[3,2,22],[3,3,5],[3,4,58],[3,5,70],[6,0,73],[4,1,96],[4,2,25],[4,3,25],[4,4,37],[4,5,27],[5,0,10],[5,1,1],[5,2,93],[5,3,10],[5,4,40],[5,5,40],[3,1,17],[0,1,15],[0,7,51],[6,3,5],[0,4,20],[0,8,10],[5,10,7],[1,10,8],[1,9,80],[1,7,20],];
	data = data.map(function (item) {
	    return [item[1], item[0], item[2] || '-'];
	});
	
	var option = {
	    tooltip: {
	        position: 'top'
	    },
	    animation: false,
	    grid: {
	        height: '50%',
	        top: '10%'
	    },
	    tooltip : {
	        show:false,
	    },
	    xAxis: {
	        type: 'category',
	        data: xCon,
	        splitArea: {
	            show: true
	        },
	        axisLabel : {
                textStyle: {
                    fontSize:16,
                    color:'#333'
                }
            },
	    }, 
	    yAxis: {
	        type: 'category',
	        data: yCon,
	        splitArea: {
	            show: true
	        },
	        axisLabel : {
                textStyle: {
                    fontSize:16,
                    color:'#333'
                }
            },
	    },
	    visualMap: {
	        min: 0,
	        max: 100,
	        calculable: true,
	        orient: 'horizontal',
	        left: 'center',
	        bottom: '15%'
	    },
	    series: [{
	        name: '',
	        type: 'heatmap',
	        data: data,
	        label: {
	            show: true
	        },
	        emphasis: {
	            itemStyle: {
	                shadowBlur: 10,
	                shadowColor: 'rgba(0, 0, 0, 0.5)'
	            }
	        },
	        itemStyle : {
				normal : {
					label: {		                       
						show: true,//是否展示
						position: 'inside',
						textStyle: {
							fontSize: 16,		                            
							fontFamily : '微软雅黑',	
							color:'#fff'
						}		                    
					},
				}
			},
	    }]
	};
	// 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
})
