//>>built
define("dgrid/extensions/_DnD-touch-autoscroll",["dojo/aspect","dojo/dom-geometry","dojo/dnd/autoscroll","../List"],function(_1,_2,_3,_4){var _5=_3.autoScrollNodes,_6,_7;_6={};_1.after(_4.prototype,"postCreate",function(r){var id=this.id;if(_6[id]){console.warn("dgrid instance registered with duplicate id \""+id+"\"");}_6[id]=this;return r;});_1.after(_4.prototype,"destroy",function(r){delete _6[this.id];return r;});_7=function(_8){var id,_9;while(_8){if((id=_8.id)&&(_9=_6[id])){return _9;}_8=_8.parentNode;}};_3.autoScrollNodes=function(_a){var _b=_a.target,_c=_7(_b),_d,_e,_f,_10,_11,dx,dy,_12,_13;if(_c){_b=_c.touchNode.parentNode;_d=_2.position(_b,true);_e=_a.pageX-_d.x;_f=_a.pageY-_d.y;_10=Math.min(_3.H_TRIGGER_AUTOSCROLL,_d.w/2);_11=Math.min(_3.V_TRIGGER_AUTOSCROLL,_d.h/2);if(_e<_10){dx=-_10;}else{if(_e>_d.w-_10){dx=_10;}}if(_f<_11){dy=-_11;}else{if(_f>_d.h-_11){dy=_11;}}if(dx||dy){_12=_c.getScrollPosition();_13={};if(dx){_13.x=_12.x+dx;}if(dy){_13.y=_12.y+dy;}_c.scrollTo(_13);return;}}_5.call(this,_a);};return _3;});