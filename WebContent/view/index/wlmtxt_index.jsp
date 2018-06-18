/*<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>*/
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<!-- --------头部导航（个人信息）- -->
<header id="panda_header" data-nav-current="home">	<div class="pheader"><div class="pheader-inner">
		<!-- ---------图标logo------------ -->
		<div class="ph-logo" data-pdt-block="pheader-l">
			<a href="" data-pdt-ele="1"><img src="https://i.h2.pdim.gs/b2a97149ec43dfc95eb177508af29f6c.png"></a>
		</div>
              <!-- ---------------投稿----------- -->
			<div report-id="playpage_contribution" class="up-load fr">
				<a href="//member.bilibili.com/v/video/submit.html" target="_blank"
					class="u-link">投 稿</a>
				<ul class="up-nav" style="display: none;">
					<li><a href="//member.bilibili.com/v/#/text-apply"
						target="_blank"><i class="bili-icon rect i-art"></i><span>专栏投稿</span></a></li>
					<li><a href="//www.bilibili.com/audio/submit/" target="_blank"><i
							class="bili-icon rect i-ap"></i><span>音频投稿</span></a></li>
					<li><a href="//member.bilibili.com/v/video/submit.html"
						target="_blank"><i class="bili-icon rect i-vp"></i><span>视频投稿</span></a></li>
					<li><a href="//member.bilibili.com/v/#/article"
						target="_blank"><i class="bili-icon rect i-vm"></i><span>投稿管理</span></a></li>
					<li><a href="//member.bilibili.com/v/" target="_blank"><i
							class="bili-icon rect i-vc"></i><span>创作中心</span></a></li>
				</ul>
			</div>
              <!-- ---------------个人头像------------------ -->
			<div class="ph-myinfo" data-pdt-block="pheader-m">
				<div class="ph-myinfo-block pheader--effect-simo">
					<img class="ph-myinfo-block_photo"
						src="https://i.h2.pdim.gs/dmfd/200_200_100/0257040380bd7d294a8017532c07e39b.jpg">
					<span class="ph-myinfo-block_num js-ph-messageNum"></span>
				</div>
				<div class="ph-myinfo-panel">
					<a href="javascript:;"
						class="ph-myinfo-panel_closebtn js-ph-logout">退出</a>

					<div class="ph-myinfo-panel-info">

						<a class="ph-myinfo-panel-info-main" href="/personal"
							data-pdt-ele="0"> <img
							src="https://i.h2.pdim.gs/dmfd/200_200_100/0257040380bd7d294a8017532c07e39b.jpg"
							alt="恺曦宇"
							class="ph-myinfo-panel-info-main-front ph-myinfo-panel-info-main_photo js-ph-nickname-alt">
							<div class="ph-myinfo-panel-info-main-back">
								<img
									src="https://i.h2.pdim.gs/dmfd/200_200_100/0257040380bd7d294a8017532c07e39b.jpg"
									alt="恺曦宇"
									class="ph-myinfo-panel-info-main_photo js-ph-nickname-alt">
								<p>
									升级还需 <strong class="js-ph-exp-needExp">2</strong> 经验
								</p>
							</div>
						</a>

						<div class="ph-myinfo-panel-info_cycle">
							<div></div>
							<div>
								<span class="js-ph-exp-leftDeg" style="transform: rotate(0deg);"></span>
							</div>
							<div>
								<span class="js-ph-exp-rightDeg"
									style="transform: rotate(0deg);"></span>
							</div>
						</div>

					</div>

					<div class="ph-myinfo-panel-name">
						<a href="/personal" target="_blank" class="js-ph-nickname"
							data-pdt-ele="1">恺曦宇</a>
					</div>

					<div class="ph-myinfo-panel-func">
						<i class="icon-level icon-level-1"></i> <a target="_blank"
							href="http://message.panda.tv/message?__plat="
							class="ph-myinfo-panel-func_item" data-pdt-ele="m"> <span
							class="ph-icon ph-icon--email"></span> 消息 <em
							class="ph-myinfo-panel-func_num js-ph-messageNum"></em>
						</a> <a target="_blank" href="/watchhistory"
							class="ph-myinfo-panel-func_item" data-pdt-ele="h"> <span
							class="ph-icon ph-icon--time"></span> 历史
						</a>
					</div>

					<div class="ph-myinfo-panel-menu">
						<a target="_blank"
							href="https://www.panda.tv/personal?pdt=1.18.pheader-m.p.7pio3inl6am"
							class="ph-myinfo-panel-menu_item" data-pdt-ele="p">我的资料</a>
					</div>

					<ul class="ph-myinfo-panel-property">
						<li><strong
							class="ph-myinfo-panel-property_num js-ph-bamboo-num">0</strong>
							<span class="ph-myinfo-panel-property_bicon"></span> <span
							class="ph-myinfo-panel-property_text">竹子</span></li>
						<li><strong
							class="ph-myinfo-panel-property_num js-ph-maobi-num">0</strong> <span
							class="ph-myinfo-panel-property_micon"></span> <span
							class="ph-myinfo-panel-property_text">猫币</span></li>
						<li class="js-ph-payfirst ph-myinfo-panel-property--firstpay">
							<a target="_blank" href="https://pay.panda.tv?__plat="
							class="ph-myinfo-panel-property_paybtn" data-pdt-ele="c">充值</a> <span
							class="ph-myinfo-panel-property_payfirst">首充礼包</span>
						</li>
					</ul>
				</div>
			</div>
			<!-- -------------------------个人信息导航（消息、收藏夹、播放历史、投稿）------------------------------------ -->
			<div class="nav-con fr">
				<ul class="fr">

					<li data-v-4d9bc88b="" class="nav-item"
						report-id="playpage_message"><a data-v-4d9bc88b=""
						href="//message.bilibili.com" target="_blank" title="消息" class="t">
							<!----> <!----> 消息
					</a> <!---->
						<div data-v-4d9bc88b="" class="i-frame" style="display: none;">
							<iframe data-v-4d9bc88b=""
								src="https://message.bilibili.com/pages/nav/index" width="100%"
								height="100%" frameborder="0"></iframe>
						</div></li>
					
					
					<li report-id="playpage_collection" class="nav-item"><a
						href="//space.bilibili.com/333961901/#/favlist" target="_blank"
						class="t">收藏夹</a>
					<div class="favorites-m mini-wnd-nav favorite-wnd dd-bubble"
							style="display: none;">
							<ul class="list history">
								<!---->
								<!---->
								<!---->
								<div>
									<li class="no-data">列表中空空如也，赶紧去添加几个吧~</li>
								</div>
							</ul>
							<div>
								<a href="//space.bilibili.com/333961901/#/favlist"
									target="_blank" class="read-more"> 查看更多<i
									class="b-icon b-icon-arrow-r"></i></a>
							</div>
						</div></li>
					<li report-id="playpage_history" class="nav-item"><a
						href="//www.bilibili.com/account/history" target="_blank"
						class="t">历史</a>
					<div class="history-record-m mini-wnd-nav history-wnd dd-bubble"
							style="display: none;">
							<!---->
							<!---->
							<ul class="list history">
								<!---->
								<!---->
								<div>
									<li class="no-data">没有数据哦，多看点视频吧</li>
								</div>
							</ul>
							<div>
								<a href="//www.bilibili.com/account/history" target="_blank"
									class="read-more"> 查看更多<i class="b-icon b-icon-arrow-r"></i></a>
							</div>
						</div></li>
				</ul>
				<!---->
			</div>

                 <!-- --------------------------搜索框----------------------------------------------- -->
		<div class="ph-search" data-pdt-block="pheader-s">
		  <form name="room-search" action="/search" method="get" target="_top">
		  	<label class="ph-search_label" for="ph-searchInput">搜游戏/主播</label>
		    <input name="kw" id="ph-searchInput" value="" autocomplete="off" class="ph-search_input" type="text">
		    <a href="javascript:void(0)" class="ph-search_submit"></a>
		    <!-- <input type="submit" class="ph-search_submit" value="&#xe617;"> -->
		  </form>
		</div>

	</div></div></header>


