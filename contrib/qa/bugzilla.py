#
# BugZilla query page scanner to work with ancient
# Debian Stable bugzilla installationss
#
# This includes three test sites
#   site contains one bug entry
#   all_bugs contains all OpenMoko bugs as of \today
#   no_bug  is a query which showed no bug
#

from HTMLParser import HTMLParser

class BugQueryExtractor(HTMLParser):
    STATE_NONE             = 0
    STATE_FOUND_TR         = 1
    STATE_FOUND_NUMBER     = 2
    STATE_FOUND_PRIO       = 3
    STATE_FOUND_PRIO2      = 4
    STATE_FOUND_NAME       = 5
    STATE_FOUND_PLATFORM   = 6
    STATE_FOUND_STATUS     = 7
    STATE_FOUND_WHATEVER   = 8 # I don't know this field
    STATE_FOUND_DESCRIPTION =9

    def __init__(self):
        HTMLParser.__init__(self)
        self.state = self.STATE_NONE
        self.bugs = []

    def handle_starttag(self, tag, attr):
        if self.state == self.STATE_NONE and tag.lower() == "tr":
            if len(attr) == 1 and attr[0] == ('class', 'bz_normal bz_P2 '):
                print "Found tr %s %s" % (tag, attr)
                self.state = self.STATE_FOUND_TR
        elif self.state == self.STATE_FOUND_TR and tag.lower() == "td":
            self.state += 1

    def handle_endtag(self, tag):
        if tag.lower() == "tr":
            print "Going back"
            if self.state != self.STATE_NONE:
                self.bugs.append( (self.bug,self.status) )
            self.state = self.STATE_NONE
        if self.state > 1 and tag.lower() == "td":
            print "Next TD"
            self.state += 1

    def handle_data(self,data):
        data = data.strip()

        # skip garbage
        if len(data) == 0:
            return
    
        if self.state == self.STATE_FOUND_NUMBER:
            print "Bug Number '%s'" % data.strip()
            self.bug = data
           
        elif self.state == self.STATE_FOUND_STATUS:
            print "Status Name '%s'" % data.strip()
            self.status = data

    def result(self):
        print "Found bugs"
        return self.bugs

#
site = """<!-- 1.0@bugzilla.org -->











<!-- 1.0@bugzilla.org -->




<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Bug List</title>


    
    
    
    <link href="/style/style.css" rel="stylesheet" type="text/css" />
    
        <link href="/bugzilla/css/buglist.css" rel="stylesheet" type="text/css">
  
  </head>
  


  <body bgcolor="#FFFFFF" onload="">


<!-- 1.0@bugzilla.org -->




        <div id="header">
                <a href="http://bugzilla.openmoko.org/cgi-bin/bugzilla/" id="site_logo"><img src="/style/images/openmoko_logo.png" alt="openmoko.org" /></a>
                
                <div id="main_navigation">
                        <ul>
                                <li><a href="http://www.openmoko.org/" class="nav_home"><span>Home</span></a></li>
                                <li><a href="http://wiki.openmoko.org/" class="nav_wiki"><span>Wiki</span></a></li>
                                <li><a href="http://bugzilla.openmoko.org/" class="nav_bugzilla selected"><span>Bugzilla</span></a></li>
                                <li><a href="http://planet.openmoko.org/" class="nav_planet"><span>Planet</span></a></li>
                                <li><a href="http://projects.openmoko.org/" class="nav_projects"><span>Projects</span></a></li>
                                <li><a href="http://lists.openmoko.org/" class="nav_lists"><span>Lists</span></a></li>
                        </ul>
                </div>
        </div>

        <div class="page_title">
                <strong>Bug List</strong> 
        </div>
    
 <div class="container">

<div align="center">
  <b>Tue Mar  6 19:01:13 CET 2007</b><br>


    <a href="quips.cgi"><i>Free your problems
</i></a>

</div>


<hr>

















<!-- 1.0@bugzilla.org -->





















  
  <table class="bz_buglist" cellspacing="0" cellpadding="4" width="100%">
    <colgroup>
      <col class="bz_id_column">
      <col class="bz_severity_column">
      <col class="bz_priority_column">
      <col class="bz_platform_column">
      <col class="bz_owner_column">
      <col class="bz_status_column">
      <col class="bz_resolution_column">
      <col class="bz_summary_column">
    </colgroup>

    <tr align="left">
      <th colspan="1">
        <a href="buglist.cgi?short_desc_type=substring&amp;short_desc=manual+test+bug&amp;product=OpenMoko&amp;component=autobuilds&amp;order=bugs.bug_id">ID</a>
      </th>

<th colspan="1">
    <a href="buglist.cgi?short_desc_type=substring&amp;short_desc=manual+test+bug&amp;product=OpenMoko&amp;component=autobuilds&amp;order=bugs.bug_severity,bugs.bug_id">Sev</a>
  </th><th colspan="1">
    <a href="buglist.cgi?short_desc_type=substring&amp;short_desc=manual+test+bug&amp;product=OpenMoko&amp;component=autobuilds&amp;order=bugs.priority,bugs.bug_id">Pri</a>
  </th><th colspan="1">
    <a href="buglist.cgi?short_desc_type=substring&amp;short_desc=manual+test+bug&amp;product=OpenMoko&amp;component=autobuilds&amp;order=bugs.rep_platform,bugs.bug_id">Plt</a>
  </th><th colspan="1">
    <a href="buglist.cgi?short_desc_type=substring&amp;short_desc=manual+test+bug&amp;product=OpenMoko&amp;component=autobuilds&amp;order=map_assigned_to.login_name,bugs.bug_id">Owner</a>
  </th><th colspan="1">
    <a href="buglist.cgi?short_desc_type=substring&amp;short_desc=manual+test+bug&amp;product=OpenMoko&amp;component=autobuilds&amp;order=bugs.bug_status,bugs.bug_id">State</a>
  </th><th colspan="1">
    <a href="buglist.cgi?short_desc_type=substring&amp;short_desc=manual+test+bug&amp;product=OpenMoko&amp;component=autobuilds&amp;order=bugs.resolution,bugs.bug_id">Result</a>
  </th><th colspan="1">
    <a href="buglist.cgi?short_desc_type=substring&amp;short_desc=manual+test+bug&amp;product=OpenMoko&amp;component=autobuilds&amp;order=bugs.short_desc,bugs.bug_id">Summary</a>
  </th>


    </tr>

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=238">238</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Mac</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>manual test bug
    </td>

  </tr>

  
    </table>





  One bug found.


<br>












  <form method="post" action="long_list.cgi">
    <input type="hidden" name="buglist" value="238">
    <input type="submit" value="Long Format">

    <a href="query.cgi">Query Page</a> &nbsp;&nbsp;
    <a href="enter_bug.cgi">Enter New Bug</a> &nbsp;&nbsp;
    <a href="colchange.cgi?short_desc_type=substring&amp;short_desc=manual+test+bug&amp;product=OpenMoko&amp;component=autobuilds">Change Columns</a> &nbsp;&nbsp;



    <a href="query.cgi?short_desc_type=substring&amp;short_desc=manual+test+bug&amp;product=OpenMoko&amp;component=autobuilds">Edit this Query</a> &nbsp;&nbsp;

  </form>






<!-- 1.0@bugzilla.org -->



  

  
</div>

<div class="footer">
        <div class="group">This is <b>Bugzilla</b>: the Mozilla bug system.  For more information about what Bugzilla is and what it can do, see <a href="http://www.bugzilla.org/">bugzilla.org</a>.</div>
        <!-- 1.0@bugzilla.org -->






<form method="get" action="show_bug.cgi">
        <div class="group">
                <a href="enter_bug.cgi">New</a> | <a href="query.cgi">Query</a> | <input type="submit" value="Find"> bug # <input name="id" size="6"> | <a href="reports.cgi">Reports</a> | <a href="votes.cgi?action=show_user">My Votes</a> 
        </div>
 
        <div class="group">
        Edit <a href="userprefs.cgi">prefs</a> 
        | <a href="relogin.cgi">Log&nbsp;out</a>&nbsp;&nbsp;freyther@yahoo.com
        </div>

    
    
      
    <div class="group">
                  Preset&nbsp;Queries:

          <a href="buglist.cgi?bug_status=NEW&amp;bug_status=ASSIGNED&amp;bug_status=REOPENED&amp;email1=freyther%40yahoo.com&amp;emailtype1=exact&amp;emailassigned_to1=1&amp;emailreporter1=1">My&nbsp;Bugs</a>

    </div>
</form>
</div>  

</body>
</html>
"""

