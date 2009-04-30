require wlan-ng-modules.inc

PR = "r0"

PV = "0.2.8+svnr${SRCPV}"

SRC_URI += "svn://svn.shaftnet.org/linux-wlan-ng;module=trunk "
		
S = "${WORKDIR}/trunk"
