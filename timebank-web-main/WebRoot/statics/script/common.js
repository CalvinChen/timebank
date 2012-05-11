// ##########################公共方法#################
/**
 * 
 */
var CommonUtil={
	contains:function(sourceArray,ele){
		if(!sourceArray) {
			sourceArray=[];
		}
		for(var i=0;i<sourceArray.length;++i){
			if(sourceArray[i]===ele){
				return true;
			}
		}
		return false;
	},
	togglePanel:function (id) {
		if ($("#" + id).css("display") == "none") {
			$("#" + id).show();
		} else {
			$("#" + id).hide();
		}
	},
	parseFunc:function (jqEle,attr){
		var func=null;
		var funcStr=$(jqEle).attr(attr);
		if(funcStr==""){
			return null;
		}
		func=eval(funcStr);
		if (typeof(func) != "function") {
			func=null;
		}
		return func;				
	},
	showLoading:function(context){
		if(!context){
			context=document.body;
		}
		var left=$(context).width()/2-40;
		var top=$(context).height()/2;
		$(context).append("<div class='ajaxLoading' style='position:absolute; min-width:80px; text-align:center; top:"+top+"px;left:"+left+"px; color:white; line-height:26px;z-index:19999;background-color:#57A957; border:1ps solid #3D773D; display:none;'>处理中...</div>");
		$(".ajaxLoading").show();	
	},
	hiddenLoading:function(){
		$(".ajaxLoading").hide();
		$(".ajaxLoading").remove();
	},
	showError:function(error){
		var options = {
			sizes : { 
				minW : 500, 
				minH : 300
			}
		}
		
		if($.nmTop()){
			$.nmTop().elts.hidden.append("<div>"+error+"</div>");
			window.setTimeout(function(){
				return $.nmTop()._load();
			},500);
			return;
		}
		$.nmData("<div>"+error+"</div>", options);
	}
};

var AjaxRequest={
	send:function(url,option){
		if(!url || url.length<1){
			return;
		}		
		var exOption=this.extendOption(option);
		exOption.url=url;
		$.ajax(exOption);
	},
	
	extendOption:function(option){
		var exOption=$.fn.extend(true,{
			dataType:"json",
			error:AjaxRequest._error,
			beforeSend:AjaxRequest._beforeSend,
			complete:AjaxRequest._complete
		},option);
		return exOption;
	},
	
	_beforeSend:function(xhr){
		CommonUtil.showLoading();		
	},
	_error:function(xhr,textStatus, errorThrown){
		var options = {
			sizes : {
				minW : 500, 
				minH : 300
			}
		}	
		if($.nmTop()){
			$.nmTop().elts.hidden.append("<div>"+xhr.responseText+"</div>");
			window.setTimeout(function(){
				return $.nmTop()._load();
			},500);
			return;
		}
		$.nmData("<div>"+xhr.responseText+"</div>", options);
	},
	_complete:function(xhr,textStatus){
		CommonUtil.hiddenLoading();
	}
}

var Pager={
	ajaxPaging:function (container,isReplaceContainer) {// ajax分页
		$(container).find(".pager").find("a").each(function() {
			$(this).bind("click", function(event) {
						if(true===isReplaceContainer){
							CommonLoader.reloadView(container, $(this).attr("href"),null);
						}else{
							CommonLoader.loadData(container, $(this).attr("href"), null, null);
						}
						return false;
					});
		});
	}
};

var NMDialog={
	initDialogLink:function(context){
		if(!context){
			context=document;
		}
		$("a.dialoglink",context).each(function(i,domEle){
			var _self=$(this);
			var options={
				callbacks: {
					afterClose:function(nm){
						var returnVal=NMDialog._getReturnData();
						NMDialog._removeReturnData();
						var callBack=CommonUtil.parseFunc(_self,"data-callback");
						if(callBack!=null){
							callBack(returnVal);						
						}					
					}
				}};			
			$(this).nyroModal(NMDialog.extendOption(options));
		});
		$("button.closeDialog", context).click(function(){
			NMDialog.closeDialog();
		});
	},	
	
	openDialog:function(url,callBack,options){		
		var op=NMDialog.extendOption(options);
		
		var oldAfterClose=null;
		if(op.callbacks && op.callbacks.afterClose){
			oldAfterClose=op.callbacks.afterClose;
		}
		op.callbacks.afterClose=function(nm){
			var returnVal=NMDialog._getReturnData();
			NMDialog._removeReturnData();
			if(callBack){
				callBack(returnVal);
			}
			if(oldAfterClose){
				oldAfterClose(nm);
			}
		}
		$.nmManual(url,op);
	},	
	
	closeDialog:function () {// /关闭dialog
		if($.nmTop()){
			$.nmTop().close();
		}
	},
	
	closeDialogWithReturn:function (returnValue) {// /关闭dialog
		NMDialog._setReturnData(returnValue)
		NMDialog.closeDialog();
	},
	
	extendOption:function(exOptions){
		var options=$.extend(true,{
			stack:true,
			modal:false,
			callbacks:{
				filledContent:null,
				afterClose:null
			}
		},exOptions);
		
		var oldFilledContent=null;
		if(options.callbacks && options.callbacks.filledContent){
			oldFilledContent=options.callbacks.filledContent;
		}
		options.callbacks.filledContent=function(nm){
			NMDialog._removeReturnData();
//			setTimeout(function(){				
//				nm.elts.cont.draggable({cancel:"input,textarea,select,object,a,img"});
//			},500);
			
			if(oldFilledContent){
				oldFilledContent(nm);
			}
		}	
		return options;
	},
	
	_removeReturnData:function(){
		$("body").removeData("returnValue");
	},
	_getReturnData:function(){
		return $("body").data("returnValue");
	},
	_setReturnData:function(val){
		$("body").data("returnValue",val);
	}
};

