include wlan-ng-modules.inc
PR = "r0"
PV = "0.2.3+svn${SRCDATE}"

SRC_URI += "svn://svn.shaftnet.org/linux-wlan-ng;module=trunk "
S = "${WORKDIR}/trunk"

