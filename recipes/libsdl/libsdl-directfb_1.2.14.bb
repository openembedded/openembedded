DESCRIPTION = "Simple DirectMedia Layer (DirectFB and Framebuffer support)"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "alsa-lib directfb"
PROVIDES = "virtual/libsdl"

SRC_URI = "http://www.libsdl.org/release/SDL-${PV}.tar.gz"
SRC_URI[md5sum] = "e52086d1b508fa0b76c52ee30b55bec4"
SRC_URI[sha256sum] = "5d927e287034cb6bb0ebccfa382cb1d185cb113c8ab5115a0759798642eed9b6"

S = "${WORKDIR}/SDL-${PV}"

inherit autotools lib_package binconfig pkgconfig

EXTRA_OECONF = " \
        --disable-arts \
        --disable-diskaudio \
        --disable-esd \
        --disable-esd-shared \
        --disable-esdtest \
        --enable-input-events \
        --disable-input-tslib \
        --disable-mintaudio \
        --disable-nas \
        --disable-nasm \
        --disable-video-dga \
        --disable-video-dummy \
        --enable-video-directfb \
        --enable-video-fbcon \
        --disable-video-opengl \
        --disable-video-picogui \
        --disable-video-ps2gs \
        --disable-video-ps3 \
        --disable-video-qtopia \
        --disable-video-x11 \
"
EXTRA_AUTORECONF += "--include=acinclude --exclude=autoheader"

do_configure_prepend () {
        # Remove old libtool macros.
        MACROS="libtool.m4 lt~obsolete.m4 ltoptions.m4 ltsugar.m4 ltversion.m4"
        for i in ${MACROS}; do
               rm -f acinclude/$i
        done
	export SYSROOT=$PKG_CONFIG_SYSROOT_DIR
}
