//>>built
define("bootstrap/Marquee",["./Support","dojo/_base/declare","dojo/_base/lang","dojo/_base/array","dojo/_base/fx","dojo/query","dojo/on","dojo/Deferred","dojo/dom-class","dojo/dom-construct","dojo/dom-attr","dojo/dom-style","dojo/dom-geometry","dojo/NodeList-dom","dojo/NodeList-traverse","dojo/NodeList-manipulate","dojo/domReady!"],function(_1,_2,_3,_4,fx,_5,on,_6,_7,_8,_9,_a,_b){"use strict";var _c="[data-spy=marquee]";function _d(_e,_f){if(_f){return (_e.current-1<0)?_e.messages.length-1:_e.current-1;}else{return (_e.current+1>_e.messages.length-1)?0:_e.current+1;}};function _10(msg){var _11=_12(msg);fx.animateProperty({node:msg.domNode,properties:_11.trans_in,duration:0}).play();};function _13(msg){var _14=_12(msg);fx.animateProperty({node:msg.domNode,properties:_14.trans_out,duration:0}).play();};function _12(msg){return {trans_in:_15[msg.options.anim].trans_in(msg),trans_out:_15[msg.options.anim].trans_out(msg)};};var _16=_2([],{defaultOptions:{link:"",className:"",life:2,anim:"fade",duration:1},constructor:function(_17){this.options=_3.mixin(_3.clone(this.defaultOptions),(_17||{}));this.options.life=isNaN(this.options.life)?this.defaultOptions.life:Number(this.options.life);this.options.duration=isNaN(this.options.duration)?this.defaultOptions.duration:Number(this.options.duration);this.domNode=_8.toDom("<div>"+(_17.message||"")+"</div>");if(this.options.link!==""){var _18=_8.toDom("<a href=\""+this.options.link+"\">"+_17.message+"</a>");_5(this.domNode).html(_18);}_7.add(this.domNode,"marquee-item");if(this.options.className!==""){_7.add(this.domNode,this.options.className);}_8.place(this.domNode,_17.parent||document.body);this.parent=this.options.parent;this.dim={me:_b.position(this.domNode),up:_b.position(this.parent)};_13(this);}});var _19=_2([],{defaultOptions:{autostart:true,blend:false},constructor:function(_1a,_1b){this.options=_3.mixin(_3.clone(this.defaultOptions),(_1b||{}));this.domNode=_1a;this.messages=[];_7.add(this.domNode,"marquee");this.load(this.options.messages,this.options.autostart);},load:function(_1c,_1d){this.empty();this.add(_1c);on.emit(this.domNode,"loaded",{bubbles:false,cancelable:false});if(_1d&&_1d===true){this.start(this.current);}},add:function(_1e){if(_1e){if(_1e instanceof Array){_1e=_1e;}else{if(_3.isObject(_1e)){_1e=[_1e];}else{if(_3.isString(_1e)){_1e=[{message:_1e}];}else{return;}}}}else{return;}_4.forEach(_1e,function(msg){var _1f=_3.mixin(_3.clone(this.options),msg);_1f.parent=this.domNode;_4.forEach(["messages","startOnLoad","blend","toggle"],function(_20){delete _1f[_20];});this.messages.push(new _16(_1f));},this);},remove:function(i){if(this.current===i){this.next();}this.messages.splice(i,1);},clear:function(){this.stop(true);_13(this.messages[this.current]);},empty:function(){this.stop();_5(this.domNode).empty("");this.messages=[];this.current=0;},start:function(s){var _21=this;if(this.messages.length===0||this.running){return;}else{if(this.messages.length===1){_10(this.messages[0]);on.emit(_21.domNode,"changed",{bubbles:false,cancelable:false,currentIndex:0,currentMessage:this.messages[0]});}else{if(typeof s==="number"){this.clear();this.current=s;_10(this.messages[this.current]);}var _22=this.messages[this.current];var _23=_12(_22);var _24=_22.options.life;_21.lifeTime=window.setTimeout(function(){_21.running=true;function _25(){_21.current=_d(_21);var _26=_21.messages[_21.current];var _27=_12(_26);on.emit(_21.domNode,"before",{bubbles:false,cancelable:false,currentIndex:_21.current,currentMessage:_26});fx.animateProperty({node:_26.domNode,properties:_27.trans_in,duration:(_26.options.duration*1000),onEnd:function(){_21.running=false;on.emit(_21.domNode,"changed",{bubbles:false,cancelable:false,currentIndex:_21.current,currentMessage:_26});_21.start();}}).play();};fx.animateProperty({node:_22.domNode,properties:_23.trans_out,duration:(_22.options.duration*1000),onEnd:function(){on.emit(_21.domNode,"after",{bubbles:false,cancelable:false,currentIndex:_21.current,currentMessage:_22});return _21.options.blend||_25();}}).play();return _21.options.blend&&_25();},(_24*1000));}}},stop:function(q){this.running=false;if(this.lifeTime){window.clearTimeout(this.lifeTime);}if(q&&q===true){return;}on.emit(this.domNode,"stop",{bubbles:false,cancelable:false});},next:function(){return this.running||this.start(_d(this));},previous:function(){return this.running||this.start(_d(this,true));},first:function(){return this.running||this.start(0);},last:function(){return this.running||this.start(this.messages.length-1);}});_19.extend({animations:{"slide":{trans_in:function(msg){return {left:{start:msg.dim.up.w+1,end:0}};},trans_out:function(msg){return {left:{start:0,end:-1*(msg.dim.me.w+1)}};}},"scroll":{trans_in:function(msg){return {top:{start:msg.dim.up.h+1,end:0}};},trans_out:function(msg){return {top:{start:0,end:-1*(msg.dim.me.h+1)}};}},"fade":{trans_in:function(msg){return {opacity:{start:0,end:1}};},trans_out:function(msg){return {opacity:{start:1,end:0}};}}}});var _15=_19.prototype.animations;_3.extend(_5.NodeList,{marquee:function(_28,_29){var _2a=(_3.isObject(_28))?_28:{};return this.forEach(function(_2b){var _2c=_1.getData(_2b,"marquee");if(!_2c){_1.setData(_2b,"marquee",(_2c=new _19(_2b,_2a)));}if(_3.isString(_28)){_2c[_28].call(_2c,_29||"");}});}});_5(_c).forEach(function(_2d){var _2e=_1.getData(_2d);_2e.messages=[];_5("> *",_2d).forEach(function(_2f){var _30=_1.getData(_2f)||{};_30.message=_2f.innerHTML;if(_2f.className!==""){_30.className=_2f.className;}_2e.messages.push(_30);});_1.setData(_2d,"marquee",new _19(_2d,_2e));});return _19;});