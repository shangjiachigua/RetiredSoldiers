$(function(){
	$('.select-ul').hide();
	$('.select-down').click(function(){
		//折叠元素显示隐藏
		$(this).parent().next('ul.select-ul').slideToggle();
		//切换箭头图片
		var that = this;
		var src = $(this).find('img');
		if(src.attr('src')=='img/down_arrow.png'){
			src.attr('src','img/top_arrow.png');
		}else{
			src.attr('src','img/down_arrow.png');
		}
	})
})