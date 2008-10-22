require wlan-ng-modules.inc

PR = "r2"

SRC_URI += "ftp://ftp.linux-wlan.org/pub/linux-wlan-ng/linux-wlan-ng-${PV}.tar.bz2 \
	    file://2.6.22-fixes.patch;patch=1"

S = "${WORKDIR}/linux-wlan-ng-${PV}"

