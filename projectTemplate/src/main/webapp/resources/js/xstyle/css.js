//>>built
define("xstyle/css",["require"],function(_1){"use strict";var _2=window.cssCache||(window.cssCache={});return {load:function(_3,_4,_5,_6){var _7=_4.toUrl(_3);if(_2[_7]){return createStyleSheet(_2[_7]);}var _8=document.documentElement;var _9=_8.insertBefore(document.createElement("div"),_8.firstChild);_9.id=_4.toAbsMid(_3).replace(/\//g,"-").replace(/\..*/,"")+"-loaded";var _a=(_9.currentStyle||getComputedStyle(_9,null));if(_a){_a=_a.display;}_8.removeChild(_9);if(_a=="none"){return _5();}_1(["./load-css"],function(_b){_b(_7,_5);});},pluginBuilder:"xstyle/css-builder"};});