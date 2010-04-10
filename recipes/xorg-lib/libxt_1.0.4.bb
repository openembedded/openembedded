require xorg-lib-common.inc
PE = "1"

DESCRIPTION = "X Toolkit Intrinsics"
PRIORITY = "optional"

DEPENDS += " libsm virtual/libx11 xproto kbproto"
PROVIDES = "xt"

XORG_PN = "libXt"

SRC_URI += "file://pr10970-header-fix.patch;patch=1"

PR = "r1"

EXTRA_OECONF="--enable-malloc0returnsnull --disable-install-makestrs --disable-xkb"

do_compile() {
	(
		unset CC LD CXX CCLD
		oe_runmake -C util 'XT_CFLAGS=' 'CC=${BUILD_CC}' 'LD=${BUILD_LD}' 'CXX=${BUILD_CXX}' 'CCLD=${BUILD_CCLD}' 'CFLAGS=-D_GNU_SOURCE ${BUILD_CFLAGS}' 'LDFLAGS=${BUILD_LDFLAGS}' 'CXXFLAGS=${BUILD_CXXFLAGS}' 'CPPFLAGS=${BUILD_CPPFLAGS}' makestrs
	) || exit 1
	oe_runmake
}

SRC_URI[archive.md5sum] = "937735f342c046db239852fec0413f6c"
SRC_URI[archive.sha256sum] = "ec7088b2ffe8f56c177525283601fb048decaf6f175d9ee5db01e12810a4d345"
