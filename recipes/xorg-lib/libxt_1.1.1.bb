require xorg-lib-common.inc
DESCRIPTION = "X11 toolkit intrinsics library"
DEPENDS += "libsm virtual/libx11 kbproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "eb22c0a1f172b06b97a3f5ae89768412"
SRC_URI[archive.sha256sum] = "a2a1c29c684e3c9082cdb920b5aea802b179d19107b9ab2170fda07575559da7"

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
