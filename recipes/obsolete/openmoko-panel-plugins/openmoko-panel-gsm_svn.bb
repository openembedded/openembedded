DESCRIPTION = "Shows the GSM / GPRS status in the Openmoko panel"
DEPENDS = "libmokogsmd2 libnotify"
SRCREV = "4335"
PV = "0.1.0+svnr${SRCPV}"
PR = "r2"

inherit openmoko-panel-plugin