all_bugs = """<!-- 1.0@bugzilla.org -->











<!-- 1.0@bugzilla.org -->




<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Bug List</title>


    
    
    
    <link href="/style/style.css" rel="stylesheet" type="text/css" />
    
        <link href="/bugzilla/css/buglist.css" rel="stylesheet" type="text/css">
  
  </head>
  


  <body bgcolor="#FFFFFF" onload="">


<!-- 1.0@bugzilla.org -->




        <div id="header">
                <a href="http://bugzilla.openmoko.org/cgi-bin/bugzilla/" id="site_logo"><img src="/style/images/openmoko_logo.png" alt="openmoko.org" /></a>
                
                <div id="main_navigation">
                        <ul>
                                <li><a href="http://www.openmoko.org/" class="nav_home"><span>Home</span></a></li>
                                <li><a href="http://wiki.openmoko.org/" class="nav_wiki"><span>Wiki</span></a></li>
                                <li><a href="http://bugzilla.openmoko.org/" class="nav_bugzilla selected"><span>Bugzilla</span></a></li>
                                <li><a href="http://planet.openmoko.org/" class="nav_planet"><span>Planet</span></a></li>
                                <li><a href="http://projects.openmoko.org/" class="nav_projects"><span>Projects</span></a></li>
                                <li><a href="http://lists.openmoko.org/" class="nav_lists"><span>Lists</span></a></li>
                        </ul>
                </div>
        </div>

        <div class="page_title">
                <strong>Bug List</strong> 
        </div>
    
 <div class="container">

<div align="center">
  <b>Tue Mar  6 20:09:40 CET 2007</b><br>


    <a href="quips.cgi"><i>Don't complain -- it could be worse!
</i></a>

</div>


<hr>





228 bugs found.











<!-- 1.0@bugzilla.org -->





















  
  <table class="bz_buglist" cellspacing="0" cellpadding="4" width="100%">
    <colgroup>
      <col class="bz_id_column">
      <col class="bz_severity_column">
      <col class="bz_priority_column">
      <col class="bz_platform_column">
      <col class="bz_owner_column">
      <col class="bz_status_column">
      <col class="bz_resolution_column">
      <col class="bz_summary_column">
    </colgroup>

    <tr align="left">
      <th colspan="1">
        <a href="buglist.cgi?product=OpenMoko&amp;order=bugs.bug_id">ID</a>
      </th>

<th colspan="1">
    <a href="buglist.cgi?product=OpenMoko&amp;order=bugs.bug_severity,bugs.bug_id">Sev</a>
  </th><th colspan="1">
    <a href="buglist.cgi?product=OpenMoko&amp;order=bugs.priority,bugs.bug_id">Pri</a>
  </th><th colspan="1">
    <a href="buglist.cgi?product=OpenMoko&amp;order=bugs.rep_platform,bugs.bug_id">Plt</a>
  </th><th colspan="1">
    <a href="buglist.cgi?product=OpenMoko&amp;order=map_assigned_to.login_name,bugs.bug_id">Owner</a>
  </th><th colspan="1">
    <a href="buglist.cgi?product=OpenMoko&amp;order=bugs.bug_status,bugs.bug_id">State</a>
  </th><th colspan="1">
    <a href="buglist.cgi?product=OpenMoko&amp;order=bugs.resolution,bugs.bug_id">Result</a>
  </th><th colspan="1">
    <a href="buglist.cgi?product=OpenMoko&amp;order=bugs.short_desc,bugs.bug_id">Summary</a>
  </th>


    </tr>

  <tr class="bz_critical bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=1">1</a>
    </td>

    <td><nobr>cri</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>CLOS</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>kernel is running way too slow
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=2">2</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>SD card driver unstable
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=4">4</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>ASSI</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>random crashes of gsmd
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=5">5</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>call progress information is lacking
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=7">7</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>CLOS</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>PMU RTC driver date/time conversion is erroneous
    </td>

  </tr>

  


  

  <tr class="bz_critical bz_P5 ">

    <td>
      <a href="show_bug.cgi?id=8">8</a>
    </td>

    <td><nobr>cri</nobr>
    </td>
    <td><nobr>P5</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>SD/MMC: Card sometimes not detected
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=9">9</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>ASSI low (kernel part)
    </td>

  </tr>

  


  

  <tr class="bz <a href="show_bug.cgi?id=10">10</a>
    </td>

    <td><nobr>e>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>la>
    <td><nobr>CLOS</nobr>
    </td>
    <td><nobr>FIXE</nobr>ng
    </td>

  </tr>

  


  

  <tr class="bz_blocker bz_P2 "><nobr>blo</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
 /nobr>
    </td>
    <td><nobr>ken_zhao@fic-sh.com.cn</nobr>
  ><nobr>FIXE</nobr>
    </td>
    <td>u-boot lacks USB DFU suppo2">12</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>gordon_hsu@f<td>Boot speed too low (bootloader part)
    </td>

  </tr>

  ug.cgi?id=13">13</a>
    </td>

    <td><nobr>nor</nobr>
    </d>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>teddy@fic-snobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
  

  <tr class="bz_minor bz_P2 ">

    <td>
      <a href="shonobr>min</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
   nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><noe before booting th...
    </td>

  </tr>

  


  

  <tr class=15">15</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <oko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
   =18">18</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <<td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    < ...
    </td>

  </tr>

  


  

  <tr class="bz_minor bz_P2 "</a>
    </td>

    <td><nobr>min</nobr>
    </td>
    <td><nob/td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>teddy@fich.com.cn</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
 <nobr>FIXE</nobr>
    </td>
    <td>&quot;reboot&quot; doesn't tr>

  


  

  <tr class="bz_critical bz_P2 ">

    <td>
     f="show_bug.cgi?id=20">20</a>
    </td>

    <td><nobr>cri</nob    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</ </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
d>connection status
    </td>

  </tr>

  


  

  <tr class="ber bz_P3 ">

    <td>
      <a href="show_bug.cgi?id=21">21</a>  <td><nobr>blo</nobr>
    </td>
    <td><nobr>P3</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>sean_chiannobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nob <td>sms function missing
    </td>

  </tr>

  


  

  <tr cl="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=2/a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr</td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@ko.org</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
   nobr>FIXE</nobr>
    </td>
    <td>outgoing call generates 'seg...
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 "<td>
      <a href="show_bug.cgi?id=23">23</a>
    </td>

    <<nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
  obr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </d><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </ttd>dtmf support not available now
    </td>

  </tr>

  


  

wishlist bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=24">
    </td>

    <td><nobr>wis</nobr>
    </td>
    <td><nobr>P2   </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>lafornmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
 br>
    </td>
    <td>libgsmd/misc.h: lgsm_get_signal_quality()</td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    < <a href="show_bug.cgi?id=25">25</a>
    </td>

    <td><nobr>n
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
   >
    <td><nobr>davewu01@seed.net.tw</nobr>
    </td>
    <td><</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>GtkSpd
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">
>
      <a href="show_bug.cgi?id=26">26</a>
    </td>

    <td>>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td  </td>
    <td><nobr>ken_zhao@fic-sh.com.cn</nobr>
    </td>
 br>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <tdngine and Shadows
    </td>

  </tr>

  


  

  <tr class="bz_  <td>
      <a href="show_bug.cgi?id=27">27</a>
    </td>

   <nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
  d><nobr>Neo</nobr>
    </td>
    <td><nobr>ken_zhao@fic-sh.com.<td><nobr>ASSI</nobr>
    </td>
    <td><nobr></nobr>
    </td>Labels on GtkButton don't appear centered
    </td>

  </tr>

  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="shog.cgi?id=28">28</a>
    </td>

    <td><nobr>nor</nobr>
    </tP2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td>zhao@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>NEW</nobr>
  >
    <td><nobr></nobr>
    </td>
    <td>GtkComboBox styling w  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
   a href="show_bug.cgi?id=29">29</a>
    </td>

    <td><nobr>nor  </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nod>
    <td><nobr>ken_zhao@fic-sh.com.cn</nobr>
    </td>
    <t>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    ProgressBar styling woes
    </td>

  </tr>

  


  

  <tr cla2 ">

    <td>
      <a href="show_bug.cgi?id=30">30</a>
    </  <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td><nobr>Neo</nobr>
    </td>
    <td><nobr>mickey@vanille-meditd>
    <td><nobr>REOP</nobr>
    </td>
    <td><nobr></nobr>
 d>
    <td>Touchscreen emits bogus events under X
    </td>

    

  <tr class="bz_critical bz_P2 ">

    <td>
      <a href="=31">31</a>
    </td>

    <td><nobr>cri</nobr>
    </td>
    <P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td>rge@openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
      <td><nobr></nobr>
    </td>
    <td>Display colors are slight </tr>

  


  

  <tr class="bz_enhancement bz_P2 ">

    <td>    <a href="show_bug.cgi?id=32">32</a>
    </td>

    <td><nob/nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nob>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <tW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Commction for loading GdkPixbuf
    </td>

  </tr>

  


  

  <tr ocker bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=33">33<d>

    <td><nobr>blo</nobr>
    </td>
    <td><nobr>P2</nobr>
td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@op </td>
    <td><nobr>ASSI</nobr>
    </td>
    <td><nobr></nobrd>
    <td>incoming call status report causes gsmd to crash.
  >

  </tr>

  


  

  <tr class="bz_blocker bz_P2 ">

    <td>bug.cgi?id=34">34</a>
    </td>

    <td><nobr>blo</nobr>
    <  <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <tdI</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Need lgsm_handle is still valid.
    </td>

  </tr>

  


  

  <tr_enhancement bz_P5 ">

    <td>
      <a href="show_bug.cgi?id=a>
    </td>

    <td><nobr>enh</nobr>
    </td>
    <td><nobr>td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@openmoko.orbr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobrobr>
    </td>
    <td>Support debug board from u-boot
    </td <tr class="bz_blocker bz_P2 ">

    <td>
      <a href="show_bid=36">36</a>
    </td>

    <td><nobr>blo</nobr>
    </td>
   >P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <tdge@openmoko.org</nobr>
    </td>
    <td><nobr>RESO</nobr>
       <td><nobr>FIXE</nobr>
    </td>
    <td>Implement s3c2410 udice controller) driver in u...
    </td>

  </tr>

  


  

  <obr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>RESO</n

  </tr>

  


  

  <tr class="bz_enhancement bz_P2 ">

    <r>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr</td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <    </td>
    <td><nobr>werner@openmoko.org</nobr>
    </td>
  href="show_bug.cgi?id=41">41</a>
    </td>

    <td><nobr>enh</</td>

  </tr>

  


  

  <tr class="bz_blocker bz_P3 ">

    
    </td>
    <td>dynamic mtd partition table cration
    </tdusBar (Footer) API
    </td>

  </tr>

  


  

  <tr class="bz   </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

  td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
  gi?id=46">46</a>
    </td>

    <td><nobr>maj</nobr>
    </td>

    <td>
      <a href="show_bug.cgi?id=47">47</a>
    </td>

obr>
    </td>
    <td><nobr>DUPL</nobr>
    </td>
    <td>Eval

  


  

  <tr class="bz_major bz_P2 ">

    <td>
      <a hr=48">48</a>
    </td>

    <td><nobr>maj</nobr>
    </td>
    <P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td>r>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>RESO</nobtd><nobr>DUPL</nobr>
    </td>
    <td>Only power up the phone e power button was pressed ...
    </td>

  </tr>

  


  

  <"bz_minor bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=49"  <td><nobr>min</nobr>
    </td>
    <td><nobr>P2</nobr>
    </   <td><nobr>All</nobr>
    </td>
    <td><nobr>mickey@vanille-/nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><no/nobr>
    </td>
    <td>Implement touchscreen &amp; click daem

  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="g.cgi?id=50">50</a>
    </td>

    <td><nobr>nor</nobr>
    </t    <td><nobr>P2</nobr>
    </td>
    <td><nobr>All</nobr>
    obr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>NEW<td>
    <td><nobr></nobr>
    </td>
    <td>Sound Event API
     </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
   g.cgi?id=51">51</a>
    </td>

    <td><nobr>nor</nobr>
    </t  <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </<nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>NE<td><nobr></nobr>
    </td>
    <td>Preferences API
    </td>

/tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      show_bug.cgi?id=52">52</a>
    </td>

    <td><nobr>nor</nobr>
  <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </obr>cj_steven@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>RESO  </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>Single Inst

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
  href="show_bug.cgi?id=53">53</a>
    </td>

    <td><nobr>nor<  </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>All</no   </td>
    <td><nobr>tonyguan@fic-sh.com.cn</nobr>
    </td>
RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <ones during call
    </td>

  </tr>

  


  

  <tr class="bz_bocker bz_P1 ">

    <td>
      <a href="show_bug.cgi?id=54">54<nobr>
    </td>
    <td><nobr>P1</nobr>
    </td>
    <td><nobrobr>
    </td>
    <td><nobr>tonyguan@fic-sh.com.cn</nobr>
    >
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>>PIN Entry
    </td>

  </tr>

  


  

  <tr class="bz_major b

    <td>
      <a href="show_bug.cgi?id=55">55</a>
    </td>
obr>maj</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    r>
    </td>
    <td><nobr>tonyguan@fic-sh.com.cn</nobr>
    </  <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
       <td>Don't pop up the dialer interface initially
    </td>

 <tr class="bz_blocker bz_P4 ">

    <td>
      <a href="show_b6">56</a>
    </td>

    <td><nobr>blo</nobr>
    </td>
    <tdr>P4</nobr>
    </td>
    <td><nobr>All</nobr>
    </td>
    <tyguan@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>RESO</nobr>
obr>FIXE</nobr>
    </td>
    <td>Integrate with contacts datab </td>

  </tr>

  


  

  <tr class="bz_minor bz_P2 ">

    <    <a href="show_bug.cgi?id=57">57</a>
    </td>

    <td><nob  <td><nobr>P2</nobr>
    </td>
    <td><nobr>All</nobr>
    </    <td><nobr>tonyguan@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>
    </td>
    <td><nobr>LATE</nobr>
    </td>
    <td>Rec/td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <t  <a href="show_bug.cgi?id=58">58</a>
    </td>

    <td><nobr>>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td>r>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td> devmand
    </td>

  </tr>

  


  

  <tr class="bz_enhancemetd>
      <a href="show_bug.cgi?id=59">59</a>
    </td>

    <tenh</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td>eo</nobr>
    </td>
    <td><nobr>ken_zhao@fic-sh.com.cn</nobr>d><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
  d>Real DPI vs. Fake DPI
    </td>

  </tr>

  


  

  <tr clas bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=60">60</a>
 >

    <td><nobr>min</nobr>
    </td>
    <td><nobr>P2</nobr>
 nobr>Neo</nobr>
    </td>
    <td><nobr>ken_zhao@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><no
    </td>
    <td>fontconfig antialiasing
    </td>

  </tr>

s="bz_major bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=6>
    </td>

    <td><nobr>maj</nobr>
    </td>
    <td><nobr>Pnobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nob</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr>
    </td>
    <td>Theme is very slow
    </td>

  </tr>

 
  <tr class="bz_wishlist bz_P2 ">

    <td>
      <a href="sho</a>
    </td>

    <td><nobr>wis</nobr>
    </td>
    <td><nobbr>
    </td>
    <td><nobr>All</nobr>
    </td>
    <td><nobr>ey@vanille-media.de</nobr>
    </td>
    <td><nobr>NEW</nobr>
 nobr></nobr>
    </td>
    <td>High Level Multi Layer Network Dry API
    </td>

  </tr>

  


  

  <tr class="bz_enhancement    <td>
      <a href="show_bug.cgi?id=63">63</a>
    </td>

 /nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nob/nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
 
    <td><nobr>ASSI</nobr>
    </td>
    <td><nobr></nobr>
       <td>matchbox-panel 1 vs. 2
    </td>

  </tr>

  


  

  <t_P2 ">

    <td>
      <a href="show_bug.cgi?id=64">64</a>
    <td><nobr>maj</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td<td><nobr>Neo</nobr>
    </td>
    <td><nobr>mickey@vanille-med  </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr
    <td>Show Cipher Status in GSM-Panel applet
    </td>

  </

  


  

  <tr class="bz_major bz_P2 ">

    <td>
      <a hr?id=65">65</a>
    </td>

    <td><nobr>maj</nobr>
    </td>
  r>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <t>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>NEW</nofor SMS overflow
    </td>

  </tr>

  


  

  <tr class="bz_c href="show_bug.cgi?id=66">66</a>
    </td>

    <td><nobr>cri<    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td for Missed Events
    </td>

  </tr>

  


  

  <tr class="bz<td>
      <a href="show_bug.cgi?id=67">67</a>
    </td>

    <d>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>All</nobr>
 ><nobr>RESO</nobr>
    </td>
    <td><nobr>WONT</nobr>
    </td    <td>
      <a href="show_bug.cgi?id=68">68</a>
    </td>

 
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
   </nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nr bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=69">69</a>
obr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>td><nobr>buglog@lists.openmoko.org</nobr>
    </td>
    <td><nonobr>
    </td>
    <td>Speed up System Initialization
    </td href="show_bug.cgi?id=70">70</a>
    </td>

    <td><nobr>nor<br>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Minimement bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=71">71<br>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Nh.com.cn</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
 d>make a short vibration pulse once u-boot is starting
    </td href="show_bug.cgi?id=72">72</a>
    </td>

    <td><nobr>wis<  </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>gordon </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</Add on-screen boot menu
    </td>

  </tr>

  


  

  <tr clas ">

    <td>
      <a href="show_bug.cgi?id=73">73</a>
    </t>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>r>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>test a</tr>

  


  

  <tr class="bz_blocker bz_P1 ">

    <td>
    lo</nobr>
    </td>
    <td><nobr>P1</nobr>
    </td>
    <td></td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>WONT</nodriver to power up amp and route audio through...
    </td>

  /a>
    </td>

    <td><nobr>maj</nobr>
    </td>
    <td><nobr   <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobE</nobr>
    </td>
    <td>PWM code for display brightness cont
    <td>
      <a href="show_bug.cgi?id=76">76</a>
    </td>


    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    <or
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">r>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neobr>songcw@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>NEW</no
    <td>Finish, test and verify agpsd implementation
    </td>_P2 ">

    <td>
      <a href="show_bug.cgi?id=78">78</a>
    /td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@oSO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td and test ASoC platform driver
    </td>

  </tr>

  


  

  <er bz_P1 ">

    <td>
      <a href="show_bug.cgi?id=79">79</a>

    <td><nobr>blo</nobr>
    </td>
    <td><nobr>P1</nobr>
     <td><nobr>Neo</nobr>
    </td>
    <td><nobr>werner@openmoko
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FI   </td>
    <td>suspend/resume to RAM support
    </td>

  </t

  <tr class="bz_major bz_P2 ">

    <td>
      <a href="show_80">80</a>
    </td>

    <td><nobr>maj</nobr>
    </td>
    <t>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td<nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>RESO<    <td><nobr>WONT</nobr>
    </td>
    <td>Add sysfs entry foreup reason
    </td>

  </tr>

  


  

  <tr class="bz_major b    <td>
      <a href="show_bug.cgi?id=81">81</a>
    </td>

    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</n    </td>
    <td><nobr>werner@openmoko.org</nobr>
    </td>
  td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
 TC alarm interrupt is signalled to userspace
    </td>

  </tr>
  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="s2</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><no</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nrg</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td>/nobr>
    </td>
    <td>implement and test cpufreq interface t PLL / SLO...
    </td>

  </tr>

  


  

  <tr class="bz_enha
    <td>
      <a href="show_bug.cgi?id=83">83</a>
    </td>

 <td><nobr>enh</nobr>
    </td>
    <td><nobr>P2</nobr>
    </t<td><nobr>Neo</nobr>
    </td>
    <td><nobr>teddy@fic-sh.com.c   </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nob    <td>evaluate process and I/O schedulers
    </td>

  </tr>


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="84">84</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <tr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <trge@openmoko.org</nobr>
    </td>
    <td><nobr>RESO</nobr>
   r>FIXE</nobr>
    </td>
    <td>enable voluntary preemption
   >

  </tr>

  


  

  <tr class="bz_minor bz_P2 ">

    <td>
  href="show_bug.cgi?id=85">85</a>
    </td>

    <td><nobr>min<r>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Netd>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <tdRESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <test NO_IDLE_HZ / tickless idle
    </td>

  </tr>

  


  

  bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=86">86</a>
     <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    <  <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@openmoko </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</>
    </td>
    <td>APM emulation for battery / charger / chargpossib...
    </td>

  </tr>

  


  

  <tr class="bz_normal b <a href="show_bug.cgi?id=87">87</a>
    </td>

    <td><nobr>nbr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </EW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>def implement how headphone jack routing/signallin...
    </td>

 
  


  

  <tr class="bz_minor bz_P2 ">

    <td>
      <a hreid=88">88</a>
    </td>

    <td><nobr>min</nobr>
    </td>
   2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><sh.com.cn</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
 td><nobr></nobr>
    </td>
    <td>use and test PMU watchdog dr  </tr>

  


  

  <tr class="bz_critical bz_P2 ">

    <td>
 ref="show_bug.cgi?id=89">89</a>
    </td>

    <td><nobr>cri</n   </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</n
    <td><nobr>teddy@fic-sh.com.cn</nobr>
    </td>
    <td><no/nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>determct gamma calibration values and put them i...
    </td>

  </tr
  

  <tr class="bz_critical bz_P1 ">

    <td>
      <a href=g.cgi?id=90">90</a>
    </td>

    <td><nobr>cri</nobr>
    </ttd><nobr>P1</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>ge@openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    <  <td><nobr></nobr>
    </td>
    <td>GSM TS07.10 multiplex mis </td>

  </tr>

  


  

  <tr class="bz_major bz_P2 ">

    <ow_bug.cgi?id=91">91</a>
    </td>

    <td><nobr>maj</nobr>
  d>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
 /td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <tbr>
    </td>
    <td><nobr>DUPL</nobr>
    </td>
    <td>debugcard timeout problems
    </td>

  </tr>

  


  

  <tr class=z_P2 ">

    <td>
      <a href="show_bug.cgi?id=92">92</a>
   >

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
 br>Neo</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nob</td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</n  </td>
    <td>test multiple microSD card vendors for compatib..
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 "><td>
      <a href="show_bug.cgi?id=93">93</a>
    </td>

    <obr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nNEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>temicroSD card compatibility
    </td>

  </tr>

  


  

  <tr cbz_P2 ">

    <td>
      <a href="show_bug.cgi?id=94">94</a>
  
    <td><nobr>maj</nobr>
    </td>
    <td><nobr>P2</nobr>
      <td><nobr>Neo</nobr>
    </td>
    <td><nobr>tonyguan@fic-shtd>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nob/td>
    <td>+ symbol support
    </td>

  </tr>

  


  

  <t="bz_minor bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=95>

    <td><nobr>min</nobr>
    </td>
    <td><nobr>P2</nobr>
 /td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>sean_chiac.com.tw</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
  r></nobr>
    </td>
    <td>verify charger current and battery ing co...
    </td>

  </tr>

  


  

  <tr class="bz_major bz/td>
    <td>make sure PMU alarm (set via rtc interface) is per   </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nr class="bz_enhancement bz_P2 ">

    <td>
      <a href="show_lass="bz_major bz_P2 ">

    <td>
      <a href="show_bug.cgi?i
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
g.cgi?id=100">100</a>
    </td>

    <td><nobr>maj</nobr>
    <>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laf><nobr>cri</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
 
  


  

  <tr class="bz_blocker bz_P1 ">

    <td>
      <a hr>Neo</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr/td>

    <td><nobr>cri</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td>Volume control
    </td>

  </tr>

  
    <class="bz_platform_column">
      <col class="bz_owner_column">_id">Sev</a>
  </th><th colspan="1">
    <a href="buglist.cgi?p">Pri</a>
  </th><th colspan="1">
    <a href="buglist.cgi?prodpenMoko&amp;order=bugs.rep_platform,bugs.bug_id">Plt</a>
  </thth colspan="1">
    <a href="buglist.cgi?product=OpenMoko&amp;ogned_to.login_name,bugs.bug_id">Owner</a>
  </th><th colspan="1  <a href="buglist.cgi?product=OpenMoko&amp;order=bugs.bug_statgs.bug_id">State</a>
  </th><th colspan="1">
    <a href="bugliroduct=OpenMoko&amp;order=bugs.resolution,bugs.bug_id">Result</ </th><th colspan="1">
    <a href="buglist.cgi?product=OpenMokrder=bugs.short_desc,bugs.bug_id">Summary</a>
  </th>


    </t_enhancement bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=105</a>
    </td>

    <td><nobr>enh</nobr>
    </td>
    <td><P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td>enmoko.org</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>  <td><nobr>DUPL</nobr>
    </td>
    <td>add passthrough mode
td>

  </tr>

  


  

  <tr class="bz_blocker bz_P2 ">

    <tshow_bug.cgi?id=106">106</a>
    </td>

    <td><nobr>blo</nobr  </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</no</td>
    <td><nobr>tonyguan@fic-sh.com.cn</nobr>
    </td>
   ><nobr>RESO</nobr>
    </td>
    <td><nobr>LATE</nobr>
    </tdrgency Call Support
    </td>

  </tr>

  


  

  <tr class="bor bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=107">107</ </td>

    <td><nobr>maj</nobr>
    </td>
    <td><nobr>P2</no>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@openg</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><r></nobr>
    </td>
    <td>obtain list of operators / control tion
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 

    <td>
      <a href="show_bug.cgi?id=108">108</a>
    </td <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </t>Neo</nobr>
    </td>
    <td><nobr>tonyguan@fic-sh.com.cn</nob   </td>
    <td><nobr>REOP</nobr>
    </td>
    <td><nobr></no   </td>
    <td>allow query of manufacturer/model/revision/imetr>

  


  

  <tr class="bz_enhancement bz_P2 ">

    <td>
    <a href="show_bug.cgi?id=109">109</a>
    </td>

    <td><nobnobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobrd>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td>obr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <tdd dbus interface, like recent upstream gpsd
    </td>

  </tr> 


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a hrefcgi?id=110">110</a>
    </td>

    <td><nobr>nor</nobr>
    </t  <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </   <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nob>
    </td>
    <td><nobr></nobr>
    </td>
    <td>look into gps integration
    </td>

  </tr>

  


  

  <tr class="bz_norbz_P2 ">

    <td>
      <a href="show_bug.cgi?id=111">111</a>
  <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </  <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@openmokorg</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td> <td>integrate agpsd in our system power management.
    </td>
  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a hreow_bug.cgi?id=112">112</a>
    </td>

    <td><nobr>nor</nobr>
><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
  <td><nobr>buglog@lists.openmoko.org</nobr>
    </td>
    <td><NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Hoo deliver kernel-level alarm to destination app
    </td>

  </
  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_i?id=113">113</a>
    </td>

    <td><nobr>nor</nobr>
    </td>   <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    <obr>marcel@holtmann.org</nobr>
    </td>
    <td><nobr>ASSI</no   </td>
    <td><nobr></nobr>
    </td>
    <td>bluetooth headupport
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P>
      <a href="show_bug.cgi?id=114">114</a>
    </td>

    <tbr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <<nobr>Neo</nobr>
    </td>
    <td><nobr>buglog@lists.openmoko.   </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nob</td>
    <td>Who is managing wakeup times?
    </td>

  </tr>

  

  <tr class="bz_enhancement bz_P2 ">

    <td>
      <a hrug.cgi?id=115">115</a>
    </td>

    <td><nobr>enh</nobr>
    
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
   td>
    <td><nobr>marcel@holtmann.org</nobr>
    </td>
    <td>
    </td>
    <td><nobr></nobr>
    </td>
    <td>A2DP / alsa tion
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 
    <td>
      <a href="show_bug.cgi?id=116">116</a>
    </td> <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </tobr>Neo</nobr>
    </td>
    <td><nobr>marcel@holtmann.org</nob</td>
    <td><nobr>ASSI</nobr>
    </td>
    <td><nobr></nobr> </td>
    <td>bluetooth HID support (host)
    </td>

  </tr>
ass="bz_minor bz_P2 ">

    <td>
      <a href="show_bug.cgi?id>117</a>
    </td>

    <td><nobr>min</nobr>
    </td>
    <td>br>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <ann.org</nobr>
    </td>
    <td><nobr>ASSI</nobr>
    </td>
  td><nobr></nobr>
    </td>
    <td>bluetooth HID support (devic  </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    href="show_bug.cgi?id=118">118</a>
    </td>

    <td><nobr>nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Nobr>
    </td>
    <td><nobr>marcel@holtmann.org</nobr>
    </tobr>ASSI</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>bluetooth networking support
    </td>

  </tr>

  


  

  <tr class="bz_critical bz_P3 ">

    <td>
      <a href="show_b9</a>
    </td>

    <td><nobr>cri</nobr>
    </td>
    <td><noP3</nobr>
    </td>
    <td><nobr>All</nobr>
    </td>
    <td>br>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>NEW</
    </td>
    <td><nobr></nobr>
    </td>
    <td>merge openmoer into openmoko-footer
    </td>

  </tr>

  


  

  <tr clas_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=120">0</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><no</td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>marcel@hmann.org</nobr>
    </td>
    <td><nobr>ASSI</nobr>
    </td>
 <td><nobr></nobr>
    </td>
    <td>bluetooth OBEX
    </td>

   <tr class="bz_critical bz_P3 ">

    <td>
      <a href="showbug.cgi?id=121">121</a>
    </td>

    <td><nobr>cri</nobr>
   
    <td><nobr>P3</nobr>
    </td>
    <td><nobr>All</nobr>
   >mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>NEW</no    </td>
    <td><nobr></nobr>
    </td>
    <td>merge openmokainmenu into openmoko-mainmenu (panel)
    </td>

  </tr>

  

rmal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=122">122 </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</no   </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>mickee</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><br></nobr>
    </td>
    <td>rename openmoko-history to openmoks="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id= </td>
    <td><nobr>DUPL</nobr>
    </td>
    <td>rename openmtion
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 <nobr>P2</nobr>
    </td>
    <td><nobr>All</nobr>
    </td>
  r>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a </td>
    <td>Remove back functionality from Main Menu
    </tr>
    </td>
    <td><nobr>davewu01@seed.net.tw</nobr>
    </td   </td>
    <td><nobr>cj_steven@fic-sh.com.cn</nobr>
    </td></td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nob </td>
    <td><nobr></nobr>
    </td>
    <td>Create / Find be   </td>
    <td><nobr>All</nobr>
    </td>
    <td><nobr>micke  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <td><nobr>ASSI</nobr>
    </td>
    <td><nobr></nobr>
    </nobr>
    </td>
    <td><nobr>sunzhiyong@fic-sh.com.cn</nobr>
 l</nobr>
    </td>
    <td><nobr>davewu01@seed.net.tw</nobr>
  d>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>lications need close function
    </td>

  </tr>

  


  

  <t    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td>nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr<td>
      <a href="show_bug.cgi?id=137">137</a>
    </td>

   obr>
    </td>
    <td>submit patch against ipkg upstream
    <
    </td>
    <td><nobr>sunzhiyong@fic-sh.com.cn</nobr>
    </ss="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
  

    <td>
      <a href="show_bug.cgi?id=140">140</a>
    </tdfbgrab from openEZX to openmoko-devel...
    </td>

  </tr>

  >All</nobr>
    </td>
    <td><nobr>buglog@lists.openmoko.org</142</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><hancement bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=143  


  

  <tr class="bz_major bz_P2 ">

    <td>
      <a hreftd>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    br>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <tdone is hard-rebooted, Xfbdev complains about /tmp/...
    </td>ss="bz_blocker bz_P2 ">

    <td>
      <a href="show_bug.cgi?i>145</a>
    </td>

    <td><nobr>blo</nobr>
    </td>
    <td></nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><npenmoko.org</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td
    </td>
    <td>battery is not automatically charging
    </ </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
    show_bug.cgi?id=146">146</a>
    </td>

    <td><nobr>nor</nobr <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <tdSO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <tdes not contain latest svn code
    </td>

  </tr>

  


  

  <ass="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?i147</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><d>
    <td><nobr>PC</nobr>
    </td>
    <td><nobr>mickey@vanildia.de</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
   WONT</nobr>
    </td>
    <td>openmoko-panel-applet could not b

  </tr>

  


  

  <tr class="bz_blocker bz_P1 ">

    <td>
  <a href="show_bug.cgi?id=148">148</a>
    </td>

    <td><nobo</nobr>
    </td>
    <td><nobr>P1</nobr>
    </td>
    <td><n</td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <r>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    not talking to TI modem on GTA01Bv2
    </td>

  </tr>

  


 <tr class="bz_major bz_P2 ">

    <td>
      <a href="show_bug.9</a>
    </td>

    <td><nobr>maj</nobr>
    </td>
    <td><nonobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobopenmoko.org</nobr>
    </td>
    <td><nobr>ASSI</nobr>
    </tobr>
    </td>
    <td>lm4857 not i2c address compliant
    </t/tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      ef="show_bug.cgi?id=150">150</a>
    </td>

    <td><nobr>nor</
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
     <td><nobr>graeme.gregory@wolfsonmicro...</nobr>
    </td>
   obr>RESO</nobr>
    </td>
    <td><nobr>INVA</nobr>
    </td>
  doesn't compile
    </td>

  </tr>

  


  

  <tr class="bz_nz_P2 ">

    <td>
      <a href="show_bug.cgi?id=151">151</a>
 d><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
br>
    </td>
    <td><nobr>cj_steven@fic-sh.com.cn</nobr>
       <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </t <td>Does mainmenu need libmatchbox or not?
    </td>

  </tr>
"bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=15</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nob/nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <td><nobsteven@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>NEW</nobr>
></nobr>
    </td>
    <td>VFOLDERDIR is hardcoded
    </td>

 
  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a hrw_bug.cgi?id=153">153</a>
    </td>

    <td><nobr>nor</nobr>
 <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>d><nobr>sunzhiyong@fic-sh.com.cn</nobr>
    </td>
    <td><nobrnobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>RationaIconView instead of deriving?
    </td>

  </tr>

  


  

  <t_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=154">>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P    <td><nobr>PC</nobr>
    </td>
    <td><nobr>sunzhiyong@fic-cn</nobr>
    </td>
    <td><nobr>ASSI</nobr>
    </td>
    <td</nobr>
    </td>
    <td>mainmenu crashes when clicking wheel  </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

     <a href="show_bug.cgi?id=155">155</a>
    </td>

    <td><nobrr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC   </td>
    <td><nobr>sunzhiyong@fic-sh.com.cn</nobr>
    </tdESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <tto get back one level if you are in a subdirectory?
    </td>



  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a h156">156</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    obr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <nzhiyong@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>ASSI</nobobr></nobr>
    </td>
    <td>Where is mainmenu going to look fications?
    </td>

  </tr>

  


  

  <tr class="bz_normal b2 ">

    <td>
      <a href="show_bug.cgi?id=157">157</a>
    d><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
obr>PC</nobr>
    </td>
    <td><nobr>davewu01@seed.net.tw</nob  </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>DUPL<  <td>The sizes of each keys are too small
    </td>

  </tr>



  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="_bug.cgi?id=158">158</a>
    </td>

    <td><nobr>nor</nobr>
  P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <td><log@lists.openmoko.org</nobr>
    </td>
    <td><nobr>RESO</nob/td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>musicplayer cr   </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

  "show_bug.cgi?id=159">159</a>
    </td>

    <td><nobr>nor</nob/td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
>
    <td><nobr>sunzhiyong@fic-sh.com.cn</nobr>
    </td>
    <    </td>
    <td><nobr></nobr>
    </td>
    <td>display thumbctual applications
    </td>

  </tr>

  


  

  <tr class="bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=160">160</a>
  </nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><noobr>
    </td>
    <td><nobr>sunzhiyong@fic-sh.com.cn</nobr>
  td>
    <td><nobr>ASSI</nobr>
    </td>
    <td><nobr></nobr>
 isplay thumbnails in 3x3 grid
    </td>

  </tr>

  


  

  <t"bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=16a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>O</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>br>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>RESO<r>PC</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nor>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>wove non-SanDisk microSD support in u-boot
    </td>

  </tr>

 >

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
 d>

  </tr>

  


  

  <tr class="bz_minor bz_P2 ">

    <td>
bug.cgi?id=167">167</a>
    </td>

    <td><nobr>enh</nobr>
    <tr class="bz_minor bz_P2 ">

    <td>
      <a href="show_bugobr>
    </td>
    <td><nobr>buglog@lists.openmoko.org</nobr>
   <td>
      <a href="show_bug.cgi?id=169">169</a>
    </td>

 /td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>gdb currently   </tr>

  


  

  <tr class="bz_major bz_P2 ">

    <td>
       </td>
    <td>agpsd source code and bitbake rules not in ourtd>
    <td><nobr>Oth</nobr>
    </td>
    <td><nobr>tonyguan@f
  


  

  <tr class="bz_major bz_P2 ">

    <td>
      <a hremoko.org</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
 ">

    <td>
      <a href="show_bug.cgi?id=174">174</a>
    </ <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
        </td>
    <td><nobr>PC</nobr>
    </td>
    <td><nobr>micke </td>

  </tr>

  


  

  <tr class="bz_critical bz_P2 ">

  </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
     functions should return GtkWidget
    </td>

  </tr>

  


  
/td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>u-boot 'factord><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
 t bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=181">181</atorage/Retrieval Application
    </td>

  </tr>

  


  

  <tr/nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><n"bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=18/a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>
    <td><nobr>Mac</nobr>
    </td>
    <td><nobr>mickey@vanil.de</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td></nobr>
    </td>
    <td>openmoko-simple-mediaplayer missing ...
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 "   <td>
      <a href="show_bug.cgi?id=184">184</a>
    </td>

br>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <>
    </td>
    <td><nobr>cj_steven@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
  td>openmoko-mainmenu should link against libmb
    </td>

  </t


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href=185">185</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    nobr>P2</nobr>
    </td>
    <td><nobr>Mac</nobr>
    </td>
   >thomas@openedhand.com</nobr>
    </td>
    <td><nobr>RESO</nobtd><nobr>FIXE</nobr>
    </td>
    <td>openmoko-dates lacks intdate.in
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_

    <td>
      <a href="show_bug.cgi?id=186">186</a>
    </tdnor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td></nobr>
    </td>
    <td><nobr>thomas@openedhand.com</nobr>
  td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobgerbubbles take endless amount of ram and get OOMed
    </td>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a hrehow_bug.cgi?id=187">187</a>
    </td>

    <td><nobr>nor</nobr><nobr>P2</nobr>
    </td>
    <td><nobr>Mac</nobr>
    </td>
  nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>RESr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>src/tasn't mention ipkg patch
    </td>

  </tr>

  


  

  <tr clasnormal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=188">1    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2<   </td>
    <td><nobr>Mac</nobr>
    </td>
    <td><nobr>micke</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><br>
    </td>
    <td>openmoko-panel-demo fails to build
    </ </tr>

  


  

  <tr class="bz_normal bz_P5 ">

    <td>
    gi?id=189">189</a>
    </td>

    <td><nobr>nor</nobr>
    </tdnobr>
    </td>
    <td><nobr>Mac</nobr>
    </td>
    <td><nobas@openedhand.com</nobr>
    </td>
    <td><nobr>RESO</nobr>
  r>FIXE</nobr>
    </td>
    <td>openmoko-dates tries to includestant header
    </td>

  </tr>

  


  

  <tr class="bz_norma">

    <td>
      <a href="show_bug.cgi?id=190">190</a>
    </r</nobr>
    </td>
    <td><nobr>P5</nobr>
    </td>
    <td><n>Mac</nobr>
    </td>
    <td><nobr>thomas@openedhand.com</nobr>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr><td>No rule to build dates.desktop
    </td>

  </tr>

  


  
r class="bz_enhancement bz_P2 ">

    <td>
      <a href="show_i?id=192">192</a>
    </td>

    <td><nobr>enh</nobr>
    </td>br>
    </td>
    <td><nobr>Mac</nobr>
    </td>
    <td><nobr>s.openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </ <td><nobr></nobr>
    </td>
    <td>Graphic bootsplash during space sysinit
    </td>

  </tr>

  


  

  <tr class="bz_mino <a href="show_bug.cgi?id=194">194</a>
    </td>

    <td><nobrbr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>N
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>s3c24t mode corrupt
    </td>

  </tr>

  


  

  <tr class="bz_nor
    <td>
      <a href="show_bug.cgi?id=195">195</a>
    </td>/nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobnobr>
    </td>
    <td><nobr>stefan@openmoko.org</nobr>
    </
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    <sthrough mode (Directly use GSM Modem from PC
    </td>

  </tr
  


  

  <tr class="bz_enhancement bz_P2 ">

    <td>
      bug.cgi?id=196">196</a>
    </td>

    <td><nobr>enh</nobr>
   br>
    </td>
    <td><nobr>Mac</nobr>
    </td>
    <td><nobr>nille-media.de</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </  <td><nobr></nobr>
    </td>
    <td>Merge back fixes to openm recipes from OE
    </td>

  </tr>

  


  

  <tr class="bz_n  <td>
      <a href="show_bug.cgi?id=197">197</a>
    </td>

 obr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    r>PC</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</no
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    <<td>Make theme suitable for qvga screens.
    </td>

  </tr>

 

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>la@openmoko.org</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </<nobr>FIXE</nobr>
    </td>
    <td>Please enable CONFIG_TUN asefconfig-fic-gta01
    </td>

  </tr>

  


  

  <tr class="bzor bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=199">199</   <td><nobr>maj</nobr>
    </td>
    <td><nobr>P2</nobr>
    < <td><nobr>Neo</nobr>
    </td>
    <td><nobr>sean_mosko@fic.conobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nob   <td>We need freely licensed ringtones
    </td>

  </tr>

   

  <tr class="bz_minor bz_P2 ">

    <td>
      <a href="show=200">200</a>
    </td>

    <td><nobr>min</nobr>
    </td>
   nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    lle-media.de</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </tdtd><nobr></nobr>
    </td>
    <td>PARALLEL_MAKE seems to not w </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    f="show_bug.cgi?id=201">201</a>
    </td>

    <td><nobr>nor</n
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo<</td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <  </td>
    <td><nobr></nobr>
    </td>
    <td>Use TEXT_BASE 0000 in u-boot on GTA01Bv2 and higher
    </td>

  </tr>

  


 nobr>Neo</nobr>
    </td>
    <td><nobr>werner@openmoko.org</nobug.cgi?id=205">205</a>
    </td>

    <td><nobr>min</nobr>
   nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    < <td><nobr>maj</nobr>
    </td>
    <td><nobr>P2</nobr>
    </tmaj</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td>en in &quot;911 key&quot; mode
    </td>

  </tr>

  


  

  <nor bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=208">208<obr></nobr>
    </td>
    <td>u-boot DFU upload broken
    </td  <table class="bz_buglist" cellspacing="0" cellpadding="4" wid class="bz_resolution_column">
      <col class="bz_summary_colrity,bugs.bug_id">Sev</a>
  </th><th colspan="1">
    <a href="f="buglist.cgi?product=OpenMoko&amp;order=bugs.bug_status,bugs.  </th><th colspan="1">
    <a href="buglist.cgi?product=OpenMo<nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</access while in DFU mode
    </td>

  </tr>

  


  

  <tr clar>ASSI</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td1</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nod>
    <td><nobr>All</nobr>
    </td>
    <td><nobr>buglog@listmoko.org</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
 r>FIXE</nobr>
    </td>
    <td>sjf2410-linux-native.bb has do_ong location
    </td>

  </tr>

  


  

  <tr class="bz_norma">

    <td>
      <a href="show_bug.cgi?id=213">213</a>
    </   <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    <Oth</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nob  </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE<
    </td>
    <td>openmoko-dates-0.1+svnnow fails certificate tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <f="show_bug.cgi?id=214">214</a>
    </td>

    <td><nobr>nor</n </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <tdnobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>AddRBALL_STASH for missing upstream sources
    </td>

  </tr>

   <tr class="bz_blocker bz_P2 ">

    <td>
      <a href="show_b</a>
    </td>

    <td><nobr>blo</nobr>
    </td>
    <td><nobbr>
    </td>
    <td><nobr>All</nobr>
    </td>
    <td><nobr>ey@vanille-media.de</nobr>
    </td>
    <td><nobr>NEW</nobr>
 </nobr>
    </td>
    <td>fingerwheel crashes mainmenu when touthe black part
    </td>

  </tr>

  


  

  <tr class="bz_bloP3 ">

    <td>
      <a href="show_bug.cgi?id=216">216</a>
   r>blo</nobr>
    </td>
    <td><nobr>P3</nobr>
    </td>
    <tr>Neo</nobr>
    </td>
    <td><nobr>thomas@openedhand.com</nobtd>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>DUPL</nob>contacts crashes when tying to enter import widget
    </td>

tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <_bug.cgi?id=217">217</a>
    </td>

    <td><nobr>nor</nobr>
  
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
   obr>werner@openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobd>
    <td><nobr></nobr>
    </td>
    <td>Implement NAND OTP aead/write as u-boot commands
    </td>

  </tr>

  


  

  <trent bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=218">218<td>

    <td><nobr>enh</nobr>
    </td>
    <td><nobr>P2</nobr></td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></n   </td>
    <td>Distinguish stylus from finger via tslib
    <
  </tr>

  


  

  <tr class="bz_blocker bz_P2 ">

    <td>
 g.cgi?id=219">219</a>
    </td>

    <td><nobr>blo</nobr>
    <>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>All</nobr>
  td>
    <td><nobr>tonyguan@fic-sh.com.cn</nobr>
    </td>
    <</td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>openmoko-dial1159 fails to compile
    </td>

  </tr>

  


  

  <tr class=_P2 ">

    <td>
      <a href="show_bug.cgi?id=220">220</a>
  d><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
 <td><nobr>PC</nobr>
    </td>
    <td><nobr>laforge@openmoko.or>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>obr>
    </td>
    <td>libgsmd_device.c is missing
    </td>

  

  <tr class="bz_blocker bz_P2 ">

    <td>
      <a href="shid=221">221</a>
    </td>

    <td><nobr>blo</nobr>
    </td>
 nobr>P2</nobr>
    </td>
    <td><nobr>Mac</nobr>
    </td>
      </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE
    </td>
    <td>Can't add new contacts via the gui
    </td>>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a bug.cgi?id=222">222</a>
    </td>

    <td><nobr>nor</nobr>
       <td><nobr>P2</nobr>
    </td>
    <td><nobr>Mac</nobr>
    d>
    <td><nobr>thomas@openedhand.com</nobr>
    </td>
    <td>
    </td>
    <td><nobr>WORK</nobr>
    </td>
    <td>Can't aents
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2   <td>
      <a href="show_bug.cgi?id=223">223</a>
    </td>

  </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Mac</nob    </td>
    <td><nobr>thomas@openedhand.com</nobr>
    </td>
><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
   y displays half the week
    </td>

  </tr>

  


  

  <tr clabz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=224a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <td><nobr>lafrg</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <tdFIXE</nobr>
    </td>
    <td>call to uboot-mkimage requires ${BINDIR} prefix
    </td>

  </tr>

  


  

  <tr class="bz_nor      <a href="show_bug.cgi?id=225">225</a>
    </td>

    <td>or</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><r>PC</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</no<td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    <    <td>Fix ordering of do_deploy in uboot to be compatible wittd>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <tdw_bug.cgi?id=226">226</a>
    </td>

    <td><nobr>nor</nobr>
 >
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
   >
    <td><nobr>buglog@lists.openmoko.org</nobr>
    </td>
    /nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>dfu-utative do_deploy tries to install from wrong sou...
    </td>

 r>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <ahow_bug.cgi?id=227">227</a>
    </td>

    <td><nobr>nor</nobr>td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>NEW</no   </td>
    <td><nobr></nobr>
    </td>
    <td>Add openmoko-mnd enable use of it
    </td>

  </tr>

  


  

  <tr class="bbz_P2 ">

    <td>
      <a href="show_bug.cgi?id=228">228</a>

    <td><nobr>blo</nobr>
    </td>
    <td><nobr>P2</nobr>
   ><nobr>Neo</nobr>
    </td>
    <td><nobr>mickey@vanille-media.br>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr>    </td>
    <td>openmoko applications(contacts,  appmanager .<a href="show_bug.cgi?id=229">229</a>
    </td>

    <td><nobr>d><nobr></nobr>
    </td>
    <td>outgoing call/incoming call/t</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><no  <a href="show_bug.cgi?id=231">231</a>
    </td>

    <td><nobutput, off&quot; when suspe...
    </td>

  </tr>

  


  

  </td>
    <td><nobr>werner@openmoko.org</nobr>
    </td>
    <td ">

    <td>
      <a href="show_bug.cgi?id=234">234</a>
    <e of each b...
    </td>

  </tr>

  


  

  <tr class="bz_nor<nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>NEref="show_bug.cgi?id=236">236</a>
    </td>

    <td><nobr>cri<ylus_demo ...
    </td>

  </tr>

  


  

  <tr class="bz_normmedia.de</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
  </nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><no

228 bugs found.


<br>












  <form method="post" acti54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,8,129,130,131,132,133,134,135,136,137,138,139,140,141,142,143,1,211,213,214,215,216,217,218,219,220,221,222,223,224,225,226,22
      <a href="mailto:stefan@openmoko.org,sean_mosko@fic.com.ty@fic-sh.com.cn,marcel@holtmann.org,cj_steven@fic-sh.com.cn,micnbsp;&nbsp;

    <a href="query.cgi?product=OpenMoko">Edit this it can do, see <a href="http://www.bugzilla.org/">bugzilla.orglue="Find"> bug # <input name="id" size="6"> | <a href="reportsnbsp;&nbsp;freyther@yahoo.com
        </div>

    
    
      
    <di>

    </div>
</form>
</div>  

</body>
</html>
"""

