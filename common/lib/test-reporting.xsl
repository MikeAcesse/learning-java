<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"  xmlns:test="http://www.info2soft.com/qa/framework/junit/schema" xmlns:uuid="java.util.UUID">
	<xsl:output method="html"/>
	<xsl:template name="Root" match="/test:report">
		<xsl:text disable-output-escaping='yes'>&lt;!DOCTYPE html&gt;</xsl:text>
		<html lang="en">
			<xsl:call-template name="html-head"/>


			<body class="nav-sm">
    <div class="container body">
        <div class="main_container">

				<xsl:call-template name="left-column-content"/>

            <div class="right_col" role="main">
                <div class="container-fluid">

				<xsl:call-template name="right-column-header"/>
				<xsl:for-each select="//test:report//test:testcase">

				<xsl:variable name="elapsed" select="test:elapse"/>
				<xsl:variable name="totaltests" select="count(test:test)"/>
				<xsl:variable name="passedtest" select="count(test:test[@result='Passed'])"/>					
				<xsl:variable name="failedtest" select="count(test:test[@result='Failed'])"/>	
				<xsl:variable name="cnrtest" select="count(test:test[@result='CNR'])"/>

<section>
        <xsl:choose>
            <xsl:when test="$passedtest &gt; 0">
                <xsl:choose>
                        <xsl:when test="$failedtest &gt; 0">
                            <xsl:choose>
                                <xsl:when test="$cnrtest &gt; 0">
                                    <xsl:attribute name="class"><xsl:text>suite-wrap has-success has-fail has-cnr</xsl:text></xsl:attribute>
                                </xsl:when>
                                <xsl:otherwise>
                                    <xsl:attribute name="class"><xsl:text>suite-wrap has-success has-fail no-cnr</xsl:text></xsl:attribute>
                                </xsl:otherwise>
                           </xsl:choose>

                        </xsl:when>
                        <xsl:otherwise>
                            <xsl:choose>
                                <xsl:when test="$cnrtest &gt; 0">
                                    <xsl:attribute name="class"><xsl:text>suite-wrap has-success no-fail has-cnr</xsl:text></xsl:attribute>
                                </xsl:when>
                                <xsl:otherwise>
                                    <xsl:attribute name="class"><xsl:text>suite-wrap has-success no-fail no-cnr</xsl:text></xsl:attribute>
                                </xsl:otherwise>
                            </xsl:choose>
                        </xsl:otherwise>
                </xsl:choose>
            </xsl:when>
            <xsl:otherwise>
                <xsl:choose>
                        <xsl:when test="$failedtest &gt; 0">
                            <xsl:choose>
                                <xsl:when test="$cnrtest &gt; 0">
                                    <xsl:attribute name="class"><xsl:text>suite-wrap no-success has-fail has-cnr</xsl:text></xsl:attribute>
                                </xsl:when>
                                <xsl:otherwise>
                                    <xsl:attribute name="class"><xsl:text>suite-wrap no-success has-fail no-cnr</xsl:text></xsl:attribute>
                                </xsl:otherwise>
                           </xsl:choose>

                        </xsl:when>
                        <xsl:otherwise>
                            <xsl:choose>
                                <xsl:when test="$cnrtest &gt; 0">
                                    <xsl:attribute name="class"><xsl:text>suite-wrap no-success no-fail has-cnr</xsl:text></xsl:attribute>
                                </xsl:when>
                                <xsl:otherwise>
                                    <xsl:attribute name="class"><xsl:text>suite-wrap no-success no-fail no-cnr</xsl:text></xsl:attribute>
                                </xsl:otherwise>
                            </xsl:choose>
                        </xsl:otherwise>
                </xsl:choose>
            </xsl:otherwise>
        </xsl:choose>

                        <div class="suite">
                            <table class="suite_info">
                                <tr>
                                    <td>
                                        <h4 class="suite-title"><b>Test Set: <xsl:value-of select="test:name"/></b></h4>
                                        <h6 class="suite-filename"><xsl:value-of select="test:description"/></h6>
                                        </td>
                                        <td align="right">