var Form={
	init:function(context){
		Form.initValidator(context);
		Form.wrapAjaxForm(context);
		Form.setReadonlyFieldStyle(context);
	},
	initValidator:function(context){
		if(!context){
			context=document;
		}
		$("form",context).each(function(){
			$(this).validation();
		});
	},
	setReadonlyFieldStyle:function(context){
		$(":input[readonly]").each(function(){
			$(this).addClass("input_readonly");
			$(this).focus(function(){
				$(this).blur();
			});
		});
	},
	resetForm:function(form){
		$(form).resetForm();
	},
	storePreVal:function(formFiled){
		$(formFiled).data("preVal",$(formFiled).val());
	},
	getPreVal:function(formFiled){
		return $(formFiled).data("preVal");
	},
	validateForm:function(jqForm){
		var pass=true;
		var valInfo = $.validation.validate(jqForm) ;
		if( valInfo.isError ) {
			pass=false;
		}
		return pass;
	},
	
	wrapAjaxForm:function(context,options) {
		if(!context){
			context=document;
		}
		$("form.ajaxpost",context).each(function(){
			$(this).ajaxForm(Form.extendOption(options,$(this)));
		});
	},

	multiAjaxSubmit:function(jqForms,options){
		var length=$(jqForms).length;
		if(length<1){
			return;
		}
		
		if(options.before){
			options.before();
		}
		
		$(jqForms).each(function(i,domEle){
			var extendOp=Form.extendOption({
				isInMutiSubmit:true,
				complete:function(event,xhr){
					length=length-1;
					if(length===0){
						if(options.complete){
							options.complete();
						}
					}
				}	
			},$(this));			
			$(this).ajaxSubmit(extendOp);
		});
	},
	
	extendOption:function(exOptions,jForm){
		var successHandlers=new Array();
		var beforeSubmitHandlers=new Array();
		var completeHandlers=new Array();

		var options=$.fn.extend(true,{
			dataType:"json",
			ignorefile:true,
			isInMutiSubmit:false,
			businessException:Form._businessException
		},exOptions);
			
		beforeSubmitHandlers.push(Form._beforeSubmit);
		if(jForm && jForm.attr("onsubmit")){			
			beforeSubmitHandlers.push(new Function(jForm.attr("onsubmit")));
			$(jForm).removeAttr("onsubmit");
		}
		if(options.beforeSubmit){
			beforeSubmitHandlers.push(options.beforeSubmit);
		}
				
		completeHandlers.push(Form._complete);
		if(options.complete){
			completeHandlers.push(options.complete);
		}
		
		if(!options.isInMutiSubmit){
			beforeSubmitHandlers.push(function(){CommonUtil.showLoading(jForm)});
			completeHandlers.push(function(){CommonUtil.hiddenLoading()});
		}		
		
		successHandlers.push(Form._success);
		if(options.success){
			successHandlers.push(options.success);
		}
		
		if(!options.error){
			options.error=Form._error;
		}	
		
		options.complete=function(event,xhr){
			$.each(completeHandlers,function(i){
				completeHandlers[i](event,xhr);
			});
		}
		
		options.beforeSubmit=function(arr, jqForm, options){
			var isOk=true;
			$.each(beforeSubmitHandlers,function(i){
				if(isOk===false) return false;
				isOk=beforeSubmitHandlers[i](arr, jqForm, options);
			});
			if(isOk===false){
				options.complete(null,null);
			}
			return isOk;
		}
		
		options.success=function(responseData, statusText, xhr,jqForm){
			if(responseData.returnCode && responseData.returnCode!=200){
				//500错误
				options.error(xhr,responseData.returnCode,responseData);
				return;
			}
			if(false===responseData.isValid){
				//逻辑业务验证
				options.businessException(responseData,jqForm);				
			}else{
				//成功
				$.each(successHandlers,function(i){
					successHandlers[i](responseData, statusText, xhr,jqForm);
				});
			}
		}
	
		return options;
	},	
	
	_success:function(responseData, statusText, xhr,jqForm) {				
		var onFormCallback = CommonUtil.parseFunc($(jqForm),"data-callback");
		if (onFormCallback != null){
			onFormCallback(responseData, statusText, xhr,jqForm);
		}
	},
	
	_beforeSubmit:function(arr, jqForm, options){
		$(jqForm).find("input:submit").attr("disabled",	"disabled");		
		if (!Form.validateForm(jqForm)) {					
			return false;
		}
		$(".validation-error-input",jqForm).removeClass("validation-error-input");
		$(".validation-error-info",jqForm).remove();
	},
	
	_error:function(xhr, textStatus, errorThrown){
		CommonUtil.showError(xhr.responseText);
	},
	
	_complete:function(event,xhr){
		$("input:submit").removeAttr("disabled");		
	},
	
	_businessException:function(responseData,jqForm){
		if(!responseData.errors){
			return;
		}
		var noFieldErrMsg="";
		$.each(responseData.errors,function(key,value){
			var formField= $(jqForm).find(":input[name="+key+"]");
			if(formField.length>0){
				formField.addClass("validation-error-input");
				formField.after("<span class='validation-error-info'>"+key+"</span>");			
			}else{
				noFieldErrMsg+="<li>"+key+"</li>";
			}
		});
	}

};

