/*
 *  eXist Open Source Native XML Database
 *  Copyright (C) 2013 The eXist Project
 *  http://exist-db.org
 *
 *  This program is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU Lesser General Public License
 *  as published by the Free Software Foundation; either version 2
 *  of the License, or (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public
 *  License along with this library; if not, write to the Free Software
 *  Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.exist.messaging.xquery;

import org.exist.dom.QName;
import org.exist.messaging.receive.ReceiversManager;
import org.exist.xquery.*;
import org.exist.xquery.value.*;

/**
 *  Implementation of the jms:list() function. Provides information about the receivers.
 * 
 * @author Dannes Wessels
 */
public class ListReceivers extends BasicFunction {
    
 public final static FunctionSignature signatures[] = {

        new FunctionSignature(
            new QName("list", MessagingModule.NAMESPACE_URI, MessagingModule.PREFIX),
            "Retrieve sequence of reciever IDs",
            new SequenceType[]{
                          // no params              
            },
            new FunctionReturnSequenceType(Type.STRING, Cardinality.ZERO_OR_MORE, "Sequence of receiver IDs")
        ),
        
    };

    public ListReceivers(XQueryContext context, FunctionSignature signature) {
        super(context, signature);
    }

    @Override
    public Sequence eval(Sequence[] args, Sequence contextSequence) throws XPathException {
    
        // Get object that manages the receivers
        ReceiversManager manager = ReceiversManager.getInstance();
        
        // Conten holfer results
        ValueSequence returnSequence = new ValueSequence();
        
        // Collect IDs
        for(String id : manager.getIds()){
            returnSequence.add( new StringValue(id) );
        }
        
        // Return IDs
        return returnSequence;
    }
    
}