<ul class="suite-summary list-unstyled">
<li class="suite-summary-item">
<h2 style="color: ＃404040;margin-top: 0; margin-bottom: 0;"><xsl:choose>
                            <xsl:when test="$elapsed &gt; 3600">
                                <font size="5"><xsl:value-of select="floor($elapsed div 3600)"/></font><font size="3">h </font><font size="5"><xsl:value-of select="floor(($elapsed mod 3600) div 60)"/></font><font size="3">m </font><font size="5"><xsl:value-of select="$elapsed mod 60"/></font><font size="3">s</font>
                            </xsl:when>
                            <xsl:when test="$elapsed &gt; 60">
                                <font size="5"><xsl:value-of select="floor($elapsed div 60)"/></font><font size="3">m </font><font size="5"><xsl:value-of select="$elapsed mod 60"/></font><font size="3">s</font>
                            </xsl:when>
                            <xsl:otherwise>
                                <font size="5"><xsl:value-of select="$elapsed"/></font><font size="3">s</font>
                            </xsl:otherwise>
                        </xsl:choose></h2>
<h5 style="color: ＃404040;margin-top: 0; margin-bottom: 0;">Suite Duration</h5>                        
</li>
<li class="suite-summary-item">
</li>
<li class="suite-summary-item">
<h2 style="color: ＃404040;margin-top: 0; margin-bottom: 0;">
<b><xsl:value-of select="$totaltests"/></b></h2>
<h5 style="color: ＃404040;margin-top: 0; margin-bottom: 0;">Total</h5>
</li>
<li class="suite-summary-item">
<h2 style="color: #5cb85c;margin-top: 0; margin-bottom: 0;">
<b><xsl:value-of select="$passedtest"/></b></h2>
<h5 style="color: #5cb85c;margin-top: 0; margin-bottom: 0;">Pass</h5>
</li>
<li class="suite-summary-item">
<h2 style="color: #d9534f;margin-top: 0; margin-bottom: 0;">
<b><xsl:value-of select="$failedtest"/></b></h2>
<h5 style="color: #d9534f;margin-top: 0; margin-bottom: 0;">Fail</h5>
</li>
<li class="suite-summary-item">
<h2 style="color: grey;margin-top: 0; margin-bottom: 0;">
<b><xsl:value-of select="$cnrtest"/></b></h2>
<h5 style="color: grey;margin-top: 0; margin-bottom: 0;">CNR</h5>
</li>

                                            <li class="suite-summary-item">
                                                <canvas class="halfdoughnut" height="35" width="80" style="margin: 0px 0px 0px 0">
                                                	<xsl:attribute name="data-pass"><xsl:value-of select="$passedtest"/></xsl:attribute>
                                                	<xsl:attribute name="data-fail"><xsl:value-of select="$failedtest"/></xsl:attribute> 
                                                	<xsl:attribute name="data-cnr"><xsl:value-of select="$cnrtest"/></xsl:attribute>
                                                </canvas>
                                            </li>

                                            </ul>
                                        </td>
                                    </tr>
                                </table>

              <div class="suite-test-wrap">
                                    <table class="test_info2"  width="100%">
                                        <tr>
                                            <th width="6%">Status</th>
                                            <th width="64%" text-align="left">Case Name</th>
                                            <th width="10%">Duration</th>
                                            <th width="10%">Runtime Log</th>
                                            <th width="10%">Screenshot</th>
                                        </tr>

          <xsl:apply-templates select="test:test"/>

					</table>
              </div>



                            </div>

</section>
</xsl:for-each>




</div>
</div>				
		</div>
</div>		

 			<!-- Scripts -->
        <script src="../../js/jquery.min.js"></script>
        <script src="../../js/bootstrap.min.js"></script>
        <script src="../../js/Chart.min.js"></script>
        <script src="../../js/cloud.min.js"></script>

			</body>
		</html>
	</xsl:template>


	<xsl:template name="html-head">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <link rel="stylesheet" href="../../css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../../css/custom.css"/>
    <link rel="stylesheet" href="../../css/test2.css"/>
