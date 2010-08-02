DESCRIPTION = "Library which can be used to write a source client like ices"
HOMEPAGE = "http://www.icecast.org"
DEPENDS = "speex libtheora libvorbis libogg"
LICENSE = "LGPL"

SRC_URI = "http://downloads.us.xiph.org/releases/libshout/libshout-${PV}.tar.gz \
           file://no-host-includes.ac;apply=yes "

inherit autotools

do_configure_prepend() {
    # Use the staged m4 files
    rm -f ${S}/m4/speex.m4
    rm -f ${S}/m4/ogg.m4
    rm -f ${S}/m4/vorbis.m4
}

