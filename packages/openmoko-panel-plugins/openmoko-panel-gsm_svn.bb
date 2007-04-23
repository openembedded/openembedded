DESCRIPTION = "Shows the GSM status in the OpenMoko panel"
PV = "0.0.1+svn${SRCDATE}"
PR = "r1"

DEPENDS_append = " libgsmd"

inherit openmoko-panel-plugin

FILES_${PN} += "${bindir}/${PN}"

