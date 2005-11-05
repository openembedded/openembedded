SECTION = "base"
DESCRIPTION = "framebuffer getty."
LICENSE = "GPL"

SRC_URI = "http://ftp3.ie.freebsd.org/pub/gentoo/distfiles/fbgetty-${PV}.tar.gz \
	   file://compile.patch;patch=1"
B = "${WORKDIR}/build.${HOST_SYS}.${TARGET_SYS}"

inherit autotools