var CommonLoader={
	reloadList:function(listContainer,selectedItem){//列表重新加载方法，listContainer:容器id，selectedItem可选的触发列表行
		url = $(listContainer).attr("url");
		if(!url){
			return;
		}
		CommonLoader.loadData(listContainer, url, null, function() {
					if (selectedItem != "" || selectedItem != null) {
						$(selectedItem+" .detail").trigger('click');
					}
		});
	},
	loadForm:function (container, formObj) {// /提交指定id表单
		CommonLoader.loadData(container, $(formObj).attr("action"), $(formObj).serialize(),function(){});
		return false;
	},
	reloadView:function(viewContainer,url,callback){
		if(!url){
			url = $(viewContainer).attr("url");
		}
		if(!url){
			return;
		}
		AjaxRequest.send(url,{
			dataType:"html",
			success:function(resp){
				$(viewContainer).replaceWith($(resp));
				if(callback){
					callback();
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				$(viewContainer)
						.html("<div style='z-index:99999;' class=\"ajaxError\">加载出错，请" +
								"<a href=\"javascript:CommonLoader.reloadView('#"+ viewContainer.attr("id")+"','"+url+"');\">点击重试</a>。<div>");
			}
		});
	},	
	loadModelList:function(container) {
		url = $(container).attr("url");
		CommonLoader.loadData(container, url, null, function() {});
	},
	loadData:function (container, url, data, callback) {// 加载html页面到指定id的区域
		$(container).append("<div class='ajaxLoading' style='position:absolute; min-width:80px; text-align:center; top:0;left:0; color:white; line-height:26px;z-index:19999;background-color:#57A957; border:1ps solid #3D773D; display:none;'>加载中...</div>");
		$(".ajaxLoading").show();
		$.ajax({
			url : url,
			cache : false,
			beforeSend : function(jqXHR, settings) {
				// alert("ddd");
			},
			success : function(html) {
				$(container).html(html);
				if (callback != null) {
					callback();
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				$(container)
						.html("<div style='z-index:99999;' class=\"ajaxError\">加载出错，请<a href=\"javascript:CommonLoader.loadData('"
								+ container + "','" + url + "');\">点击重试</a>。<div>");
			},
			data : data
		});
	},	
	modelListRowAction:function(url) {
		var target = $("tr.model-list-row").find("a").each(function() {
			$(this).unbind('click');
			$(this).bind("click", function(e) {
				e.stopImmediatePropagation();
				e.stopPropagation();
				e.preventDefault();
				var url = $(this).attr("href");
	
				$("#main-loading").show();
				$("tr.model-list-row").removeClass("current_1");
				var id = $(this).attr("id");
				$(this).parent().parent().addClass("current_1");
				CommonLoader.loadData("#main-content", url, null, function() {
					$("#main-loading").css("display", "none");
					$("#main-mask").hide();
				});
	
				return false;
			});
			$(this).css("cursor", "pointer");
			$(this).hover(function() {
				$(this).css("background", "#fff");
			}, function() {
				$(this).css("background", "");
			});
		});
	}
}

var Table={
			/*表格删除行后，下面的行name索引全部减去1；
			 * jqObject:jquery对象，当前待删除的对象
			 * indexName：name对应索引的名字，如果name为aa[].bb[].id，bb和aa就是indexName，aa的n=1，bb的n=2
			 * containerType：需要更新的容器类型
			 * n：indexName所在的索引位置
			 */
			changeNameIndex:function(jqObject,indexName,containerType,n){
				if(!n){
					n=1;
				}
				var tables=jqObject.nextAll(containerType);
				$.each(tables,function(index,value){
					$.each($(value).find(":input[name*="+indexName+"]"),function(i,v){
						var name=$(v).attr("name");
						var index=Table.getIndex(name,indexName);
						index=index-1;
						var begin=name.indexOf(indexName)+indexName.length+1;
						var end=Table.getTheNIndex(name,n);
						$(v).attr("name",name.substr(0,begin)+index+name.substr(end));
					});
				})
			},
			changeOneNameIndex:function(jqObject,indexName,n){
				if(!n){
					n=1;
				}
				$.each($(jqObject).find(":input[name*="+indexName+"]"),function(i,v){
					var name=$(v).attr("name");
					var index=Table.getIndex(name,indexName);
					index=index-1;
					var begin=name.indexOf(indexName)+indexName.length+1;
					var end=Table.getTheNIndex(name,n);
					$(v).attr("name",name.substr(0,begin)+index+name.substr(end));
				});
				
			},
			getIndex:function(value,indexName){
				var name=value;
				var pattern=new RegExp(indexName+"\\[(\\d*)\\]");
				var matcher=name.match(pattern);
				if(matcher.length==2){
					var index=matcher[1];
					return index;
				}else{
					return -1;
				}
			},
			getTheNIndex:function(value,n){
				if(n<1){
					return -1;
				}
				var index=value.indexOf("]");
				for(var i=1;i<=n-1;++i){
					var v=value.substr(index+1);
					var idx=v.indexOf("]");
					index=index+idx+1;
				}
				return index;
			}
};

var ValidationEx={
	
			/*
			 * 检查当前输入框与当前容器中同一类型的其它数据项是否重复
			 * caller: 一般为输入框
			 * parent: 当前容器
			 * siblingSelector: 同一类型的其它数据项的选择表达式
			 */
			chkSiblingDuplicate:function(caller, parent, siblingSelector){
				var count = 0;
				var curValue = $(caller).val();
				
				$(caller).parentsUntil(parent)
					.find(siblingSelector).each(function(){
						console.log($(this).val());
						if($(this).val() == curValue){
							count++;
						}	
					}
				);
				if(count == 1){
					return {isError: false};
				} else {
					return {isError: true, errorInfo: "此值与已有值重复"};
				}
			}
	
};


var PlUploadUtil={
		initUpload:function(jqcontext,option){
			var settings=$.fn.extend(true,{
					runtimes : 'flash',
					max_file_size : '10mb',
					browse_button:null,
					container:null,
					dragdrop:false,
					url : Global.contextPath+'/ui/upload',
					resize : {width : 320, height : 240, quality : 90},
					flash_swf_url : Global.contextPath+'/statics/scripts/plugins/plupload/plupload.flash.swf',
					filters : [
						{title : "Image files", extensions : "jpg,gif,png"}
					]
			},option);
			$(jqcontext).each(function(){
				var _self=$(this);
				var _id=$(this).attr("id");
				if (!_id) {
					_id = plupload.guid();
					$(this).attr('id', _id);
				}		
				//扩展browse_button,可以通过函数获取
				if(option && option.browse_button){					
					if($.isFunction(option.browse_button)){
						settings.browse_button=option.browse_button(_self);
					}
				}else{				
					settings.browse_button=_id;
				}
				
				//扩展container,可以通过函数获取
				if(option && option.container){					
					if($.isFunction(option.container)){
						settings.container=option.container(_self);
					}
				}else{				
					settings.container=_id;
				}
				
				var uploader = new plupload.Uploader(settings);
				
				uploader.bind('Init', function(up, params) {
					//alert(params.runtime);
				});
			
				uploader.bind('FilesAdded', function(up, files) {	
					if(settings.filesAdded){
						settings.filesAdded(up,files,_self);
					}					
					if(settings.autostart===true){
						setTimeout(function() {
							uploader.start();
						}, 10);
					}
				});
			
				uploader.bind('UploadProgress', function(up, file) {
					//alert(file.percent);
				});
			
				uploader.bind('FileUploaded', function(up, file,resp) {
					if(settings.fileUploaded){
						var data=$.parseJSON(resp.response);
						settings.fileUploaded(up,file,data,_self);
					}
				});
				uploader.init();
				$(this).data("uploader",uploader);
			});
		},		
		getUploader:function(domEle){
			var $obj=$(domEle);
			if($obj.length<0){
				return null;				
			}
			return $($obj.get(0)).data("uploader");
		}
};
	