</head>
	</xsl:template>

	<xsl:template name="left-column-content">

            <div class="col-md-3 left_col">
                <div class="left_col scroll-view">
                    <div class="navbar nav_title" >
                        <a id="menu_toggle" href="#" class="site_title"><img src="../../icon/icon.png" style="display: block;margin: auto" /></a>
                    </div>
                    <!--<div class="clearfix"></div>-->
                    <div id="sidebar-menu" class="main_menu_side hidden-print main_menu" style="display: none">
                        <br/>
                        <br/>
                        <dl>Start Time
                            <ul>
                                <li><xsl:value-of select="//test:report/test:starttime"/></li>
                            </ul>
                        </dl>
                        <dl>End Time
                            <ul>
                                <li><xsl:value-of select="//test:report/test:endtime"/></li>
                            </ul>
                        </dl>
                        <dl>Testing Account
                            <ul>
                                <li><xsl:value-of select="//test:report/test:tester"/></li>
                            </ul>
                        </dl>
                        <dl>Browser
                            <ul>
                                <li>Chrome 76.0.3809.132</li>
                            </ul>
                        </dl>
                        <dl>OS
                            <ul>
                                <li>
                                	<xsl:value-of select="//test:report/test:system/test:OS"/>
						<xsl:text>, </xsl:text>
						<xsl:value-of select="//test:report/test:system/test:OS-version"/>
                                </li>
                            </ul>
                        </dl>
                        <dl>Testing Language
                            <ul>
                                <li><xsl:value-of select="//test:report/test:language"/></li>
                            </ul>
                        </dl>
                        <dl>Time Elapsed
                            <ul>
                                <li>
                                	<xsl:variable name="exec_time" select="//test:report/test:elapse"/>
						
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
                                </li>
                            </ul>
                        </dl>
                        <dl>System Out Log
                            <ul>
                                <li><a><xsl:attribute name="href">../../../TestRunner.txt</xsl:attribute>
												<xsl:attribute name="target">_blank</xsl:attribute><font color="white"><u>System Out</u></font></a></li>
                            </ul>
                        </dl>
                        <!--/div-->
                    </div>
                </div>
            </div>
	</xsl:template>




	<xsl:template name="right-column-header">
                   <h2 style="margin-top: 3px">Info2soft Automation Test Results</h2>
                    
                    <table  style="width:100%">
                        <tr>
                            <td width="20%">   
                                      <table >
<tr>
<th>Environment:</th><td align="left"><xsl:value-of select="//test:report/test:build"/></td>
</tr>
<tr>
<th>Start Time:</th><td align="left"><xsl:value-of select="//test:report/test:starttime"/></td>
</tr>
<tr>
<th>End Time:</th><td align="left"><xsl:value-of select="//test:report/test:endtime"/></td>
</tr>
<tr>
<th>Elapsed:</th><td align="left"><xsl:variable name="exec_time" select="//test:report/test:elapse"/>
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
<td>
<u><a href="#" data-toggle="modal" data-target="#myModal">Test Config</a></u>

  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-lg">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">x</button>
            <h4 class="modal-title" >Test Config</h4>
        </div>
        <div class="modal-body">        
                   			 <div width="100%">
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

        </div>


        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
</td>
                                    </tr>



                                      </table>
                            </td>
				<xsl:variable name="totaltests" select="count(//test:test)"/>
				<xsl:variable name="passedtest" select="count(//test:test[@result='Passed'])"/>					
				<xsl:variable name="failedtest" select="count(//test:test[@result='Failed'])"/>	
				<xsl:variable name="cnrtest" select="count(//test:test[@result='CNR'])"/>
<td width="5%">
</td>
<td algin="left" width="75%">

<div class="row">
<div class="col-sm-3">
    <a href="#" style="text-decoration:none">
                        <div class="panel panel-total" id="total-button">
                            <div class="panel-heading">
                                <h5 class="panel-title">Total</h5>
                            </div>
                            <div class="panel-body">
                                <h1 style="color: #404040"><xsl:value-of select="$totaltests"/></h1>
                                <img src="../../icon/funnel-icon.png" style="display: block;margin-top: 15px;float: right"/>
                            </div>
                        </div>
                    </a>
                    </div>

<div class="col-sm-3">
    <a href="#" style="text-decoration:none">
                        <div class="panel panel-pass" id="pass-button">
                            <div class="panel-heading">
                                <h3 class="panel-title">Pass</h3>
                            </div>
                            <div class="panel-body">
                                <h1 style="color: #5cb85c"><xsl:value-of select="$passedtest"/></h1>
                                <h4 style="color: #5cb85c">(<xsl:value-of select="floor($passedtest div $totaltests * 100+ 0.5)"/>%)</h4>
                                <img src="../../icon/funnel-icon.png" style="display: block;margin-top: 15px;float: right"/>
                            </div>
                        </div>
     </a>
                    </div>

<div class="col-sm-3">
         <a href="#" style="text-decoration:none">
                        <div class="panel panel-fail" id="fail-button">
                            <div class="panel-heading">
                                <h3 class="panel-title">Fail</h3>
                            </div>
                            <div class="panel-body">
                                <h1 style="color: #d9534f"><xsl:value-of select="$failedtest"/></h1>
                                <h4 style="color: #d9534f">(<xsl:value-of select="floor($failedtest div $totaltests * 100+ 0.5)"/>%)</h4>
                                <img src="../../icon/funnel-icon.png" style="display: block;margin-top: 15px;float: right"/>
                            </div>
                        </div>
                    </a>
                    </div>

