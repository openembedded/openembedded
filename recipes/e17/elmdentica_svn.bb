DESCRIPTION = "A indenti.ca client for E"
DEPENDS = "glib-2.0 gconf libxml2 curl elementary"
LICENSE = "GPLv3+"
SECTION = "e/apps"
HOMEPAGE = "http://elmdentica.googlecode.com"
AUTHOR = "seabra"
PV = "0.6.0+svn${SRCREV}"
PR = "r1"
 
 
SRC_URI = "svn://elmdentica.googlecode.com/svn/trunk;module=.;proto=http"
 
S = "${WORKDIR}"
 
inherit autotools
