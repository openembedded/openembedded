SECTION = "base"
DESCRIPTION = "framebuffer getty."
LICENSE = "GPL"

SRC_URI = "http://ftp3.ie.freebsd.org/pub/gentoo/distfiles/fbgetty-${PV}.tar.gz \
	   file://compile.patch;patch=1"
B = "${WORKDIR}/build.${HOST_SYS}.${TARGET_SYS}"

inherit autotools

SRC_URI[md5sum] = "1705bc0f8f1e03fe50d324ba84ac4e56"
SRC_URI[sha256sum] = "332cbffa7c489b39a7d13d12d581c27dfc57ba098041431a6845b44785cf2d35"
