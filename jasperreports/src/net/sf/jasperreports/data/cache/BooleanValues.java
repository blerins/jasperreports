/*
 * JasperReports - Free Java Reporting Library.
 * Copyright (C) 2001 - 2011 Jaspersoft Corporation. All rights reserved.
 * http://www.jaspersoft.com
 *
 * Unless you have purchased a commercial license agreement from Jaspersoft,
 * the following license terms apply:
 *
 * This program is part of JasperReports.
 *
 * JasperReports is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JasperReports is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with JasperReports. If not, see <http://www.gnu.org/licenses/>.
 */
package net.sf.jasperreports.data.cache;

import java.io.Serializable;

/**
 * @author Lucian Chirita (lucianc@users.sourceforge.net)
 * @version $Id$
 */
public class BooleanValues implements ColumnValues, Serializable
{

	private final int size;
	private final ColumnValues longValues;

	public BooleanValues(int size, ColumnValues longValues)
	{
		this.size = size;
		this.longValues = longValues;
	}

	public int size()
	{
		return size;
	}

	public ColumnValuesIterator iterator()
	{
		return new BooleanIterator();
	}

	protected class BooleanIterator implements ColumnValuesIterator
	{
		private final ColumnValuesIterator longIterator;
		private int index;
		private long currentLong;

		public BooleanIterator()
		{
			longIterator = longValues.iterator();
			index = -1;
			currentLong = 0;
		}

		public void moveFirst()
		{
			longIterator.moveFirst();
			index = -1;
			currentLong = 0;
		}

		public boolean next()
		{
			if (index + 1 >= size)
			{
				return false;
			}
			
			++index;
			if ((index & 0x3F) == 0)
			{
				if (!longIterator.next())
				{
					throw new IllegalStateException();
				}
				
				currentLong = ((Number) longIterator.get()).longValue();
			}
			
			return true;
		}

		public Object get()
		{
			return (currentLong & (1L << index)) != 0;
		}
	
	}
}
