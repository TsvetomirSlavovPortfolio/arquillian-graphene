/**
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
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
package org.jboss.arquillian.graphene.spi.enricher;

import java.lang.reflect.Method;

import org.openqa.selenium.SearchContext;

/**
 * The test enricher taking account there is {@link SearchContext} linked to the enriched object. Usually the
 * {@link SearchContext} is given by {@link org.openqa.selenium.WebDriver} or {@link org.openqa.selenium.WebElement} instance.
 *
 * @author <a href="mailto:jhuska@redhat.com">Juraj Huska</a>
 * @author <a href="mailto:jpapouse@redhat.com">Jan Papousek</a>
 * @author <a href="mailto:mjobanek@redhat.com">Matous Jobanek</a>
 */
public interface SearchContextTestEnricher {

    /**
     * Performs enrichment on the given object with the given {@link SearchContext}.
     *
     * @param searchContext the context which should be used for enrichment
     * @param target instance to be enriched
     */
    void enrich(SearchContext searchContext, Object target);

    /**
     * Performs resolve for the given method with the given {@link SearchContext}.
     * @param searchContext the context which should be used for resolve
     * @param method method to be resolved
     * @param resolvedParams parameters that has (not) been resolved so far
     */
    Object[] resolve(SearchContext searchContext, Method method, Object[] resolvedParams);

    /**
     * Returns the enricher precedence. Zero precedence is is the lowest one.
     */
    int getPrecedence();
}
