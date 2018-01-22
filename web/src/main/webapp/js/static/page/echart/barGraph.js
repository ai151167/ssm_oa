$(document).ready(function() {
	// 把生成的图表挂载到barEchart的div中
	var myChart = echarts.init(document.getElementById("barEchart"));

	var legendData = [ '男', '女', '保密' ];// 图例
	var colors = [ '#5793f3', '#d14a61', '#675bba' ];// 图例颜色

	var option = {
		color : colors,
		// 移动到柱体时有阴影的效果
		tooltip : {
			trigger : 'axis',
			axisPointer : { // 坐标轴指示器，坐标轴触发有效
				type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
			}
		},
		// 图表离右边框的距离
		grid : {
			right : '20%'
		},
		// 右边的三个小工具
		toolbox : {
			feature : {
				dataView : {
					show : true,
					readOnly : false
				},
				restore : {
					show : true
				},
				saveAsImage : {
					show : true
				}
			}
		},
		// 图表上显示的分类信息
		legend : {
			data : []
		},
		// X轴显示的内容
		// option.xAxis[0].data
		xAxis : [ {
			type : 'category',
			axisTick : {
				alignWithLabel : false
			// 刻度与分类的位置
			},
			data : []
		} ],
		// Y轴显示的三个刻度条
		yAxis : [ {
			type : 'value',
			name : '',
			// min: 0,
			// max: 250,
			position : 'right',
			axisLine : {
				lineStyle : {
					color : colors[0]
				}
			},
			axisLabel : {
				formatter : '{value} 个'
			}
		}, {
			type : 'value',
			name : '',
			/*
			 * min: 0, max: 250,
			 */
			position : 'right',
			offset : 80,
			axisLine : {
				lineStyle : {
					color : colors[1]
				}
			},
			axisLabel : {
				formatter : '{value} 个'
			}
		}, {
			type : 'value',
			name : '',
			/*
			 * min: 0, max: 25,
			 */
			position : 'left',
			axisLine : {
				lineStyle : {
					color : colors[2]
				}
			},
			axisLabel : {
				formatter : '{value} 个'
			}
		} ],
		// 移动柱体时旁边小图框展示的数据
		series : [ {
			name : '',
			type : 'bar',// line
			data : []
		}, {
			name : '',
			type : 'bar',
			yAxisIndex : 1,
			data : []
		}, {
			name : '',
			type : 'bar',
			yAxisIndex : 2,
			data : []
		} ]
	};

	var param = new Object();
	$.getJSON("/user/getUserSexStatistics",param,function(data){
		if(data.isSuccess==true){
			var list = data.list;
			var max = 0;
			
			//保存X轴数据
			var xAxisData = [];
			var seriesBoyData = [];
			var seriesGirlData = [];
			var seriesSecretData = [];
			
			for(var i =0;i<list.length;i++){
				var item = list[i];
				xAxisData[i] =  item['proviceName'];
				seriesBoyData[i] = item['boy'];
				seriesGirlData[i] = item['girl'];
				seriesSecretData[i] = item['secret'];
				
				if(seriesBoyData[i]>max){
					max = seriesBoyData[i];
				}
				if(seriesGirlData[i]>max){
					max = seriesGirlData[i];
				}
				
				if(seriesSecretData[i]>max){
					max = seriesSecretData[i];
				}
			}
			
			//图例赋值 
			option.legend.data = legendData;
			//给X轴赋值 
			option.xAxis[0].data = xAxisData;
			//给Y轴的名称赋值 
			option.yAxis[0].name = legendData[0];
			option.yAxis[1].name = legendData[1];
			option.yAxis[2].name = legendData[2];
			//给Y轴的刻度赋最大值 
			option.yAxis[0].max = max;
			option.yAxis[1].max = max;
			option.yAxis[2].max = max;
			//给小框框赋值 
			option.series[0].name =legendData[0];
			option.series[0].data = seriesBoyData;
			
			option.series[1].name =legendData[1];
			option.series[1].data = seriesGirlData;
			
			option.series[2].name =legendData[2];
			option.series[2].data = seriesSecretData;
			
			myChart.setOption(option);
		}else{
			alert("请求服务器失败!");
		}
	});
	
});