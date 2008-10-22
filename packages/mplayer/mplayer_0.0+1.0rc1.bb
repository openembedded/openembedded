DESCRIPTION = "Open Source multimedia player."
SECTION = "multimedia"
PRIORITY = "optional"
HOMEPAGE = "http://www.mplayerhq.hu/"
DEPENDS = "virtual/libsdl libmad zlib libpng jpeg liba52 freetype fontconfig alsa-lib lzo ncurses lame libxv virtual/libx11"
RDEPENDS = "mplayer-common"
LICENSE = "GPL"
SRC_URI = "http://www1.mplayerhq.hu/MPlayer/releases/MPlayer-1.0rc1.tar.bz2 \
           file://vo_w100.c \
           file://vo_w100_api.h \
           file://vo_w100_fb.h \
           file://vo_pxa.c \
           file://vo_pxa.h \
           file://Makefile.patch;patch=1 \
           file://w100-configure.patch;patch=1 \
           file://w100-Makefile.patch;patch=1 \
           file://w100-video_out.patch;patch=1 \
           file://w100-mplayer.patch;patch=1 \
           file://pld-onlyarm5.patch;patch=1 \
           file://makefile-nostrip.patch;patch=1 \
           ${SOURCEFORGE_MIRROR}/libw100/mplayer-imageon.patch;patch=1 \
           file://imageon-video_out.patch;patch=1 \
	   file://powerpc-is-ppc.diff;patch=1 \
           file://pxa_configure.patch;patch=1 \
           file://pxa-video_out.patch;patch=1 \
          "

SRC_URI_append_avr32 = " file://mplayer-1.0rc1-atmel.2.patch;patch=1 \
                       "

# This is required for the collie machine only as all stacks in that
# machine seem to be set to executable by the toolchain. If someone
# discovers this is more general than please make this more general
# ie. for all armv4 machines.
SRC_URI_append_collie = "file://disable-executable-stack-test.patch;patch=1"
PACKAGE_ARCH_mplayer_collie = "collie"
PACKAGE_ARCH_mencoder_collie = "collie"

RCONFLICTS_${PN} = "mplayer-atty"
RREPLACES_${PN} = "mplayer-atty"
PR = "r16"

PARALLEL_MAKE = ""

DEPENDS_append_c7x0 = " sharp-aticore-oss libw100 "
DEPENDS_append_hx4700 = " libw100 "

S = "${WORKDIR}/MPlayer-1.0rc1"

PACKAGES =+ "mencoder"

FILES_${PN} = "${bindir}/mplayer ${libdir}"
FILES_mencoder = "${bindir}/mencoder"

inherit autotools pkgconfig

FULL_OPTIMIZATION = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -O4 -ffast-math"
BUILD_OPTIMIZATION = "${FULL_OPTIMIZATION}"

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
        --disable-joystick \
        --disable-vm \
        --disable-xf86keysym \
	--disable-tv \
        --disable-tv-v4l2 \
        --disable-tv-bsdbt848 \
	--enable-rtc \
        --enable-network \
        --disable-winsock2 \
	--disable-smb \
        --disable-live \
        --disable-dvdread \
        --disable-mpdvdkit \
        --disable-cdparanoia \
        --enable-freetype \
        --disable-unrarlib \
        --disable-menu \
        --enable-sortsub \
        --disable-fribidi \
        --disable-enca \
        --disable-macosx \
        --disable-macosx-finder-support \
        --disable-macosx-bundle \
        --disable-ftp \
        --disable-vstream \
        \
        --disable-gif \
        --enable-png \
        --enable-jpeg \
        --disable-libcdio \
        --enable-liblzo \
	--disable-win32 \
        --disable-qtx \
        --disable-xanim \
        --disable-real \
        --disable-xvid \
        --disable-x264 \
        \
        --disable-libavutil_so \
        --disable-libavcodec_so \
        --disable-libavformat_so \
        --disable-libpostproc_so \
        --disable-libfame \
	\
	--enable-tremor-low \
        \
        --disable-speex \
        --disable-theora \
        --disable-faac \
        --disable-ladspa \
        --disable-libdv \
        --enable-mad \
        --disable-toolame \
        --disable-twolame \
        --disable-xmms \
	--disable-mp3lib \
        --disable-libdts \
        --enable-libmpeg2 \
        --disable-musepack \
        --disable-amr_nb \
        --disable-amr_nb-fixed \
        --disable-amr_wb \
	\
        --disable-gl \
        --disable-dga \
        --disable-vesa \
        --disable-svga \
	--enable-sdl \
        --disable-aa \
        --disable-caca \
        --disable-ggi \
        --disable-ggiwmh \
        --disable-directx \
        --disable-dxr2 \
        --disable-dxr3 \
        --disable-dvb \
        --disable-dvbhead \
        --disable-mga \
        --disable-xmga \
        --enable-xv \
        --disable-xvmc \
        --disable-vm \
        --disable-xinerama \
        --enable-x11 \
	--enable-fbdev \
        --disable-mlib \
        --disable-3dfx \
        --disable-tdfxfb \
        --disable-s3fb \
        --disable-directfb \
        --disable-zr \
        --disable-bl \
        --disable-tdfxvid \
        --disable-tga \
        --disable-pnm \
        --disable-md5sum \
        \
        --enable-alsa \
        --enable-ossaudio \
        --disable-arts \
        --disable-esd \
        --disable-polyp \
        --disable-jack \
        --disable-openal \
        --disable-nas \
        --disable-sgiaudio \
        --disable-sunaudio \
        --disable-win32waveout \
        --enable-select \
        \
        --disable-runtime-cpudetection \
        "

