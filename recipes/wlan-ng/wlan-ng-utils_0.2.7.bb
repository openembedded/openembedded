require wlan-ng-utils.inc

SRC_URI += "ftp://ftp.linux-wlan.org/pub/linux-wlan-ng/linux-wlan-ng-${PV}.tar.bz2 \
        file://scripts-makefile-hostcc.patch;patch=1 \
	file://pcmciasrc.patch;patch=1 \
	file://hostldflags.patch;patch=1"

S = "${WORKDIR}/linux-wlan-ng-${PV}"

PR = "r3"

SRC_URI[md5sum] = "b2b0ffd11d27c72a9c01b8a9ef3832b7"
SRC_URI[sha256sum] = "9dbd0f6c92b33ae8b96c5a045a341a00b2454492c2229839d056e4fd1488bca5"
