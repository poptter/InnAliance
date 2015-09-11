var request;// AJAX异步通信对象
// 初始化request对象
function init() {
	try {
		// Firefox, Opera 8.0+, Safari
		request = new XMLHttpRequest();
	} catch (e) {

		// Internet Explorer
		try {
			request = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {

			try {
				request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
				alert("您的浏览器不支持AJAX！");
				return false;
			}
		}
	}
}
/**
 * 
 * @param {Object}
 *            url
 * @param {Object}
 *            params "a=1&b=2"
 * @param {Object}
 *            callBack
 */
function sendByGet(url, params, callBack) {
	init();
	var requestUrl = url + "?" + params;
	request.open("GET", requestUrl, true);
	request.send(null);
	request.onreadystatechange = callBack;// 服务器返回的状态码发生改变时调用callBack函数
}

function sendByPost(url, params, callBack) {
	init();
	request.open("POST", url, true);
	request.setRequestHeader("content-type",
			"application/x-www-form-urlencoded;charset=UTF-8");
	request.send(params);
	request.onreadystatechange = callBack;
}

function setFloorByBuild(obj,set){
	init();//初始化
	request.onreadystatechange = function(){
		if(request.readyState == 4){
			var xmlDoc = request.responseXML;
			var dataElement = getTagData(xmlDoc.documentElement,"int");
			//alert(dataElement);
			var floors = document.getElementById(set);
			floors.options.length = 0;
			for(var i=0;i<dataElement.length;i++){
				var str = dataElement[i].firstChild.nodeValue+"F";
				floors.options.add(new Option(str,dataElement[i].firstChild.nodeValue));
			}
		}
	};
	var id= obj.value;
	request.open("POST","activefloordorm?buildId="+id,true);
	request.send();
}

function setChangeDorm(build,floor,tarbuild,tarfloor,changedorm,tardorm,stu,tarstu){
	init();//初始化
	var buildId = document.getElementById(build).value;
	var floorId = document.getElementById(floor).value;
	var tarbuildId = document.getElementById(tarbuild).value;
	var tarfloord = document.getElementById(tarfloor).value;
	
	request.onreadystatechange = function(){
		if(request.readyState == 4){
			var changeList = document.getElementById(changedorm);//调整的寝室
			var tarList = document.getElementById(tardorm);//目标寝室
			var stu = document.getElementById(stu);//调整的寝室人员
			var tarstu = document.getElementById(tarstu);//目标寝室人员
			var stus = [stu,tarstu];
			
			changeList.options.length = 0;
			tarList.options.length = 0;
			var dorms = [changeList,tarList];
			
			var xmlDoc = request.responseXML;
			var dataElement = getTagData(xmlDoc.documentElement,"list");
			//alert(dataElement.length);
			for(var i=0;i<dataElement.length;i++){
				var dormList = getTagData(dataElement[i],"dorm");
				//alert(dormList.length);
//				if(dormList.length == 0){
//					alert(stus[i].options.length);
//					//stus[i].options.length = 0;
//				}
				for(var j=0;j<dormList.length;j++){
						var dtId = dormList[j].getElementsByTagName("dtId");
						var dtno = dormList[j].getElementsByTagName("dtno");
						dorms[i].options.add(new Option(dtno[0].firstChild.nodeValue,dtId[0].firstChild.nodeValue));
				}
			}
		}
	};
	request.open("GET","activefloordorm?build="+buildId+"&floor="+floorId+"&" +
			"tarbuild="+tarbuildId+"&tarfloor="+tarfloord,true);
	request.send();
	return false;
}

function setStuByDorm(dorm,stuList){
	init();//初始化
	request.onreadystatechange = function(){
		if(request.readyState == 4){
			var xmlDoc = request.responseXML;
			var dataElement = getTagData(xmlDoc.documentElement,"stu");
			//alert(dataElement.length);
			var stus = document.getElementById(stuList);
			stus.options.length = 0;
			for(var i=0;i<dataElement.length;i++){
				var sid = getTagData(dataElement[i],"siId");
				var sname = getTagData(dataElement[i],"siName");
				var sinum = getTagData(dataElement[i],"sinum");
				var text;
				if(sid[0].firstChild.nodeValue == 0){
					var studorms = getTagData(dataElement[i],"TDomitory");
					var studormId = getTagData(studorms[0],"dtId");//得到寝室id
					text = studormId[0].firstChild.nodeValue + "-no-"+sinum[0].firstChild.nodeValue;
				}else{
					text = sid[0].firstChild.nodeValue;
				}
				stus.options.add(new Option("bed"+sinum[0].firstChild.nodeValue+": "+sname[0].firstChild.nodeValue,text));
			}
		}
	};
	var id= dorm.value;//寝室ID
	request.open("POST","bedbydorm?dormId="+id,true);
	request.send();
	return true;
}

function changeDorm(stu,tarstu,alldorm,targetDorm){
	
	var stumess = document.getElementById(stu);
	var tarstumess = document.getElementById(tarstu);
	var value1 = stumess.value;
	var value2 = tarstumess.value;
	if(getSelect(stumess) == null || getSelect(stumess) == null){
		alert("\u64cd\u4f5c\u65e0\u6548\uff0c\u53bb\u9009\u62e9\u6b63\u786e\u7684\u5e8a\u4f4d\uff01");
	}else{
	init();//初始化
	request.onreadystatechange = function(){
		if(request.readyState == 4){
			var xmlDoc = request.responseText;
			var returnMess = xmlDoc;
			//alert(returnMess);
			var dorm = document.getElementById(alldorm);
			var tardorm= document.getElementById(targetDorm);
			
			if(returnMess == "error"){
				alert("\u64cd\u4f5c\u65e0\u6548\uff0c\u53bb\u9009\u62e9\u6b63\u786e\u7684\u5e8a\u4f4d\uff01");
			}else{
				var pattern = /^[0-9]*$/;
				var index1 = getSelect(stumess);
				var index2 = getSelect(tarstumess);
				var option1 = stumess.options[index1];//被选中的寝室
				var option2 = tarstumess.options[index2];//被选中目标寝室
				
				if(!pattern.test(value1) && pattern.test(value2)){
					option1.value = option2.value;
					option1.text = getSubString(option2.text,option1.text);
					stumess.options[index1] = option1;
					setStuByDorm(tardorm,"targetstu");
					tarstumess.options[index2].selected = true;
				}else{
					option2.value = option1.value;
					//alert(getSubString(option2.text,option1.text));
					option2.text = getSubString(option1.text,option2.text);
					tarstumess.options[index2] = option2;
					setStuByDorm(dorm,"stuList");
					stumess.options[index1].selected = true;
				}
				alert(returnMess);
			}
		}
	};
	request.open("POST","changedorm?dormId="+value1+"&tardormId="+value2,true);
	request.send();
	}
	return false;
}

function getTagData(obj,tagname){
	return obj.getElementsByTagName(tagname);
}

function getSubString(str1,str2){
//	var s= "sss";
//	s.i
	var index1 = str1.indexOf(":",0);
	var index2 = str2.indexOf(":",0);
	var text1 = str1.substring(index1+1,str1.length);
	var text2 = str2.substring(0,index2+1);
	//alert(text2+text1);
	return text2+text1;
}

function getSelect(obj){
	for(var i=0;i<obj.options.length;i++){
		if(obj.options[i].selected == true){
			return i;
		}
	}
	return null;
}