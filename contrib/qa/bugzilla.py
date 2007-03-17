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
        self.bug  = None
        self.bugs = []

    def handle_starttag(self, tag, attr):
        if self.state == self.STATE_NONE and tag.lower() == "tr":
            # check for bz_normal and bz_P2 as indicator in buglist.cgi
            # use 'all' and 'map' on python2.5
            if len(attr) == 1 and attr[0][0] == 'class' and \
               ('bz_normal' in attr[0][1] or 'bz_blocker' in attr[0][1] or 'bz_enhancement' in attr[0][1] or 'bz_major' in attr[0][1] or 'bz_minor' in attr[0][1] or 'bz_trivial' in attr[0][1] or 'bz_critical' in attr[0][1] or 'bz_wishlist' in attr[0][1]) \
               and 'bz_P' in attr[0][1]:
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
            self.bug = None
        if self.state > 1 and tag.lower() == "td":
            print "Next TD"
            self.state += 1

    def handle_data(self,data):
        data = data.strip()

        # skip garbage
        if len(data) == 0:
            return

        if self.state == self.STATE_FOUND_NUMBER:
            """
            #1995 in bugs.oe.org has [SEC] additionally to the number and we want to ignore it
            """
            print "Bug Number '%s'" % data.strip()
            if self.bug:
                print "Ignoring bug data"
                return
            self.bug = data

        elif self.state == self.STATE_FOUND_STATUS:
            print "Status Name '%s'" % data.strip()
            self.status = data

    def result(self):
        print "Found bugs"
        return self.bugs

