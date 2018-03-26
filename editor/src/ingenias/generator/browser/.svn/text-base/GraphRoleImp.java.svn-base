/*
    Copyright (C) 2002 Jorge Gomez Sanz

    This file is part of INGENIAS IDE, a support tool for the INGENIAS
    methodology, availabe at http://grasia.fdi.ucm.es/ingenias or
    http://ingenias.sourceforge.net

    INGENIAS IDE is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    INGENIAS IDE is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with INGENIAS IDE; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

*/

package ingenias.generator.browser;

import java.util.*;
import org.jgraph.graph.*;

import ingenias.editor.IDEState;
import ingenias.editor.ModelJGraph;
import ingenias.editor.entities.*;
import ingenias.exception.NullEntity;

class GraphRoleImp extends AttributedElementImp implements GraphRole {

 private RoleEntity re;

 private Entity player;
 private ModelJGraph graph;
 private IDEState ids;

 GraphRoleImp(RoleEntity re,Entity player, ModelJGraph graph, IDEState ids){
   super(re,graph,ids);
   this.re=re;
   this.player=player;
   this.graph=graph;
   this.ids=ids;
   if (ids==null)
		throw new RuntimeException("The ids parameter cannot be null");
 }

  public GraphEntity getPlayer() throws NullEntity{
    return new GraphEntityImp(player,graph,ids);
  }


  public String getName(){
    return re.getType().substring(0,re.getType().length()-4);
  }

  public boolean equals(Object obj){
    if (obj instanceof GraphRoleImp){
      return ((GraphRoleImp)obj).player.equals(player);
    } else
     return super.equals(obj);
  }

}