// 房屋类型
$(function(){
	// 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main18'));
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
    var myChart = echarts.init(document.getElementById('main19'));
    var link1 = 'https://echarts.apache.org/zh/option.html#series-treemap.data.target';
    var link2 = 'https://https://www.baidu.com';
	var option = {
		color: ['#2196F3', '#7986CB', '#4DD0E1', '#80CBC4', '#C5E1A5', '#FCE68D', '#FFAB91'],
	    series: [{
	        type: 'treemap',
	        roma: false,
	        nodeClick: 'link',
	        breadcrumb: false,
	        silent:false,
	       	levels: [  //https://blog.csdn.net/dtq007/article/details/87879790
            
                {   //钻入矩形树图的顶层
                   // colorSaturation: [0.1, 0.5],    //设置颜色饱和度
                    color: ['#2196F3', '#7986CB', '#4DD0E1', '#80CBC4', '#C5E1A5', '#FCE68D', '#FFAB91'], //颜色列表，对于定义每个分块颜色不太理想
                    //colorMappingBy: 'value',    //颜色根据value设置
                    /*itemStyle: {
                        normal: {
                            borderWidth: 2,    //方块外边框粗细
                            borderColor: '#333',    //边框颜色
                            gapWidth: 1  //方块内部边框粗细
                        }
                    }*/
                },
                {   //钻入矩形树图的第二层
                    //color: ['#269f3c', '#ca6872','#942e38'],
                    //colorMappingBy: 'value',
                    itemStyle: {
                        normal: {
                            gapWidth: 0
                        }
                    }
                },
                {   //钻入矩形树图的第三层
                    //color: ['#269f3c', '#ca6872','#942e38'],
                   // colorMappingBy: 'value',
                    itemStyle: {
                        normal: {
                            borderWidth: 0.2,
                          
                        }
                    }
                },
                {   //钻入矩形树图的第四层，没有的话就不用写了
                    //color: ['#269f3c', '#ca6872','#942e38'],
                   // colorMappingBy: 'value',
                    itemStyle: {
                        normal: {
                            borderWidth: 0.2,
                          
                        }
                    }
                }
            ],
	        data: [{
	            name: '怒二',
	            children: [{
	            	name: '分数除法', value: 5,
	            }, {
	            	name: '分数加法', value: 10,
	            }, {
	            	name: '分数减法', value: 22
	            }]
	        },
	        {
	          	name: '梅一',
	          	children: [{
	            	name: '个位数除法', value: 15
	          	}, 
	          	{
	            	name: '两位数除法', value: 50
	          	}, 
	          	{
	            	name: '分数除法', value: 45
	          	}]
	        },
	        {
	          	name: '东旺',
	          	children: [{
	            	name: '个位数加法', value: 37,
	          	}, 
	          	{
	            	name: '小数数除法',
	            	children: [{
	              		name: '有理数加法', value: 55,
	            	}, 
	            	{
	              		name: '优先级加法', value: 18,
	            	}]
	           }]
	        },
	        {
	          	name: '花苑',
	          	children: [{
	            	name: '个位数小数减法', value: 31,
	          	}, 
	          	{
	            	name: '两位数小数减法', value: 61,
	          	}, 
	          	{
	            	name: '分数减法', value: 25
	       		}]
	        },
	        {
	          	name: '嘉广',
	          	children: [{
	            	name: '个位数小数减法', value: 31,
	          	}, 
	          	{
	            	name: '两位数小数减法', value: 61,
	          	}, 
	          	{
	            	name: '分数减法', value: 25
	       		}]
	        },
	        {
	          	name: '建德',
	          	children: [{
	            	name: '个位数小数减法', value: 31,
	          	}, 
	          	{
	            	name: '两位数小数减法', value: 61,
	          	}, 
	          	{
	            	name: '分数减法', value: 25
	       		}]
	        },
	        {
	          	name: '建二',
	          	children: [{
	            	name: '个位数小数减法', value: 31,
	          	}, 
	          	{
	            	name: '两位数小数减法', value: 61,
	          	}, 
	          	{
	            	name: '分数减法', value: 25
	       		}]
	        }]
	    }]
	};
	// 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
})
