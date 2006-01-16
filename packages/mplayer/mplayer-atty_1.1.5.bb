DESCRIPTION = "Open Source multimedia player."
SECTION = "opie/multimedia"
PRIORITY = "optional"
HOMEPAGE = "http://atty.skr.jp/?Zaurus%2Fmplayer"
DEPENDS = "virtual/libsdl freetype libmad libogg libvorbis zlib libpng jpeg alsa-lib"
LICENSE = "GPL"
RCONFLICTS = "mplayer"
MAINTAINER = "Graeme Gregory <dp@xora.org.uk>"
PR = "r4"

SRC_URI = "http://www.xora.org.uk/oe/mplayer-${PV}.tar.gz \
	   file://Makefile.patch;patch=1;pnum=0 \
	   file://sdl.patch;patch=1 \
           file://Makefile-libs.patch;patch=1 \
           file://libmpdemux-ogg-include.patch;patch=1 \
           file://libmpcodecs-ogg-include.patch;patch=1 \
	   file://alsa-configure.patch;patch=1 "

PARALLEL_MAKE = ""

DEPENDS_append_c7x0 = " sharp-aticore-oss"
PACKAGE_ARCH_c7x0 = "${MACHINE_ARCH}"
PACKAGE_ARCH_akita = "${MACHINE_ARCH}"
PACKAGE_ARCH_spitz = "${MACHINE_ARCH}"

S = "${WORKDIR}/mplayer-${PV}"

FILES_${PN} = "${bindir}/mplayer"

inherit autotools 

EXTRA_OECONF = " \
        --prefix=/usr \
        --mandir=${mandir} \
        --target=${TARGET_SYS} \
        --disable-shared-pp \
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
	--disable-smb \
        \
        --enable-dynamic-plugins \
        --enable-fbdev \
        --enable-sdl \
	--enable-alsa \
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
	--enable-freetype \
        --with-extralibdir=${STAGING_LIBDIR} "

EXTRA_OECONF_append_c7x0 = " --enable-w100"
EXTRA_OECONF_append_akita = " --enable-bvdd"
EXTRA_OECONF_append_spitz = " --enable-bvdd"

do_configure() {
        ./configure ${EXTRA_OECONF}
}

