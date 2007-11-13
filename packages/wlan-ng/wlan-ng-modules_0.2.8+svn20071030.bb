require wlan-ng-modules.inc

SRCDATE = "20071030"
PV = "0.2.8+svn${SRCDATE}"

SRC_URI += "svn://svn.shaftnet.org/linux-wlan-ng;module=trunk "
		
S = "${WORKDIR}/trunk"

