DESCRIPTION = "Open Source multimedia player."
SECTION = "opie/multimedia"
PRIORITY = "optional"
HOMEPAGE = "http://www.mplayerhq.hu/"
DEPENDS = "virtual/libsdl libmad zlib libpng jpeg mplayer-common"
RDEPENDS = "mplayer-common"
LICENSE = "GPL"
SRC_URI = "svn://svn.mplayerhq.hu/;module=mplayer \
	   file://vo_w100.c \
	   file://vo_w100_api.h \
	   file://vo_w100_fb.h \
	   file://Makefile.patch;patch=1 \
	   file://w100-configure.patch;patch=1 \
	   file://w100-Makefile.patch;patch=1 \
	   file://w100-video_out.patch;patch=1 \
	   file://w100-mplayer.patch;patch=1"

MAINTAINER="Graeme Gregory <dp@xora.org.uk>"
RCONFLICTS_${PN} = "mplayer-atty"
RREPLACES_${PN} = "mplayer-atty"

PV = "1.0pre8+svn${SRCDATE}"
PR = "r0"
DEFAULT_PREFERENCE = "-1"

PARALLEL_MAKE = ""

DEPENDS_append_c7x0 = " sharp-aticore-oss"

S = "${WORKDIR}/mplayer/trunk/"

PACKAGES =+ "mencoder"

FILES_${PN} = "${bindir}/mplayer"
FILES_mencoder = "${bindir}/mencoder"

inherit autotools

EXTRA_OECONF = " \
        --prefix=/usr \
	--mandir=${mandir} \
        --target=${TARGET_SYS} \
	\
	--enable-mencoder \
	--disable-gui \
	--enable-largefiles \
	--disable-linux-devfs \
	--disable-lirc \
	--disable-lircc \
	--disable-tv \
	--enable-rtc \
	--disable-smb \
	--disable-win32 \
	\
	--enable-tremor-low \
	--disable-mp3lib \
	\
	--disable-x11 \
	--enable-sdl \
	--enable-fbdev "

EXTRA_OECONF_append_c7x0 = " --enable-w100 "

do_configure() {
	cp ${WORKDIR}/vo_w100.c ${S}/libvo
	cp ${WORKDIR}/vo_w100_api.h ${S}/libvo
	cp ${WORKDIR}/vo_w100_fb.h ${S}/libvo
        ./configure ${EXTRA_OECONF}
}

do_compile () {
	oe_runmake
}

