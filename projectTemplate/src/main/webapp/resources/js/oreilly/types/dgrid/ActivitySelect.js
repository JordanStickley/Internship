//>>built
define("oreilly/types/dgrid/ActivitySelect",["dojo/_base/declare","dijit/form/FilteringSelect","dijit/registry","dojo/on"],function(_1,_2,_3,on){return _1("oreilly.types.dgrid.ActivitySelect",[_2],{gridId:"",hasDownArrow:true,pageSize:6,value:true,constructor:function(_4){this.inherited(arguments);dojo.mixin(this,_4);on(this,"change",function(_5){var _6=_3.byId(this.gridId);var _7=_5=="true";_6.clientQueryParameters["active"]=_7;_6.refresh();});}});});