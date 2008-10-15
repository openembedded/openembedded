require wlan-ng-utils.inc

SRC_URI += "ftp://ftp.linux-wlan.org/pub/linux-wlan-ng/linux-wlan-ng-${PV}.tar.bz2 \
        file://scripts-makefile-hostcc.patch;patch=1 \
	file://pcmciasrc.patch;patch=1 \
	file://hostldflags.patch;patch=1"

S = "${WORKDIR}/linux-wlan-ng-${PV}"

PR = "r2"
