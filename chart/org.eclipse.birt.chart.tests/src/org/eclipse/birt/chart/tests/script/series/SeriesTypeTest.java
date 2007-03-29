/*******************************************************************************
 * Copyright (c) 2006 Actuate Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Actuate Corporation  - initial API and implementation
 *******************************************************************************/

package org.eclipse.birt.chart.tests.script.series;

import org.eclipse.birt.chart.script.api.IChart;
import org.eclipse.birt.chart.script.api.IChartWithAxes;
import org.eclipse.birt.chart.script.api.component.IValueSeries;
import org.eclipse.birt.chart.script.api.series.IStock;
import org.eclipse.birt.chart.script.api.series.data.IStockData;
import org.eclipse.birt.chart.tests.script.BaseChartTestCase;

/**
 * 
 */

public class SeriesTypeTest extends BaseChartTestCase
{

	public void testStockSeries( )
	{
		IChart ichart = null;
		try
		{
			ichart = (IChart) getReportDesign( ).getReportElement( "Stock" );
		}
		catch ( Exception e )
		{
			e.printStackTrace( );
		}
		assertTrue( ichart instanceof IChartWithAxes );

		IValueSeries series = ( (IChartWithAxes) ichart ).getValueSeries( )[0][0];
		assertTrue( series instanceof IStock );

		IStock stock = (IStock) series;
		assertTrue( stock.getDataExpr( ) instanceof IStockData );

		IStockData data = (IStockData) stock.getDataExpr( );
		assertEquals( data.getHighExpr( ), "" );
		assertEquals( data.getLowExpr( ), "2" );

		data.setOpenExpr( "3" );
		assertEquals( data.getOpenExpr( ), "3" );
	}

}
