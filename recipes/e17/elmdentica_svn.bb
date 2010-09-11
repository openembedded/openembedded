DESCRIPTION = "A indenti.ca client for E"
DEPENDS = "glib-2.0 gconf curl elementary sqlite3-native"
LICENSE = "GPLv3+"
SECTION = "e/apps"
HOMEPAGE = "http://elmdentica.googlecode.com"
AUTHOR = "seabra"

inherit e

PV = "0.9.9+svnr${SRCPV}"
PR = "r1"
SRCREV = "${EFL_SRCREV}"