<div class="col-sm-3">
<a href="#" style="text-decoration:none">
                        <div class="panel panel-cnr" id="cnr-button">
                            <div class="panel-heading">
                                <h3 class="panel-title">Can Not Run (CNR)</h3>
                            </div>
                            <div class="panel-body">
                                <h1 style="color: #979797"><xsl:value-of select="$cnrtest"/></h1>
                                <h4 style="color: #979797">(<xsl:value-of select="floor($cnrtest div $totaltests * 100+ 0.5)"/>%)</h4>
                                <img src="../../icon/funnel-icon.png" style="display: block;margin-top: 15px;float: right"/>
                            </div>
                        </div>
                    </a>
                    </div>
</div>
</td>

                        </tr>
                    </table>
                    <br/>
	</xsl:template>


	<xsl:template match="test:test">
		  <xsl:variable name="unqId" select="uuid:randomUUID()"/>
                                        <tr class="test_case">
                                                            <td width="6%" align="center" onclick="showContentIn('{$unqId}')"><div>
                                                            	<xsl:attribute name="class">
                                                            		<xsl:if test="@result='Passed'"><xsl:text>success</xsl:text></xsl:if>
																	<xsl:if test="@result='Failed'"><xsl:text>fail</xsl:text></xsl:if>
																	<xsl:if test="@result='CNR'"><xsl:text>cnr</xsl:text></xsl:if>
                                                            	</xsl:attribute>
																	<xsl:if test="@result='Passed'"><xsl:text>Pass</xsl:text></xsl:if>
																	<xsl:if test="@result='Failed'"><xsl:text>Fail</xsl:text></xsl:if>
																	<xsl:if test="@result='CNR'"><xsl:text>CNR</xsl:text></xsl:if></div></td>
                                            <td width="69%" onclick="showContentIn('{$unqId}')"><h5><div style="margin-left:0px" ><xsl:value-of select="test:name"/></div></h5></td>
                                                            <td width="5%" align="center">
                                                            	<xsl:choose>
											<xsl:when test="@elapsed &gt; 3600">
												<xsl:value-of select="floor(@elapsed div 3600)"/> h <xsl:value-of select="floor((@elapsed mod 3600) div 60)"/> m <xsl:value-of select="@elapsed mod 60"/> s
											</xsl:when>
											<xsl:when test="@elapsed &gt; 60">
												<xsl:value-of select="floor(@elapsed div 60)"/> m <xsl:value-of select="@elapsed mod 60"/> s
											</xsl:when>
											<xsl:otherwise>
												<xsl:value-of select="@elapsed"/> s
											</xsl:otherwise>
										</xsl:choose>
                                                            </td>
                                                            <td width="10%" align="center"><a>
                                                            	<xsl:attribute name="href"><xsl:value-of select="test:system-out/@href"/></xsl:attribute>
												<xsl:attribute name="target">_blank</xsl:attribute><img src="../../icon/log-icon.png" style="display: block;margin: auto"/></a></td>
                                                            <td width="10%" align="center"><a>
                                                            	<xsl:attribute name="href"><xsl:value-of select="test:screenshot/@href"/></xsl:attribute>
												<xsl:attribute name="target">_blank</xsl:attribute><img src="../../icon/screenshot-icon.png" style="display: block;margin: auto"/></a></td>

                                    </tr>

                                    <tr style="display: none" id="{$unqId}" >
                                      <td colspan="10">
<table class="test-case-details">
<tbody >
                                <xsl:if test="test:desc">
                                
                                    <tr>
                                        <td>
                                            <b> Description</b>
                                        </td>
                                        <td style="white-space:pre"><xsl:value-of select="test:desc"/></td>
                                    </tr>
                                
                                </xsl:if>
	<xsl:if test="test:output">
<tr>
<td ><b> Message</b></td><td style="white-space:pre" ><xsl:variable name="output" select="test:output" />
											<xsl:call-template name="LineBreaker">
												<xsl:with-param name="line" select="substring-after($output, '&#xA;')"/>
												<xsl:with-param name="separator" select="'&#xA;'"/>
											</xsl:call-template>
</td>
</tr>
</xsl:if>
<xsl:if test="test:error">
<tr>
<td ><b> Failure</b></td><td style="white-space:pre" ><xsl:variable name="error" select="test:error" />
											<xsl:call-template name="LineBreaker">
												<xsl:with-param name="line" select="substring-after($error, '&#xA;')"/>
												<xsl:with-param name="separator" select="'&#xA;'"/>
											</xsl:call-template>
</td>
</tr>
</xsl:if>
</tbody>
</table>                                            </td>

                                    </tr>






	</xsl:template>

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
