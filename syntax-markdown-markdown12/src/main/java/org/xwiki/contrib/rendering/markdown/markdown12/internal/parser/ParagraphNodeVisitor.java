/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.contrib.rendering.markdown.markdown12.internal.parser;

import java.util.Collections;
import java.util.Deque;

import org.xwiki.rendering.listener.Listener;

import com.vladsch.flexmark.ast.NodeVisitor;
import com.vladsch.flexmark.ast.Paragraph;
import com.vladsch.flexmark.ast.VisitHandler;
import com.vladsch.flexmark.ast.Visitor;

/**
 * Handle paragraph events.
 *
 * @version $Id$
 * @since 8.4
 */
public class ParagraphNodeVisitor extends AbstractNodeVisitor
{
    static <V extends ParagraphNodeVisitor> VisitHandler<?>[] VISIT_HANDLERS(final V visitor)
    {
        return new VisitHandler<?>[]{
                new VisitHandler<>(Paragraph.class, new Visitor<Paragraph>()
                {
                    @Override
                    public void visit(Paragraph node)
                    {
                        visitor.visit(node);
                    }
                })
        };
    }

    public ParagraphNodeVisitor(NodeVisitor visitor, Deque<Listener> listeners)
    {
        super(visitor, listeners);
    }

    public void visit(Paragraph node)
    {
        getListener().beginParagraph(Collections.EMPTY_MAP);
        getVisitor().visitChildren(node);
        getListener().endParagraph(Collections.EMPTY_MAP);

    }
}
