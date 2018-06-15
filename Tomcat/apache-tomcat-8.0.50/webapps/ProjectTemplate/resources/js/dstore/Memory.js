//>>built
define("dstore/Memory",["dojo/_base/declare","dojo/_base/lang","dojo/_base/array","./Store","./Promised","./SimpleQuery","./QueryResults"],function(_1,_2,_3,_4,_5,_6,_7){return _1([_4,_5,_6],{constructor:function(){this.storage.version=0;},postscript:function(){this.inherited(arguments);this.setData(this.data||[]);},data:null,autoEmitEvents:false,getSync:function(id){return this.storage.fullData[this.storage.index[id]];},putSync:function(_8,_9){_9=_9||{};var _a=this.storage,_b=_a.index,_c=_a.fullData;var _d=this.Model;if(_d&&!(_8 instanceof _d)){_8=this._restore(_8);}var id=this.getIdentity(_8);if(id==null){this._setIdentity(_8,("id" in _9)?_9.id:Math.random());id=this.getIdentity(_8);}_a.version++;var _e=id in _b?"update":"add",_f={target:_8},_10,_11;if(_e==="update"){if(_9.overwrite===false){throw new Error("Object already exists");}else{_c.splice(_10=_b[id],1);_11=_10;}}else{_11=this.defaultNewToStart?0:_c.length;}var _12;if("beforeId" in _9){var _13=_9.beforeId;if(_13===null){_12=_c.length;}else{_12=_b[_13];if(_10<_12){--_12;}}if(_12!==undefined){_f.beforeId=_13;}else{console.error("options.beforeId was specified but no corresponding index was found");_12=_11;}}else{_12=_11;}_c.splice(_12,0,_8);var i=isFinite(_10)?Math.min(_10,_12):_12;for(var l=_c.length;i<l;++i){_b[this.getIdentity(_c[i])]=i;}this.emit(_e,_f);return _8;},addSync:function(_14,_15){(_15=_15||{}).overwrite=false;return this.putSync(_14,_15);},removeSync:function(id){var _16=this.storage;var _17=_16.index;var _18=_16.fullData;if(id in _17){var _19=_18.splice(_17[id],1)[0];this._reindex();this.emit("delete",{id:id,target:_19});return true;}},setData:function(_1a){if(this.parse){_1a=this.parse(_1a);}if(_1a.items){this.idProperty=_1a.identifier||this.idProperty;_1a=_1a.items;}var _1b=this.storage;_1b.fullData=this.data=_1a;this._reindex();},_reindex:function(){var _1c=this.storage;var _1d=_1c.index={};var _1e=_1c.fullData;var _1f=this.Model;var _20=Object.prototype;for(var i=0,l=_1e.length;i<l;i++){var _21=_1e[i];if(_1f&&!(_21 instanceof _1f)){var _22=this._restore(_21,_21.__proto__===_20);if(_21!==_22){_1e[i]=_21=_22;}}_1d[this.getIdentity(_21)]=i;}_1c.version++;},fetchSync:function(){var _23=this.data;if(!_23||_23._version!==this.storage.version){_23=this.storage.fullData;var _24=this.queryLog;for(var i=0,l=_24.length;i<l;i++){_23=_24[i].querier(_23);}_23._version=this.storage.version;this.data=_23;}return new _7(_23);},fetchRangeSync:function(_25){var _26=this.fetchSync(),_27=_25.start,end=_25.end;return new _7(_26.slice(_27,end),{totalLength:_26.length});},_includePropertyInSubCollection:function(_28){return _28!=="data"&&this.inherited(arguments);}});});