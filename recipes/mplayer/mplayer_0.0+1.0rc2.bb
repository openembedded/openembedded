DESCRIPTION = "Open Source multimedia player."
SECTION = "multimedia"
PRIORITY = "optional"
HOMEPAGE = "http://www.mplayerhq.hu/"
DEPENDS = "virtual/libsdl xsp zlib libpng jpeg freetype fontconfig alsa-lib lzo ncurses libxv virtual/libx11 \
           ${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'libmad liba52 lame', d)}"
DEPENDS_append_c7x0 = " libw100 "
DEPENDS_append_hx4700 = " libw100 "

DEFAULT_PREFERENCE_avr32 = "1"

RDEPENDS = "mplayer-common"
LICENSE = "GPL"
SRC_URI = "http://www1.mplayerhq.hu/MPlayer/releases/MPlayer-1.0rc2.tar.bz2 \
           file://vo_w100.c \
           file://vo_w100_api.h \
           file://vo_w100_fb.h \
           file://vo_pxa.c \
           file://vo_pxa.h \
	   file://simple_idct_armv5te.S \
           file://Makefile-codec-cfg.patch;patch=1 \
           file://w100-configure-svn.patch;patch=1 \
           file://w100-video_out.patch;patch=1 \
           file://w100-mplayer.patch;patch= \
           file://pld-onlyarm5.patch;patch=1 \
           file://makefile-nostrip-rc2.patch;patch=1 \
           file://mplayer-imageon-svn.patch;patch=1 \
           file://imageon-video_out.patch;patch=1 \
           file://pxa_configure.patch;patch=1 \
           file://pxa-video_out.patch;patch=1 \
           file://motion-comp-pld.patch;patch=1 \
	   file://ivtv-fix.patch;patch=1 "

# This is required for the collie machine only as all stacks in that
# machine seem to be set to executable by the toolchain. If someone
# discovers this is more general than please make this more general
# ie. for all armv4 machines.
SRC_URI_append_collie = "file://disable-executable-stack-test.patch;patch=1"

PACKAGE_ARCH_collie = "collie"
PACKAGE_ARCH_c7x0 = "c7x0"
PACKAGE_ARCH_hx4700 = "hx4700"

ARM_INSTRUCTION_SET = "ARM"

RCONFLICTS_${PN} = "mplayer-atty"
RREPLACES_${PN} = "mplayer-atty"

PR = "r14"

PARALLEL_MAKE = ""

S = "${WORKDIR}/MPlayer-1.0rc2"

PACKAGES =+ "mencoder"

FILES_${PN} = "${bindir}/mplayer ${libdir}"
FILES_mencoder = "${bindir}/mencoder"

inherit autotools pkgconfig

EXTRA_OECONF = " \
        --prefix=${prefix} \
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
	--enable-v4l2 \
        --disable-tv-bsdbt848 \
	--enable-rtc \
        --enable-network \
        --disable-winsock2 \
	--disable-smb \
        --disable-live \
	--disable-dvdnav \
        --disable-dvdread \
	--disable-libdvdcss-internal \
	--disable-dvdread-internal \
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
        --disable-liblzo \
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
        \
	--enable-tremor-low \
        \
        --disable-speex \
        --disable-theora \
        --disable-faac \
        --disable-ladspa \
        --disable-libdv \
        ${@base_conditional('ENTERPRISE_DISTRO', '1', '--disable-mad', '--enable-mad', d)} \
        --disable-toolame \
        --disable-twolame \
        --disable-xmms \
	--disable-mp3lib \
        ${@base_conditional('ENTERPRISE_DISTRO', '1', '--disable-libmpeg2', '--enable-libmpeg2', d)} \
        --disable-musepack \
	\
        --disable-gl \
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
	--disable-ass \
        "

EXTRA_OECONF_append_arm = " --disable-decoder=vorbis_decoder \
			    --disable-encoder=vorbis_encoder"
EXTRA_OECONF_append_c7x0 = " --enable-imageon "
EXTRA_OECONF_append_hx4700 = " --enable-imageon "

EXTRA_OECONF_append_armv6 = " --enable-armv6 "
EXTRA_OECONF_append_armv7a = "--enable-armv6 "

#build with support for the iwmmxt instruction and pxa270fb overlay support (pxa270 and up)
#not every iwmmxt machine has the lcd connected to pxafb, but building the module doesn't hurt 
MY_ARCH := "${PACKAGE_ARCH}"
PACKAGE_ARCH = "${@base_contains('MACHINE_FEATURES', 'iwmmxt', 'iwmmxt', '${MY_ARCH}',d)}"

MY_TARGET_CC_ARCH := "${TARGET_CC_ARCH}"
TARGET_CC_ARCH = "${@base_contains('MACHINE_FEATURES', 'iwmmxt', '-march=iwmmxt -mtune=iwmmxt', '${MY_TARGET_CC_ARCH}',d)}"

EXTRA_OECONF_append = " ${@base_contains('MACHINE_FEATURES', 'iwmmxt', '--enable-pxa --enable-iwmmxt', '',d)} "
EXTRA_OECONF_append = " ${@base_contains('MACHINE_FEATURES', 'x86', '--enable-runtime-cpudetection', '',d)} "

FULL_OPTIMIZATION = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -O4 -ffast-math"
FULL_OPTIMIZATION_armv7a = "-fexpensive-optimizations  -ftree-vectorize -fomit-frame-pointer -O4 -ffast-math"
BUILD_OPTIMIZATION = "${FULL_OPTIMIZATION}"
# FIXME: Temporarily disable debugging to work-around http://gcc.gnu.org/bugzilla/show_bug.cgi?id=37987
DEBUG_OPTIMIZATION_spitz = "-O -fomit-frame-pointer -g"
DEBUG_OPTIMIZATION_akita = "-O -fomit-frame-pointer -g"

do_configure() {
	cp ${WORKDIR}/vo_w100.c ${S}/libvo
	cp ${WORKDIR}/vo_w100_api.h ${S}/libvo
	cp ${WORKDIR}/vo_w100_fb.h ${S}/libvo
	cp ${WORKDIR}/vo_pxa.c ${S}/libvo
	cp ${WORKDIR}/vo_pxa.h ${S}/libvo
	cp ${WORKDIR}/simple_idct_armv5te.S ${S}/libavcodec/armv4l/

	sed -i 's|/usr/include|${STAGING_INCDIR}|g' ${S}/configure
	sed -i 's|/usr/lib|${STAGING_LIBDIR}|g' ${S}/configure
	sed -i 's|/usr/\S*include[\w/]*||g' ${S}/configure
	sed -i 's|/usr/\S*lib[\w/]*||g' ${S}/configure

        ./configure ${EXTRA_OECONF}
}

do_compile () {
	oe_runmake
}

