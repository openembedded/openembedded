require wlan-ng-modules.inc

SRCDATE = "20061109"
PV = "0.2.5+svn${SRCDATE}"

SRC_URI += "svn://svn.shaftnet.org/linux-wlan-ng;module=trunk "
S = "${WORKDIR}/trunk"

