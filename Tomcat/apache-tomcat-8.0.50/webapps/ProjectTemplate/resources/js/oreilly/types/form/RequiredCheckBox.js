//>>built
define("oreilly/types/form/RequiredCheckBox",["dojo/_base/declare","dijit/form/CheckBox","dijit/Tooltip","dojo/dom-class","dojo/_base/array"],function(_1,_2,_3,_4,_5){return _1("oreilly.types.form.RequiredCheckBox",[_2],{message:"This field is required",tooltipPosition:[],startup:function(){this.inherited(arguments);this._determineState();},_determineState:function(_6){var _7=this.get("checked"),_8=_7?"":"Incomplete";this._set("state",_8);if(_6){if(_7){_3.hide(this.domNode);}else{if(this._hasBeenBlurred){_3.show(this.message,this.domNode,this.tooltipPosition,this.isLeftToRight());}}}},_onClick:function(_9){this.inherited(arguments);this._determineState(this.focused);},validate:function(){var _a=this.get("checked");this._determineState(true);return _a;}});});