EXTRA_OECONF_append_arm = " --disable-decoder=vorbis_decoder \
			    --disable-encoder=vorbis_encoder"

EXTRA_OECONF_append_progear = " --disable-sse --disable-3dnow --disable-mmxext --disable-sse2"

#enable support for the ati imageon series (w100 and w3220)
EXTRA_OECONF_append_c7x0 = " --enable-w100 "
EXTRA_OECONF_append_hx4700 = " --enable-imageon "

#enable pxa270 overlay support
EXTRA_OECONF_append_spitz = " --enable-pxa "
EXTRA_OECONF_append_akita = " --enable-pxa "
EXTRA_OECONF_append_a780 = " --enable-pxa "
EXTRA_OECONF_append_magician = " --enable-pxa "
EXTRA_OECONF_append_htcuniversal = " --enable-pxa "
EXTRA_OECONF_append_palmld = " --enable-pxa "

#build with support for the iwmmxt instruction support (pxa270 and up)
TARGET_CC_ARCH_spitz = "-march=iwmmxt -mtune=iwmmxt"
PACKAGE_ARCH_spitz = "iwmmxt"
TARGET_CC_ARCH_akita = "-march=iwmmxt -mtune=iwmmxt"
PACKAGE_ARCH_akita = "iwmmxt"
TARGET_CC_ARCH_a780 = "-march=iwmmxt -mtune=iwmmxt"
PACKAGE_ARCH_a780 = "iwmmxt"
TARGET_CC_ARCH_hx4700 = "-march=iwmmxt -mtune=iwmmxt"
PACKAGE_ARCH_hx4700 = "iwmmxt"
TARGET_CC_ARCH_magician = "-march=iwmmxt -mtune=iwmmxt"
PACKAGE_ARCH_magician = "iwmmxt"
TARGET_CC_ARCH_htcuniversal = "-march=iwmmxt -mtune=iwmmxt"
PACKAGE_ARCH_htcuniversal = "iwmmxt"
TARGET_CC_ARCH_palmld = "-march=iwmmxt -mtune=iwmmxt"
PACKAGE_ARCH_palmld = "iwmmxt"

do_configure() {
	cp ${WORKDIR}/vo_w100.c ${S}/libvo
	cp ${WORKDIR}/vo_w100_api.h ${S}/libvo
	cp ${WORKDIR}/vo_w100_fb.h ${S}/libvo
    cp ${WORKDIR}/vo_pxa.c ${S}/libvo
    cp ${WORKDIR}/vo_pxa.h ${S}/libvo

	sed -i 's|/usr/include|${STAGING_INCDIR}|g' ${S}/configure
	sed -i 's|/usr/lib|${STAGING_LIBDIR}|g' ${S}/configure
	sed -i 's|/usr/\S*include[\w/]*||g' ${S}/configure
	sed -i 's|/usr/\S*lib[\w/]*||g' ${S}/configure

        ./configure ${EXTRA_OECONF}
}

do_compile () {
	oe_runmake
}

