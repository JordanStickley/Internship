//>>built
define("bootstrap/Tab",["dojo/_base/declare","dojo/query","dojo/_base/lang","dojo/_base/window","dojo/on","dojo/dom-class","dojo/dom-attr","./Support","dojo/NodeList-dom","dojo/NodeList-traverse","dojo/domReady!"],function(_1,_2,_3,_4,on,_5,_6,_7){"use strict";var _8="[data-toggle=tab], [data-toggle=pill]";var _9=_1([],{constructor:function(_a){this.domNode=_a;},show:function(e){var _b=this;var ul=_2(this.domNode).closest("ul:not(.dropdown-menu)");var li=_2(this.domNode).parent("li")[0];if(li&&_5.contains(li,"active")){return;}var _c=_2(".active a",ul[0]).last()[0];on.emit(this.domNode,"show.bs.tab",{bubbles:false,cancelable:false,relatedTarget:_c});if(e&&e.defaultPrevented){return;}if(li&&!_5.contains(li,"active")){this.activate(li,ul[0]);}var _d=_6.get(this.domNode,"data-target");if(!_d){_d=_7.hrefValue(this.domNode);}var _e;if(_d&&_d!=="#"&&_d!==""){_e=_2(_d);if(_e[0]&&_e.parent()[0]){this.activate(_e[0],_e.parent()[0],function(){on.emit(_b.domNode,"shown.bs.tab",{bubbles:false,cancelable:false,relatedTarget:_c});});}}},activate:function(_f,_10,_11){var _12=_2("> .active",_10)[0];var _13=_11&&_7.trans&&_12&&_5.contains(_12,"fade");function _14(){if(_12){_5.remove(_12,"active");_2("> .dropdown-menu > .active",_12).removeClass("active");}_5.add(_f,"active");if(_13){_f.offsetWidth;_5.add(_f,"in");}else{_5.remove(_f,"fade");}if(_2(_f).parent(".dropdown-menu")[0]){_2(_f).closest("li.dropdown").addClass("active");}if(_11){_11();}};if(_13){on.once(_12,_7.trans.end,_14);}else{_14();}if(_12){_5.remove(_12,"in");}}});_3.extend(_2.NodeList,{tab:function(_15){return this.forEach(function(_16){var _17=_7.getData(_16,"tab");if(!_17){_7.setData(_16,"tab",(_17=new _9(_16)));}if(_3.isString(_15)){_17[_15].call(_17);}});}});on(_4.body(),on.selector(_8,"click"),function(e){if(e){e.preventDefault();}_2(this).tab("show");});return _9;});