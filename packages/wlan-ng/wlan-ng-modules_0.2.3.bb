include wlan-ng-modules.inc
PR = "r2"

SRC_URI += "ftp://ftp.linux-wlan.org/pub/linux-wlan-ng/linux-wlan-ng-${PV}.tar.bz2 \
	    file://prism2sta_commsqual_defer.patch;patch=1 \
	    file://usb-owner.patch;patch=1 "
S = "${WORKDIR}/linux-wlan-ng-${PV}"

