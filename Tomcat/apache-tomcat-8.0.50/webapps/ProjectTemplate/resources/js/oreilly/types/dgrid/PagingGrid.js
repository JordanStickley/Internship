//>>built
define("oreilly/types/dgrid/PagingGrid",["dijit/registry","dojo/_base/declare","dojo/_base/array","dojo/dom-class","dojo/dom-style","dojo/dom-construct","dojo/dom-attr","dojo/query","put-selector/put","dojo/aspect","dojo/dom-geometry","dgrid/GridFromHtml","dgrid/Keyboard","dgrid/extensions/DijitRegistry","dgrid/extensions/ColumnResizer","oreilly/types/dgrid/CustomPagination","dojo/_base/lang","oreilly/types/store/StoreAdapter","dgrid/extensions/CompoundColumns","oreilly/utils/sortUtils","dojo/ready"],function(_1,_2,_3,_4,_5,_6,_7,_8,_9,_a,_b,_c,_d,_e,_f,_10,_11,_12,_13,_14,_15){function _16(_17,_18){if(_18&&_18.nodeType){_17.appendChild(_18);}};function _19(_1a){var _1b=[],trs=_1a.getElementsByTagName("tr"),_1c=trs.length,_1d=_c.utils.getColumnFromCell,_1e,tr,ths,_1f,i,j;for(i=0;i<_1c;i+=1){_1e=[];_1b.push(_1e);tr=trs[i];ths=tr.getElementsByTagName("th");_1f=ths.length;for(j=0;j<_1f;j+=1){_1e.push(_1d(ths[j]));}}return _1b;};function _20(_21){var trs=_21.getElementsByTagName("tr"),_22=trs.length,tr,ctr=[],ths,_23,_24=[],i,j;for(i=0;i<_22;i+=1){tr=trs[i];ths=tr.getElementsByTagName("td");_23=ths.length;ctr=[];for(j=0;j<_23;j+=1){ctr.push(ths[j].firstElementChild);}_24.push(ctr);}return _24;};return _2("oreilly.types.dgrid.PagingGrid",[_c,_13,_d,_e,_f,_10],{highlightMatches:true,filterString:"",loadingMessage:"-",noDataMessage:"<p class='centercontents'><strong>No results found</strong></p>",clientQueryParameters:{},showPaginationStatusNode:true,loadDataOnStartup:true,showFooter:false,sortings:{},configStructure:function(){this.srcNodeRefBack=this.srcNodeRef;if(!this._checkedTrs){this._checkedTrs=true;if(this.showFooter){this.thead=this.srcNodeRef.getElementsByTagName("thead")[0];this.tfoot=(this.srcNodeRef.getElementsByTagName("tfoot").length>0)?this.srcNodeRef.getElementsByTagName("tfoot")[0]:null;this.subRows=_19(this.thead,this.subRows);if(this.tfoot){this.customFooter=_20(this.tfoot);}}else{this.subRows=_19(this.srcNodeRef,this.subRows);}}return this.inherited(arguments);},generateHighlightingQuery:function(_25){return function(_26,_27,_28){var _29=0,_2a,_2b,_2c,_2d,_2e,_2f;for(_2a in _25.clientQueryParameters){if(_25.clientQueryParameters.hasOwnProperty(_2a)){if(_2a in _26){_2b=_25.clientQueryParameters[_2a];_2c=_26[_2a];if(_2b!==_2c){return false;}}}}for(_2d in _25.columns){if(_25.columns.hasOwnProperty(_2d)){_2e=_25.columns[_2d];if(_2e.highlightText){_29+=1;_2f=_2e.get?_2e.get(_26):_26[_2e.field];if(_2f!==null){_2f=""+_2f;if(_2f.toLowerCase().indexOf(_25.filterString.toLowerCase())!==-1){return true;}}}}}if(!_29){return true;}return false;};},_updateStore:function(){if(this.store){if(this.store.query){this.collection=new _12({objectStore:this.store});this.collection.idProperty=this.store.idProperty;this.store=this.collection.objectStore;}else{this.collection=this.store;}}},constructor:function(_30){this.inherited(arguments);_11.mixin(this,_30);var _31=this;this._updateStore();_a.after(this,"refresh",this._setHeight);_a.after(this,"resize",this._setHeight);},_setFilterString:function(val){this.filterString=val;this.set("collection",this.collection.filter(this.generateHighlightingQuery(this)));},_setQuery:function(val){this.collection.queryLog=[];this.set("collection",this.collection.filter(val));},postCreate:function(){var _32,_33=(this.sortOptions)?(this.sortOptions):[],i,_34=this,_35,_36,_37=false;this.inherited(arguments);if(!this.collection){this._updateStore();}_15(function(){_34.set("collection",_34.collection.filter(_34.generateHighlightingQuery(_34)));if(_33.length===0){for(i in this.columns){if(this.columns.hasOwnProperty(i)){_32=this.columns[i];_33.push({attribute:_32.field});break;}}}_35=_34.columns;for(_36 in _35){if("renderCell" in _35[_36]&&!_35[_36].renderCell){_37=true;}if("sortType" in _35[_36]&&_14[_35[_36].sortType]){if("sortField" in _35[_36]){_34.sortings[_35[_36].field]=_14[_35[_36].sortType](_35[_36].sortField);}else{_34.sortings[_35[_36].field]=_14[_35[_36].sortType](_35[_36].field);}}}if(_34.sort&&_34.sort.length>0){_34.set("sort",_34.sort);}else{if(_33.length>0){_34.set("sort",_33);}}if(_37){_34.showLoadingMessage();_34._checkedTrs=false;_34.srcNodeRef=_34.srcNodeRefBack;_34.configStructure();if(_34.promise){_34.promise.then(function(){_34.refresh();});}else{_34.refresh();}}});},startup:function(){this.inherited(arguments);if(this.loadDataOnStartup){this.loadContent();}},pleaseWaitDom:function(_38,_39){if(_38!==null){var id=_38.id,_3a=_5.get(id,"width");_38.innerHTML=_7.set("waitMsgLargeDark","innerHTML");_5.set(id,"width",_3a+"px");_4.add(id,"centercontents");}if(_39!==""){window.location.replace(_39);}},showErrorMessage:function(_3b){var _3c=this.contentNode,_3d=this,_3e=_3d.errorNode;_3d.contentNode.innerHTML="";_3d.resetPagination();_3e=_3d.errorNode=_9(_3c,"div.dgrid-error");_3e.innerHTML="<p class='centercontents'><strong>"+_3b+"</strong></h3>";},showLoadingMessage:function(){var _3f=this;if(_3f.paginationLinksNode){_3f.paginationLinksNode.innerHTML="";}if(_3f.contentNode){_3f.contentNode.innerHTML="";}_3f.loadingNode=_9(_3f.contentNode,"div.dgrid-loading");},renderRow:function(_40,_41){var _42=this,row=this.createRowCells("td",function(td,_43){var _44=_40,_45=_44;if(_43.get){_44=_43.get(_40);}else{if("field" in _43&&_43.field!=="_item"){_44=_44[_43.field];}}_45=_44;if(_43.prettyPrint){_45=_42.prettyPrint(_45);}if(_43.highlightText){if(_42.filterString){_45=_42.highlightText(_45,_42.filterString,"<strong>","</strong>");}}if(_43.linkUrl){if((null===_45||undefined===_45)||(""===_11.trim(""+_45))){_45=_43.defaultLabel||"-";}if(_43.linkUrl=="#"){_44="<a href='"+_43.linkUrl+"' onclick='return false;'>"+_45+"</a>";}else{if(_43.linkId){_44="<a href='"+_43.linkUrl+"/"+_40[_43.linkId]+"' >"+_45+"</a>";}else{_44="<a href='"+_43.linkUrl+"/"+_44+"'>"+_45+"</a>";}}}else{_44=_45;}if((null===_44)||(""===_44)){_44="-";}if(_43.formatter){td.innerHTML=_43.formatter(_44);}else{if(_43.renderCell){_16(td,_43.renderCell(_40,_44,td,_41));}else{if(_44!==null){td.innerHTML=_44;}}}},_41&&_41.subRows);return _9("div[role=row]>",row);},prettyPrint:function(str){console.warn("pretty print is deprecated, use java prettyprint tag");str=str.toUpperCase().replace(/[^\s]+/g,function(_46){if(_46.match(/^(M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})|[IDCXMLV])$/)){return _46;}return _46.substring(0,1)+_46.substring(1).toLowerCase();});return str;},highlightText:function(_47,key,_48,_49){var i;function _4a(str){return (!str||0===str.length);};_47=String(_47);if(_47!==null){if(!_4a(key)&&!_4a(_47)){if((_48===undefined)||(_49===undefined)){_48="<em>";_49="</em>";}i=_47.toLowerCase().indexOf(key.toLowerCase());if(i!==-1){_47=_47.split("");_47=Array.prototype.concat(_47.splice(0,i),_48,_47.splice(0,key.length),_49,_47).join("");}}}return _47;},buildRendering:function(){this.inherited(arguments);var _4b=this,idx=0;if(this.showFooter&&this.customFooter){if(this.customFooter.length<2&&this.customFooter[0].length<2){_6.place(this.customFooter[0][0],this.footerNode,"only");}else{_3.forEach(_4b.customFooter,function(_4c,_4d){idx=0;_4b.summaryTableNode=_4b.createRowCells("td",function(_4e,_4f){if(!_4b.customFooter[_4d]){return false;}if(_4b.customFooter[_4d][idx]){_4e.appendChild(_4b.customFooter[_4d][idx]);}else{_4e.appendChild(document.createTextNode(""));}idx+=1;});_4b.footerNode.appendChild(_4b.summaryTableNode);});}}},loadContent:function(){var _50=this;if(_50.contentNode){_50.showLoadingMessage();}if(_50.collection.loadData){_50.promise=_50.collection.loadData();_50.promise.then(function(){_50.refresh();});return _50.promise;}else{_50.refresh();}},_setCollection:function(_51,_52){if(this._renderedCollection){this.cleanup();this._cleanupCollection({shouldRevert:!_51||_51.storage!==this._renderedCollection.storage});}if(_51){var _53=_51;if(typeof (this.sort)==="function"||(this.sort&&this.sort.length>0)){_53=_51.sort(this.sort);}if(_53.track&&this.shouldTrackCollection){_53=_53.track();this._rows=[];this._observerHandle=this._observeCollection(_53,this.contentNode,{rows:this._rows});}this._renderedCollection=_53;}this.collection=_51;if(!this.promise){this.refresh();}else{if(this.promise&&this.promise.isFulfilled()){this.refresh();}}},cleanup:function(){this._setHeight();this.inherited(arguments);},_setStore:function(_54){this.store=_54;this._updateStore();this.set("collection",this.collection);},_setSort:function(_55,_56){var _57,_58,_59=this;if(typeof _55!=="string"){if(_55[0]!=null){_57=_55[0].property;_58=_55[0].descending;}}else{_57=_55;_58=_56;}if(_57!==undefined&&this.sortings[_57]){this.sort=function(){return _59.sortings[_57](arguments[0],arguments[1],_58);};this._applySort();this.updateSortArrow(_55,true);}else{this.inherited(arguments);}},_setHeight:function(){var _5a=this,_5b=_b.position(_5a.domNode,false),_5c="30px",_5d,_5e=_5a.collection.storage.fullData||(_5a.collection.objectStore?_5a.collection.objectStore.data:[]),_5f=_8("tr",_5a.bodyNode);if(_5f.length<0){return;}if(_5b.h===0&&this.showHeader){_5c="60px";_5d=_8(".dgrid-scroller",_5a.domNode)[0];_5.set(_5d,"marginTop","30px");}if(_5a.rowsPerPage>_5e.length&&_5a._currentPage>1){_7.set(_5a.domNode,"style","min-height: "+_5c+" !important;");}else{if(_5a._getTotal()===_5e.length&&!_5a.loadingNode){_7.set(_5a.domNode,"style","min-height:"+_5b.h+"px !important;");}else{_7.set(_5a.domNode,"style","min-height:"+_5c+"px !important;");_5b=_b.position(_5a.domNode,false);_7.set(_5a.domNode,"style","min-height:"+_5b.h+"px !important;");}}}});});