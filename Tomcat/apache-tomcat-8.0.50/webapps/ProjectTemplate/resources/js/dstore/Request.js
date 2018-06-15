//>>built
define("dstore/Request",["dojo/request","dojo/_base/lang","dojo/_base/array","dojo/json","dojo/_base/declare","./Store","./QueryResults"],function(_1,_2,_3,_4,_5,_6,_7){var _8=[].push;return _5(_6,{constructor:function(){this.headers||(this.headers={});this._targetContainsQueryString=this.target.lastIndexOf("?")>=0;},headers:{},parse:_4.parse,target:"",ascendingPrefix:"+",descendingPrefix:"-",accepts:"application/json",fetch:function(){var _9=this._request();return new _7(_9.data,{response:_9.response});},fetchRange:function(_a){var _b=_a.start,_c=_a.end,_d={};if(this.useRangeHeaders){_d.headers=this._renderRangeHeaders(_b,_c);}else{_d.queryParams=this._renderRangeParams(_b,_c);}var _e=this._request(_d);return new _7(_e.data,{totalLength:_e.total,response:_e.response});},_request:function(_f){_f=_f||{};var _10=_2.delegate(this.headers,{Accept:this.accepts});if("headers" in _f){_2.mixin(_10,_f.headers);}var _11=this._renderQueryParams(),_12=this.target;if("queryParams" in _f){_8.apply(_11,_f.queryParams);}if(_11.length>0){_12+=(this._targetContainsQueryString?"&":"?")+_11.join("&");}var _13=_1(_12,{method:"GET",headers:_10});var _14=this;return {data:_13.then(function(_15){var _16=_14.parse(_15);_16=_16.items||_16;for(var i=0,l=_16.length;i<l;i++){_16[i]=_14._restore(_16[i],true);}return _16;}),total:_13.response.then(function(_17){var _18=_17.data.total;if(_18>-1){return _18;}var _19=_17.getHeader("Content-Range");return _19&&(_19=_19.match(/\/(.*)/))&&+_19[1];}),response:_13.response};},_renderFilterParams:function(_1a){var _1b=_1a.type;var _1c=_1a.args;if(!_1b){return [""];}if(_1b==="string"){return [_1c[0]];}if(_1b==="and"||_1b==="or"){return [_3.map(_1a.args,function(arg){var _1d=this._renderFilterParams(arg);return ((arg.type==="and"||arg.type==="or")&&arg.type!==_1b)?"("+_1d+")":_1d;},this).join(_1b==="and"?"&":"|")];}return [encodeURIComponent(_1c[0])+"="+(_1b==="eq"?"":_1b+"=")+encodeURIComponent(_1c[1])];},_renderSortParams:function(_1e){var _1f=_3.map(_1e,function(_20){var _21=_20.descending?this.descendingPrefix:this.ascendingPrefix;return _21+encodeURIComponent(_20.property);},this);var _22=[];if(_1f){_22.push(this.sortParam?encodeURIComponent(this.sortParam)+"="+_1f:"sort("+_1f+")");}return _22;},_renderRangeParams:function(_23,end){var _24=[];if(this.rangeStartParam){_24.push(this.rangeStartParam+"="+_23,this.rangeCountParam+"="+(end-_23));}else{_24.push("limit("+(end-_23)+(_23?(","+_23):"")+")");}return _24;},_renderQueryParams:function(){var _25=[];_3.forEach(this.queryLog,function(_26){var _27=_26.type,_28="_render"+_27[0].toUpperCase()+_27.substr(1)+"Params";if(this[_28]){_8.apply(_25,this[_28].apply(this,_26.normalizedArguments));}else{console.warn("Unable to render query params for \""+_27+"\" query",_26);}},this);return _25;},_renderUrl:function(){var _29=this._renderQueryParams();var url=this.target;if(_29.length>0){url+="?"+_29.join("&");}return url;},_renderRangeHeaders:function(_2a,end){var _2b="items="+_2a+"-"+(end-1);return {"Range":_2b,"X-Range":_2b};}});});