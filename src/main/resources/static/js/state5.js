// 性别分布
$(function(){
	// 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main14'));
	
    // 指定图表的配置项和数据
    var option = {
	    color:['#0176FE', '#E77E6F','#59C088'],
	    legend:{
	    	selectedMode:false,//取消图例上的点击事件
	    	left:20,
            itemHeight:8,//改变圆圈大小
            itemWidth:10,
            itemGap:10,
	        data:['男性','女性','其他'],
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
	                {value:335, name:'男性'},
	                {value:310, name:'女性'},
	                {value:234, name:'其他'},
	            ],
	            
	        }
	    ]
	};
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
})


// 各小区性别分布
$(function(){
	// 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main15'));
    // 指定图表的配置项和数据
    var option = {
    	color:['#0176FE','#FE8A7A','#59C088'],
	    grid: {
	    	top:'50',
            left: '20',   //图表距边框的距离
            right: '10',
            bottom: '20',
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
        	data:['男性','女性','待定']
        },
	    xAxis: {
	        type: 'category',
	        /*boundaryGap: false,*/
	        
            axisLabel: {
                textStyle: {
                    color: '#333',//坐标值得具体的颜色
                    fontSize:16
				},
                /*//文字倾斜
                interval:0,
                rotate:-40*/
            },
            axisTick:{
                show:false  //去掉y轴刻度线
            },
            
            //坐标轴颜色
            axisLine:{
                lineStyle:{
                    color:'#F1F0F6',
                    width:'1'
                }
            },
	        data: ['瑶成湾', '怒江苑（255）', '梅川鑫苑', '怒江苑（658）']
	    },
	    yAxis: [
		    {
		    	type: 'value',
		    	min:0,
                //max:600,
                interval:200,
		        splitLine: {
	                show: true ,
		            lineStyle: {
	                    color:'#F1F0F6',
                    	width:'1'
	                }
	            },
	            axisLabel: {
	            	textStyle: {
	                    color: '#333',//坐标值得具体的颜色
	                    fontSize:16
					},
		            
	            },
	            
	            axisTick:{
	                show:false  //去掉y轴刻度线
	            },
		        //坐标轴颜色
	            axisLine:{
	                show:true,
	                lineStyle:{
	                    color:'#F1F0F6',
                    	width:'1'
	                }
	            },
		    },
		    {
		    	type: 'value',
		    	min:0,
                //max:600,
                interval:200,
		        splitLine: {
	                show: true ,
		            lineStyle: {
	                    color:'#F1F0F6',
                    	width:'1'
	                }
	            },
	            axisLabel: {
	            	show: false
	            },
	            
	            axisTick:{
	                show:false  //去掉y轴刻度线
	            },
		        //坐标轴颜色
	            axisLine:{
	                show:true,
	                lineStyle:{
	                    color:'#F1F0F6',
                    	width:'1'
	                }
	            },
		    }
	    ],
	    series: [
		    {
		        name:'男性',
	            type:'line',
	            symbol: 'circle',
	            symbolSize:8, 
	            smooth: true,
	            itemStyle : {
					normal : {
						label: {		                       
							show: true,//是否展示
							position: 'top',
							textStyle: {
								fontSize : 16,		                            
								fontFamily : '微软雅黑',
								color:'#0176FE',
							}		                    
						},
						borderColor: '#fff', //折点边框颜色
            			borderWidth: 2,      //折点边框
						color:'#0176FE',     //折点颜色
					}
				},
				lineStyle:{
	            	normal:{
	            		color:'#0176FE',
	            		width:'1',
	            	}
	            },
		        data: [110, 490, 320, 210]
		    },
		    {
		        name:'女性',
	            type:'line',
	            symbol: 'circle',
	            symbolSize:8, 
	            smooth: true,
	            itemStyle : {
					normal : {
						label: {		                       
							show: true,//是否展示
							position: 'top',
							textStyle: {
								fontSize : 16,		                            
								fontFamily : '微软雅黑',
								color:'#E77E6F',
							}		                    
						},
						borderColor: '#fff', //折点边框颜色
            			borderWidth: 1,      //折点边框
						color:'#E77E6F',     //折点颜色
					}
				},
				lineStyle:{
	            	normal:{
	            		color:'#E77E6F',
	            		width:'1',
	            	}
	            },
		        data: [250, 190, 480, 330]
		    },
		    {
		        name:'待定',
	            type:'line',
	            symbol: 'circle',
	            symbolSize:8, 
	            smooth: true,
	            itemStyle : {
					normal : {
						label: {		                       
							show: true,//是否展示
							position: 'top',
							textStyle: {
								fontSize : 16,		                            
								fontFamily : '微软雅黑',
								color:'#59C088',
							}		                    
						},
						borderColor: '#fff', //折点边框颜色
            			borderWidth: 1,      //折点边框
						color:'#59C088',     //折点颜色
					}
				},
				lineStyle:{
	            	normal:{
	            		color:'#59C088',
	            		width:'1',
	            	}
	            },
		        data: [550, 360, 680, 130]
		    },
		]
	};
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
})