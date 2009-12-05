DESCRIPTION = "A indenti.ca client for E"
DEPENDS = "glib-2.0 gconf libxml2 curl elementary sqlite3-native"
LICENSE = "GPLv3+"
SECTION = "e/apps"
HOMEPAGE = "http://elmdentica.googlecode.com"
AUTHOR = "seabra"
PV = "0.7.0+svnr${SRCPV}"
PR = "r1"
 
 
SRC_URI = "svn://elmdentica.googlecode.com/svn;module=trunk;proto=http"
 
S = "${WORKDIR}/trunk"
 
inherit autotools pkgconfig
