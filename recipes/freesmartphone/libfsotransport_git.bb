require cornucopia.inc
DESCRIPTION = "freesmartphone.org transport library"
# we need posixextra.vapi
DEPENDS += "libfsoframework"
PV = "0.9.3+gitr${SRCREV}"
PR = "${INC_PR}.0"
