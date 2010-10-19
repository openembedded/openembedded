DESCRIPTION = "Shows an out-of-memory warning in the Openmoko panel"
DEPENDS = "libnotify"
RDEPENDS_${PN} = "openmoko-dialer2"
SRCREV = "3903"
PV = "0.0.0+svnr${SRCPV}"
PR = "r1"

inherit openmoko-panel-plugin
