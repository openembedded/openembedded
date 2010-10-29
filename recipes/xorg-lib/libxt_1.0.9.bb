require xorg-lib-common.inc
DESCRIPTION = "X11 toolkit intrinsics library"
DEPENDS += "libsm virtual/libx11 kbproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "8a414f8f2327aaa616ca2dcac1f5d8c3"
SRC_URI[archive.sha256sum] = "eab91b594b801f7f07a20f936dda70a629028858cbcf541becf94f2786ae6b01"

EXTRA_OECONF += "--disable-install-makestrs --disable-xkb"

do_compile() {
        (
                unset CC LD CXX CCLD
                oe_runmake -C util 'XT_CFLAGS=' 'CC=${BUILD_CC}' 'LD=${BUILD_LD}' 'CXX=${BUILD_CXX}' 'CCLD=${BUILD_CCLD}' 'CFLAGS=-D_GNU_SOURCE -I${STAGING_INCDIR_NATIVE} ${BUILD_CFLAGS}' 'LDFLAGS=${BUILD_LDFLAGS}' 'CXXFLAGS=${BUILD_CXXFLAGS}' 'CPPFLAGS=${BUILD_CPPFLAGS}' makestrs
        ) || exit 1
        oe_runmake
}

BBCLASSEXTEND = "native"

XORG_PN = "libXt"
