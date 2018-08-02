//>>built
define("dstore/legacy/DstoreAdapter",["dojo/_base/declare","dojo/_base/array","dojo/store/util/QueryResults"],function(_1,_2,_3){function _4(_5){return _5;};var _6=null;var _7={store:null,constructor:function(_8){this.store=_8;if(_8._getQuerierFactory("filter")||_8._getQuerierFactory("sort")){this.queryEngine=function(_9,_a){_a=_a||{};var _b=_8._getQuerierFactory("filter");var _c=_b?_b(_9):_4;var _d=_8._getQuerierFactory("sort");var _e=_4;if(_d){_e=_d(_2.map(_a.sort,function(_f){return {property:_f.attribute,descending:_f.descending};}));}var _10=_4;if(!isNaN(_a.start)||!isNaN(_a.count)){_10=function(_11){var _12=_a.start||0,_13=_a.count||Infinity;var _14=_11.slice(_12,_12+_13);_14.total=_11.length;return _14;};}return function(_15){return _10(_e(_c(_15)));};};}var _16=this;_8.on("add,update,delete",function(_17){var _18=_17.type;var _19=_17.target;_16.notify((_18==="add"||_18==="update")?_19:undefined,(_18==="delete"||_18==="update")?("id" in _17?_17.id:_8.getIdentity(_19)):undefined);});},query:function(_1a,_1b){_1b=_1b||{};var _1c=this.store.filter(_1a);var _1d;var _1e=_1b.sort;if(_1e){if(Object.prototype.toString.call(_1e)==="[object Array]"){var _1f;while((_1f=_1e.pop())){_1c=_1c.sort(_1f.attribute,_1f.descending);}}else{_1c=_1c.sort(_1e);}}var _20;if(_1c.track&&!_1c.tracking){_1c=_1c.track();_20=true;}if("start" in _1b){var _21=_1b.start||0;_1d=_1c[_1c.fetchRangeSync?"fetchRangeSync":"fetchRange"]({start:_21,end:_1b.count?(_21+_1b.count):Infinity});_1d.total=_1d.totalLength;}_1d=_1d||new _3(_1c[_1c.fetchSync?"fetchSync":"fetch"]());_1d.observe=function(_22,_23){function _24(_25){if(_25===undefined&&_20){return -1;}return _25;};var _26=_1c.on("add",function(_27){_22(_27.target,-1,_24(_27.index));});var _28=_1c.on("update",function(_29){if(_23||_29.previousIndex!==_29.index||!isFinite(_29.index)){_22(_29.target,_24(_29.previousIndex),_24(_29.index));}});var _2a=_1c.on("delete",function(_2b){_22(_2b.target,_24(_2b.previousIndex),-1);});var _2c={remove:function(){_26.remove();_28.remove();_2a.remove();}};_2c.cancel=_2c.remove;return _2c;};return _1d;},notify:function(){}};var _2d=["get","put","add","remove","getIdentity"];_2.forEach(_2d,function(_2e){_7[_2e]=function(){var _2f=this.store;return (_2f[_2e+"Sync"]||_2f[_2e]).apply(_2f,arguments);};});return _1(_6,_7);});