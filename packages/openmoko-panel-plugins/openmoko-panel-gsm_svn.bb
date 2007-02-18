DESCRIPTION = "Shows the current time in the OpenMoko panel"
PV = "0.0.1+svn${SRCDATE}"

inherit openmoko-panel-plugin

FILES_${PN} += "${bindir}/${PN}"

