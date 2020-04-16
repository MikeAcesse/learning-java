<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"  xmlns:test="http://www.info2soft.com/qa/framework/junit/schema" >
	<xsl:output method="html"/>
	<xsl:template name="Root" match="/test:report">
		<html>
			<xsl:call-template name="html-head"/>
			<!--xsl:call-template name="javascript"/-->
			<body link="663300" alink="#FF6600" vlink="#996633" bgcolor="#ffffff">
				<xsl:call-template name="Header"/>
				<div class="Heading">
				<br/>
				<table cellpadding="0" cellspacing="0" border="0" width="100%">
							<tr>
								<td class="Heading">Summary <xsl:value-of select="test:name"/>
								</td>
								<td align="right">
									<a href="../Summary.xml">back to main</a>
								</td>
							</tr>
						</table>
				</div>
				<xsl:call-template name="SummaryTable"/>
				
				<div class="Heading"><br/><br/>Details</div>
				<xsl:for-each select="//test:report//test:testcase">
					<xsl:variable name="testID" select="test:id"/>
					<div id="{$testID}" style="margin-bottom:15px">
						<table cellpadding="0" cellspacing="0" border="0" width="100%">
							<tr>
								<td class="TableTitle"><a> <xsl:attribute name="name"><xsl:value-of select="test:name"/></xsl:attribute><b>TestCase: <xsl:value-of select="test:name"/></b></a>
								</td>
								<td align="right">
									<a href="#top">
										<div align="right">top</div>
									</a>
								</td>
							</tr>
						</table>
						<xsl:call-template name="TestCaseTable"/>
					</div>
				</xsl:for-each>
			</body>
			<script language="JavaScript">
			sum_times();
			</script>
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
				var all_cases = new Array();
				var cur_case=null;
				<![CDATA[
				function sum_times()
				{
					var total2= 0;
					for(var i=0;i<all_cases.length;i++)
					{
						cur_case = all_cases[i];
						var total1= 0;
						try{
							var elem = document.getElementById(cur_case[0]);							
							for(var j=1;j<cur_case.length;j++)
							{
								var tstr = cur_case[j].split(":");
								var h = parseInt(tstr[0]);
								var m = parseInt(tstr[1]);
								var s = parseInt(tstr[2]);
								total1+=h*3600+m*60+s;
								
							}
							elem.innerHTML="" + Math.floor(total1/3600) + ":" + Math.floor(total1%3600/60) + ":" + Math.round(total1%3600%60 * 1000)/1000;
						}catch(e){}
						total2+=total1;
					}
					document.getElementById("td_1").innerHTML="" + Math.floor(total2/3600) + ":" + Math.floor(total2%3600/60) + ":" + Math.round(total2%3600%60 * 1000)/1000;
				}]]>

		    </script>
		    <!-- CSS styles definitions -->
			<style type="text/css">
			        BODY	{  BACKGROUND-REPEAT: no-repeat; FONT-FAMILY: Arial, Helvetica, sans-serif; BACKGROUND-COLOR: #ffffff } 
					.PageTitle { PADDING-BOTTOM: 8px;FONT-WEIGHT: bold; FONT-SIZE: medium; COLOR: #336699;  FONT-FAMILY: Arial, Times New Roman, Times, serif }
					.PageTitleSmall { PADDING-RIGHT: 8px; FONT-WEIGHT: bold; FONT-SIZE: x-small; COLOR: #336699; FONT-FAMILY: Arial, Times New Roman, Times, serif }
					.Heading { MARGIN-BOTTOM: 10px; MARGIN-TOP:15px; FONT-SIZE:medium; FONT-FAMILY: Arial, Helvetica, sans-serif; COLOR:#336699 }
					.TableTitle { PADDING-TOP: 8px;FONT-SIZE: small; COLOR: #336699; FONT-FAMILY: Arial,Helvetica,Geneva,sans-serif; BACKGROUND-COLOR: #ffffff }
					.LargeTable { BORDER-RIGHT: #cccccc 1px solid; PADDING-RIGHT: 4px; BORDER-TOP: #cccccc 1px solid; PADDING-LEFT: 4px; BORDER-LEFT: #cccccc 1px solid; BORDER-BOTTOM: #cccccc 1px solid; BORDER-COLLAPSE: collapse;  BACKGROUND-COLOR: #999966 }
					.LargeTableHeader {FONT-WEIGHT: bold; FONT-SIZE: x-small; VERTICAL-ALIGN: bottom;  FONT-FAMILY: Arial,Helvetica,Geneva,sans-serif; BACKGROUND-COLOR: #93a9d5 }
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
					.InnerTestInfoHeader { FONT-WEIGHT: bold;FONT-SIZE: xx-small; VERTICAL-ALIGN: middle; WIDTH: 100px; FONT-FAMILY: Arial,Helvetica,Geneva,sans-serif;BACKGROUND-COLOR: #eeee99 }
					.InnerValueText { FONT-SIZE: xx-small;  WIDTH: 100%; COLOR: #555555 }
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
					   <xsl:value-of select="//test:component"/>
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
					<td id="td_1"></td>					
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
		<table id="TestSuiteTable" class="LargeTable" border="1" cellpadding="0" width="100%">
			<thead>
				<tr class="LargeTableHeader">
					<th rowspan="2">TestCases</th>
					<th colspan="3">Tests</th>					
				</tr>
				<tr class="LargeTableHeader">					
					<th>Pass</th>					
					<th>Fail</th>
					<th>CNR</th>					
				</tr>
			</thead>
			<tbody class="LargeTableText">
				<xsl:variable name="totaltests" select="count(//test:test)"/>
				<xsl:variable name="passedtest" select="count(//test:test[@result='Passed' or @result='Warning'])"/>					
				<xsl:variable name="failedtest" select="count(//test:test[@result='Failed'])"/>	
				<xsl:variable name="cnrtest" select="count(//test:test[@result='CNR'])"/>
				<xsl:for-each select="//test:testcase">					
					<xsl:variable name="casetotaltests" select="count(./test:test)"/>
					<xsl:variable name="casepassedtest" select="count(./test:test[@result='Passed' or @result='Warning'])"/>					
					<xsl:variable name="casefailedtest" select="count(./test:test[@result='Failed'])"/>
					<xsl:variable name="casecnrtest" select="count(./test:test[@result='CNR'])"/>						
					<tr onmouseover="this.bgColor=0xeeeeaa" onmouseout="this.bgColor=0xf7f7e7">
						<td>
							<a>
								<xsl:attribute name="href"><xsl:value-of select="concat('#',test:name)"/></xsl:attribute>								
								<xsl:value-of select="test:name"/>
							</a>
						</td>
						<td align="center">							
						     <table border="0"><tr><td align="left">
							<xsl:value-of select="$casepassedtest"/>
							</td><td></td><td align="right">
							<xsl:text>[</xsl:text>
							<xsl:value-of select="floor($casepassedtest div $casetotaltests * 100+ 0.5)"/>
							<xsl:text>%</xsl:text>
							<xsl:text>]</xsl:text>
							</td></tr></table>
						</td>						
						<td align="center">
							<xsl:if test="$casefailedtest &gt; 0">
								<xsl:attribute name="bgcolor">#ffcccc</xsl:attribute>
							</xsl:if>
							<table border="0"><tr><td align="left">
							<xsl:value-of select="$casefailedtest"/>
							</td><td></td><td align="right">
							<xsl:text>[</xsl:text>
							<xsl:value-of select="floor($casefailedtest div $casetotaltests * 100+ 0.5)"/>
							<xsl:text>%</xsl:text>
							<xsl:text>]</xsl:text>
							</td></tr></table>
						</td>
						<td align="center">
							<xsl:if test="$casecnrtest &gt; 0">
								<xsl:attribute name="bgcolor">#ffd24d</xsl:attribute>
							</xsl:if>
							<table border="0"><tr><td align="left">
							<xsl:value-of select="$casecnrtest"/>
							</td><td></td><td align="right">
							<xsl:text>[</xsl:text>
							<xsl:value-of select="floor($casecnrtest div $casetotaltests * 100+ 0.5)"/>
							<xsl:text>%</xsl:text>
							<xsl:text>]</xsl:text>
							</td></tr></table>
						</td>
					</tr>
				</xsl:for-each>
				
			</tbody>
		</table>
		
	</xsl:template>
	<xsl:template name="TestCaseTable">
		<xsl:variable name="testID" select="test:id"/>
		<script language="javascript">
		cur_case = new Array();
		cur_case.push('td_<xsl:value-of select="$testID"/>');
		</script>
		<table class="LargeTable" width="100%" border="1" cellpadding="0">
			<tbody class="LargeTableText">
				
				<tr>
					<td class="LargeTableSideHeader">Overall Result</td>
					<td>
						<xsl:choose>
							<xsl:when test="test:test[@result='Failed']">
								<xsl:attribute name="bgcolor">#ffcccc</xsl:attribute>
								<xsl:text>Failed</xsl:text>
							</xsl:when>
							<xsl:otherwise>
								<xsl:if test="test:test[@result='CNR']">
									<xsl:attribute name="bgcolor">#ffd24d</xsl:attribute>
									<xsl:text>CNR</xsl:text>
								</xsl:if>
								<xsl:if test="test:test[@result='Passed' or @result='Warning']">
									<xsl:attribute name="bgcolor">#ccffcc</xsl:attribute>
									<xsl:text>Passed</xsl:text>
								</xsl:if>
							</xsl:otherwise>
						</xsl:choose>
						<xsl:if test="test:test[@result='Failed']">
							<xsl:attribute name="bgcolor">#ffcccc</xsl:attribute>
						</xsl:if>
						<xsl:value-of select="@result"/>
					</td>
				</tr>
				
								
				<xsl:apply-templates select="test:component"/>
				<xsl:apply-templates select="test:subcomponent"/>
				<xsl:apply-templates select="test:area"/>
				<xsl:apply-templates select="test:description"/>	
				<tr>
					<td class="LargeTableSideHeader">Execution Elapsed</td>
					<td><xsl:attribute name="id"> <xsl:value-of select="concat('td_',$testID)"/></xsl:attribute></td>
				</tr>			
				<tr>
					<td class="LargeTableSideHeader">Tests</td>
					<td>
						<table class="LargeTable" cellpadding="0" border="1" width="100%">
							<tbody class="LargeTableText">
								<xsl:apply-templates select="test:test"/>
							</tbody>
						</table>
					</td>
				</tr>
			</tbody>
		</table>
		<script language="javascript">
		all_cases.push(cur_case);
		</script>
	</xsl:template>
	
	<xsl:template match="test:component">
		<tr>
			<td class="LargeTableSideHeader">Component</td>
			<td>
				<xsl:value-of select="text()"/>
			</td>
		</tr>
	</xsl:template>
	<xsl:template match="test:subcomponent">
		<tr>
			<td class="LargeTableSideHeader">Sub-component</td>
			<td>
				<xsl:value-of select="text()"/>
			</td>
		</tr>
	</xsl:template>
	<xsl:template match="test:area">
		<tr>
			<td class="LargeTableSideHeader">Area</td>
			<td>
				<xsl:value-of select="text()"/>
			</td>
		</tr>
	</xsl:template>
	<xsl:template match="test:description">
		<tr>
			<td class="LargeTableSideHeader">Description</td>
			<td>
				<xsl:value-of select="text()"/>
			</td>
		</tr>
	</xsl:template>

	<xsl:template match="test:test">
	<script language="javascript">
		cur_case.push('<xsl:value-of select="@elapsed"/>');
	</script>
		<tr>
			<td width="100%">
				<xsl:if test="@result='Passed' or @result='Warning'">
					<xsl:attribute name="bgcolor">#ccffcc</xsl:attribute>
				</xsl:if>
				<xsl:if test="@result='Failed'">
					<xsl:attribute name="bgcolor">#ffcccc</xsl:attribute>
				</xsl:if>
				<xsl:if test="@result='CNR'">
					<xsl:attribute name="bgcolor">#ffd24d</xsl:attribute>
				</xsl:if>
				<xsl:variable name="first-line">
					<xsl:choose>					
					<xsl:when test="@result='Failed'">
						<xsl:value-of select="test:name"/>&#32;&#45;&#32;<xsl:text>Failed</xsl:text>
					</xsl:when>
					<xsl:otherwise>
						<xsl:if test="@result='CNR'">
							<xsl:value-of select="test:name"/>&#32;&#45;&#32;<xsl:text>CNR</xsl:text>
						</xsl:if>
						<xsl:if test="@result='Passed' or @result='Warning'">
							<xsl:value-of select="test:name"/>&#32;&#45;&#32;<xsl:text>Passed</xsl:text>
						</xsl:if>
					</xsl:otherwise>
				</xsl:choose>
				</xsl:variable>
				<xsl:variable name="switch-on">+<xsl:value-of select="$first-line"/>
				</xsl:variable>
				<xsl:variable name="switch-off">-<xsl:value-of select="$first-line"/>
				</xsl:variable>
				<div width="100%">
				   <xsl:variable name="unqId" select="generate-id(.)"/>
					<div class="TreeSwitcher" style="margin-left:6px">
					<xsl:attribute name="onclick">
					  switchdiv(this, '<xsl:value-of select="$unqId"/>', "<xsl:value-of select="$switch-on"/>","<xsl:value-of select="$switch-off"/>")
                    </xsl:attribute>  
				    <xsl:value-of select="$switch-on"/>
					</div>
					<div style="display:none" width="100%" class="ValueText">
					    <xsl:attribute name="id"><xsl:value-of select="$unqId"/></xsl:attribute> 
						<table class="LargeTable" cellpadding="0" cellspacing="0" border="1" width="100%">
							<tbody class="LargeTableText">
								
								<tr>
									<td class="InnerTestInfoHeader">Time Elapsed</td>
									<td class="InnerValueText">
										<xsl:value-of select="@elapsed"/> 																		
									</td>
								</tr>
								
								<xsl:if test="test:desc">
								
									<tr>
										<td class="InnerTestInfoHeader">
											<b>Description</b>
										</td>
										<td class="InnerValueText" style="white-space:pre">
											<xsl:value-of select="test:desc"/>
										</td>
									</tr>
								
								</xsl:if>
								
								<xsl:if test="test:output">
								
									<tr>
										<td class="InnerTestInfoHeader">
											<b>Message</b>
										</td>
										<td class="InnerValueText" style="white-space:pre">
											<xsl:variable name="output" select="test:output" />
											<xsl:call-template name="LineBreaker">
												<xsl:with-param name="line" select="substring-after($output, '&#xA;')"/>
												<xsl:with-param name="separator" select="'&#xA;'"/>
											</xsl:call-template>
										</td>
									</tr>
								
								</xsl:if>
								<xsl:if test="test:error">
								
									<tr>
										<td class="InnerTestInfoHeader">
											<b>Failure</b>
										</td>
										<td class="InnerValueText" style="white-space:pre">
											<xsl:variable name="error" select="test:error" />
											<xsl:call-template name="LineBreaker">
												<xsl:with-param name="line" select="substring-after($error, '&#xA;')"/>
												<xsl:with-param name="separator" select="'&#xA;'"/>
											</xsl:call-template>
										</td>
									</tr>
								
								</xsl:if>
								<xsl:if test="test:system-out">
									<tr>
										<td class="InnerTestInfoHeader">
											<b>Log</b>
										</td>
										<td class="InnerValueText">
											<a>
												<xsl:attribute name="href"><xsl:value-of select="test:system-out/@href"/></xsl:attribute>
												<xsl:attribute name="target">_new</xsl:attribute>
												Runtime Log
											</a></td>
									</tr>
								</xsl:if>
								<xsl:if test="test:qtp-out">
									<tr>
										<td class="InnerTestInfoHeader">
											<b>QTP Report</b>
										</td>
										<td class="InnerValueText">
											<a>
												<xsl:attribute name="href"><xsl:value-of select="test:qtp-out/@href"/></xsl:attribute>
												<xsl:attribute name="target">_new</xsl:attribute>
												QTP Report
											</a></td>
									</tr>
								</xsl:if>
								<xsl:if test="test:screenshot">
									<tr>
										<td class="InnerTestInfoHeader">
											<b>Screenshot</b>
										</td>
										<td class="InnerValueText">
											<a>
												<xsl:attribute name="href"><xsl:value-of select="test:screenshot/@href"/></xsl:attribute>
												<xsl:attribute name="target">_new</xsl:attribute>
												Screenshot
											</a></td>
									</tr>
								</xsl:if>
							</tbody>
						</table>
					</div>
				</div>
			</td>
		</tr>
	</xsl:template>
	
	<xsl:template match="text()"/>

	<xsl:template name="LineBreaker">

		<xsl:param name="line"/>
		<xsl:param name="separator"/>
		<xsl:value-of select="substring-before($line, $separator)"/>
		<br/>
				
		<xsl:choose>	
			<xsl:when test="string-length(substring-after($line, $separator)) != 0">
	
				<xsl:call-template name="LineBreaker">
					<xsl:with-param name="line" select="substring-after($line, $separator)"/>
					<xsl:with-param name="separator" select="$separator"/>
				</xsl:call-template>	
			</xsl:when>
			<xsl:otherwise/>
		</xsl:choose>
					
		
	</xsl:template>

</xsl:stylesheet>
