require xorg-lib-common.inc

DESCRIPTION = "X11 toolkit intrinsics library"
DEPENDS += "libsm virtual/libx11 kbproto"
PROVIDES = "xt"
PR = "r2"
PE = "1"

XORG_PN = "libXt"

SRC_URI += "file://pr10970-header-fix.patch;patch=1"

EXTRA_OECONF += "--disable-install-makestrs --disable-xkb"

do_compile() {
	(
		unset CC LD CXX CCLD
		oe_runmake -C util 'XT_CFLAGS=' 'CC=${BUILD_CC}' 'LD=${BUILD_LD}' 'CXX=${BUILD_CXX}' 'CCLD=${BUILD_CCLD}' 'CFLAGS=-D_GNU_SOURCE -I${STAGING_INCDIR_NATIVE} ${BUILD_CFLAGS}' 'LDFLAGS=${BUILD_LDFLAGS}' 'CXXFLAGS=${BUILD_CXXFLAGS}' 'CPPFLAGS=${BUILD_CPPFLAGS}' makestrs
	) || exit 1
	oe_runmake
}

SRC_URI[archive.md5sum] = "f3bdd67785ace8cd0b23249e9d8c9975"
SRC_URI[archive.sha256sum] = "43c472ada59a04428a463225cd4cd42cb81bc43eb687cc1890f2f1c81a3e9cf4"
