DESCRIPTION = "Open Source multimedia player."
SECTION = "opie/multimedia"
PRIORITY = "optional"
HOMEPAGE = "http://www.mplayerhq.hu/"
DEPENDS = "virtual/libsdl libmad libogg libvorbis zlib libpng jpeg mplayer-common"
RDEPENDS = "mplayer-common"
LICENSE = "GPL"
SRC_URI = "http://www1.mplayerhq.hu/MPlayer/releases/MPlayer-${PV}.tar.bz2 \
           file://Makefile.patch;patch=1 \
           file://sdl.patch;patch=0 \
           file://zlib.patch;patch=0 \
           file://libmpdemux-ogg-include.patch;patch=1 \
           file://libmpcodecs-ogg-include.patch;patch=1 \
           file://mplayer-1.0_pre7-gcc4.patch;patch=1 "

MAINTAINER="Graeme Gregory <dp@xora.org.uk>"
RCONFLICTS_${PN} = "mplayer-atty"
PR = "r3"

PARALLEL_MAKE = ""

DEPENDS_append_c7x0 = " sharp-aticore-oss"
PACKAGE_ARCH_c7x0 = "${MACHINE_ARCH}"
SRC_URI_append_c7x0 = "file://mplayer-w100_1.0pre3.1.modified.diff;patch=1 \
                       file://Makefile-vidix.patch;patch=0 \
                       file://vidix-drivers-w100.patch;patch=1 "

S = "${WORKDIR}/MPlayer-${PV}"

PACKAGES =+ "postproc postproc-dev"

FILES_${PN} = "${bindir}/mplayer ${libdir}/mplayer/vidix/w100_vid.so"

FILES_postproc = " ${libdir}/libpostproc.so.0.0.0 ${libdir}/libpostproc.so.0"
FILES_postproc-dev = " ${includedir}/postproc/postprocess.h ${libdir}/libpostproc.so ${libdir}/libpostproc.a"

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
	--disable-smb \
        \
        --enable-dynamic-plugins \
        --enable-fbdev \
        --enable-sdl \
        --with-sdl-config=${STAGING_BINDIR}/sdl-config \
        \
        --enable-mad \
	--enable-tremor-low \
        \
        --enable-ossaudio \
        \
	--enable-rtc \
	\
        --with-extralibdir=${STAGING_LIBDIR} "

EXTRA_OECONF_append_c7x0 = " --enable-vidix "

do_configure() {
        ./configure ${EXTRA_OECONF}
}

do_install_append () {
        install -d ${D}${libdir} ${D}${includedir} ${D}${includedir}/postproc
        install -m 0644 libavcodec/libpostproc/postprocess.h ${D}${includedir}/postproc/
        oe_libinstall -so -C ${S}/libavcodec/libpostproc libpostproc ${D}${libdir}
        cp ${S}/libavcodec/libpostproc/libpostproc.so ${D}${libdir}/libpostproc.so.0.0.0
        cd ${D}${libdir}
        ln -sf libpostproc.so.0.0.0 libpostproc.so.0
        ln -sf libpostproc.so.0 libpostproc.so
}

do_stage () {
        oe_libinstall -a -so -C libavcodec/libpostproc libpostproc ${STAGING_LIBDIR}
        cd ${STAGING_LIBDIR}
        ln -sf libpostproc.so libpostproc.so.0.0.0
        ln -sf libpostproc.so libpostproc.so.0

        install -d ${STAGING_INCDIR}/postproc
        install -m 0644 ${S}/libavcodec/libpostproc/postprocess.h ${STAGING_INCDIR}/postproc/postprocess.h
}                                       

