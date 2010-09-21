DESCRIPTION = "A indenti.ca client for E"
DEPENDS = "glib-2.0 gconf curl elementary sqlite3-native"
LICENSE = "GPLv3+"
SECTION = "e/apps"
HOMEPAGE = "http://elmdentica.googlecode.com"
AUTHOR = "seabra"

inherit e

PV = "0.9.9+svnr${SRCPV}"
PR = "r1"
#temporary bump SRCREV above EFL_SRCREV to fix build after 55b3912f14b1919bf2cd330e48546f11c179794f
#SRCREV = "${EFL_SRCREV}"
SRCREV = "52153"
