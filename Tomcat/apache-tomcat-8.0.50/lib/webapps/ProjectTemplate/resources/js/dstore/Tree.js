//>>built
define("dstore/Tree",["dojo/_base/declare"],function(_1){return _1(null,{constructor:function(){this.root=this;},mayHaveChildren:function(_2){return "hasChildren" in _2?_2.hasChildren:true;},getRootCollection:function(){return this.root.filter({parent:null});},getChildren:function(_3){return this.root.filter({parent:this.getIdentity(_3)});}});});