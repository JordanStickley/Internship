//>>built
define("dgrid/Grid",["dojo/_base/declare","dojo/_base/kernel","dojo/on","dojo/has","put-selector/put","./List","./util/misc","dojo/_base/sniff"],function(_1,_2,_3,_4,_5,_6,_7){function _8(_9,_a){if(_a&&_a.nodeType){_9.appendChild(_a);}};function _b(_c){return _7.escapeCssIdentifier(_c,"-");};var _d=_1(_6,{columns:null,cellNavigation:true,tabableHeader:true,showHeader:true,column:function(_e){if(typeof _e!=="object"){return this.columns[_e];}else{return this.cell(_e).column;}},listType:"grid",cell:function(_f,_10){if(_f.column&&_f.element){return _f;}if(_f.target&&_f.target.nodeType){_f=_f.target;}var _11;if(_f.nodeType){do{if(this._rowIdToObject[_f.id]){break;}var _12=_f.columnId;if(_12){_10=_12;_11=_f;break;}_f=_f.parentNode;}while(_f&&_f!==this.domNode);}if(!_11&&typeof _10!=="undefined"){var row=this.row(_f),_13=row&&row.element;if(_13){var _14=_13.getElementsByTagName("td");for(var i=0;i<_14.length;i++){if(_14[i].columnId===_10){_11=_14[i];break;}}}}if(_f!=null){return {row:row||this.row(_f),column:_10&&this.column(_10),element:_11};}},createRowCells:function(tag,_15,_16,_17){var row=_5("table.dgrid-row-table[role=presentation]"),_18=(_4("ie")<9)?_5(row,"tbody"):row,tr,si,sl,i,l,_19,_1a,id,_1b,_1c,_1d,_1e,_1f;_16=_16||this.subRows;for(si=0,sl=_16.length;si<sl;si++){_19=_16[si];tr=_5(_18,"tr");if(_19.className){_5(tr,"."+_19.className);}for(i=0,l=_19.length;i<l;i++){_1a=_19[i];id=_1a.id;_1b=_1a.field?".field-"+_b(_1a.field):"";_1c=typeof _1a.className==="function"?_1a.className(_17):_1a.className;if(_1c){_1b+="."+_1c;}_1d=_5(tag+".dgrid-cell"+(id?".dgrid-column-"+_b(id):"")+_1b.replace(/ +/g,".")+"[role="+(tag==="th"?"columnheader":"gridcell")+"]");_1d.columnId=id;_1e=_1a.colSpan;if(_1e){_1d.colSpan=_1e;}_1f=_1a.rowSpan;if(_1f){_1d.rowSpan=_1f;}_15(_1d,_1a);tr.appendChild(_1d);}}return row;},left:function(_20,_21){if(!_20.element){_20=this.cell(_20);}return this.cell(this._move(_20,-(_21||1),"dgrid-cell"));},right:function(_22,_23){if(!_22.element){_22=this.cell(_22);}return this.cell(this._move(_22,_23||1,"dgrid-cell"));},_defaultRenderCell:function(_24,_25,td){if(this.formatter){var _26=this.formatter,_27=this.grid.formatterScope;td.innerHTML=typeof _26==="string"&&_27?_27[_26](_25,_24):this.formatter(_25,_24);}else{if(_25!=null){td.appendChild(document.createTextNode(_25));}}},renderRow:function(_28,_29){var _2a=this;var row=this.createRowCells("td",function(td,_2b){var _2c=_28;if(_2b.get){_2c=_2b.get(_28);}else{if("field" in _2b&&_2b.field!=="_item"){_2c=_2c[_2b.field];}}if(_2b.renderCell){_8(td,_2b.renderCell(_28,_2c,td,_29));}else{_2a._defaultRenderCell.call(_2b,_28,_2c,td,_29);}},_29&&_29.subRows,_28);return _5("div[role=row]>",row);},renderHeader:function(){var _2d=this,_2e=this.headerNode,i=_2e.childNodes.length;_2e.setAttribute("role","row");while(i--){_5(_2e.childNodes[i],"!");}var row=this.createRowCells("th",function(th,_2f){var _30=_2f.headerNode=th;var _31=_2f.field;if(_31){th.field=_31;}if(_2f.renderHeaderCell){_8(_30,_2f.renderHeaderCell(_30));}else{if("label" in _2f||_2f.field){_30.appendChild(document.createTextNode("label" in _2f?_2f.label:_2f.field));}}if(_2f.sortable!==false&&_31&&_31!=="_item"){th.sortable=true;th.className+=" dgrid-sortable";}},this.subRows&&this.subRows.headerRows);this._rowIdToObject[row.id=this.id+"-header"]=this.columns;_2e.appendChild(row);if(this._sortListener){this._sortListener.remove();}this._sortListener=_3(row,"click,keydown",function(_32){if(_32.type==="click"||_32.keyCode===32||(!_4("opera")&&_32.keyCode===13)){var _33=_32.target,_34,_35,_36,_37;do{if(_33.sortable){_36=[{property:(_34=_33.field||_33.columnId),descending:(_35=_2d.sort[0])&&_35.property===_34&&!_35.descending}];_37={bubbles:true,cancelable:true,grid:_2d,parentType:_32.type,sort:_36};if(_3.emit(_32.target,"dgrid-sort",_37)){_2d._sortNode=_33;_2d.set("sort",_36);}break;}}while((_33=_33.parentNode)&&_33!==_2e);}});},resize:function(){var _38=this.headerNode.firstChild,_39=this.contentNode,_3a;this.inherited(arguments);_39.style.width="";if(_39&&_38){if((_3a=_38.offsetWidth)>_39.offsetWidth){_39.style.width=_3a+"px";}}},destroy:function(){this._destroyColumns();if(this._sortListener){this._sortListener.remove();}this.inherited(arguments);},_setSort:function(){this.inherited(arguments);this.updateSortArrow(this.sort);},_findSortArrowParent:function(_3b){var _3c=this.columns;for(var i in _3c){var _3d=_3c[i];if(_3d.field===_3b){return _3d.headerNode;}}},updateSortArrow:function(_3e,_3f){if(this._lastSortedArrow){_5(this._lastSortedArrow,"<!dgrid-sort-up!dgrid-sort-down");_5(this._lastSortedArrow,"!");delete this._lastSortedArrow;}if(_3f){this.sort=_3e;}if(!_3e[0]){return;}var _40=_3e[0].property,_41=_3e[0].descending,_42=this._sortNode||this._findSortArrowParent(_40),_43;delete this._sortNode;if(_42){_42=_42.contents||_42;_43=this._lastSortedArrow=_5("div.dgrid-sort-arrow.ui-icon[role=presentation]");_43.innerHTML="&nbsp;";_42.insertBefore(_43,_42.firstChild);_5(_42,_41?".dgrid-sort-down":".dgrid-sort-up");this.resize();}},styleColumn:function(_44,css){return this.addCssRule("#"+_7.escapeCssIdentifier(this.domNode.id)+" .dgrid-column-"+_b(_44),css);},_configColumns:function(_45,_46){var _47=[],_48=_46 instanceof Array;function _49(_4a,_4b){if(typeof _4a==="string"){_46[_4b]=_4a={label:_4a};}if(!_48&&!_4a.field){_4a.field=_4b;}_4b=_4a.id=_4a.id||(isNaN(_4b)?_4b:(_45+_4b));if(this._configColumn){this._configColumn(_4a,_46,_45);_4b=_4a.id;}if(_48){this.columns[_4b]=_4a;}_4a.grid=this;if(typeof _4a.init==="function"){_2.deprecated("colum.init","Column plugins are being phased out in favor of mixins for better extensibility. "+"column.init may be removed in a future release.");_4a.init();}_47.push(_4a);};_7.each(_46,_49,this);return _48?_46:_47;},_destroyColumns:function(){var _4c=this.subRows,_4d=_4c&&_4c.length,i,j,_4e,len;this.cleanup();for(i=0;i<_4d;i++){for(j=0,len=_4c[i].length;j<len;j++){_4e=_4c[i][j];if(typeof _4e.destroy==="function"){_2.deprecated("colum.destroy","Column plugins are being phased out in favor of mixins for better extensibility. "+"column.destroy may be removed in a future release.");_4e.destroy();}}}},configStructure:function(){var _4f=this.subRows,_50=this._columns=this.columns;this.columns=!_50||_50 instanceof Array?{}:_50;if(_4f){for(var i=0;i<_4f.length;i++){_4f[i]=this._configColumns(i+"-",_4f[i]);}}else{this.subRows=[this._configColumns("",_50)];}},_getColumns:function(){return this._columns||this.columns;},_setColumns:function(_51){this._destroyColumns();this.subRows=null;this.columns=_51;this._updateColumns();},_setSubRows:function(_52){this._destroyColumns();this.subRows=_52;this._updateColumns();},_updateColumns:function(){this.configStructure();this.renderHeader();this.refresh();this._lastCollection&&this.renderArray(this._lastCollection);if(this._started){if(this.sort.length){this.updateSortArrow(this.sort);}else{this.resize();}}}});_d.appendIfNode=_8;return _d;});