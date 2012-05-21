DESCRIPTION = "Simple DirectMedia Layer (DirectFB and Framebuffer support)"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPLv2.1"
DEPENDS = "alsa-lib"
PROVIDES = "virtual/libsdl"
INC_PR = "r2"

SRC_URI = "http://www.libsdl.org/release/SDL-${PV}.tar.gz"
SRC_URI[md5sum] = "e52086d1b508fa0b76c52ee30b55bec4"
SRC_URI[sha256sum] = "5d927e287034cb6bb0ebccfa382cb1d185cb113c8ab5115a0759798642eed9b6"

S = "${WORKDIR}/SDL-${PV}"

inherit autotools lib_package binconfig pkgconfig

EXTRA_AUTORECONF += "--include=acinclude --exclude=autoheader"

do_configure_prepend () {
        # Remove old libtool macros.
        MACROS="libtool.m4 lt~obsolete.m4 ltoptions.m4 ltsugar.m4 ltversion.m4"
        for i in ${MACROS}; do
               rm -f acinclude/$i
        done
	export SYSROOT=$PKG_CONFIG_SYSROOT_DIR
}
