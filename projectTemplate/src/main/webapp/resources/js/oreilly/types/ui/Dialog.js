//>>built
define("oreilly/types/ui/Dialog",["dojo/_base/declare","dijit/Dialog","dojo/when"],function(_1,_2,_3){"use strict";return _1("oreilly/types/ui/Dialog",[_2],{draggable:false,refreshOnShow:true,resetOnClose:true,destroyOnClose:false,hideOnBlur:true,onBlur:function(){if(this.resetOnClose){this.reset();}if(!this.hideOnBlur){return;}var _4=this;this.hide();if(this.destroyOnClose){if(this._fadeOutDeferred){_3(this._fadeOutDeferred.promise,function(){_4.destroyRecursive();});}else{_4.destroyRecursive();}}},loadingMessage:"<div class='dijitContentPaneLoading dialog-spinning' style='width: 300px; height: 200px;'>&nbsp;</div>"});});