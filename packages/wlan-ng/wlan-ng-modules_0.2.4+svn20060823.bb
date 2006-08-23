require wlan-ng-modules.inc

SRCDATE = "20060823"
PV = "0.2.4+svn${SRCDATE}"

SRC_URI += "svn://svn.shaftnet.org/linux-wlan-ng;module=trunk "
S = "${WORKDIR}/trunk"

