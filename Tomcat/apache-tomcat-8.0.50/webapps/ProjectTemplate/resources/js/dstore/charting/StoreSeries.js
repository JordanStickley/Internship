//>>built
define("dstore/charting/StoreSeries",["dojo/_base/lang","dojo/_base/declare","dojo/_base/array"],function(_1,_2,_3){return _2(null,{constructor:function(_4,_5){this.collection=_4.track?_4.track():_4;if(_5){if(typeof _5==="function"){this.value=_5;}else{if(typeof _5==="object"){this.value=function(_6){var o={};for(var _7 in _5){o[_7]=_6[_5[_7]];}return o;};}else{this.value=function(_8){return _8[_5];};}}}else{this.value=function(_9){return _9.value;};}this.data=[];this._initialRendering=false;this.fetch();},destroy:function(){var _a=this.collection.tracking;_a&&_a.remove();},setSeriesObject:function(_b){this.series=_b;},fetch:function(){var _c=this.collection,_d=_1.hitch(this,this._update);_c.fetch().then(_1.hitch(this,function(_e){this.objects=_e;_d();if(_c.tracking){_c.on("add, update, delete",_d);}}));},_update:function(){var _f=this;this.data=_3.map(this.objects,function(_10){return _f.value(_10,_f.collection);});if(this.series){this.series.chart.updateSeries(this.series.name,this,this._initialRendering);this._initialRendering=false;this.series.chart.delayedRender();}}});});