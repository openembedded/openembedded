require xorg-lib-common.inc

DESCRIPTION = "X11 toolkit intrinsics library"
DEPENDS += "libsm virtual/libx11 kbproto"
PROVIDES = "xt"
PE = "1"

XORG_PN = "libXt"

EXTRA_OECONF += "--disable-install-makestrs --disable-xkb"

do_compile() {
	(
		unset CC LD CXX CCLD
		oe_runmake -C util 'XT_CFLAGS=' 'CC=${BUILD_CC}' 'LD=${BUILD_LD}' 'CXX=${BUILD_CXX}' 'CCLD=${BUILD_CCLD}' 'CFLAGS=-D_GNU_SOURCE -I${STAGING_INCDIR_NATIVE} ${BUILD_CFLAGS}' 'LDFLAGS=${BUILD_LDFLAGS}' 'CXXFLAGS=${BUILD_CXXFLAGS}' 'CPPFLAGS=${BUILD_CPPFLAGS}' makestrs
	) || exit 1
	oe_runmake
}
SRC_URI[archive.md5sum] = "fb7d2aa5b24cd5fe9b238a26d88030e7"
SRC_URI[archive.sha256sum] = "70f52c81258661811c8eae86a7a6dc910d0bf84cd48aeeed85ba430ad6b2037c"
