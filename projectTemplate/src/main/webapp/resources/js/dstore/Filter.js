//>>built
define("dstore/Filter",["dojo/_base/declare"],function(_1){function _2(_3){return function newFilter(){var _4=this.constructor;var _5=new _4();_5.type=_3;_5.args=arguments;if(this.type){return _2("and").call(_4.prototype,this,_5);}return _5;};};var _6=_1(null,{constructor:function(_7){var _8=typeof _7;switch(_8){case "object":var _9=this;for(var _a in _7){var _b=_7[_a];if(_b instanceof this.constructor){_9=_9[_b.type](_a,_b.args[0]);}else{if(_b&&_b.test){_9=_9.match(_a,_b);}else{_9=_9.eq(_a,_b);}}}this.type=_9.type;this.args=_9.args;break;case "function":case "string":this.type=_8;this.args=[_7];}},and:_2("and"),or:_2("or"),eq:_2("eq"),ne:_2("ne"),lt:_2("lt"),lte:_2("lte"),gt:_2("gt"),gte:_2("gte"),"in":_2("in"),match:_2("match")});_6.filterCreator=_2;return _6;});