no_bugs = """<!-- 1.0@bugzilla.org -->











<!-- 1.0@bugzilla.org -->




<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Bug List</title>


    
    
    
    <link href="/style/style.css" rel="stylesheet" type="text/css" />
    
        <link href="/bugzilla/css/buglist.css" rel="stylesheet" type="text/css">
  
  </head>
  


  <body bgcolor="#FFFFFF" onload="">


<!-- 1.0@bugzilla.org -->




        <div id="header">
                <a href="http://bugzilla.openmoko.org/cgi-bin/bugzilla/" id="site_logo"><img src="/style/images/openmoko_logo.png" alt="openmoko.org" /></a>
                
                <div id="main_navigation">
                        <ul>
                                <li><a href="http://www.openmoko.org/" class="nav_home"><span>Home</span></a></li>
                                <li><a href="http://wiki.openmoko.org/" class="nav_wiki"><span>Wiki</span></a></li>
                                <li><a href="http://bugzilla.openmoko.org/" class="nav_bugzilla selected"><span>Bugzilla</span></a></li>
                                <li><a href="http://planet.openmoko.org/" class="nav_planet"><span>Planet</span></a></li>
                                <li><a href="http://projects.openmoko.org/" class="nav_projects"><span>Projects</span></a></li>
                                <li><a href="http://lists.openmoko.org/" class="nav_lists"><span>Lists</span></a></li>
                        </ul>
                </div>
        </div>

        <div class="page_title">
                <strong>Bug List</strong> 
        </div>
    
 <div class="container">

<div align="center">
  <b>Tue Mar  6 20:13:26 CET 2007</b><br>


    <a href="quips.cgi"><i>GOT THE MESSAGE OF no match
</i></a>

</div>


<hr>

















<!-- 1.0@bugzilla.org -->





  Zarro Boogs found.
  <p>
    <a href="query.cgi">Query Page</a>
    &nbsp;&nbsp;<a href="enter_bug.cgi">Enter New Bug</a>
    <a href="query.cgi?short_desc_type=substring&amp;short_desc=foo+test+bug&amp;product=OpenMoko&amp;component=autobuilds">Edit this query</a>
  </p>


<br>

















<!-- 1.0@bugzilla.org -->



  

  
</div>

<div class="footer">
        <div class="group">This is <b>Bugzilla</b>: the Mozilla bug system.  For more information about what Bugzilla is and what it can do, see <a href="http://www.bugzilla.org/">bugzilla.org</a>.</div>
        <!-- 1.0@bugzilla.org -->






<form method="get" action="show_bug.cgi">
        <div class="group">
                <a href="enter_bug.cgi">New</a> | <a href="query.cgi">Query</a> | <input type="submit" value="Find"> bug # <input name="id" size="6"> | <a href="reports.cgi">Reports</a> | <a href="votes.cgi?action=show_user">My Votes</a> 
        </div>
 
        <div class="group">
        Edit <a href="userprefs.cgi">prefs</a> 
        | <a href="relogin.cgi">Log&nbsp;out</a>&nbsp;&nbsp;freyther@yahoo.com
        </div>

    
    
      
    <div class="group">
                  Preset&nbsp;Queries:

          <a href="buglist.cgi?bug_status=NEW&amp;bug_status=ASSIGNED&amp;bug_status=REOPENED&amp;email1=freyther%40yahoo.com&amp;emailtype1=exact&amp;emailassigned_to1=1&amp;emailreporter1=1">My&nbsp;Bugs</a>

    </div>
</form>
</div>  

</body>
</html>
"""

bugfinder =BugQueryExtractor()
#bugfinder.feed(site)
#bugfinder.feed(all_bugs)
bugfinder.feed(no_bugs)
print bugfinder.result()
