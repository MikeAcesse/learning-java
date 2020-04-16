<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"  xmlns:test="http://www.info2soft.com/qa/framework/junit/schema" >
	<xsl:output method="html"/>
	<xsl:template name="Root" match="/test:report">
		<html>
			<xsl:call-template name="html-head"/>
			<!--xsl:call-template name="javascript"/-->
			<body link="663300" alink="#FF6600" vlink="#996633" bgcolor="#ffffff">
				<xsl:call-template name="Header"/>
				<br/><br/>
				<div class="Heading">Summary</div>
				<xsl:call-template name="SummaryTable"/>
				<div style="height:15"/>
				<xsl:call-template name="TestSuiteTables"/>				
			</body>
		</html>
	</xsl:template>
	<xsl:template name="html-head">
		<head>
			<meta http-equiv="Content-Type" content="text/html;CHARSET=iso-8859-1"/>
			<title>Test Report - <xsl:value-of select="//test:report/test:time"/>
			</title>
			<!--Javascript for expand and collapse of test info / error trace -->
			<script language="JavaScript">
				// hides or shows given div and change contents of the switcher itself
				function switchdiv(switcher, sw, closedname, openedname) {
					//alert("Switcher: " + switcher.tagName + " Switched: " + switched.tagName + "." + switched.id);
					switched = document.getElementById(sw);
					if (switched.style.display == "none") {
						switched.style.display = "block";
						switched.style.marginLeft = "10px";
						switcher.innerText = openedname;
					}  else {
						switched.style.display = "none";
						switcher.innerText = closedname;
					}
					window.event.cancelBubble = true;
					return false;
				}
		    </script>
		    <!-- CSS styles definitions -->
			<style type="text/css">
			        BODY	{  BACKGROUND-REPEAT: no-repeat; FONT-FAMILY: Arial, Helvetica, sans-serif; BACKGROUND-COLOR: #ffffff } 
					.PageTitle { PADDING-BOTTOM: 8px;FONT-WEIGHT: bold; FONT-SIZE: medium; COLOR: #336699;  FONT-FAMILY: Arial, Times New Roman, Times, serif }
					.PageTitleSmall { PADDING-RIGHT: 8px; FONT-WEIGHT: bold; FONT-SIZE: x-small; COLOR: #336699; FONT-FAMILY: Arial, Times New Roman, Times, serif }
					.Heading { MARGIN-BOTTOM: 10px; MARGIN-TOP:15px; FONT-SIZE:medium; FONT-FAMILY: Arial, Helvetica, sans-serif; COLOR:#336699 }
					.TableTitle { PADDING-TOP: 8px;FONT-SIZE: small; COLOR: #336699; FONT-FAMILY: Arial,Helvetica,Geneva,sans-serif; BACKGROUND-COLOR: #ffffff }
					.LargeTable { BORDER-RIGHT: #cccccc 1px solid; PADDING-RIGHT: 4px; BORDER-TOP: #cccccc 1px solid; PADDING-LEFT: 4px; BORDER-LEFT: #cccccc 1px solid; BORDER-BOTTOM: #cccccc 1px solid; BORDER-COLLAPSE: collapse;  BACKGROUND-COLOR: #999966 }
					.LargeTableHeader {FONT-WEIGHT: bold; FONT-SIZE: x-small; VERTICAL-ALIGN: bottom;  FONT-FAMILY: Arial,Helvetica,Geneva,sans-serif; BACKGROUND-COLOR:  #93a9d5 }
					.LargeTableText { FONT-SIZE: x-small;  MARGIN-BOTTOM: 0px; PADDING-BOTTOM: 1px; VERTICAL-ALIGN: top; COLOR: #000000; PADDING-TOP: 2px; FONT-FAMILY: Arial,Helvetica,Geneva,sans-serif; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f7f7e7 }
					.LargeTableSideHeader { WIDTH: 150px ; FONT-WEIGHT: bold; FONT-SIZE: x-small; VERTICAL-ALIGN: middle; FONT-FAMILY: Arial,Helvetica,Geneva,sans-serif; BACKGROUND-COLOR: #93a9d5 }
					.SmallTable { BORDER-RIGHT: #000000 1px; BORDER-TOP: #000000 1px; MARGIN: 0px; BORDER-LEFT: #000000 1px; BORDER-BOTTOM: #000000 1px; BORDER-COLLAPSE: collapse }
					.SmallTableHeader { FONT-SIZE: xx-small; VERTICAL-ALIGN: bottom; TEXT-ALIGN: left }
					.SmallTableText { FONT-SIZE: x-small; VERTICAL-ALIGN: top;  COLOR: #555555 }
					.Timestamp {  }
					.EventName { COLOR: #003366 }
					.NameValueTable { PADDING-RIGHT: 0px; PADDING-LEFT: 0px; FONT-SIZE: x-small;  PADDING-BOTTOM: 0px; MARGIN: 0px; WIDTH: 100%;    BORDER-TOP-STYLE: none; PADDING-TOP: 0px; BORDER-RIGHT-STYLE: none; BORDER-LEFT-STYLE: none; BORDER-COLLAPSE: collapse; BORDER-BOTTOM-STYLE: none }
					.TreeSwitcher { FONT-WEIGHT: bold; FONT-SIZE: x-small; VERTICAL-ALIGN: top;CURSOR: pointer }
					.BigValue { BORDER-RIGHT: #cccccc 1px solid; PADDING-RIGHT: 2px;BORDER-TOP: #cccccc 1px solid; PADDING-LEFT: 2px;FONT-SIZE: x-small;   PADDING-BOTTOM: 2px; BORDER-LEFT: #cccccc 1px solid; WIDTH: 100%; PADDING-TOP: 2px; BORDER-BOTTOM: #cccccc 1px solid; BORDER-COLLAPSE: collapse}
					.ValueName { PADDING-RIGHT: 4px; FONT-SIZE: x-small; WIDTH: 100px }
					.ValueText { FONT-SIZE: x-small;  WIDTH: 100%; COLOR: #555555 }
					.TestInfoHeader { FONT-WEIGHT: bold;FONT-SIZE: x-small; VERTICAL-ALIGN: middle; WIDTH: 100px; FONT-FAMILY: Arial,Helvetica,Geneva,sans-serif;BACKGROUND-COLOR: #eeee99 }
					.TestMethodTable {  PADDING-RIGHT: 4px; PADDING-LEFT: 4px; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #9999ee }
			</style>
		</head>
	</xsl:template>
	<xsl:template name="Header">
		<br/>
		<table cellpadding="0" cellspacing="0" border="0">
			<tr class="PageTitle">
				<td colspan="2">
					<a name="top">
					   <xsl:text>Client Automation Test Results</xsl:text>
					</a>
				</td>
			</tr>
			<tr><td><br/></td></tr>
			<tbody class="PageTitleSmall">
				<tr>
					<td>Label:</td>
					<td>
					  <xsl:value-of select="//test:report/test:build"/>
					</td>
				</tr>
				<tr>
					<td>Date:</td>
					<td>
					  <xsl:value-of select="//test:report/test:time"/>
					</td>
				</tr>
				<tr>
					<td>Testing Account:</td>
					<td>
                        <xsl:value-of select="//test:report/test:tester"/>					
					</td>
				</tr>
				<tr>
					<td>OS:</td>
					<td>
						<xsl:value-of select="//test:report/test:system/test:OS"/>
						<xsl:text>, </xsl:text>
						<xsl:value-of select="//test:report/test:system/test:OS-version"/>
					</td>
				</tr>
				<tr>
					<td>Testing Language:</td>
					<td>
                        <xsl:value-of select="//test:report/test:language"/>					
					</td>
				</tr>
				<tr>
					<td>Time Elapsed:</td>
					<td>
						<xsl:variable name="exec_time" select="sum(.//test:test/@elapsed)"/>
						<xsl:choose>
							<xsl:when test="$exec_time &gt; 3600">
								<xsl:value-of select="floor($exec_time div 3600)"/> hr <xsl:value-of select="floor(($exec_time mod 3600) div 60)"/> min <xsl:value-of select="$exec_time mod 60"/> sec
							</xsl:when>
							<xsl:when test="$exec_time &gt; 60">
								<xsl:value-of select="floor($exec_time div 60)"/> min <xsl:value-of select="$exec_time mod 60"/> sec
							</xsl:when>
							<xsl:otherwise>
								<xsl:value-of select="$exec_time"/> sec
							</xsl:otherwise>
						</xsl:choose>
                        								
					</td>
				</tr>	
				<tr>
					<td>Config:</td>
					<td>
					<div class="TreeSwitcher" style="margin-left:6px">
					<xsl:attribute name="onclick">
					  switchdiv(this, 'configuration_secion', "+Show","-Hide")
                   			 </xsl:attribute>  
                   			 +Show
                   			 </div>
                   			 <div style="display:none" width="100%" class="ValueText" id='configuration_secion'>
						<xsl:for-each select="//test:report//test:config//test:param">
						<xsl:choose>
							  <xsl:when test="contains(@name,'QTP_SERVER')">
							    SELENIUM_SERVER=<xsl:value-of select="@value"/><br/>
							  </xsl:when>
							  <xsl:when test="contains(@name,'PASSWORD') or contains(@name,'password')">
							     <xsl:value-of select="@name"/>=Contact C9 QA<br/>
							  </xsl:when>
							  <xsl:otherwise>
							     <xsl:value-of select="@name"/>=<xsl:value-of select="@value"/><br/>
							  </xsl:otherwise>
							</xsl:choose>					
						</xsl:for-each>
					 </div>
						
					</td>
				</tr>					
				<tr>
				</tr>
			</tbody>
		</table>
	</xsl:template>
	<xsl:template name="SummaryTable">
		<table id="SummaryTable" class="LargeTable" border="1" cellpadding="0" width="100%">
			<thead>
				<tr class="LargeTableHeader">
					<th rowspan="2">Suite</th>
					<th colspan="3">TestCases</th>
					<th colspan="3">Tests</th>					
				</tr>
				<tr class="LargeTableHeader">
					<th>Pass</th>					
					<th>Fail</th>
					<th>CNR</th>
					<th>Pass</th>					
					<th>Fail</th>	
					<th>CNR</th>				
				</tr>
			</thead>
			<tbody class="LargeTableText">
				<xsl:for-each select="//test:suite">
					<tr align="center" onmouseover="this.bgColor='#eeeeaa'" onmouseout="this.bgColor='#f7f7e7'">						
						<xsl:variable name="totalcases" select="count(.//test:testcase)"/>
						<xsl:variable name="passedcases" select="count(.//test:testcase[@result='Passed' or @result='Warning'])"/>
						<xsl:variable name="failedcases" select="count(.//test:testcase[@result='Failed'])"/>
						<xsl:variable name="cnrcases" select="count(.//test:testcase[@result='CNR'])"/>
						<xsl:variable name="totaltests" select="count(.//test:test)"/>
						<xsl:variable name="passedtests" select="count(.//test:test[@result='Passed' or @result='Warning'])"/>						
						<xsl:variable name="failedtests" select="count(.//test:test[@result='Failed'])"/>
						<xsl:variable name="cnrtests" select="count(.//test:test[@result='CNR'])"/>
						<td>
							<xsl:value-of select="@name"/>
						</td>
						<td align="center">
							<table border="0"><tr><td align="left">
							<xsl:value-of select="$passedcases"/>
							</td><td></td><td align="right">
							<xsl:text>[</xsl:text>
							<xsl:value-of select="floor($passedcases div $totalcases * 100 + 0.5)"/>
							<xsl:text>%</xsl:text>
							<xsl:text>]</xsl:text>
							</td></tr></table>
						</td>						
						<td align="center">
							<xsl:if test="$failedcases &gt; 0">
								<xsl:attribute name="bgcolor">#ffcccc</xsl:attribute>
							</xsl:if>
							<table border="0"><tr><td align="left">
							<xsl:value-of select="$failedcases"/>
							</td><td></td><td align="right">
							<xsl:text>[</xsl:text>
							<xsl:value-of select="floor($failedcases div $totalcases * 100 + 0.5)"/>
							<xsl:text>%</xsl:text>
							<xsl:text>]</xsl:text>
							</td></tr></table>
						</td>		
						<td align="center">
							<xsl:if test="$cnrcases &gt; 0">
								<xsl:attribute name="bgcolor">#ffd24d</xsl:attribute>
							</xsl:if>
							<table border="0"><tr><td align="left">
							<xsl:value-of select="$cnrcases"/>
							</td><td></td><td align="right">
							<xsl:text>[</xsl:text>
							<xsl:value-of select="floor($cnrcases div $totalcases * 100 + 0.5)"/>
							<xsl:text>%</xsl:text>
							<xsl:text>]</xsl:text>
							</td></tr></table>
						</td>				
						<td align="center">							
							<table border="0"><tr><td align="left">
							<xsl:value-of select="$passedtests"/>
							</td><td></td><td align="right">
							<xsl:text>[</xsl:text>
							<xsl:value-of select="floor($passedtests div $totaltests * 100 + 0.5)"/>
							<xsl:text>%</xsl:text>
							<xsl:text>]</xsl:text>
							</td></tr></table>
						</td>							
						<td align="center">
							<xsl:if test="$failedtests &gt; 0">
								<xsl:attribute name="bgcolor">#ffcccc</xsl:attribute>
							</xsl:if>
							<table border="0"><tr><td align="left">
							<xsl:value-of select="$failedtests"/>
							</td><td></td><td align="right">
							<xsl:text>[</xsl:text>
							<xsl:value-of select="floor($failedtests div $totaltests * 100 + 0.5)"/>
							<xsl:text>%</xsl:text>
							<xsl:text>]</xsl:text>
							</td></tr></table>
						</td>
						<td align="center">
							<xsl:if test="$cnrtests &gt; 0">
								<xsl:attribute name="bgcolor">#ffd24d</xsl:attribute>
							</xsl:if>
							<table border="0"><tr><td align="left">
							<xsl:value-of select="$cnrtests"/>
							</td><td></td><td align="right">
							<xsl:text>[</xsl:text>
							<xsl:value-of select="floor($cnrtests div $totaltests * 100 + 0.5)"/>
							<xsl:text>%</xsl:text>
							<xsl:text>]</xsl:text>
							</td></tr></table>
						</td>
					</tr>
				</xsl:for-each>
			</tbody>
		</table>
	</xsl:template>
	<xsl:template name="TestSuiteTables">
		<xsl:for-each select="//test:suite">
			<xsl:variable name="suitetotaltests" select="count(.//test:test)"/>
			<xsl:variable name="suitepassedtests" select="count(.//test:test[@result='Passed' or @result='Warning'])"/>
			<xsl:variable name="suitefailedtests" select="count(.//test:test[@result='Failed'])"/>
			<xsl:variable name="suitecnrtests" select="count(.//test:test[@result='CNR'])"/>			
			<xsl:variable name="suitetotalcases" select="count(.//test:testcase)"/>
			<xsl:variable name="suitepassedcases" select="count(.//test:testcase[@result='Passed' or @result='Warning'])"/>
			<xsl:variable name="suitefailedcases" select="count(.//test:testcase[@result='Failed'])"/>
			<xsl:variable name="suitecnrcases" select="count(.//test:testcase[@result='CNR'])"/>			
			<div style="margin-bottom:10px">
				<div class="TableTitle"><b>TestSuite: <xsl:value-of select="@name"/></b><br/><br/>
				</div>
				
				<table id="TestSuiteTable" class="LargeTable" border="1" cellpadding="0" width="100%">
					<thead>
						<tr class="LargeTableHeader">
							<th rowspan="2">Component</th>
							<th colspan="3">TestCases</th>
							<th colspan="3">Tests</th>					
						</tr>
						<tr class="LargeTableHeader">
							<th>Pass</th>							
							<th>Fail</th>
							<th>CNR</th>
							<th>Pass</th>							
							<th>Fail</th>
							<th>CNR</th>					
						</tr>
					</thead>
					<tbody class="LargeTableText">
						<xsl:for-each select="./test:component">
							<xsl:variable name="compName" select="@name"/>
							<xsl:variable name="totaltests" select="count(.//test:test)"/>
							<xsl:variable name="failedtests" select="count(.//test:test[@result='Failed'])"/>							
							<xsl:variable name="passedtests" select="count(.//test:test[@result='Passed' or @result='Warning'])"/>
							<xsl:variable name="cnrtests" select="count(.//test:test[@result='CNR'])"/>
							<xsl:variable name="totalcases" select="count(.//test:testcase)"/>
							<xsl:variable name="failedcases" select="count(.//test:testcase[@result='Failed'])"/>							
							<xsl:variable name="passedcases" select="count(.//test:testcase[@result='Passed' or @result='Warning'])"/>
							<xsl:variable name="cnrcases" select="count(.//test:testcase[@result='CNR'])"/>
							<tr onmouseover="this.bgColor='#eeeeaa'" onmouseout="this.bgColor='#f7f7e7'">
								<td>
									<a>
										<xsl:attribute name="href"><xsl:value-of select="concat('./',$compName,'/',$compName,'.xml')"/></xsl:attribute>
										<xsl:value-of select="@name"/>
									</a>
								</td>
								<td align="center">									
									<table border="0"><tr><td align="left">
									<xsl:value-of select="$passedcases"/>
									</td><td></td><td align="right">
									<xsl:text>[</xsl:text>
									<xsl:value-of select="floor($passedcases div $totalcases * 100 + 0.5)"/>
									<xsl:text>%</xsl:text>
									<xsl:text>]</xsl:text>
									</td></tr></table>
								</td>								
								<td align="center">
									<xsl:if test="$failedcases &gt; 0">
										<xsl:attribute name="bgcolor">#ffcccc</xsl:attribute>
									</xsl:if>
									<table border="0"><tr><td align="left">
									<xsl:value-of select="$failedcases"/>
									</td><td></td><td align="right">
									<xsl:text>[</xsl:text>
									<xsl:value-of select="floor($failedcases div $totalcases * 100 + 0.5)"/>
									<xsl:text>%</xsl:text>
									<xsl:text>]</xsl:text>
									</td></tr></table>
								</td>
								<td align="center">
									<xsl:if test="$cnrcases &gt; 0">
										<xsl:attribute name="bgcolor">#ffd24d</xsl:attribute>
									</xsl:if>
									<table border="0"><tr><td align="left">
									<xsl:value-of select="$cnrcases"/>
									</td><td></td><td align="right">
									<xsl:text>[</xsl:text>
									<xsl:value-of select="floor($cnrcases div $totalcases * 100 + 0.5)"/>
									<xsl:text>%</xsl:text>
									<xsl:text>]</xsl:text>
									</td></tr></table>
								</td>
								<td align="center">									
									<table border="0"><tr><td align="left">
									<xsl:value-of select="$passedtests"/>
									</td><td></td><td align="right">
									<xsl:text>[</xsl:text>
									<xsl:value-of select="floor($passedtests div $totaltests * 100 + 0.5)"/>
									<xsl:text>%</xsl:text>
									<xsl:text>]</xsl:text>
									</td></tr></table>
								</td>								
								<td align="center">
									<xsl:if test="$failedtests &gt; 0">
										<xsl:attribute name="bgcolor">#ffcccc</xsl:attribute>
									</xsl:if>
									<table border="0"><tr><td align="left">
									<xsl:value-of select="$failedtests"/>
									</td><td></td><td align="right">
									<xsl:text>[</xsl:text>
									<xsl:value-of select="floor($failedtests div $totaltests * 100 + 0.5)"/>
									<xsl:text>%</xsl:text>
									<xsl:text>]</xsl:text>
									</td></tr></table>
								</td>
								<td align="center">
									<xsl:if test="$cnrtests &gt; 0">
										<xsl:attribute name="bgcolor">#ffd24d</xsl:attribute>
									</xsl:if>
									<table border="0"><tr><td align="left">
									<xsl:value-of select="$cnrtests"/>
									</td><td></td><td align="right">
									<xsl:text>[</xsl:text>
									<xsl:value-of select="floor($cnrtests div $totaltests * 100 + 0.5)"/>
									<xsl:text>%</xsl:text>
									<xsl:text>]</xsl:text>
									</td></tr></table>
								</td>
							</tr>
						</xsl:for-each>
					</tbody>
				</table>
			</div>
		</xsl:for-each>
	</xsl:template>
	
	
</xsl:stylesheet>
