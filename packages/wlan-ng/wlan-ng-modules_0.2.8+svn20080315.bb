require wlan-ng-modules.inc

PR = "r1"

SRCDATE = "20080315"
PV = "0.2.8+svn${SRCDATE}"

SRC_URI += "svn://svn.shaftnet.org/linux-wlan-ng;module=trunk "
		
S = "${WORKDIR}/trunk"
