//>>built
define("oreilly/types/ui/PanelGroup",["dojo/_base/declare","dijit/_WidgetBase","dijit/_OnDijitClickMixin","dojox/dtl/_Templated","dijit/registry","dojo/on","dojo/dom-construct","dojo/dom-style","dojo/_base/connect","dojo/_base/array","./PanelItem","dojox/dtl/tag/logic","dojox/dtl/filter/dates","dojox/dtl/utils/date","dojox/date/php",],function(_1,_2,_3,_4,_5,on,_6,_7,_8,_9,_a,_b,_c,_d,_e){return _1("oreilly/types/ui/PanelGroup",[_2,_3,_4],{templateString:"<strong>Your Template Needs to Be Set</strong>",widgetsInTemplate:true,deliverableCount:0,numEntries:0,modes:{},value:[],toggleIntentList:function(_f){_7.set(this.entryList,"display",(this.entryList.children.length>0)?"block":"none");_7.set(this.noEntriesNode,"display",(this.entryList.children.length>0)?"none":"block");this.getParent().connectChildren();},_onAddEntryLinkClick:function(_10){this.addEntry(null,true);},addEntry:function(_11,_12){var _13={entryIndex:this.numEntries};if(!_11){_11={id:"",school:"",city:"",state:"",areaOfStudy:""};}var _14=new _a(dojo.mixin(_11,_13));_6.place(_14.domNode,this.entryList,"last");this.numEntries++;this.toggleIntentList(false);if(_12){this.collapseChildren(_14.id);_14.expand();}return _14;},removeEntry:function(_15){_6.destroy(_15.id);this.toggleIntentList(true);},collapseChildren:function(_16){_9.forEach(this.entryList.children,function(_17){var _18=_5.byId(_17.id);if((_16)&&(_18.id==_16)){}else{_18.collapse();}});}});});