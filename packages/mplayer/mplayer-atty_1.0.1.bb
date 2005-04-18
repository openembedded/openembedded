DESCRIPTION = "Open Source multimedia player."
SECTION = "opie/multimedia"
PRIORITY = "optional"
HOMEPAGE = "http://www.mplayerhq.hu/"
DEPENDS = "virtual/libsdl libmad libogg libvorbis zlib libpng jpeg"
LICENSE = "GPL"
SRC_URI = "http://www.xora.org.uk/oe/mplayer-${PV}.tar.gz \
	   file://Makefile.patch;patch=1;pnum=0 \
	   file://sdl.patch;patch=1 \
	   file://Makefile-libs.patch;patch=1 \
	   file://dsputil.patch;patch=1"

RCONFLICTS="mplayer"
MAINTAINER="Graeme Gregory <dp@xora.org.uk>"

PR = "r2"

PARALLEL_MAKE = ""

DEPENDS_append_c7x0 = " sharp-aticore-oss"
PACKAGE_ARCH_c7x0 = "${MACHINE_ARCH}"
PACKAGE_ARCH_akita = "${MACHINE_ARCH}"
PACKAGE_ARCH_spitze = "${MACHINE_ARCH}"

S = "${WORKDIR}/mplayer-${PV}"

FILES_${PN} = "${bindir}/mplayer"

inherit autotools 

EXTRA_OECONF = " \
        --prefix=/usr \
        --mandir=${mandir} \
        --target=${TARGET_SYS} \
        --enable-shared-pp \
        \
        --disable-win32 \
        --disable-macosx \
        --disable-dvdread \
        --disable-mpdvdkit \
        --disable-tv \
        --disable-tv-v4l \
        --disable-tv-v4l2 \
        --disable-tv-bsdbt848 \
        --disable-mencoder \
        --disable-live \
        \
        --enable-dynamic-plugins \
        --enable-fbdev \
        --enable-sdl \
        --with-sdl-config=${STAGING_BINDIR}/sdl-config \
        \
        --enable-mad \
        --enable-vorbis \
        \
        --enable-ossaudio \
        \
        --enable-rtc \
	--disable-ipp \
	--disable-iwmmxt \
        \
        --with-extralibdir=${STAGING_LIBDIR} "

EXTRA_OECONF_append_c7x0 = " --enable-w100"
EXTRA_OECONF_append_akita = " --enable-bvdd"
EXTRA_OECONF_append_spitz = " --enable-bvdd"

do_configure() {
        ./configure ${EXTRA_OECONF}
}

