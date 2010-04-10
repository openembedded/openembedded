require wlan-ng-utils.inc

SRC_URI += "ftp://ftp.linux-wlan.org/pub/linux-wlan-ng/linux-wlan-ng-${PV}.tar.bz2 \
        file://scripts-makefile-hostcc.patch;patch=1 \
	file://pcmciasrc.patch;patch=1 \
	file://hostldflags.patch;patch=1"

S = "${WORKDIR}/linux-wlan-ng-${PV}"

PR = "r2"

SRC_URI[md5sum] = "5d86ca7bb4ed458743acd922ff09dae6"
SRC_URI[sha256sum] = "e4b6ab08eaff2766c3bf85ea8d63ab31ae774266b8351772117fcc94d1318ade"