#
bugs_openmoko = """<!-- 1.0@bugzilla.org -->











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
  <b>Fri Mar 16 20:51:52 CET 2007</b><br>


    <a href="quips.cgi"><i>It was a time of great struggle and heroic deeds
</i></a>

</div>


<hr>





282 bugs found.











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
        <a href="buglist.cgi?short_desc_type=allwordssubstr&amp;short_desc=&amp;long_desc_type=allwordssubstr&amp;long_desc=&amp;bug_file_loc_type=allwordssubstr&amp;bug_file_loc=&amp;bug_status=UNCONFIRMED&amp;bug_status=NEW&amp;bug_status=ASSIGNED&amp;bug_status=REOPENED&amp;bug_status=RESOLVED&amp;bug_status=VERIFIED&amp;bug_status=CLOSED&amp;emailassigned_to1=1&amp;emailtype1=substring&amp;email1=&amp;emailassigned_to2=1&amp;emailreporter2=1&amp;emailcc2=1&amp;emailtype2=substring&amp;email2=&amp;bugidtype=include&amp;bug_id=&amp;votes=&amp;changedin=&amp;chfieldfrom=&amp;chfieldto=Now&amp;chfieldvalue=&amp;field0-0-0=noop&amp;type0-0-0=noop&amp;value0-0-0=&amp;order=bugs.bug_id">ID</a>
      </th>

<th colspan="1">
    <a href="buglist.cgi?short_desc_type=allwordssubstr&amp;short_desc=&amp;long_desc_type=allwordssubstr&amp;long_desc=&amp;bug_file_loc_type=allwordssubstr&amp;bug_file_loc=&amp;bug_status=UNCONFIRMED&amp;bug_status=NEW&amp;bug_status=ASSIGNED&amp;bug_status=REOPENED&amp;bug_status=RESOLVED&amp;bug_status=VERIFIED&amp;bug_status=CLOSED&amp;emailassigned_to1=1&amp;emailtype1=substring&amp;email1=&amp;emailassigned_to2=1&amp;emailreporter2=1&amp;emailcc2=1&amp;emailtype2=substring&amp;email2=&amp;bugidtype=include&amp;bug_id=&amp;votes=&amp;changedin=&amp;chfieldfrom=&amp;chfieldto=Now&amp;chfieldvalue=&amp;field0-0-0=noop&amp;type0-0-0=noop&amp;value0-0-0=&amp;order=bugs.bug_severity,bugs.bug_id">Sev</a>
  </th><th colspan="1">
    <a href="buglist.cgi?short_desc_type=allwordssubstr&amp;short_desc=&amp;long_desc_type=allwordssubstr&amp;long_desc=&amp;bug_file_loc_type=allwordssubstr&amp;bug_file_loc=&amp;bug_status=UNCONFIRMED&amp;bug_status=NEW&amp;bug_status=ASSIGNED&amp;bug_status=REOPENED&amp;bug_status=RESOLVED&amp;bug_status=VERIFIED&amp;bug_status=CLOSED&amp;emailassigned_to1=1&amp;emailtype1=substring&amp;email1=&amp;emailassigned_to2=1&amp;emailreporter2=1&amp;emailcc2=1&amp;emailtype2=substring&amp;email2=&amp;bugidtype=include&amp;bug_id=&amp;votes=&amp;changedin=&amp;chfieldfrom=&amp;chfieldto=Now&amp;chfieldvalue=&amp;field0-0-0=noop&amp;type0-0-0=noop&amp;value0-0-0=&amp;order=bugs.priority,bugs.bug_id">Pri</a>
  </th><th colspan="1">
    <a href="buglist.cgi?short_desc_type=allwordssubstr&amp;short_desc=&amp;long_desc_type=allwordssubstr&amp;long_desc=&amp;bug_file_loc_type=allwordssubstr&amp;bug_file_loc=&amp;bug_status=UNCONFIRMED&amp;bug_status=NEW&amp;bug_status=ASSIGNED&amp;bug_status=REOPENED&amp;bug_status=RESOLVED&amp;bug_status=VERIFIED&amp;bug_status=CLOSED&amp;emailassigned_to1=1&amp;emailtype1=substring&amp;email1=&amp;emailassigned_to2=1&amp;emailreporter2=1&amp;emailcc2=1&amp;emailtype2=substring&amp;email2=&amp;bugidtype=include&amp;bug_id=&amp;votes=&amp;changedin=&amp;chfieldfrom=&amp;chfieldto=Now&amp;chfieldvalue=&amp;field0-0-0=noop&amp;type0-0-0=noop&amp;value0-0-0=&amp;order=bugs.rep_platform,bugs.bug_id">Plt</a>
  </th><th colspan="1">
    <a href="buglist.cgi?short_desc_type=allwordssubstr&amp;short_desc=&amp;long_desc_type=allwordssubstr&amp;long_desc=&amp;bug_file_loc_type=allwordssubstr&amp;bug_file_loc=&amp;bug_status=UNCONFIRMED&amp;bug_status=NEW&amp;bug_status=ASSIGNED&amp;bug_status=REOPENED&amp;bug_status=RESOLVED&amp;bug_status=VERIFIED&amp;bug_status=CLOSED&amp;emailassigned_to1=1&amp;emailtype1=substring&amp;email1=&amp;emailassigned_to2=1&amp;emailreporter2=1&amp;emailcc2=1&amp;emailtype2=substring&amp;email2=&amp;bugidtype=include&amp;bug_id=&amp;votes=&amp;changedin=&amp;chfieldfrom=&amp;chfieldto=Now&amp;chfieldvalue=&amp;field0-0-0=noop&amp;type0-0-0=noop&amp;value0-0-0=&amp;order=map_assigned_to.login_name,bugs.bug_id">Owner</a>
  </th><th colspan="1">
    <a href="buglist.cgi?short_desc_type=allwordssubstr&amp;short_desc=&amp;long_desc_type=allwordssubstr&amp;long_desc=&amp;bug_file_loc_type=allwordssubstr&amp;bug_file_loc=&amp;bug_status=UNCONFIRMED&amp;bug_status=NEW&amp;bug_status=ASSIGNED&amp;bug_status=REOPENED&amp;bug_status=RESOLVED&amp;bug_status=VERIFIED&amp;bug_status=CLOSED&amp;emailassigned_to1=1&amp;emailtype1=substring&amp;email1=&amp;emailassigned_to2=1&amp;emailreporter2=1&amp;emailcc2=1&amp;emailtype2=substring&amp;email2=&amp;bugidtype=include&amp;bug_id=&amp;votes=&amp;changedin=&amp;chfieldfrom=&amp;chfieldto=Now&amp;chfieldvalue=&amp;field0-0-0=noop&amp;type0-0-0=noop&amp;value0-0-0=&amp;order=bugs.bug_status,bugs.bug_id">State</a>
  </th><th colspan="1">
    <a href="buglist.cgi?short_desc_type=allwordssubstr&amp;short_desc=&amp;long_desc_type=allwordssubstr&amp;long_desc=&amp;bug_file_loc_type=allwordssubstr&amp;bug_file_loc=&amp;bug_status=UNCONFIRMED&amp;bug_status=NEW&amp;bug_status=ASSIGNED&amp;bug_status=REOPENED&amp;bug_status=RESOLVED&amp;bug_status=VERIFIED&amp;bug_status=CLOSED&amp;emailassigned_to1=1&amp;emailtype1=substring&amp;email1=&amp;emailassigned_to2=1&amp;emailreporter2=1&amp;emailcc2=1&amp;emailtype2=substring&amp;email2=&amp;bugidtype=include&amp;bug_id=&amp;votes=&amp;changedin=&amp;chfieldfrom=&amp;chfieldto=Now&amp;chfieldvalue=&amp;field0-0-0=noop&amp;type0-0-0=noop&amp;value0-0-0=&amp;order=bugs.resolution,bugs.bug_id">Result</a>
  </th><th colspan="1">
    <a href="buglist.cgi?short_desc_type=allwordssubstr&amp;short_desc=&amp;long_desc_type=allwordssubstr&amp;long_desc=&amp;bug_file_loc_type=allwordssubstr&amp;bug_file_loc=&amp;bug_status=UNCONFIRMED&amp;bug_status=NEW&amp;bug_status=ASSIGNED&amp;bug_status=REOPENED&amp;bug_status=RESOLVED&amp;bug_status=VERIFIED&amp;bug_status=CLOSED&amp;emailassigned_to1=1&amp;emailtype1=substring&amp;email1=&amp;emailassigned_to2=1&amp;emailreporter2=1&amp;emailcc2=1&amp;emailtype2=substring&amp;email2=&amp;bugidtype=include&amp;bug_id=&amp;votes=&amp;changedin=&amp;chfieldfrom=&amp;chfieldto=Now&amp;chfieldvalue=&amp;field0-0-0=noop&amp;type0-0-0=noop&amp;value0-0-0=&amp;order=bugs.short_desc,bugs.bug_id">Summary</a>
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
      <a href="show_bug.cgi?id=3">3</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>sean_chiang@fic.com.tw</nobr>
    </td>
    <td><nobr>CLOS</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>Debug Board trying to control GSM_EN / FA_19
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
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
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
      <a href="show_bug.cgi?id=6">6</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>sean_chiang@fic.com.tw</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>GSM_EN should be called nGSM_EN
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
    <td><nobr>ASSI</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Boot speed too low (kernel part)
    </td>

  </tr>

  


  

  <tr class="bz_enhancement bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=10">10</a>
    </td>

    <td><nobr>enh</nobr>
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
    <td>u-boot support for usb-serial lacking
    </td>

  </tr>

  


  

  <tr class="bz_blocker bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=11">11</a>
    </td>

    <td><nobr>blo</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>ken_zhao@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>u-boot lacks USB DFU support
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=12">12</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>gordon_hsu@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Boot speed too low (bootloader part)
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=13">13</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>teddy@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>power button should not immediately react
    </td>

  </tr>

  


  

  <tr class="bz_minor bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=14">14</a>
    </td>

    <td><nobr>min</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>werner@openmoko.org</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>bootloader should display startup image before booting th...
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=15">15</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>kernel oops when unloading g_ether
    </td>

  </tr>

  


  

  <tr class="bz_blocker bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=16">16</a>
    </td>

    <td><nobr>blo</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>sean_chiang@fic.com.tw</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>bluetooth pullup / pulldown resistors
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=17">17</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>sean_chiang@fic.com.tw</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>microSD socket still has mechanical contact problems
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=18">18</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>OE build of u_boot with CVSDATE 20061030 uses latest git ...
    </td>

  </tr>

  


  

  <tr class="bz_minor bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=19">19</a>
    </td>

    <td><nobr>min</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>teddy@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>&quot;reboot&quot; doesn't work
    </td>

  </tr>

  


  

  <tr class="bz_critical bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=20">20</a>
    </td>

    <td><nobr>cri</nobr>
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
    <td>connection status
    </td>

  </tr>

  


  

  <tr class="bz_blocker bz_P3 ">

    <td>
      <a href="show_bug.cgi?id=21">21</a>
    </td>

    <td><nobr>blo</nobr>
    </td>
    <td><nobr>P3</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>sean_chiang@fic.com.tw</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>sms function missing
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=22">22</a>
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
    <td>outgoing call generates 'segmentation fault' when the pee...
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=23">23</a>
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
    <td>dtmf support not available now
    </td>

  </tr>

  


  

  <tr class="bz_wishlist bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=24">24</a>
    </td>

    <td><nobr>wis</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>libgsmd/misc.h: lgsm_get_signal_quality()
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=25">25</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>davewu01@seed.net.tw</nobr>
    </td>
    <td><nobr>ASSI</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>GtkSpinBox unfinished
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=26">26</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>ken_zhao@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Pixmap Engine and Shadows
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=27">27</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>ken_zhao@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>ASSI</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Labels on GtkButton don't appear centered
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=28">28</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>ken_zhao@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>GtkComboBox styling woes
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=29">29</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>ken_zhao@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>GtkProgressBar styling woes
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=30">30</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>REOP</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Touchscreen emits bogus events under X
    </td>

  </tr>

  


  

  <tr class="bz_critical bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=31">31</a>
    </td>

    <td><nobr>cri</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Display colors are slightly off
    </td>

  </tr>

  


  

  <tr class="bz_enhancement bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=32">32</a>
    </td>

    <td><nobr>enh</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Common function for loading GdkPixbuf
    </td>

  </tr>

  


  

  <tr class="bz_blocker bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=33">33</a>
    </td>

    <td><nobr>blo</nobr>
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
    <td>incoming call status report causes gsmd to crash.
    </td>

  </tr>

  


  

  <tr class="bz_blocker bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=34">34</a>
    </td>

    <td><nobr>blo</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>WORK</nobr>
    </td>
    <td>Need to decide if lgsm_handle is still valid.
    </td>

  </tr>

  


  

  <tr class="bz_enhancement bz_P5 ">

    <td>
      <a href="show_bug.cgi?id=35">35</a>
    </td>

    <td><nobr>enh</nobr>
    </td>
    <td><nobr>P5</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>WONT</nobr>
    </td>
    <td>Support debug board from u-boot
    </td>

  </tr>

  


  

  <tr class="bz_blocker bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=36">36</a>
    </td>

    <td><nobr>blo</nobr>
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
    <td>Implement s3c2410 udc (usb device controller) driver in u...
    </td>

  </tr>

  


  

  <tr class="bz_blocker bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=37">37</a>
    </td>

    <td><nobr>blo</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>DUPL</nobr>
    </td>
    <td>Implement USB Device Firmware Upgrade (DFU)
    </td>

  </tr>

  


  

  <tr class="bz_enhancement bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=38">38</a>
    </td>

    <td><nobr>enh</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>DUPL</nobr>
    </td>
    <td>implement USB serial emulation in u-boot
    </td>

  </tr>

  


  

  <tr class="bz_major bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=39">39</a>
    </td>

    <td><nobr>maj</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>gordon_hsu@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>Move LCM initialization into u-boot (currently in kernel ...
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=40">40</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>werner@openmoko.org</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>DUPL</nobr>
    </td>
    <td>test + debug display of image on LCM in u-boot
    </td>

  </tr>

  


  

  <tr class="bz_enhancement bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=41">41</a>
    </td>

    <td><nobr>enh</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>ken_zhao@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>evaluate sapwood theme engine
    </td>

  </tr>

  


  

  <tr class="bz_blocker bz_P3 ">

    <td>
      <a href="show_bug.cgi?id=42">42</a>
    </td>

    <td><nobr>blo</nobr>
    </td>
    <td><nobr>P3</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>dynamic mtd partition table cration
    </td>

  </tr>

  


  

  <tr class="bz_major bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=43">43</a>
    </td>

    <td><nobr>maj</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>All</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>StatusBar (Footer) API
    </td>

  </tr>

  


  

  <tr class="bz_wishlist bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=44">44</a>
    </td>

    <td><nobr>wis</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>All</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>InputMethod API
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=45">45</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>All</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Automatic opening input methods
    </td>

  </tr>

  


  

  <tr class="bz_major bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=46">46</a>
    </td>

    <td><nobr>maj</nobr>
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
    <td>266MHz initialization of GTA01Bv2
    </td>

  </tr>

  


  

  <tr class="bz_minor bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=47">47</a>
    </td>

    <td><nobr>min</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>ken_zhao@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>DUPL</nobr>
    </td>
    <td>Evaluate sapwood theming engine
    </td>

  </tr>

  


  

  <tr class="bz_major bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=48">48</a>
    </td>

    <td><nobr>maj</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>DUPL</nobr>
    </td>
    <td>Only power up the phone in case power button was pressed ...
    </td>

  </tr>

  


  

  <tr class="bz_minor bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=49">49</a>
    </td>

    <td><nobr>min</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>All</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Implement touchscreen &amp; click daemon
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=50">50</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>All</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Sound Event API
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=51">51</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Preferences API
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=52">52</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>cj_steven@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>Single Instance Startup
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=53">53</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>All</nobr>
    </td>
    <td><nobr>tonyguan@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>DTMF tones during call
    </td>

  </tr>

  


  

  <tr class="bz_blocker bz_P1 ">

    <td>
      <a href="show_bug.cgi?id=54">54</a>
    </td>

    <td><nobr>blo</nobr>
    </td>
    <td><nobr>P1</nobr>
    </td>
    <td><nobr>All</nobr>
    </td>
    <td><nobr>tonyguan@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>PIN Entry
    </td>

  </tr>

  


  

  <tr class="bz_major bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=55">55</a>
    </td>

    <td><nobr>maj</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>All</nobr>
    </td>
    <td><nobr>tonyguan@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>Don't pop up the dialer interface initially
    </td>

  </tr>

  


  

  <tr class="bz_blocker bz_P4 ">

    <td>
      <a href="show_bug.cgi?id=56">56</a>
    </td>

    <td><nobr>blo</nobr>
    </td>
    <td><nobr>P4</nobr>
    </td>
    <td><nobr>All</nobr>
    </td>
    <td><nobr>tonyguan@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>Integrate with contacts database
    </td>

  </tr>

  


  

  <tr class="bz_minor bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=57">57</a>
    </td>

    <td><nobr>min</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>All</nobr>
    </td>
    <td><nobr>tonyguan@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>LATE</nobr>
    </td>
    <td>Recording Calls
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=58">58</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>API for devmand
    </td>

  </tr>

  


  

  <tr class="bz_enhancement bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=59">59</a>
    </td>

    <td><nobr>enh</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>ken_zhao@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Real DPI vs. Fake DPI
    </td>

  </tr>

  


  

  <tr class="bz_minor bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=60">60</a>
    </td>

    <td><nobr>min</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>ken_zhao@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>fontconfig antialiasing
    </td>

  </tr>

  


  

  <tr class="bz_major bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=61">61</a>
    </td>

    <td><nobr>maj</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>ken_zhao@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Theme is very slow
    </td>

  </tr>

  


  

  <tr class="bz_wishlist bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=62">62</a>
    </td>

    <td><nobr>wis</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>All</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>High Level Multi Layer Network Discovery API
    </td>

  </tr>

  


  

  <tr class="bz_enhancement bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=63">63</a>
    </td>

    <td><nobr>enh</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>ASSI</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>matchbox-panel 1 vs. 2
    </td>

  </tr>

  


  

  <tr class="bz_major bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=64">64</a>
    </td>

    <td><nobr>maj</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Show Cipher Status in GSM-Panel applet
    </td>

  </tr>

  


  

  <tr class="bz_major bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=65">65</a>
    </td>

    <td><nobr>maj</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Visual indication for SMS overflow
    </td>

  </tr>

  


  

  <tr class="bz_critical bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=66">66</a>
    </td>

    <td><nobr>cri</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Applet for Missed Events
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=67">67</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>All</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>WONT</nobr>
    </td>
    <td>libmokopim not necessary
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=68">68</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>SIM backend for EDS
    </td>

  </tr>

  


  

  <tr class="bz_major bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=69">69</a>
    </td>

    <td><nobr>maj</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>All</nobr>
    </td>
    <td><nobr>buglog@lists.openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Speed up System Initialization
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=70">70</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>buglog@lists.openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Minimize Services started on Bootup
    </td>

  </tr>

  


  

  <tr class="bz_enhancement bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=71">71</a>
    </td>

    <td><nobr>enh</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>gordon_hsu@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>make a short vibration pulse once u-boot is starting
    </td>

  </tr>

  


  

  <tr class="bz_wishlist bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=72">72</a>
    </td>

    <td><nobr>wis</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>gordon_hsu@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>Add on-screen boot menu
    </td>

  </tr>

  


  

  <tr class="bz_blocker bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=73">73</a>
    </td>

    <td><nobr>blo</nobr>
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
    <td>test and verify battery charger control (pcf50606)
    </td>

  </tr>

  


  

  <tr class="bz_blocker bz_P1 ">

    <td>
      <a href="show_bug.cgi?id=74">74</a>
    </td>

    <td><nobr>blo</nobr>
    </td>
    <td><nobr>P1</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>WONT</nobr>
    </td>
    <td>stub audio driver to power up amp and route audio through...
    </td>

  </tr>

  


  

  <tr class="bz_major bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=75">75</a>
    </td>

    <td><nobr>maj</nobr>
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
    <td>PWM code for display brightness control
    </td>

  </tr>

  


  

  <tr class="bz_enhancement bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=76">76</a>
    </td>

    <td><nobr>enh</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>teddy@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Implement PWM control for vibrator
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=77">77</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>songcw@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Finish, test and verify agpsd implementation
    </td>

  </tr>

  


  

  <tr class="bz_major bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=78">78</a>
    </td>

    <td><nobr>maj</nobr>
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
    <td>Implement and test ASoC platform driver
    </td>

  </tr>

  


  

  <tr class="bz_blocker bz_P1 ">

    <td>
      <a href="show_bug.cgi?id=79">79</a>
    </td>

    <td><nobr>blo</nobr>
    </td>
    <td><nobr>P1</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>werner@openmoko.org</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>suspend/resume to RAM support
    </td>

  </tr>

  


  

  <tr class="bz_major bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=80">80</a>
    </td>

    <td><nobr>maj</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>WONT</nobr>
    </td>
    <td>Add sysfs entry for PMU wakeup reason
    </td>

  </tr>

  


  

  <tr class="bz_major bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=81">81</a>
    </td>

    <td><nobr>maj</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>werner@openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Decide how PMU RTC alarm interrupt is signalled to userspace
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=82">82</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>implement and test cpufreq interface to S3C2410 PLL / SLO...
    </td>

  </tr>

  


  

  <tr class="bz_enhancement bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=83">83</a>
    </td>

    <td><nobr>enh</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>teddy@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>evaluate process and I/O schedulers
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=84">84</a>
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
    <td>enable voluntary preemption
    </td>

  </tr>

  


  

  <tr class="bz_minor bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=85">85</a>
    </td>

    <td><nobr>min</nobr>
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
    <td>test NO_IDLE_HZ / tickless idle
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=86">86</a>
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
    <td>APM emulation for battery / charger / charging and possib...
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=87">87</a>
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
    <td>define and implement how headphone jack routing/signallin...
    </td>

  </tr>

  


  

  <tr class="bz_minor bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=88">88</a>
    </td>

    <td><nobr>min</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>teddy@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>use and test PMU watchdog driver
    </td>

  </tr>

  


  

  <tr class="bz_critical bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=89">89</a>
    </td>

    <td><nobr>cri</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>teddy@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>determine correct gamma calibration values and put them i...
    </td>

  </tr>

  


  

  <tr class="bz_critical bz_P1 ">

    <td>
      <a href="show_bug.cgi?id=90">90</a>
    </td>

    <td><nobr>cri</nobr>
    </td>
    <td><nobr>P1</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>GSM TS07.10 multiplex missing
    </td>

  </tr>

  


  

  <tr class="bz_major bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=91">91</a>
    </td>

    <td><nobr>maj</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>DUPL</nobr>
    </td>
    <td>debug sd card timeout problems
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=92">92</a>
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
    <td>test multiple microSD card vendors for compatibility with...
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=93">93</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>test 4GB microSD card compatibility
    </td>

  </tr>

  


  

  <tr class="bz_major bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=94">94</a>
    </td>

    <td><nobr>maj</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>tonyguan@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>+ symbol support
    </td>

  </tr>

  


  

  <tr class="bz_minor bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=95">95</a>
    </td>

    <td><nobr>min</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>sean_chiang@fic.com.tw</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>verify charger current and battery temperature reading co...
    </td>

  </tr>

  


  

  <tr class="bz_major bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=96">96</a>
    </td>

    <td><nobr>maj</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>make sure PMU alarm (set via rtc interface) is persistent
    </td>

  </tr>

  


  

  <tr class="bz_blocker bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=97">97</a>
    </td>

    <td><nobr>blo</nobr>
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
    <td>remove static mtd partition table, use u-boot created dyn...
    </td>

  </tr>

  


  

  <tr class="bz_enhancement bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=98">98</a>
    </td>

    <td><nobr>enh</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>how to do touch panel calibration in factory and store va...
    </td>

  </tr>

  


  

  <tr class="bz_major bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=99">99</a>
    </td>

    <td><nobr>maj</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>All</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>DUPL</nobr>
    </td>
    <td>Implement SMS support
    </td>

  </tr>

  


  

  <tr class="bz_major bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=100">100</a>
    </td>

    <td><nobr>maj</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>All</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Implement Cell Broadcast support
    </td>

  </tr>

  
    </table>


  
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
        <a href="buglist.cgi?short_desc_type=allwordssubstr&amp;short_desc=&amp;long_desc_type=allwordssubstr&amp;long_desc=&amp;bug_file_loc_type=allwordssubstr&amp;bug_file_loc=&amp;bug_status=UNCONFIRMED&amp;bug_status=NEW&amp;bug_status=ASSIGNED&amp;bug_status=REOPENED&amp;bug_status=RESOLVED&amp;bug_status=VERIFIED&amp;bug_status=CLOSED&amp;emailassigned_to1=1&amp;emailtype1=substring&amp;email1=&amp;emailassigned_to2=1&amp;emailreporter2=1&amp;emailcc2=1&amp;emailtype2=substring&amp;email2=&amp;bugidtype=include&amp;bug_id=&amp;votes=&amp;changedin=&amp;chfieldfrom=&amp;chfieldto=Now&amp;chfieldvalue=&amp;field0-0-0=noop&amp;type0-0-0=noop&amp;value0-0-0=&amp;order=bugs.bug_id">ID</a>
      </th>

<th colspan="1">
    <a href="buglist.cgi?short_desc_type=allwordssubstr&amp;short_desc=&amp;long_desc_type=allwordssubstr&amp;long_desc=&amp;bug_file_loc_type=allwordssubstr&amp;bug_file_loc=&amp;bug_status=UNCONFIRMED&amp;bug_status=NEW&amp;bug_status=ASSIGNED&amp;bug_status=REOPENED&amp;bug_status=RESOLVED&amp;bug_status=VERIFIED&amp;bug_status=CLOSED&amp;emailassigned_to1=1&amp;emailtype1=substring&amp;email1=&amp;emailassigned_to2=1&amp;emailreporter2=1&amp;emailcc2=1&amp;emailtype2=substring&amp;email2=&amp;bugidtype=include&amp;bug_id=&amp;votes=&amp;changedin=&amp;chfieldfrom=&amp;chfieldto=Now&amp;chfieldvalue=&amp;field0-0-0=noop&amp;type0-0-0=noop&amp;value0-0-0=&amp;order=bugs.bug_severity,bugs.bug_id">Sev</a>
  </th><th colspan="1">
    <a href="buglist.cgi?short_desc_type=allwordssubstr&amp;short_desc=&amp;long_desc_type=allwordssubstr&amp;long_desc=&amp;bug_file_loc_type=allwordssubstr&amp;bug_file_loc=&amp;bug_status=UNCONFIRMED&amp;bug_status=NEW&amp;bug_status=ASSIGNED&amp;bug_status=REOPENED&amp;bug_status=RESOLVED&amp;bug_status=VERIFIED&amp;bug_status=CLOSED&amp;emailassigned_to1=1&amp;emailtype1=substring&amp;email1=&amp;emailassigned_to2=1&amp;emailreporter2=1&amp;emailcc2=1&amp;emailtype2=substring&amp;email2=&amp;bugidtype=include&amp;bug_id=&amp;votes=&amp;changedin=&amp;chfieldfrom=&amp;chfieldto=Now&amp;chfieldvalue=&amp;field0-0-0=noop&amp;type0-0-0=noop&amp;value0-0-0=&amp;order=bugs.priority,bugs.bug_id">Pri</a>
  </th><th colspan="1">
    <a href="buglist.cgi?short_desc_type=allwordssubstr&amp;short_desc=&amp;long_desc_type=allwordssubstr&amp;long_desc=&amp;bug_file_loc_type=allwordssubstr&amp;bug_file_loc=&amp;bug_status=UNCONFIRMED&amp;bug_status=NEW&amp;bug_status=ASSIGNED&amp;bug_status=REOPENED&amp;bug_status=RESOLVED&amp;bug_status=VERIFIED&amp;bug_status=CLOSED&amp;emailassigned_to1=1&amp;emailtype1=substring&amp;email1=&amp;emailassigned_to2=1&amp;emailreporter2=1&amp;emailcc2=1&amp;emailtype2=substring&amp;email2=&amp;bugidtype=include&amp;bug_id=&amp;votes=&amp;changedin=&amp;chfieldfrom=&amp;chfieldto=Now&amp;chfieldvalue=&amp;field0-0-0=noop&amp;type0-0-0=noop&amp;value0-0-0=&amp;order=bugs.rep_platform,bugs.bug_id">Plt</a>
  </th><th colspan="1">
    <a href="buglist.cgi?short_desc_type=allwordssubstr&amp;short_desc=&amp;long_desc_type=allwordssubstr&amp;long_desc=&amp;bug_file_loc_type=allwordssubstr&amp;bug_file_loc=&amp;bug_status=UNCONFIRMED&amp;bug_status=NEW&amp;bug_status=ASSIGNED&amp;bug_status=REOPENED&amp;bug_status=RESOLVED&amp;bug_status=VERIFIED&amp;bug_status=CLOSED&amp;emailassigned_to1=1&amp;emailtype1=substring&amp;email1=&amp;emailassigned_to2=1&amp;emailreporter2=1&amp;emailcc2=1&amp;emailtype2=substring&amp;email2=&amp;bugidtype=include&amp;bug_id=&amp;votes=&amp;changedin=&amp;chfieldfrom=&amp;chfieldto=Now&amp;chfieldvalue=&amp;field0-0-0=noop&amp;type0-0-0=noop&amp;value0-0-0=&amp;order=map_assigned_to.login_name,bugs.bug_id">Owner</a>
  </th><th colspan="1">
    <a href="buglist.cgi?short_desc_type=allwordssubstr&amp;short_desc=&amp;long_desc_type=allwordssubstr&amp;long_desc=&amp;bug_file_loc_type=allwordssubstr&amp;bug_file_loc=&amp;bug_status=UNCONFIRMED&amp;bug_status=NEW&amp;bug_status=ASSIGNED&amp;bug_status=REOPENED&amp;bug_status=RESOLVED&amp;bug_status=VERIFIED&amp;bug_status=CLOSED&amp;emailassigned_to1=1&amp;emailtype1=substring&amp;email1=&amp;emailassigned_to2=1&amp;emailreporter2=1&amp;emailcc2=1&amp;emailtype2=substring&amp;email2=&amp;bugidtype=include&amp;bug_id=&amp;votes=&amp;changedin=&amp;chfieldfrom=&amp;chfieldto=Now&amp;chfieldvalue=&amp;field0-0-0=noop&amp;type0-0-0=noop&amp;value0-0-0=&amp;order=bugs.bug_status,bugs.bug_id">State</a>
  </th><th colspan="1">
    <a href="buglist.cgi?short_desc_type=allwordssubstr&amp;short_desc=&amp;long_desc_type=allwordssubstr&amp;long_desc=&amp;bug_file_loc_type=allwordssubstr&amp;bug_file_loc=&amp;bug_status=UNCONFIRMED&amp;bug_status=NEW&amp;bug_status=ASSIGNED&amp;bug_status=REOPENED&amp;bug_status=RESOLVED&amp;bug_status=VERIFIED&amp;bug_status=CLOSED&amp;emailassigned_to1=1&amp;emailtype1=substring&amp;email1=&amp;emailassigned_to2=1&amp;emailreporter2=1&amp;emailcc2=1&amp;emailtype2=substring&amp;email2=&amp;bugidtype=include&amp;bug_id=&amp;votes=&amp;changedin=&amp;chfieldfrom=&amp;chfieldto=Now&amp;chfieldvalue=&amp;field0-0-0=noop&amp;type0-0-0=noop&amp;value0-0-0=&amp;order=bugs.resolution,bugs.bug_id">Result</a>
  </th><th colspan="1">
    <a href="buglist.cgi?short_desc_type=allwordssubstr&amp;short_desc=&amp;long_desc_type=allwordssubstr&amp;long_desc=&amp;bug_file_loc_type=allwordssubstr&amp;bug_file_loc=&amp;bug_status=UNCONFIRMED&amp;bug_status=NEW&amp;bug_status=ASSIGNED&amp;bug_status=REOPENED&amp;bug_status=RESOLVED&amp;bug_status=VERIFIED&amp;bug_status=CLOSED&amp;emailassigned_to1=1&amp;emailtype1=substring&amp;email1=&amp;emailassigned_to2=1&amp;emailreporter2=1&amp;emailcc2=1&amp;emailtype2=substring&amp;email2=&amp;bugidtype=include&amp;bug_id=&amp;votes=&amp;changedin=&amp;chfieldfrom=&amp;chfieldto=Now&amp;chfieldvalue=&amp;field0-0-0=noop&amp;type0-0-0=noop&amp;value0-0-0=&amp;order=bugs.short_desc,bugs.bug_id">Summary</a>
  </th>


    </tr>

  <tr class="bz_major bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=101">101</a>
    </td>

    <td><nobr>maj</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Implement GPRS setup/teardown support
    </td>

  </tr>

  


  

  <tr class="bz_critical bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=102">102</a>
    </td>

    <td><nobr>cri</nobr>
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
    <td>SIM phonebook access
    </td>

  </tr>

  


  

  <tr class="bz_blocker bz_P1 ">

    <td>
      <a href="show_bug.cgi?id=103">103</a>
    </td>

    <td><nobr>blo</nobr>
    </td>
    <td><nobr>P1</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>power-up/power-down GSM Modem
    </td>

  </tr>

  


  

  <tr class="bz_critical bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=104">104</a>
    </td>

    <td><nobr>cri</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>All</nobr>
    </td>
    <td><nobr>tonyguan@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>LATE</nobr>
    </td>
    <td>Volume control
    </td>

  </tr>

  


  

  <tr class="bz_enhancement bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=105">105</a>
    </td>

    <td><nobr>enh</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>DUPL</nobr>
    </td>
    <td>add passthrough mode
    </td>

  </tr>

  


  

  <tr class="bz_blocker bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=106">106</a>
    </td>

    <td><nobr>blo</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>tonyguan@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>LATE</nobr>
    </td>
    <td>Emergency Call Support
    </td>

  </tr>

  


  

  <tr class="bz_major bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=107">107</a>
    </td>

    <td><nobr>maj</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>obtain list of operators / control operator selection
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=108">108</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>tonyguan@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>REOP</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>allow query of manufacturer/model/revision/imei
    </td>

  </tr>

  


  

  <tr class="bz_enhancement bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=109">109</a>
    </td>

    <td><nobr>enh</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>add dbus interface, like recent upstream gpsd
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=110">110</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>look into gps / agps integration
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=111">111</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>integrate agpsd in our system power management.
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=112">112</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>buglog@lists.openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>How to deliver kernel-level alarm to destination app
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=113">113</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>marcel@holtmann.org</nobr>
    </td>
    <td><nobr>ASSI</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>bluetooth headset support
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=114">114</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>buglog@lists.openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Who is managing wakeup times?
    </td>

  </tr>

  


  

  <tr class="bz_enhancement bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=115">115</a>
    </td>

    <td><nobr>enh</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>marcel@holtmann.org</nobr>
    </td>
    <td><nobr>ASSI</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>A2DP / alsa integration
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=116">116</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>marcel@holtmann.org</nobr>
    </td>
    <td><nobr>ASSI</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>bluetooth HID support (host)
    </td>

  </tr>

  


  

  <tr class="bz_minor bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=117">117</a>
    </td>

    <td><nobr>min</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>marcel@holtmann.org</nobr>
    </td>
    <td><nobr>ASSI</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>bluetooth HID support (device)
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=118">118</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>marcel@holtmann.org</nobr>
    </td>
    <td><nobr>ASSI</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>bluetooth networking support
    </td>

  </tr>

  


  

  <tr class="bz_critical bz_P3 ">

    <td>
      <a href="show_bug.cgi?id=119">119</a>
    </td>

    <td><nobr>cri</nobr>
    </td>
    <td><nobr>P3</nobr>
    </td>
    <td><nobr>All</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>merge openmoko-taskmanager into openmoko-footer
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=120">120</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>marcel@holtmann.org</nobr>
    </td>
    <td><nobr>ASSI</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>bluetooth OBEX
    </td>

  </tr>

  


  

  <tr class="bz_critical bz_P3 ">

    <td>
      <a href="show_bug.cgi?id=121">121</a>
    </td>

    <td><nobr>cri</nobr>
    </td>
    <td><nobr>P3</nobr>
    </td>
    <td><nobr>All</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>merge openmoko-mainmenu into openmoko-mainmenu (panel)
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=122">122</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>rename openmoko-history to openmoko-taskmanager
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=123">123</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>DUPL</nobr>
    </td>
    <td>rename openmoko-history to openmoko-taskmanager
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=124">124</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>modem volume control on connection
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=125">125</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>All</nobr>
    </td>
    <td><nobr>davewu01@seed.net.tw</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>FInger UI is not usable on 2.8&quot; screen
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=126">126</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>All</nobr>
    </td>
    <td><nobr>sunzhiyong@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>ASSI</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Remove back functionality from Main Menu
    </td>

  </tr>

  


  

  <tr class="bz_major bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=127">127</a>
    </td>

    <td><nobr>maj</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>All</nobr>
    </td>
    <td><nobr>davewu01@seed.net.tw</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>Power On / Off Images needed
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=128">128</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <td><nobr>cj_steven@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Tap and hold on panel icon doesn't change to Today applic...
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=129">129</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>All</nobr>
    </td>
    <td><nobr>ken_zhao@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Create / Find better system fonts
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=130">130</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>All</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>GTK Popup menus size incorrectly
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=131">131</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>All</nobr>
    </td>
    <td><nobr>davewu01@seed.net.tw</nobr>
    </td>
    <td><nobr>ASSI</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Move Search Open / Close buttons into same location
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=132">132</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>All</nobr>
    </td>
    <td><nobr>sunzhiyong@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>Task Manager is not quick to use
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=133">133</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>All</nobr>
    </td>
    <td><nobr>davewu01@seed.net.tw</nobr>
    </td>
    <td><nobr>ASSI</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Designer image layouts should have both 4 corners and ful...
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=134">134</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>All</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Stylus applications need close function
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=135">135</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>All</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Finger applications need close functionality
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=136">136</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>buglog@lists.openmoko.org</nobr>
    </td>
    <td><nobr>ASSI</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>application manager doesn't build
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=137">137</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>All</nobr>
    </td>
    <td><nobr>buglog@lists.openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>submit patch against ipkg upstream
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=138">138</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>All</nobr>
    </td>
    <td><nobr>sunzhiyong@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>REOP</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>submit patch against matchbox-window-manager upstream
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=139">139</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>GSM API
    </td>

  </tr>

  


  

  <tr class="bz_enhancement bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=140">140</a>
    </td>

    <td><nobr>enh</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>stefan@openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>add network-enabled fbgrab from openEZX to openmoko-devel...
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=141">141</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>All</nobr>
    </td>
    <td><nobr>buglog@lists.openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Need support for device under WIndows and OS X
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=142">142</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <td><nobr>werner@openmoko.org</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>sjf2410-linux cleanup / help message / NAND read
    </td>

  </tr>

  


  

  <tr class="bz_enhancement bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=143">143</a>
    </td>

    <td><nobr>enh</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <td><nobr>buglog@lists.openmoko.org</nobr>
    </td>
    <td><nobr>REOP</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Implement NAND write/read support in OpenOCD
    </td>

  </tr>

  


  

  <tr class="bz_major bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=144">144</a>
    </td>

    <td><nobr>maj</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>when phone is hard-rebooted, Xfbdev complains about /tmp/...
    </td>

  </tr>

  


  

  <tr class="bz_blocker bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=145">145</a>
    </td>

    <td><nobr>blo</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>WONT</nobr>
    </td>
    <td>battery is not automatically charging
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=146">146</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>sjf2410-linux does not contain latest svn code
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=147">147</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>WONT</nobr>
    </td>
    <td>openmoko-panel-applet could not be resized
    </td>

  </tr>

  


  

  <tr class="bz_blocker bz_P1 ">

    <td>
      <a href="show_bug.cgi?id=148">148</a>
    </td>

    <td><nobr>blo</nobr>
    </td>
    <td><nobr>P1</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>gsmd not talking to TI modem on GTA01Bv2
    </td>

  </tr>

  


  

  <tr class="bz_major bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=149">149</a>
    </td>

    <td><nobr>maj</nobr>
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
    <td>lm4857 not i2c address compliant
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=150">150</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>graeme.gregory@wolfsonmicro...</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>INVA</nobr>
    </td>
    <td>ASoC patch doesn't compile
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=151">151</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>cj_steven@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Does mainmenu need libmatchbox or not?
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=152">152</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <td><nobr>cj_steven@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>VFOLDERDIR is hardcoded
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=153">153</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <td><nobr>sunzhiyong@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>ASSI</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Rationale for copying GtkIconView instead of deriving?
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=154">154</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <td><nobr>sunzhiyong@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>mainmenu crashes when clicking wheel the 2nd time
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=155">155</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <td><nobr>sunzhiyong@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>How to get back one level if you are in a subdirectory?
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=156">156</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <td><nobr>sunzhiyong@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>ASSI</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Where is mainmenu going to look for applications?
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=157">157</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <td><nobr>davewu01@seed.net.tw</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>DUPL</nobr>
    </td>
    <td>The sizes of each keys are too small
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=158">158</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <td><nobr>buglog@lists.openmoko.org</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>musicplayer crashes
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=159">159</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <td><nobr>sunzhiyong@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>ASSI</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>display thumbnails of actual applications
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=160">160</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <td><nobr>sunzhiyong@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>ASSI</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>display thumbnails in 3x3 grid
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=161">161</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <td><nobr>davewu01@seed.net.tw</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>Docked Keypad is too small
    </td>

  </tr>

  


  

  <tr class="bz_major bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=162">162</a>
    </td>

    <td><nobr>maj</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>All</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>REMI</nobr>
    </td>
    <td>libmutil0_svn.bb setup misses libltdl creation
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=163">163</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Audio Profile Management
    </td>

  </tr>

  


  

  <tr class="bz_major bz_P1 ">

    <td>
      <a href="show_bug.cgi?id=164">164</a>
    </td>

    <td><nobr>maj</nobr>
    </td>
    <td><nobr>P1</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>werner@openmoko.org</nobr>
    </td>
    <td><nobr>ASSI</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>improve non-SanDisk microSD support in u-boot
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=165">165</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <td><nobr>buglog@lists.openmoko.org</nobr>
    </td>
    <td><nobr>ASSI</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>openmoko-simplemediaplayer doesn't build in OE
    </td>

  </tr>

  


  

  <tr class="bz_minor bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=166">166</a>
    </td>

    <td><nobr>min</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>u-boot cdc_acm hot un-plug/replug hang
    </td>

  </tr>

  


  

  <tr class="bz_enhancement bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=167">167</a>
    </td>

    <td><nobr>enh</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>stefan@openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>add LCM QVGA switching support
    </td>

  </tr>

  


  

  <tr class="bz_minor bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=168">168</a>
    </td>

    <td><nobr>min</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>buglog@lists.openmoko.org</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>usb0 is not automatically configured
    </td>

  </tr>

  


  

  <tr class="bz_major bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=169">169</a>
    </td>

    <td><nobr>maj</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>gdb currently broken (gdb-6.4-r0)
    </td>

  </tr>

  


  

  <tr class="bz_minor bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=170">170</a>
    </td>

    <td><nobr>min</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>usbtty: sometimes bogus characters arrive
    </td>

  </tr>

  


  

  <tr class="bz_major bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=171">171</a>
    </td>

    <td><nobr>maj</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>All</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>agpsd source code and bitbake rules not in our svn
    </td>

  </tr>

  


  

  <tr class="bz_blocker bz_P1 ">

    <td>
      <a href="show_bug.cgi?id=172">172</a>
    </td>

    <td><nobr>blo</nobr>
    </td>
    <td><nobr>P1</nobr>
    </td>
    <td><nobr>Oth</nobr>
    </td>
    <td><nobr>tonyguan@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>missing openmoko-dialer-window-pin.o breaks build
    </td>

  </tr>

  


  

  <tr class="bz_major bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=173">173</a>
    </td>

    <td><nobr>maj</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Oth</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>no NAND partitions due to ID mismatch if using defaults
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=174">174</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Oth</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>defconfig-fic-gta01 could use updating
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=175">175</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>MOKO_FINGER_WINDOW has to show_all and then hide to initi...
    </td>

  </tr>

  


  

  <tr class="bz_critical bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=176">176</a>
    </td>

    <td><nobr>cri</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>libgsmd need a mechanism to avoid dead waiting.
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=177">177</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>libmokoui widget functions should return GtkWidget
    </td>

  </tr>

  


  

  <tr class="bz_major bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=178">178</a>
    </td>

    <td><nobr>maj</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>werner@openmoko.org</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>u-boot 'factory reset' option
    </td>

  </tr>

  


  

  <tr class="bz_minor bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=179">179</a>
    </td>

    <td><nobr>min</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>werner@openmoko.org</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>Implement u-boot power-off timer
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=180">180</a>
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
    <td>uboot build broken for EABI
    </td>

  </tr>

  


  

  <tr class="bz_wishlist bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=181">181</a>
    </td>

    <td><nobr>wis</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <td><nobr>buglog@lists.openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Password Storage/Retrieval Application
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=182">182</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Mac</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>openmoko-panel-demo-simple hardcodes -Werror
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=183">183</a>
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
    <td>openmoko-simple-mediaplayer missing mkinstalldirs and has...
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=184">184</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Mac</nobr>
    </td>
    <td><nobr>cj_steven@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>openmoko-mainmenu should link against libmb
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=185">185</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Mac</nobr>
    </td>
    <td><nobr>thomas@openedhand.com</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>openmoko-dates lacks intltool-update.in
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=186">186</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Mac</nobr>
    </td>
    <td><nobr>thomas@openedhand.com</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>Fingerbubbles take endless amount of ram and get OOMed
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=187">187</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Mac</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>src/target/OM-2007/README doesn't mention ipkg patch
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=188">188</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Mac</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>openmoko-panel-demo fails to build
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P5 ">

    <td>
      <a href="show_bug.cgi?id=189">189</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P5</nobr>
    </td>
    <td><nobr>Mac</nobr>
    </td>
    <td><nobr>thomas@openedhand.com</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>openmoko-dates tries to include non-existant header
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P5 ">

    <td>
      <a href="show_bug.cgi?id=190">190</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P5</nobr>
    </td>
    <td><nobr>Mac</nobr>
    </td>
    <td><nobr>thomas@openedhand.com</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>No rule to build dates.desktop
    </td>

  </tr>

  


  

  <tr class="bz_enhancement bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=191">191</a>
    </td>

    <td><nobr>enh</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>sean_chiang@fic.com.tw</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>investigate if we can set CPU voltage to 1.8V on 200MHz o...
    </td>

  </tr>

  


  

  <tr class="bz_enhancement bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=192">192</a>
    </td>

    <td><nobr>enh</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Mac</nobr>
    </td>
    <td><nobr>buglog@lists.openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Graphic bootsplash during userspace sysinit
    </td>

  </tr>

  


  

  <tr class="bz_enhancement bz_P3 ">

    <td>
      <a href="show_bug.cgi?id=193">193</a>
    </td>

    <td><nobr>enh</nobr>
    </td>
    <td><nobr>P3</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>sean_chiang@fic.com.tw</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Information about current charging status when AC is online
    </td>

  </tr>

  


  

  <tr class="bz_minor bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=194">194</a>
    </td>

    <td><nobr>min</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>stefan@openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>s3c2410fb 8bit mode corrupt
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=195">195</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>stefan@openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>passthrough mode (Directly use GSM Modem from PC
    </td>

  </tr>

  


  

  <tr class="bz_enhancement bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=196">196</a>
    </td>

    <td><nobr>enh</nobr>
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
    <td>Merge back fixes to openmoko recipes from OE
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=197">197</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Make theme suitable for qvga screens.
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=198">198</a>
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
    <td>Please enable CONFIG_TUN as a module in defconfig-fic-gta01
    </td>

  </tr>

  


  

  <tr class="bz_major bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=199">199</a>
    </td>

    <td><nobr>maj</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>sean_mosko@fic.com.tw</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>We need freely licensed ringtones
    </td>

  </tr>

  


  

  <tr class="bz_minor bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=200">200</a>
    </td>

    <td><nobr>min</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>PARALLEL_MAKE seems to not work
    </td>

  </tr>

  
    </table>


  
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
        <a href="buglist.cgi?short_desc_type=allwordssubstr&amp;short_desc=&amp;long_desc_type=allwordssubstr&amp;long_desc=&amp;bug_file_loc_type=allwordssubstr&amp;bug_file_loc=&amp;bug_status=UNCONFIRMED&amp;bug_status=NEW&amp;bug_status=ASSIGNED&amp;bug_status=REOPENED&amp;bug_status=RESOLVED&amp;bug_status=VERIFIED&amp;bug_status=CLOSED&amp;emailassigned_to1=1&amp;emailtype1=substring&amp;email1=&amp;emailassigned_to2=1&amp;emailreporter2=1&amp;emailcc2=1&amp;emailtype2=substring&amp;email2=&amp;bugidtype=include&amp;bug_id=&amp;votes=&amp;changedin=&amp;chfieldfrom=&amp;chfieldto=Now&amp;chfieldvalue=&amp;field0-0-0=noop&amp;type0-0-0=noop&amp;value0-0-0=&amp;order=bugs.bug_id">ID</a>
      </th>

<th colspan="1">
    <a href="buglist.cgi?short_desc_type=allwordssubstr&amp;short_desc=&amp;long_desc_type=allwordssubstr&amp;long_desc=&amp;bug_file_loc_type=allwordssubstr&amp;bug_file_loc=&amp;bug_status=UNCONFIRMED&amp;bug_status=NEW&amp;bug_status=ASSIGNED&amp;bug_status=REOPENED&amp;bug_status=RESOLVED&amp;bug_status=VERIFIED&amp;bug_status=CLOSED&amp;emailassigned_to1=1&amp;emailtype1=substring&amp;email1=&amp;emailassigned_to2=1&amp;emailreporter2=1&amp;emailcc2=1&amp;emailtype2=substring&amp;email2=&amp;bugidtype=include&amp;bug_id=&amp;votes=&amp;changedin=&amp;chfieldfrom=&amp;chfieldto=Now&amp;chfieldvalue=&amp;field0-0-0=noop&amp;type0-0-0=noop&amp;value0-0-0=&amp;order=bugs.bug_severity,bugs.bug_id">Sev</a>
  </th><th colspan="1">
    <a href="buglist.cgi?short_desc_type=allwordssubstr&amp;short_desc=&amp;long_desc_type=allwordssubstr&amp;long_desc=&amp;bug_file_loc_type=allwordssubstr&amp;bug_file_loc=&amp;bug_status=UNCONFIRMED&amp;bug_status=NEW&amp;bug_status=ASSIGNED&amp;bug_status=REOPENED&amp;bug_status=RESOLVED&amp;bug_status=VERIFIED&amp;bug_status=CLOSED&amp;emailassigned_to1=1&amp;emailtype1=substring&amp;email1=&amp;emailassigned_to2=1&amp;emailreporter2=1&amp;emailcc2=1&amp;emailtype2=substring&amp;email2=&amp;bugidtype=include&amp;bug_id=&amp;votes=&amp;changedin=&amp;chfieldfrom=&amp;chfieldto=Now&amp;chfieldvalue=&amp;field0-0-0=noop&amp;type0-0-0=noop&amp;value0-0-0=&amp;order=bugs.priority,bugs.bug_id">Pri</a>
  </th><th colspan="1">
    <a href="buglist.cgi?short_desc_type=allwordssubstr&amp;short_desc=&amp;long_desc_type=allwordssubstr&amp;long_desc=&amp;bug_file_loc_type=allwordssubstr&amp;bug_file_loc=&amp;bug_status=UNCONFIRMED&amp;bug_status=NEW&amp;bug_status=ASSIGNED&amp;bug_status=REOPENED&amp;bug_status=RESOLVED&amp;bug_status=VERIFIED&amp;bug_status=CLOSED&amp;emailassigned_to1=1&amp;emailtype1=substring&amp;email1=&amp;emailassigned_to2=1&amp;emailreporter2=1&amp;emailcc2=1&amp;emailtype2=substring&amp;email2=&amp;bugidtype=include&amp;bug_id=&amp;votes=&amp;changedin=&amp;chfieldfrom=&amp;chfieldto=Now&amp;chfieldvalue=&amp;field0-0-0=noop&amp;type0-0-0=noop&amp;value0-0-0=&amp;order=bugs.rep_platform,bugs.bug_id">Plt</a>
  </th><th colspan="1">
    <a href="buglist.cgi?short_desc_type=allwordssubstr&amp;short_desc=&amp;long_desc_type=allwordssubstr&amp;long_desc=&amp;bug_file_loc_type=allwordssubstr&amp;bug_file_loc=&amp;bug_status=UNCONFIRMED&amp;bug_status=NEW&amp;bug_status=ASSIGNED&amp;bug_status=REOPENED&amp;bug_status=RESOLVED&amp;bug_status=VERIFIED&amp;bug_status=CLOSED&amp;emailassigned_to1=1&amp;emailtype1=substring&amp;email1=&amp;emailassigned_to2=1&amp;emailreporter2=1&amp;emailcc2=1&amp;emailtype2=substring&amp;email2=&amp;bugidtype=include&amp;bug_id=&amp;votes=&amp;changedin=&amp;chfieldfrom=&amp;chfieldto=Now&amp;chfieldvalue=&amp;field0-0-0=noop&amp;type0-0-0=noop&amp;value0-0-0=&amp;order=map_assigned_to.login_name,bugs.bug_id">Owner</a>
  </th><th colspan="1">
    <a href="buglist.cgi?short_desc_type=allwordssubstr&amp;short_desc=&amp;long_desc_type=allwordssubstr&amp;long_desc=&amp;bug_file_loc_type=allwordssubstr&amp;bug_file_loc=&amp;bug_status=UNCONFIRMED&amp;bug_status=NEW&amp;bug_status=ASSIGNED&amp;bug_status=REOPENED&amp;bug_status=RESOLVED&amp;bug_status=VERIFIED&amp;bug_status=CLOSED&amp;emailassigned_to1=1&amp;emailtype1=substring&amp;email1=&amp;emailassigned_to2=1&amp;emailreporter2=1&amp;emailcc2=1&amp;emailtype2=substring&amp;email2=&amp;bugidtype=include&amp;bug_id=&amp;votes=&amp;changedin=&amp;chfieldfrom=&amp;chfieldto=Now&amp;chfieldvalue=&amp;field0-0-0=noop&amp;type0-0-0=noop&amp;value0-0-0=&amp;order=bugs.bug_status,bugs.bug_id">State</a>
  </th><th colspan="1">
    <a href="buglist.cgi?short_desc_type=allwordssubstr&amp;short_desc=&amp;long_desc_type=allwordssubstr&amp;long_desc=&amp;bug_file_loc_type=allwordssubstr&amp;bug_file_loc=&amp;bug_status=UNCONFIRMED&amp;bug_status=NEW&amp;bug_status=ASSIGNED&amp;bug_status=REOPENED&amp;bug_status=RESOLVED&amp;bug_status=VERIFIED&amp;bug_status=CLOSED&amp;emailassigned_to1=1&amp;emailtype1=substring&amp;email1=&amp;emailassigned_to2=1&amp;emailreporter2=1&amp;emailcc2=1&amp;emailtype2=substring&amp;email2=&amp;bugidtype=include&amp;bug_id=&amp;votes=&amp;changedin=&amp;chfieldfrom=&amp;chfieldto=Now&amp;chfieldvalue=&amp;field0-0-0=noop&amp;type0-0-0=noop&amp;value0-0-0=&amp;order=bugs.resolution,bugs.bug_id">Result</a>
  </th><th colspan="1">
    <a href="buglist.cgi?short_desc_type=allwordssubstr&amp;short_desc=&amp;long_desc_type=allwordssubstr&amp;long_desc=&amp;bug_file_loc_type=allwordssubstr&amp;bug_file_loc=&amp;bug_status=UNCONFIRMED&amp;bug_status=NEW&amp;bug_status=ASSIGNED&amp;bug_status=REOPENED&amp;bug_status=RESOLVED&amp;bug_status=VERIFIED&amp;bug_status=CLOSED&amp;emailassigned_to1=1&amp;emailtype1=substring&amp;email1=&amp;emailassigned_to2=1&amp;emailreporter2=1&amp;emailcc2=1&amp;emailtype2=substring&amp;email2=&amp;bugidtype=include&amp;bug_id=&amp;votes=&amp;changedin=&amp;chfieldfrom=&amp;chfieldto=Now&amp;chfieldvalue=&amp;field0-0-0=noop&amp;type0-0-0=noop&amp;value0-0-0=&amp;order=bugs.short_desc,bugs.bug_id">Summary</a>
  </th>


    </tr>

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=201">201</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Use TEXT_BASE 0x37f80000 in u-boot on GTA01Bv2 and higher
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=202">202</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>werner@openmoko.org</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>Start using NAND hardware ECC support
    </td>

  </tr>

  


  

  <tr class="bz_major bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=203">203</a>
    </td>

    <td><nobr>maj</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>All</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>fix the web site: http://openmoko.com/
    </td>

  </tr>

  


  

  <tr class="bz_minor bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=204">204</a>
    </td>

    <td><nobr>min</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>All</nobr>
    </td>
    <td><nobr>buglog@lists.openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Fatal error in Special:Newimages
    </td>

  </tr>

  


  

  <tr class="bz_minor bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=205">205</a>
    </td>

    <td><nobr>min</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>add code to u-boot to query hardware revision and serial ...
    </td>

  </tr>

  


  

  <tr class="bz_major bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=206">206</a>
    </td>

    <td><nobr>maj</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Disallow setting of overvoltage via pcf50606 kernel driver
    </td>

  </tr>

  


  

  <tr class="bz_major bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=207">207</a>
    </td>

    <td><nobr>maj</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>DFU mode should only be enabled when in &quot;911 key&quot; mode
    </td>

  </tr>

  


  

  <tr class="bz_minor bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=208">208</a>
    </td>

    <td><nobr>min</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>u-boot DFU upload broken
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=209">209</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>u-boot DFU needs to block console access while in DFU mode
    </td>

  </tr>

  


  

  <tr class="bz_major bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=210">210</a>
    </td>

    <td><nobr>maj</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Oth</nobr>
    </td>
    <td><nobr>henryk@ploetzli.ch</nobr>
    </td>
    <td><nobr>ASSI</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>&quot;now&quot; causes frequent rebuilds and fills disks
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=211">211</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>All</nobr>
    </td>
    <td><nobr>buglog@lists.openmoko.org</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>sjf2410-linux-native.bb has do_deploy in the wrong location
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=212">212</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Oth</nobr>
    </td>
    <td><nobr>werner@openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Charging seems completely broken
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=213">213</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Oth</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>openmoko-dates-0.1+svnnow fails certificate check
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=214">214</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>Add CVS_TARBALL_STASH for missing upstream sources
    </td>

  </tr>

  


  

  <tr class="bz_blocker bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=215">215</a>
    </td>

    <td><nobr>blo</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>All</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>fingerwheel crashes mainmenu when touching the black part
    </td>

  </tr>

  


  

  <tr class="bz_blocker bz_P3 ">

    <td>
      <a href="show_bug.cgi?id=216">216</a>
    </td>

    <td><nobr>blo</nobr>
    </td>
    <td><nobr>P3</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>thomas@openedhand.com</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>DUPL</nobr>
    </td>
    <td>contacts crashes when tying to enter import widget
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=217">217</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>werner@openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Implement NAND OTP area read/write as u-boot commands
    </td>

  </tr>

  


  

  <tr class="bz_enhancement bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=218">218</a>
    </td>

    <td><nobr>enh</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Distinguish stylus from finger via tslib
    </td>

  </tr>

  


  

  <tr class="bz_blocker bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=219">219</a>
    </td>

    <td><nobr>blo</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>All</nobr>
    </td>
    <td><nobr>tonyguan@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>openmoko-dialer r1159 fails to compile
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=220">220</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>libgsmd_device.c is missing
    </td>

  </tr>

  


  

  <tr class="bz_blocker bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=221">221</a>
    </td>

    <td><nobr>blo</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Mac</nobr>
    </td>
    <td><nobr>thomas@openedhand.com</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>Can't add new contacts via the gui
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=222">222</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Mac</nobr>
    </td>
    <td><nobr>thomas@openedhand.com</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>WORK</nobr>
    </td>
    <td>Can't add new events
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=223">223</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Mac</nobr>
    </td>
    <td><nobr>thomas@openedhand.com</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>weekview only displays half the week
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=224">224</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>call to uboot-mkimage requires ${STAGING_BINDIR} prefix
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=225">225</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>Fix ordering of do_deploy in uboot to be compatible with ...
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=226">226</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <td><nobr>buglog@lists.openmoko.org</nobr>
    </td>
    <td><nobr>REOP</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>dfu-util-native do_deploy tries to install from wrong sou...
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=227">227</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Add openmoko-mirrors.bbclass and enable use of it
    </td>

  </tr>

  


  

  <tr class="bz_blocker bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=228">228</a>
    </td>

    <td><nobr>blo</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>openmoko applications(contacts,  appmanager ...) easily c...
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=229">229</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <td><nobr>davewu01@seed.net.tw</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>outgoing call/incoming call/talking status should be more...
    </td>

  </tr>

  


  

  <tr class="bz_trivial bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=230">230</a>
    </td>

    <td><nobr>tri</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>Use the toolchain speified in $CROSS_COMPILE in u-boot.
    </td>

  </tr>

  


  

  <tr class="bz_minor bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=231">231</a>
    </td>

    <td><nobr>min</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>werner@openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>switch display backlight GPIO to &quot;output, off&quot; when suspe...
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=232">232</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Oth</nobr>
    </td>
    <td><nobr>buglog@lists.openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>n-plicate buglog mails 
    </td>

  </tr>

  


  

  <tr class="bz_critical bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=233">233</a>
    </td>

    <td><nobr>cri</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>werner@openmoko.org</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>power-off timer should be halted in DFU mode
    </td>

  </tr>

  


  

  <tr class="bz_major bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=234">234</a>
    </td>

    <td><nobr>maj</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>werner@openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>check for bad blocks in first _and_ second page of each b...
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=235">235</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>Deploy openocd-native, not openocd, and make openocd-nati...
    </td>

  </tr>

  


  

  <tr class="bz_critical bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=236">236</a>
    </td>

    <td><nobr>cri</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Close moko_dialog_window several times, moko_stylus_demo ...
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=237">237</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>Fix remaining https urls in bitbake recipes.
    </td>

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
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>LATE</nobr>
    </td>
    <td>manual test bug
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=239">239</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>LATE</nobr>
    </td>
    <td>foo
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=240">240</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>INVA</nobr>
    </td>
    <td>broken-1.0-r0-do_fetch
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=241">241</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>CLOS</nobr>
    </td>
    <td><nobr>LATE</nobr>
    </td>
    <td>broken-1.0-r0-do_fetch
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=242">242</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>INVA</nobr>
    </td>
    <td>broken-1.0-r0-do_compile
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=243">243</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>INVA</nobr>
    </td>
    <td>broken-1.0-r0-do_configure
    </td>

  </tr>

  


  

  <tr class="bz_major bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=244">244</a>
    </td>

    <td><nobr>maj</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>I can't build Xorg7.1 from MokoMakefile
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=245">245</a>
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
    <td>Neo crashes when writing large amounts of data to SD
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=246">246</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <td><nobr>sean_chiang@fic.com.tw</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Debug board needs to be recognized by mainline linux kernel.
    </td>

  </tr>

  


  

  <tr class="bz_major bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=247">247</a>
    </td>

    <td><nobr>maj</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>thomas@openedhand.com</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>openmoko-dates svn rev. 335 does no longer build
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=248">248</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <td><nobr>buglog@lists.openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Buttons disappear under zoom
    </td>

  </tr>

  


  

  <tr class="bz_enhancement bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=249">249</a>
    </td>

    <td><nobr>enh</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>All</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>add command to print gsmd version number
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=250">250</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>INVA</nobr>
    </td>
    <td>broken-1.0-r0-do_compile
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=251">251</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>INVA</nobr>
    </td>
    <td>broken-1.0-r0-do_compile
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=252">252</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>REOP</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>openmoko-devel-image-1.0-r0-do_rootfs
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=253">253</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Mount /tmp as tmpfs
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=254">254</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Oth</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>bug with &quot;patch&quot; on arklinux 2006.1??
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=255">255</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>tony_tu@fiwin.com.tw</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>battery voltage scale is not correct
    </td>

  </tr>

  


  

  <tr class="bz_critical bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=256">256</a>
    </td>

    <td><nobr>cri</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <td><nobr>sean_chiang@fic.com.tw</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>GSM Modem doesn't seem to work on some devices
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=257">257</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Oth</nobr>
    </td>
    <td><nobr>sean_chiang@fic.com.tw</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>AUX button sticking
    </td>

  </tr>

  


  

  <tr class="bz_major bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=258">258</a>
    </td>

    <td><nobr>maj</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>All</nobr>
    </td>
    <td><nobr>cj_steven@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Main Menu needs to have Single Instance functionality
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=259">259</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>stefan@openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>implement 500mA charging in u-boot
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=260">260</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>stefan@openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>implement 100mA charging in Linux
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=261">261</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>stefan@openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Implement 500mA charging using wall-outlet charger
    </td>

  </tr>

  


  

  <tr class="bz_enhancement bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=262">262</a>
    </td>

    <td><nobr>enh</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>buglog@lists.openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>Indicate different charging mode in battery applet
    </td>

  </tr>

  


  

  <tr class="bz_blocker bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=263">263</a>
    </td>

    <td><nobr>blo</nobr>
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
    <td>gsmd doesn't receive AT reply from the modem properly.
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=264">264</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>package libelf-0.8.6-r0: task do_populate_staging: failed
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=265">265</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>MokoMakefile: perl-native fix
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=266">266</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>ftdi-eeprom-native missing confuse-native dependency
    </td>

  </tr>

  


  

  <tr class="bz_enhancement bz_P4 ">

    <td>
      <a href="show_bug.cgi?id=267">267</a>
    </td>

    <td><nobr>enh</nobr>
    </td>
    <td><nobr>P4</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <td><nobr>buglog@lists.openmoko.org</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>internal function duplicates strstr(3)
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=268">268</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <td><nobr>buglog@lists.openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>openmoko-today crashes when one of the buttons is pressed
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=269">269</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>openmoko-contacts-0.1+svnnow-r3_0_200703151745-do_unpack
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=270">270</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>does our xserver need security updates?
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=271">271</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>laforge@openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>It would be nice if ppp was supported by kernel
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=272">272</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>openmoko-contacts-0.1+svnnow-r3_0_200703152250-do_unpack
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=273">273</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>openmoko-contacts-0.1+svnnow-r3_0_200703160254-do_unpack
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=274">274</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>openmoko-contacts-0.1+svnnow-r3_0_200703160321-do_unpack
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=275">275</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>openmoko-contacts-0.1+svnnow-r3_0_200703160350-do_unpack
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P3 ">

    <td>
      <a href="show_bug.cgi?id=276">276</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P3</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>songcw@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>The open file window is too ugly
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=277">277</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>openmoko-contacts-0.1+svnnow-r3_0_200703160712-do_unpack
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=278">278</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>mickey@vanille-media.de</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>openmoko-contacts-0.1+svnnow-r3_0_200703160805-do_unpack
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=279">279</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>buglog@lists.openmoko.org</nobr>
    </td>
    <td><nobr>RESO</nobr>
    </td>
    <td><nobr>FIXE</nobr>
    </td>
    <td>Appmanager crush when install packages
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=280">280</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>songcw@fic-sh.com.cn</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>openmoko-appmanager not refresh the packages list after r...
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P3 ">

    <td>
      <a href="show_bug.cgi?id=281">281</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P3</nobr>
    </td>
    <td><nobr>PC</nobr>
    </td>
    <td><nobr>buglog@lists.openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>implicit declaration of function `strdup'
    </td>

  </tr>

  


  

  <tr class="bz_normal bz_P2 ">

    <td>
      <a href="show_bug.cgi?id=282">282</a>
    </td>

    <td><nobr>nor</nobr>
    </td>
    <td><nobr>P2</nobr>
    </td>
    <td><nobr>Neo</nobr>
    </td>
    <td><nobr>buglog@lists.openmoko.org</nobr>
    </td>
    <td><nobr>NEW</nobr>
    </td>
    <td><nobr></nobr>
    </td>
    <td>microSD Problem
    </td>

  </tr>

  
    </table>




282 bugs found.


<br>












  <form method="post" action="long_list.cgi">
    <input type="hidden" name="buglist" value="1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,127,128,129,130,131,132,133,134,135,136,137,138,139,140,141,142,143,144,145,146,147,148,149,150,151,152,153,154,155,156,157,158,159,160,161,162,163,164,165,166,167,168,169,170,171,172,173,174,175,176,177,178,179,180,181,182,183,184,185,186,187,188,189,190,191,192,193,194,195,196,197,198,199,200,201,202,203,204,205,206,207,208,209,210,211,212,213,214,215,216,217,218,219,220,221,222,223,224,225,226,227,228,229,230,231,232,233,234,235,236,237,238,239,240,241,242,243,244,245,246,247,248,249,250,251,252,253,254,255,256,257,258,259,260,261,262,263,264,265,266,267,268,269,270,271,272,273,274,275,276,277,278,279,280,281,282">
    <input type="submit" value="Long Format">

    <a href="query.cgi">Query Page</a> &nbsp;&nbsp;
    <a href="enter_bug.cgi">Enter New Bug</a> &nbsp;&nbsp;
    <a href="colchange.cgi?short_desc_type=allwordssubstr&amp;short_desc=&amp;long_desc_type=allwordssubstr&amp;long_desc=&amp;bug_file_loc_type=allwordssubstr&amp;bug_file_loc=&amp;bug_status=UNCONFIRMED&amp;bug_status=NEW&amp;bug_status=ASSIGNED&amp;bug_status=REOPENED&amp;bug_status=RESOLVED&amp;bug_status=VERIFIED&amp;bug_status=CLOSED&amp;emailassigned_to1=1&amp;emailtype1=substring&amp;email1=&amp;emailassigned_to2=1&amp;emailreporter2=1&amp;emailcc2=1&amp;emailtype2=substring&amp;email2=&amp;bugidtype=include&amp;bug_id=&amp;votes=&amp;changedin=&amp;chfieldfrom=&amp;chfieldto=Now&amp;chfieldvalue=&amp;field0-0-0=noop&amp;type0-0-0=noop&amp;value0-0-0=">Change Columns</a> &nbsp;&nbsp;



    <a href="query.cgi?short_desc_type=allwordssubstr&amp;short_desc=&amp;long_desc_type=allwordssubstr&amp;long_desc=&amp;bug_file_loc_type=allwordssubstr&amp;bug_file_loc=&amp;bug_status=UNCONFIRMED&amp;bug_status=NEW&amp;bug_status=ASSIGNED&amp;bug_status=REOPENED&amp;bug_status=RESOLVED&amp;bug_status=VERIFIED&amp;bug_status=CLOSED&amp;emailassigned_to1=1&amp;emailtype1=substring&amp;email1=&amp;emailassigned_to2=1&amp;emailreporter2=1&amp;emailcc2=1&amp;emailtype2=substring&amp;email2=&amp;bugidtype=include&amp;bug_id=&amp;votes=&amp;changedin=&amp;chfieldfrom=&amp;chfieldto=Now&amp;chfieldvalue=&amp;field0-0-0=noop&amp;type0-0-0=noop&amp;value0-0-0=">Edit this Query</a> &nbsp;&nbsp;

  </form>






<!-- 1.0@bugzilla.org -->



  

  
</div>

<div class="footer">
    <div class="group">This is <b>Bugzilla</b>: the Mozilla bug system.  For more information about what Bugzilla is and what it can do, see <a href="http://www.bugzilla.org/">bugzilla.org</a>.</div>
    <!-- 1.0@bugzilla.org -->






<form method="get" action="show_bug.cgi">
    <div class="group">
        <a href="enter_bug.cgi">New</a> | <a href="query.cgi">Query</a> | <input type="submit" value="Find"> bug # <input name="id" size="6"> | <a href="reports.cgi">Reports</a> 
    </div>
    
        <div>
            <a href="createaccount.cgi">New&nbsp;Account</a> | <a href="query.cgi?GoAheadAndLogIn=1">Log&nbsp;In</a>
        </div>
</form>
</div>  

</body>
</html>
"""

bugfinder =BugQueryExtractor()
bugfinder.feed(bugs_openmoko)
print bugfinder.result()
print len(bugfinder.result())

seen_numbers = {}
for (number,_) in bugfinder.result():
    seen_numbers[number] = "Yes"

for i in range(1,283):
    if not seen_numbers.has_key(str(i)):
        print "Not seen %d" % i
