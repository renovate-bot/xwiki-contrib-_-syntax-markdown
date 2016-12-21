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
package org.xwiki.contrib.rendering.markdown.commonmark027.internal.parser;

import javax.inject.Inject;
import javax.inject.Named;

import org.xwiki.contrib.rendering.markdown.common.internal.parser.AbstractMarkdownParser;
import org.xwiki.rendering.parser.StreamParser;
import org.xwiki.rendering.syntax.Syntax;
import org.xwiki.rendering.syntax.SyntaxType;

/**
 * Commons Mark 0.27 Parser.
 *
 * @version $Id$
 * @since 8.4
 */
@Named("commonmark/0.27")
public class CommonMark027Parser extends AbstractMarkdownParser
{
    // TODO: fix problem in RenderingTest.parseSyntax() which cannot guess the pretty name of a syntax from an id
    // and thus the CTS is failing. Idea: modify CTS to not check the pretty name.
    static final Syntax COMMONMARKDOWN_0_27 = new Syntax(new SyntaxType("commonmark", "commonmark"), "0.27");

    /**
     * Streaming Markdown Parser.
     */
    @Inject
    @Named("commonmark/0.27")
    private StreamParser commonMarkStreamParser;

    @Override
    protected StreamParser getMarkdownStreamParser()
    {
        return this.commonMarkStreamParser;
    }

    @Override
    public Syntax getSyntax()
    {
        return COMMONMARKDOWN_0_27;
    }
}