<!-- ---------------主体----------------------------------- -->
	<div class="index-wrapper">
	    <!--  轮播start -->
		<div class="index-slider-video-container" pdt-ignore=""
			data-pdt-block="i0"
			style="background: rgb(28, 33, 29) url(&quot;https://i.h2.pdim.gs/5dd9a4f31f3f6736142f045802aaae7a.jpeg&quot;) no-repeat scroll center center;">
			<div class="index-slider-video-content clearfix">
				<object id="swf_play" type="application/x-shockwave-flash"
					data="https://s.h2.pdim.gs/static/89b360f4edb8f1f1.swf"
					style="visibility: visible;" width="1000" height="562">
					<param name="allowFullScreen" value="true">
					<param name="wMode" value="Opaque">
					<param name="allowScriptAccess" value="always">
					<param name="allowFullScreenInteractive" value="true">
					<param name="bgColor" value="#000">
					<param name="flashvars"
						value="resource=https://s.h2.pdim.gs/static/89b360f4edb8f1f1.swf&amp;width=1000&amp;height=562&amp;sign=true&amp;protocol=https&amp;roomType=1&amp;playurl=&amp;videoId=35b8198d05df92b91c93b95dd0241d68&amp;roomUrl=https://www.panda.tv/1557356&amp;plflag_list=%7B%22backup%22%3A%5B%224_7%22%2C%2214_29%22%5D%2C%22current%22%3A%22%22%2C%22default%22%3Atrue%2C%22https%22%3Afalse%2C%22main%22%3A%222_3%22%7D&amp;watermark_switch=&amp;watermark_loc=&amp;flashId=swf_play">
				</object>
				<div class="small-pic-container">
					<div class="slider-video-arrow" style="display: block; top: 369px;">
						<span class="slider-video-arrow-icon"></span>
					</div>
					<a class="small-pic-item-a" href="javascript:;" data-flag="4_8"
						data-flag-list="{&quot;backup&quot;:[&quot;2_4&quot;,&quot;14_29&quot;],&quot;current&quot;:&quot;&quot;,&quot;default&quot;:false,&quot;https&quot;:false,&quot;main&quot;:&quot;4_8&quot;}"
						data-key="4a7049871ff5a05970a379da68cc9cd1" data-stream-url=""
						data-id="60995" data-url="" data-channel=""
						data-watermark-switch="" data-watermark-loc=""> <img
						src="https://i.h2.pdim.gs/d3920bb0464d39d24d3b1e15ac007a24.png"
						class="slider-small-img">
						<div class="small-pic-item" data-toggle="panda-monitor"
							data-paew="shouye-jd-1"></div>
					</a> <a class="small-pic-item-a" href="javascript:;" data-flag="2_3"
						data-flag-list="{&quot;backup&quot;:[&quot;4_7&quot;,&quot;14_29&quot;],&quot;current&quot;:&quot;&quot;,&quot;default&quot;:false,&quot;https&quot;:false,&quot;main&quot;:&quot;2_3&quot;}"
						data-key="fba2a909f6838f8ff253415086195409" data-stream-url=""
						data-id="60997" data-url="" data-channel=""
						data-watermark-switch="" data-watermark-loc=""> <img
						src="https://i.h2.pdim.gs/2b081f9152440d887c917783b5cba72d.jpeg"
						class="slider-small-img">
						<div class="small-pic-item" data-toggle="panda-monitor"
							data-paew="shouye-jd-2"></div>
					</a> <a class="small-pic-item-a" href="javascript:;" data-flag="2_3"
						data-flag-list="{&quot;backup&quot;:[&quot;4_7&quot;,&quot;14_29&quot;],&quot;current&quot;:&quot;&quot;,&quot;default&quot;:true,&quot;https&quot;:false,&quot;main&quot;:&quot;2_3&quot;}"
						data-key=""
						data-stream-url="http://flv-live-qn.xingxiu.panda.tv/panda-xingxiu/d4c16b909a011422af56ddb4c699930a.flv"
						data-id="227594" data-url="" data-channel=""
						data-watermark-switch="" data-watermark-loc=""> <img
						src="https://image.xingyan.panda.tv/d46e9ef96900d30b6d6b5f89aff75378_w258_h100.jpeg"
						class="slider-small-img">
						<div class="small-pic-item" data-toggle="panda-monitor"
							data-paew="shouye-jd-3"></div>
					</a> <a class="small-pic-item-a" href="javascript:;" data-flag="2_3"
						data-flag-list="{&quot;backup&quot;:[&quot;4_7&quot;,&quot;14_29&quot;],&quot;current&quot;:&quot;&quot;,&quot;default&quot;:true,&quot;https&quot;:false,&quot;main&quot;:&quot;2_3&quot;}"
						data-key="24709cfe5086209bbb1e591911001633" data-stream-url=""
						data-id="1571712" data-url="" data-channel=""
						data-watermark-switch="" data-watermark-loc=""> <img
						src="https://i.h2.pdim.gs/dc91a6f478c379c3e4caaf8767e126c4.jpeg"
						class="slider-small-img">
						<div class="small-pic-item" data-toggle="panda-monitor"
							data-paew="shouye-jd-4"></div>
					</a> <a class="small-pic-item-a" href="javascript:;" data-flag="14_28"
						data-flag-list="{&quot;backup&quot;:[&quot;2_4&quot;],&quot;current&quot;:&quot;&quot;,&quot;default&quot;:false,&quot;https&quot;:false,&quot;main&quot;:&quot;14_28&quot;}"
						data-key="e86fd6c1527962ce255cf1f204b19371" data-stream-url=""
						data-id="491128" data-url="" data-channel=""
						data-watermark-switch="" data-watermark-loc=""> <img
						src="https://i.h2.pdim.gs/84f114676e17777afdcb492d87699390.jpeg"
						class="slider-small-img">
						<div class="small-pic-item" data-toggle="panda-monitor"
							data-paew="shouye-jd-5"></div>
					</a> <a class="small-pic-item-a small-pic-current-item"
						href="javascript:;" data-flag="2_3"
						data-flag-list="{&quot;backup&quot;:[&quot;4_7&quot;,&quot;14_29&quot;],&quot;current&quot;:&quot;&quot;,&quot;default&quot;:true,&quot;https&quot;:false,&quot;main&quot;:&quot;2_3&quot;}"
						data-key="35b8198d05df92b91c93b95dd0241d68" data-stream-url=""
						data-id="1557356" data-url="" data-channel=""
						data-watermark-switch="" data-watermark-loc=""> <img
						src="https://i.h2.pdim.gs/ddcdd7a3aecce555f33e5813a42259a3.jpeg"
						class="slider-small-img">
						<div class="small-pic-item" data-toggle="panda-monitor"
							data-paew="shouye-jd-6"></div>
					</a>
				</div>
			</div>
			<script src="https://s.h2.pdim.gs/static/b9bfca82e08dcf1b.js"></script>
			<script src="//hm.baidu.com/hm.js?204071a8b1d0b2a04c782c44b88eb996"></script>
			<script id="index-slider-bg" type="text/data">[{"title":"\u80cc\u666f\u56fe\u4e09\u56fe\u5408\u4e00","url":"http:\/\/aplay.wan.panda.tv\/api\/played\/random?pkey=panda&id=8","bg0":"http:\/\/i6.pdim.gs\/f1c8f1d9deb1efd76f48a3dc73bb6883.jpeg","color":"","bg1":"http:\/\/i9.pdim.gs\/94dcca9ef9ea1e08438fd01a30655c0c.jpeg","bg2":"http:\/\/i6.pdim.gs\/5dd9a4f31f3f6736142f045802aaae7a.jpeg"}]</script>
			<a data-pdt-ele="0" target="_blank"
				href="http://aplay.wan.panda.tv/api/played/random?pkey=panda&amp;id=8"
				class="index-slider-outlink" data-toggle="panda-monitor"
				data-paew="shouye-bj-1"></a>
		</div>
        <!-- 轮播end -->

		
       <!-- -------------------------类别开始------ -->
         <div>
         
         </div>
       <!---------------------类别结束----------------- -->
		<!-- 频道版块 start -->
		<div class="index-channel">
				<div
				class="index-channel-list index-channel-pubg  index-channel-even  index-channel-pubg ">
				<div class="bw" data-pdt-block="i13">
					<div class="index-channel-cnt clearfix">
						<div class="index-channel-title">
							<div class="index-channel-name">
								<a href="/cate/pubg" target="_blank" data-pdt-ele="0"><span
									class="avt"> <i class="avt-bg"
										style="background-image: url(https://i.h2.pdim.gs/b1581a9f072c97b66ccb302ebb1ccfc6.png); background-image: none\9; filter: progid:DXImageTransform.Microsoft.AlphaImageLoader(src=https://i.h2.pdim.gs/b1581a9f072c97b66ccb302ebb1ccfc6.png, sizingMethod='scale')"></i>
								</span> <span class="tips tips-color-green"><i class="num">1053</i><i
										class="txt">个直播</i></span><span class="name">绝地求生</span> </a>
							</div>
							<ul class="labers clearfix">
								<li><a href="https://www.panda.tv/26668" target="_blank"
									data-pdt-ele="1">图拉夫</a></li>
							     
							</ul>
							<div class="more">
								<a href="/cate/pubg" target="_blank" data-pdt-ele="more">更多</a>
							</div>
							<div class="index-channel-generalize">
								<a data-pdt-ele="11" href="https://wan.panda.tv/tzyx_index.html"
									class="index-channel-generalize-banner" target="_blank"><img
									class="thumb-img"
									src="https://i.h2.pdim.gs/8281e64723fbb52b29f2af42d0daeb40.jpeg"
									data-toggle="panda-monitor" data-paew="shouye-fltj_pubg_pic-1"></a>
							</div>
						</div>
						<ul class="figrues-list figrues-list-line2 clearfix">
							<li class="list-item"><a data-pdt-ele="21" href="/26668"
								target="_blank">
									<div class="pd-thumb">
										<div class="pictures">
											<img class="thumb-img thumb-img-lazy"
												data-original="https://i.h2.pdim.gs/90/e824ee6096ac2924686743c4c1ff05b5/w338/h190.jpg"
												src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsQAAA7EAZUrDhsAAAANSURBVBhXYzh8+PB/AAffA0nNPuCLAAAAAElFTkSuQmCC">
										</div>
										<div class="thumb-layer"></div>
										<div class="play-btn"></div>
									</div>
									<div class="thumb-info">
										<div class="thumb-list">
											<div class="title">【图拉夫】礼炮抽2668 !</div>
											<div class="thumb-list-info">
												<span class="nickname">ToveLo</span> <span
													class="thumb-number">533478</span>
											</div>
										</div>
										<div class="thumb-bar"></div>
									</div>
							</a></li>
							
						</ul>
					</div>
				</div>
			</div>
			
		<!-- 频道版块 end -->
		</div>
	</div>

	<footer id="panda_footer">
	<div class="footer-text">
		<p>
			<a href="http://www.miitbeian.gov.cn/" target="_blank">沪ICP备15043293号</a>
			| <a
				href="http://www.panda.tv/news/1101414857/3700943925/3701130188.html"
				target="_blank">沪网文[2015]0826-226号</a> | <a target="_blank"
				href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=31010802001046"><img
				src="https://i.h2.pdim.gs/d0289dc0a46fc5b15b3363ffa78cf6c7.png">沪公网安备
				31010802001046号</a>
		</p>
		<p>上海熊猫互娱文化有限公司 | 地址：上海闸北区灵石路695号3号楼1804室 | 举报电话&amp;客服热线：10108666</p>
		<p>
			<span class="room-report">儿童色情信息&amp;不良房间举报</span> | <a
				href="http://report.12377.cn:13225/toreportinputNormal_anis.do"
				target="_blank">网上有害信息举报专区</a> | <a href="http://jb.ccm.gov.cn/"
				target="_blank">12318全国文化市场举报网站</a> | <a
				href="http://www.shjbzx.cn/" target="_blank">上海市互联网违法和不良信息举报</a>
		</p>
	</div>
	</footer>
</body>
</html>