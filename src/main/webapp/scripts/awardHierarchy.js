    var node;
    var i = 1;
    var j = 1;
    var removedNode=null;
    var cutNode;
    var sqlScripts = "";
    var ulTagId;
    var sqls = []; 
    var sqlidx = 0;
    var deletedNodes="";
    var newNodes=";";
    var loadedidx=0;
    var selectedAwardNumber = $("#selectedAwardNumber").attr("value");
    var selectedNodeReached = false;
    
    $(document).ready(function(){
      $.ajaxSettings.cache = false; 
      $("#awardhierarchy").treeview({
                 toggle: function() {
                     var idstr=$(this).attr("id").substring(4);
                     var tagId = "listcontrol"+idstr;
                     var divId = "listcontent"+idstr;
                 
                     $(".hierarchydetail").slideUp(300); 
                     loadChildrenRA($("#itemText"+idstr).text(), tagId);
                    },
                animated: "fast",
                collapsed: true,
                control: "#treecontrol" 
                    
                 
              });

      $(document).ajaxStart(function(){
         $("#loading").show();
       });

      $(document).ajaxComplete(function(){
         $("#loading").hide();
       });
    }); 
     
    /*
	 * Load first level area of research when page is initially loaded
	 */
    function loadFirstLevel(){ 
      $.ajax({
        url: 'awardHierarchyAwardActionsAjax.do',
        type: 'GET',
        dataType: 'html',
        cache: false,
        data:'awardNumber=&addRA=N&rootAwardNumber=' + $("#rootAwardNumber").attr("value"),
        async:false,
        timeout: 1000,
        error: function(){
           alert('Error loading XML document');
        },
        success: function(xml){
           $(xml).find('h3').each(function(){
           var item_text = $(this).text();
           i++;
           var racode = item_text.substring(0,item_text.indexOf("%3A")).trim();
           item_text = item_text.replace("%3A",":");
           var id = "item"+i;
           var tagId = "listcontrol"+i;
           var divId = "listcontent"+i;
           
          // NOTES : if use 'div', then FF will display the '+' and idDiv in
			// separate lines. IE7 is fine
          // But 'IE7 has problem with 'span'
          
          var idDiv;
          if ( jQuery.browser.msie ) { 
               idDiv = $('<div></div>').attr("id","itemText"+i).html(builduUi(item_text, racode)); // for
																					// later
																					// change
																					// RA
																					// description
          } else {
               idDiv = $('<span>').attr("id","itemText"+i).html(builduUi(item_text, racode)); // for
																			// later
																			// change
																			// RA
																			// description
          }
               
           var tag = $('<a style = "margin-left:2px;" ></a>').attr("id",tagId).html(idDiv);
           var div = $('<div  class="hierarchydetail" style="margin-top:2px;" align="left"></div>').attr("id",divId);
       	   var hidracode = $('<input type="hidden" id = "racode" name = "racode" />').attr("id",
    			"racode" + i).attr("name", "racode" + i).attr("value",racode);
       	   hidracode.appendTo(div);
           
           tag.click(
                  function()
                  {
                	  linkOnclick($(this), item_text, divId, tagId);
                  }
              );
       	
           div.hide();
           var listitem = $('<li class="closed"></li>').attr("id",id).html(tag);
           ulTagId = "browser";
           div.appendTo(listitem);
           // need this ultag to force to display folder.
           var childUlTag = $('<ul></ul>').attr("id","ul"+i);
           childUlTag.appendTo(listitem);
           listitem.appendTo('ul#awardhierarchy');
           
           if(racode == selectedAwardNumber) {
        	   selectedNodeReached = true;
         	   tag.trigger('click');
           } 
           
           if(selectedAwardNumber != null && selectedAwardNumber != '' && racode != selectedAwardNumber){
        	   loadChildrenRA($("#itemText"+i).text(), tagId);
           } 
           
           // also need this to show 'folder' icon
           $('#awardhierarchy').treeview({
        	   add: listitem
           });

           
           });
        }
       });  
    }  // generate
    
    function revString(str) { 
    	   var retStr = "";    	   
    	   for (j=str.length - j ; j > - 1 ; j--){ 
    	      retStr += str.substr(j,1); 
    	   } 
    	   return retStr; 
    }
    
    function builduUi(item_text, racode) { 
    	var original_item_text = item_text; 
        var text1 = item_text.substring(0,item_text.indexOf("%3A")).trim();
        item_text = item_text.substring(item_text.indexOf("%3A")+3, item_text.length).trim();
        var text2 = item_text.substring(0,item_text.indexOf("%3A")).trim();
        
        item_text = item_text.substring(item_text.indexOf("%3A")+3, item_text.length).trim();
        var text3 = item_text.substring(0,item_text.indexOf("%3A")).trim();
        
        item_text = item_text.substring(item_text.indexOf("%3A")+3, item_text.length).trim();
        var text4 = item_text.substring(0,item_text.indexOf("%3A")).trim();
        
        item_text = item_text.substring(item_text.indexOf("%3A")+3, item_text.length).trim();
        var text5 = item_text.substring(0,item_text.indexOf("%3A")).trim();
        
        item_text = item_text.substring(item_text.indexOf("%3A")+3, item_text.length).trim();
        var text6 = item_text.substring(0,item_text.indexOf("%3A")).trim();
        
        item_text = item_text.substring(item_text.indexOf("%3A")+3, item_text.length).trim();
        var text7 = item_text.substring(0,item_text.indexOf("%3A")).trim();
        
        item_text = item_text.substring(item_text.indexOf("%3A")+3, item_text.length).trim();
        var text8 = item_text.substring(0,item_text.indexOf("%3A")).trim();
        
        item_text = item_text.substring(item_text.indexOf("%3A")+3, item_text.length).trim();
        var text9 = item_text.substring(0,item_text.indexOf("%3A")).trim();
        
        item_text = item_text.substring(item_text.indexOf("%3A")+3, item_text.length).trim();
        var text10 = item_text.substring(0,item_text.indexOf("%3A")).trim();
        
        item_text = item_text.substring(item_text.indexOf("%3A")+3, item_text.length).trim();
        var text11 = item_text.substring(0,item_text.indexOf("%3A")).trim();

        if(text11 == 1){
        	var txtImage = "<img src=\"static/images/award_active.gif\" alt=\"Active\" title=\"Active\" />";
        }else if(text11 == 2 || text11 == 4 || text11 == 5){
        	var txtImage = "<img src=\"static/images/award_inactive.gif\" alt=\"Inactive\" title=\"Inactive\" />";
        }else if(text11 == 3 || text11 == 6){
        	var txtImage = "<img src=\"static/images/award_pending.gif\" alt=\"Pending\" title=\"Pending\" />";
        }

        item_text = item_text.substring(item_text.indexOf("%3A")+3, item_text.length).trim();
        var text12 = item_text.substring(0,item_text.indexOf("%3A")).trim();
        item_text = item_text.substring(item_text.indexOf("%3A")+3, item_text.length).trim();
        var text13 = item_text.substring(0,item_text.indexOf("%3A")).trim();
        item_text = item_text.substring(item_text.indexOf("%3A")+3, item_text.length).trim();
        var text14 = item_text.substring(0,item_text.indexOf("%3A")).trim();
        item_text = item_text.substring(item_text.indexOf("%3A")+3, item_text.length).trim();
        var text15 = item_text.substring(0,item_text.indexOf("%3A")).trim();
        
        var racodereverse = revString(racode);
        var index = racodereverse.indexOf("0");
        var i2 = 12 - index;
        var racode2 = racode.substring(i2,12); 
        
      	var abc = "<table style=\"border: medium none ; padding: 0px; border-collapse: collapse;\"><tbody><tr><td align='left' style=\"border: medium none ; border-collapse: collapse; vertical-align: top;\">"+txtImage+"&nbsp;"+text1
      				+ "</td><td align='right' style='border: medium none ; border-collapse: collapse; vertical-align: top;'>"
      				+ "<a href='kew/DocHandler.do?docId=" + text15 + "&command=displayDocSearchView' target='_blank'><img src='static/images/tinybutton-open.gif' /></a>"
      				+ "</td></tr></tbody></table>"; 
        
      	return abc; 
    }
  
  function tbodyTag2(name, id) {
	  var text1 = name.substring(0,name.indexOf("%3A")).trim();
      name = name.substring(name.indexOf("%3A")+3, name.length).trim();
      text1 = text1.substr(0,12);
      
      var text1reverse = revString(text1);
      var index = text1reverse.indexOf("0");
      var i2 = 12 - index;
      var indexForHiddenField = text1.substring(i2,12);
      
      
	  var tblTag = $('<table id="tbody2_1" style="border: 1px solid rgb(147, 147, 147); padding: 0px; border-collapse: collapse;"></table>')
	    
	  	var trTag0 = $('<tr></tr>');
	    var thTag0 = $('<th colspan="5" style="border-style: solid; text-align:left; border-color: rgb(230, 230, 230) rgb(147, 147, 147) rgb(147, 147, 147); border-width: 1px; padding: 3px; border-collapse: collapse; background-color: rgb(184, 184, 184); background-image: none;"></th>').attr("id","raHeader"+id.substring(4)).html("Award Copy");
	    trTag0.html(thTag0);
	    trTag0.appendTo(tblTag);
	    // 1st tr
	    var trTag = $('<tr></tr>');
	    var thTag1=$('<th style="border: 1px solid rgb(147, 147, 147); padding: 3px; border-collapse: collapse; background-color: rgb(230, 230, 230); background-image: none; width: 130px; vertical-align: middle;">').html('<b>Copy Descendents: </b>');
	    trTag.html(thTag1);
	    if($("#awardHierarchyTempObject\\[" + indexForHiddenField + "\\]\\.copyDescendants").attr("value")){
	    	var checkbox = $('<input class="nobord" type="checkbox" ></input>').attr("name","awardHierarchyTempObject["+indexForHiddenField+"].copyDescendants").attr("id","awardHierarchyTempObject["+indexForHiddenField+"].copyDescendants").attr("value",$("#awardHierarchyTempObject\\[" + indexForHiddenField + "\\]\\.copyDescendants").attr("value")).attr("checked",$("#awardHierarchyTempObject\\[" + indexForHiddenField + "\\]\\.copyDescendants").attr("value"));
	    }else{
	    	var checkbox = $('<input class="nobord" type="checkbox" ></input>').attr("name","awardHierarchyTempObject["+indexForHiddenField+"].copyDescendants").attr("id","awardHierarchyTempObject["+indexForHiddenField+"].copyDescendants");
	    }
	    
	    var hiddenTagForCheckBox = $('<input type="hidden" />').attr("name","elementsToReset").attr("value","awardHierarchyTempObject["+indexForHiddenField+"].copyDescendants");
	    
	    var tdTag1=$('<td style="border: 1px solid rgb(147, 147, 147); padding: 3px; border-collapse: collapse; background-color: rgb(255, 255, 255); vertical-align: middle; width: 30px;">');
	    checkbox.appendTo(tdTag1);
	    hiddenTagForCheckBox.appendTo(tdTag1);
	    tdTag1.appendTo(trTag);	    
	    var thTag2=$('<th style="border: 1px solid rgb(147, 147, 147); padding: 3px; border-collapse: collapse; background-color: rgb(230, 230, 230); background-image: none; width: 60px; vertical-align: middle;">').html('<b>Copy as:</b>');
	    thTag2.appendTo(trTag);
	    
	    var subTblTag = $('<table cellspacing="0" cellpadding="0" style="border: medium none ; background: transparent none repeat scroll 0% 0%; -moz-background-clip: border; -moz-background-origin: padding; -moz-background-inline-policy: continuous; width: 505px;"></table>')
	    var subTrTag = $('<tr></tr>');
	    var subTdTag1 = $('<td style="border: medium none ; background: transparent none repeat scroll 0% 0%; -moz-background-clip: border; -moz-background-origin: padding; -moz-background-inline-policy: continuous; text-align: left; width: 60px;">');
	    var subTdTag2 = $('<td style="border: medium none ; background: transparent none repeat scroll 0% 0%; -moz-background-clip: border; -moz-background-origin: padding; -moz-background-inline-policy: continuous; vertical-align: bottom; text-align: right; width: 100px;">');
	    var subTdTag3 = $('<td style="border: medium none ; background: transparent none repeat scroll 0% 0%; -moz-background-clip: border; -moz-background-origin: padding; -moz-background-inline-policy: continuous; vertical-align: bottom; text-align: left; width: 325px;">');
	    var subTdTag4 = $('<td style="border: medium none ; background: transparent none repeat scroll 0% 0%; -moz-background-clip: border; -moz-background-origin: padding; -moz-background-inline-policy: continuous; vertical-align: bottom; text-align: center; width: 20px;">');
	    	    
	    if($("#awardHierarchyTempObject\\[" + indexForHiddenField + "\\]\\.copyAwardRadio").attr("value") == "a"){
	    	var radio1 = $('<input class="nobord" type="radio" name="awardHierarchyTempObject['+indexForHiddenField+'].copyAwardRadio" />').attr("id","awardHierarchyTempObject["+indexForHiddenField+"].copyAwardRadio").attr("value","a").attr("checked",true);
	    }else{
	    	var radio1 = $('<input class="nobord" type="radio" name="awardHierarchyTempObject['+indexForHiddenField+'].copyAwardRadio" />').attr("id","awardHierarchyTempObject["+indexForHiddenField+"].copyAwardRadio").attr("value","a");
	    }
	    
	    subTdTag1.html('new');
	    radio1.appendTo(subTdTag1);
	    
	    if($("#awardHierarchyTempObject\\[" + indexForHiddenField + "\\]\\.copyAwardRadio").attr("value") == "b"){
	    	var radio2 = $('<input class="nobord" type="radio" name="awardHierarchyTempObject['+indexForHiddenField+'].copyAwardRadio" />').attr("id","awardHierarchyTempObject["+indexForHiddenField+"].copyAwardRadio").attr("value","b").attr("checked",true);
	    }else{
	    	var radio2 = $('<input class="nobord" type="radio" name="awardHierarchyTempObject['+indexForHiddenField+'].copyAwardRadio" />').attr("id","awardHierarchyTempObject["+indexForHiddenField+"].copyAwardRadio").attr("value","b");
	    }
	    
	    subTdTag2.html('child of');
	    radio2.appendTo(subTdTag2);
	    
	    var lookupField = $('<input type="image" title="Lookup" alt="Lookup" src="static/images/searchicon.gif"/>').attr("name","methodToCall.performLookup.(!!org.kuali.kra.award.home.Award!!).(((awardNumber:awardHierarchyTempObject["+indexForHiddenField+"].awardNumber2,awardHierarchyTempObject["+indexForHiddenField+"].awardNumber2:awardNumber))).((##)).((<>)).(([])).((**)).((^^)).((&&)).((//)).((~~))");
	    var selectBoxText = $("#awardHierarchyTempObject\\[" + indexForHiddenField + "\\]\\.selectBox2").attr("value");
	    var selectTag = $('<select />').attr("name","awardHierarchyTempObject["+indexForHiddenField+"].copyAwardPanelTargetAward").attr("id","awardHierarchyTempObject["+indexForHiddenField+"].copyAwardPanelTargetAward");   
	    var optionTag = $("<option> select: </option>").attr("value","");
	    optionTag.appendTo(selectTag);
	    while(selectBoxText.length>1){
	    	var optionValue = selectBoxText.substring(0,selectBoxText.indexOf("%3A")).trim();	    	
	    	selectBoxText = selectBoxText.substring(selectBoxText.indexOf("%3A")+3, selectBoxText.length).trim();
	    	if($("#awardHierarchyTempObject\\[" + indexForHiddenField + "\\]\\.awardNumber2").attr("value") == optionValue){
	    		var optionTag = $("<option>"+optionValue+"</option>").attr("value",optionValue).attr("selected",true);
	    	}else{
	    		var optionTag = $("<option>"+optionValue+"</option>").attr("value",optionValue);
	    	}
	    	optionTag.appendTo(selectTag);	    	
	    }
	    selectTag.appendTo(subTdTag3)
	    
	    lookupField.appendTo(subTdTag4);
	    
	    subTdTag1.appendTo(subTrTag);
	    subTdTag2.appendTo(subTrTag);
	    subTdTag3.appendTo(subTrTag);
	    subTdTag4.appendTo(subTrTag);
	    
	    subTrTag.appendTo(subTblTag);
	    
	    var tdTag2=$('<td></td>').html(subTblTag);
	    tdTag2.appendTo(trTag);	    
	    trTag.appendTo(tblTag);
	    
	    var tdTag3=$('<td style="border: 1px solid rgb(147, 147, 147); padding: 3px; border-collapse: collapse; background-color: rgb(255, 255, 255); vertical-align: middle; text-align: center; width: 65px;">');
	    var copyButton = $('<input type="image" title="Copy" alt="copy" style="border: medium none ;" src="static/images/tinybutton-copy2.gif"/>').attr("property","methodToCall.copyAward.awardNumber"+text1).attr("name","methodToCall.copyAward.awardNumber"+text1);;
	    copyButton.appendTo(tdTag3);	    
	    tdTag3.appendTo(trTag);	    
	    trTag.appendTo(tblTag);
	    
	    return tblTag;
  }
  
  function tbodyTag3(name, id) {
	  
	  var text1 = name.substring(0,name.indexOf("%3A")).trim();
      name = name.substring(name.indexOf("%3A")+3, name.length).trim();
      text1 = text1.substr(0,12);
      
      var text1reverse = revString(text1);
      var index = text1reverse.indexOf("0");
      var i2 = 12 - index;
      var indexForHiddenField = text1.substring(i2,12);
      
	  var tblTag = $('<table id="tbody3_1" style="border: 1px solid rgb(147, 147, 147); padding: 0px; border-collapse: collapse;"></table>')

	    var trTag0 = $('<tr></tr>');
	    var thTag0 = $('<th colspan="3" style="border-style: solid; text-align:left; border-color: rgb(230, 230, 230) rgb(147, 147, 147) rgb(147, 147, 147); border-width: 1px; padding: 3px; border-collapse: collapse; background-color: rgb(184, 184, 184); background-image: none;"></th>').attr("id","raHeader"+id.substring(4)).html("New Child");
	    trTag0.html(thTag0);
	    trTag0.appendTo(tblTag);
	    
	    // 1st tr
	    var trTag = $('<tr></tr>');
	    var thTag1=$('<th style="border: 1px solid rgb(147, 147, 147); padding: 3px; border-collapse: collapse; background-color: rgb(230, 230, 230); background-image: none; width: 70px; vertical-align: middle;"></th>').html('<b>Based on:</b>');
	    trTag.html(thTag1);
	
	    var subTblTag = $('<table cellspacing="0" cellpadding="0" style="border: medium none ; background: transparent none repeat scroll 0% 0%; -moz-background-clip: border; -moz-background-origin: padding; -moz-background-inline-policy: continuous; width: 505px;"></table>')
	    var subTrTag = $('<tr></tr>');
	    var subTdTag1 = $('<td style="border: medium none ; background: transparent none repeat scroll 0% 0%; -moz-background-clip: border; -moz-background-origin: padding; -moz-background-inline-policy: continuous; text-align: left; width: 60px;"></td>');
	    var subTdTag2 = $('<td style="border: medium none ; background: transparent none repeat scroll 0% 0%; -moz-background-clip: border; -moz-background-origin: padding; -moz-background-inline-policy: continuous; vertical-align: bottom; text-align: right; width: 140px;"></td>');
	    var subTdTag3 = $('<td style="border: medium none ; background: transparent none repeat scroll 0% 0%; -moz-background-clip: border; -moz-background-origin: padding; -moz-background-inline-policy: continuous; vertical-align: bottom; text-align: right; width: 130px;"></td>');
	    var subTdTag4 = $('<td style="border: medium none ; background: transparent none repeat scroll 0% 0%; -moz-background-clip: border; -moz-background-origin: padding; -moz-background-inline-policy: continuous; vertical-align: bottom; text-align: left; width: 325px;"></td>');
	    var subTdTag5 = $('<td style="border: medium none ; background: transparent none repeat scroll 0% 0%; -moz-background-clip: border; -moz-background-origin: padding; -moz-background-inline-policy: continuous; vertical-align: bottom; text-align: center; width: 20px;"></td>');
	    	    
	    
	    
	    if($("#awardHierarchyTempObject\\[" + indexForHiddenField + "\\]\\.createNewChildRadio").attr("value") == "a"){
	    	var radio1 = $('<input class="nobord" type="radio" name="awardHierarchyTempObject['+indexForHiddenField+'].createNewChildRadio" />').attr("id","awardHierarchyTempObject["+indexForHiddenField+"].createNewChildRadio").attr("value","a").attr("checked",true);
	    }else{
	    	var radio1 = $('<input class="nobord" type="radio" name="awardHierarchyTempObject['+indexForHiddenField+'].createNewChildRadio" />').attr("id","awardHierarchyTempObject["+indexForHiddenField+"].createNewChildRadio").attr("value","a");
	    }
	    subTdTag1.html('new');
	    radio1.appendTo(subTdTag1);
	    
	    if($("#awardHierarchyTempObject\\[" + indexForHiddenField + "\\]\\.createNewChildRadio").attr("value") == "b"){
	    	var radio2 = $('<input class="nobord" type="radio" name="awardHierarchyTempObject['+indexForHiddenField+'].createNewChildRadio" />').attr("id","awardHierarchyTempObject["+indexForHiddenField+"].createNewChildRadio").attr("value","b").attr("checked",true);
	    }else{
	    	var radio2 = $('<input class="nobord" type="radio" name="awardHierarchyTempObject['+indexForHiddenField+'].createNewChildRadio" />').attr("id","awardHierarchyTempObject["+indexForHiddenField+"].createNewChildRadio").attr("value","b");
	    }
	    subTdTag2.html('copy from parent');
	    radio2.appendTo(subTdTag2);
	    
	    if($("#awardHierarchyTempObject\\[" + indexForHiddenField + "\\]\\.createNewChildRadio").attr("value") == "c"){
	    	var radio3 = $('<input class="nobord" type="radio" name="awardHierarchyTempObject['+indexForHiddenField+'].createNewChildRadio" />').attr("id","awardHierarchyTempObject["+indexForHiddenField+"].createNewChildRadio").attr("value","c").attr("checked",true);
	    }else{
	    	var radio3 = $('<input class="nobord" type="radio" name="awardHierarchyTempObject['+indexForHiddenField+'].createNewChildRadio" />').attr("id","awardHierarchyTempObject["+indexForHiddenField+"].createNewChildRadio").attr("value","c");
	    }
	    
	    subTdTag3.html('selected award');
	    radio3.appendTo(subTdTag3);	

	    var lookupField = $('<input type="image" title="Lookup" alt="Lookup" src="static/images/searchicon.gif"/>').attr("name","methodToCall.performLookup.(!!org.kuali.kra.award.home.Award!!).(((awardNumber:awardHierarchyTempObject["+indexForHiddenField+"].awardNumber1,awardHierarchyTempObject["+indexForHiddenField+"].awardNumber1:awardNumber))).((##)).((<>)).(([])).((**)).((^^)).((&&)).((//)).((~~))");
	    var selectBoxText = $("#awardHierarchyTempObject\\[" + indexForHiddenField + "\\]\\.selectBox1").attr("value");
	    var selectTag = $('<select />').attr("name","awardHierarchyTempObject["+indexForHiddenField+"].newChildPanelTargetAward").attr("id","awardHierarchyTempObject["+indexForHiddenField+"].newChildPanelTargetAward");   
	    var optionTag = $("<option> select: </option>").attr("value","");
	    optionTag.appendTo(selectTag);
	    while(selectBoxText.length>1){
	    	var optionValue = selectBoxText.substring(0,selectBoxText.indexOf("%3A")).trim();
	    	selectBoxText = selectBoxText.substring(selectBoxText.indexOf("%3A")+3, selectBoxText.length).trim();
	    	if($("#awardHierarchyTempObject\\[" + indexForHiddenField + "\\]\\.awardNumber1").attr("value") == optionValue){
	    		var optionTag = $("<option>"+optionValue+"</option>").attr("value",optionValue).attr("selected",true);
	    	}else{
	    		var optionTag = $("<option>"+optionValue+"</option>").attr("value",optionValue);
	    	}
	    	optionTag.appendTo(selectTag);	    	
	    } 
	    selectTag.appendTo(subTdTag4)
	    
	    lookupField.appendTo(subTdTag5);
	    
	    subTdTag1.appendTo(subTrTag);
	    subTdTag2.appendTo(subTrTag);
	    subTdTag3.appendTo(subTrTag);
	    subTdTag4.appendTo(subTrTag);
	    subTdTag5.appendTo(subTrTag);
	    
	    subTrTag.appendTo(subTblTag);
	    
	    var tdTag1=$('<td></td>').html(subTblTag);
	    tdTag1.appendTo(trTag);	    
	    trTag.appendTo(tblTag);
	    
	    
	    var tdTag2=$('<td style="border: 1px solid rgb(147, 147, 147); padding: 3px; border-collapse: collapse; background-color: rgb(255, 255, 255); vertical-align: middle; text-align: center; width: 65px;"></td>');
	    var createButton = $('<input type="image" title="Create" alt="create" style="border: medium none ;" src="static/images/tinybutton-create.gif"/>').attr("property","methodToCall.create.awardNumber"+text1).attr("name","methodToCall.create.awardNumber"+text1);	    
	    createButton.appendTo(tdTag2);	    
	    tdTag2.appendTo(trTag);
	    
	    trTag.appendTo(tblTag);
	    
	    return tblTag;
  }

  function tbodyTag1(name, id) {
	  
	  var text1 = name.substring(0,name.indexOf("%3A")).trim();
      name = name.substring(name.indexOf("%3A")+3, name.length).trim();
      
	  var text2 = name.substring(0,name.indexOf("%3A")).trim();
      
	  name = name.substring(name.indexOf("%3A")+3, name.length).trim();
      var text3 = name.substring(0,name.indexOf("%3A")).trim();
      
      name = name.substring(name.indexOf("%3A")+3, name.length).trim();
      var text4 = name.substring(0,name.indexOf("%3A")).trim();
      
      name = name.substring(name.indexOf("%3A")+3, name.length).trim();
      var text5 = name.substring(0,name.indexOf("%3A")).trim();
      
      name = name.substring(name.indexOf("%3A")+3, name.length).trim();
      var text6 = name.substring(0,name.indexOf("%3A")).trim();
      
      name = name.substring(name.indexOf("%3A")+3, name.length).trim();
      var text7 = name.substring(0,name.indexOf("%3A")).trim();
      
      name = name.substring(name.indexOf("%3A")+3, name.length).trim();
      var text8 = name.substring(0,name.indexOf("%3A")).trim();
      
      name = name.substring(name.indexOf("%3A")+3, name.length).trim();
      var text9 = name.substring(0,name.indexOf("%3A")).trim();
      
      name = name.substring(name.indexOf("%3A")+3, name.length).trim();
      var text10 = name.substring(0,name.indexOf("%3A")).trim();
      
      name = name.substring(name.indexOf("%3A")+3, name.length).trim();
      var text11 = name.substring(0,name.indexOf("%3A")).trim();
      
      name = name.substring(name.indexOf("%3A")+3, name.length).trim();
      var text12 = name.substring(0,name.indexOf("%3A")).trim();
      
      name = name.substring(name.indexOf("%3A")+3, name.length).trim();
      var text13 = name.substring(0,name.indexOf("%3A")).trim();
    
    var idx = id.substring(4);  
    var tblTag = $('<table id="tbody1_1" style="border: 1px solid rgb(147, 147, 147); padding: 0px; border-collapse: collapse;"></table>')
    
    var trTag0 = $('<tr></tr>');
	var thTag0 = $('<th colspan="8" style="border-style: solid; text-align:left; border-color: rgb(230, 230, 230) rgb(147, 147, 147) rgb(147, 147, 147); border-width: 1px; padding: 3px; border-collapse: collapse; background-color: rgb(184, 184, 184); background-image: none;"></th>').attr("id","raHeader"+id.substring(4)).html("Detail: " + text1);
	trTag0.html(thTag0);
	trTag0.appendTo(tblTag);
	
	text1 = text1.substr(0,12);
	
    // 1st tr
    var trTag = $('<tr></tr>');
    var thTag1=$('<th style="text-align:right;width:160px;"></th>').html('<b>Project Start Date</b>');
    trTag.html(thTag1);
    var tdTag1=$('<td></td>').html(text12);
    tdTag1.appendTo(trTag);
    var thTag2=$('<th style="text-align:right;width:160px;"></th>').html('<b>Obligation Start Date</b>');
    thTag2.appendTo(trTag);    
    var tdTag2=$('<td></td>').html(text2);
    tdTag2.appendTo(trTag);
    
    // 2nd tr
    var trTag1 = $('<tr></tr>');
    var thTag3=$('<th style="text-align:right;width:160px;"></th>').html('<b>Project End Date</b>');
    trTag1.html(thTag3);
    var tdTag3=$('<td ></td>').html(text4);
    tdTag3.appendTo(trTag1);
    var thTag4=$('<th style="text-align:right;width:160px;"></th>').html('<b>Obligation End Date</b>');
    thTag4.appendTo(trTag1);    
    var tdTag4=$('<td ></td>').html(text3);
    tdTag4.appendTo(trTag1);
    
    // 3rd tr
    var trTag2 = $('<tr></tr>');
    var thTag5=$('<th style="text-align:right;width:160px;"></th>').html('<b>Anticipated Amount</b>');
    trTag2.html(thTag5);
    var tdTag5=$('<td ></td>').html("$" + text6);
    tdTag5.appendTo(trTag2);
    var thTag6=$('<th style="text-align:right;width:160px;"></th>').html('<b>Obligated Amount</b>');
    thTag6.appendTo(trTag2);    
    var tdTag6=$('<td ></td>').html("$" + text5);
    tdTag6.appendTo(trTag2);
    
    // 4th tr
    var trTag3 = $('<tr></tr>');
    var thTag7=$('<th style="text-align:right;width:160px;"></th>').html('<b>Title</b>');
    trTag3.html(thTag7);
    var tdTag7=$('<td colspan="3" ></td>').html(text13);
    tdTag7.appendTo(trTag3);
      
    trTag.appendTo(tblTag);
    trTag1.appendTo(tblTag);
    trTag2.appendTo(tblTag);
    trTag3.appendTo(tblTag);
    
    return tblTag;
  }    
  
  /*
	 * set up area of resear list tag. the main table detail is not set up
	 * initially.
	 */
  function setupListItem(code, name) {
            i++;
            var id1 = "item"+i;
            var tagId = "listcontrol"+i;
            var divId = "listcontent"+i;
            var idDiv;
            if ( jQuery.browser.msie ) { 
                idDiv = $('<div></div>').attr("id","itemText"+i).html(code +" : "+name); // for
																				// later
																				// change
																				// RA
																				// description
            } else {
                idDiv = $('<span>').attr("id","itemText"+i).html(code +" : "+name); // for
																			// later
																			// change
																			// RA
																			// description
            }
            var tag = $('<a style = "margin-left:2px;" ></a>').attr("id",tagId).html(idDiv);
            var detDiv = $('<div  class="hierarchydetail" style="margin-top:2px; " align="left"></div>').attr("id",divId);
        	   var hidracode = $('<input type="hidden" id = "racode" name = "racode" />').attr("id",
         			"racode" + i).attr("name", "racode" + i).attr("value",code);
            	   hidracode.appendTo(detDiv);
                   
            $(tag).click(
                    function()
                    {
                        $(".hierarchydetail:not(#"+divId+")").slideUp(300);
                        if ($(this).siblings('div:eq(1)').children('table:eq(0)').size() == 0) {
                            var idx = $(this).attr("id").substring(11);
                            tbodyTag1(item_text, "item"+idx).appendTo($("#listcontent"+idx));
                            tbodyTag2(item_text, "item"+idx).appendTo($("#listcontent"+idx));
                            var docStatus = item_text.substring(item_text.length-6,item_text.length-5);
                            if(docStatus == 'F') { 
                          	  tbodyTag3(item_text, "item"+idx).appendTo($("#listcontent"+idx));
                            }
                            
                            if ($("#"+divId).is(":hidden")) {
                                $("#listcontent"+idx).show();
                            }
                        } else {   

                            $("#"+divId).slideToggle(300);
                        }  
                    }
                );
            var listitem = $('<li class="closed"></li>').attr("id",id1).html(tag);
            detDiv.appendTo(listitem);
            return listitem;
	}
 
  function linkOnclick(obj, item_text, divId, tagId) {
      $(".hierarchydetail:not(#"+divId+")").slideUp(300);
      var idx = obj.attr("id").substring(11);
      if (obj.siblings('div:eq(1)').children('table:eq(0)').size() == 0) {
    	  tbodyTag1(item_text, "item"+idx).appendTo($("#listcontent"+idx));
          tbodyTag2(item_text, "item"+idx).appendTo($("#listcontent"+idx));
          var docStatus = item_text.substring(item_text.length-6,item_text.length-5);
          if(docStatus == 'F') { 
        	  tbodyTag3(item_text, "item"+idx).appendTo($("#listcontent"+idx));
          }
          if ($("#listcontent"+idx).is(":hidden")) {
               $("#listcontent"+idx).show();  
          }
      } else {
          $("#listcontent"+idx).slideToggle(300); 
      }   
  }

  /*
	 * load children area of research when parents RA is expanding.
	 */
  function loadChildrenRA(nodeName, tagId) {
      var parentNode = $("#"+tagId); 
      var liNode = parentNode.parents('li:eq(0)');
      var ulNode = liNode.children('ul:eq(0)'); 
      var inputNodev;
      var awardNumber = getAwardNumber(liNode);
      
      if (liNode.children('ul').size() == 0 || ulNode.children('input').size() == 0 ) {
          $.ajax({
           url: 'awardHierarchyAwardActionsAjax.do',
           type: 'GET',
           dataType: 'html',
           data:'awardNumber='+awardNumber+'&addRA=E',
           cache: false,
           async: false,
           timeout: 1000,
           error: function(){
              alert('Error loading XML document');
           },
           success: function(xml){
              var ulTag ;
              if (liNode.children('ul').size() == 0) {
                  ulTag = $('<ul class="filetree"></ul>').attr("id","ul"+i);
              } else {
                  ulTag = ulNode;
              }
             
              ulTag.appendTo(liNode);
              var loadedId = "loaded"+i;
              var inputtag = $('<input type="hidden"></input>').attr("id",loadedId);
              inputtag.appendTo(ulTag);
              $(xml).find('h3').each(function(){
              var item_text = $(this).text();
              i++;
              var racode = item_text.substring(0,item_text.indexOf("%3A")).trim();
              item_text = item_text.replace("%3A",":");
              var id = "item"+i;
              var tagId = "listcontrol"+i;
              var divId = "listcontent"+i;
              
	          var idDiv;
	          if ( jQuery.browser.msie ) { 
	               idDiv = $('<div></div>').attr("id","itemText"+i).html(builduUi(item_text, racode)); // for
																						// later
																						// change
																						// RA
																						// description
	          } else {    
	               idDiv = $('<span>').attr("id","itemText"+i).html(builduUi(item_text, racode)); // for
																				// later
																				// change
																				// RA
																				// description
	          }
              var tag = $('<a style = "margin-left:2px;" ></a>').attr("id",tagId).html(idDiv);
              var detDiv = $('<div  class="hierarchydetail" style="margin-top:2px; " align="left" ></div>').attr("id",divId);
         	  var hidracode = $('<input type="hidden" id = "racode" name = "racode" />').attr("id",
              			"racode" + i).attr("name", "racode" + i).attr("value",racode);
                 	   hidracode.appendTo(detDiv);
                 	  
                 	   tag.click(
                              function(){ 
                            	  linkOnclick($(this), item_text, divId, tagId);
                          	  }
                          );
           	  detDiv.hide();
              
              var listitem = $('<li class="closed"></li>').attr("id",id).html(tag);
              ulTagId = ulTag.attr("id");
              detDiv.appendTo(listitem);
              var childUlTag = $('<ul></ul>').attr("id","ul"+i);
              childUlTag.appendTo(listitem);
              listitem.appendTo(ulTag);
              
              if(racode == selectedAwardNumber) {
            	  selectedNodeReached = true;
            	  tag.trigger('click');
            	  $("#"+id).parents('li').each(function(){
            		  $(this).removeClass("closed");
            		  $(this).addClass("open"); 
            	  });
              }
              
              while(selectedAwardNumber != null && selectedAwardNumber != '' && !selectedNodeReached && racode != selectedAwardNumber) {
            	  loadChildrenRA(item_text, tagId);
              }
	              
              // force to display folder icon
              $("#awardhierarchy").treeview({
                 add: listitem
              });
              
              });
           }
          });    
      }
      loadedidx=i;
  } // end loadChildrenRA

  /*
	 * Utility function to get code from 'code : description' This need to be
	 * refined because if code contains ':', then this is not working correctly.
	 */
  function getAwardNumber(node) {
       return $("#racode"+node.attr("id").substring(4)).attr("value");
  }
  
  <!-- initial state -->
  $(".hierarchydetail").hide();
<!-- hidedetail -->
  $(".hidedetail").toggle(
      function()
      {
          $(".hierarchydetail").slideUp(300);
      }
  );
<!-- listcontent00 -->
  $("#listcontrol00").click(
      function()
      {
          $(".hierarchydetail:not(#listcontent00)").slideUp(300);
          $("#listcontent00").slideToggle(300);
      }
  );  

  $(document).ready(function(){
      loadFirstLevel();
      $("#listcontent00").show();
      loadedidx=i;
  })
  $("#loading").hide();
