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
package org.exist.messaging.shared;

import java.util.Properties;

import org.exist.dom.StoredNode;
import org.exist.memtree.DocumentBuilderReceiver;
import org.exist.numbering.NodeId;
import org.exist.storage.DBBroker;
import org.exist.xquery.XPathException;
import org.exist.xquery.value.AtomicValue;
import org.exist.xquery.value.Item;
import org.exist.xquery.value.Sequence;

import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

/**
 * Container wrapper for the eXistMessage object.
 *
 * @author Dannes Wessels
 */
public class eXistMessageItem implements Item {

    private eXistMessage data = null;

    public eXistMessage getData() {
        return data;
    }

    public void setData(eXistMessage data) {
        this.data = data;
    }

    @Override
    public int getType() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public String getStringValue() throws XPathException {
        if (data != null) {
            return data.getPayload().toString();
        }
        return null;
    }

    @Override
    public Sequence toSequence() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public AtomicValue convertTo(int requiredType) throws XPathException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public AtomicValue atomize() throws XPathException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void toSAX(DBBroker broker, ContentHandler handler, Properties properties) throws SAXException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void copyTo(DBBroker broker, DocumentBuilderReceiver receiver) throws SAXException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public int conversionPreference(Class<?> javaClass) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public <T> T toJavaObject(Class<T> target) throws XPathException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void nodeMoved(NodeId oldNodeId, StoredNode newNode) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}