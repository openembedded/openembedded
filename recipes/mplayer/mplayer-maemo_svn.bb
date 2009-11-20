DESCRIPTION = "Open Source multimedia player."
SECTION = "multimedia"
PRIORITY = "optional"
HOMEPAGE = "http://www.mplayerhq.hu/"
DEPENDS = "virtual/libsdl xsp libmad zlib libpng jpeg liba52 freetype fontconfig alsa-lib lzo ncurses lame libxv virtual/libx11"

DEFAULT_PREFERENCE_avr32 = "-1"

PV = "0.0+1.0rc1+svnr${SRCPV}"
PE = "1"

RCONFLICTS_${PN} = "mplayer"

RDEPENDS = "mplayer-common"
LICENSE = "GPL"
SRC_URI = "svn://garage.maemo.org/svn/mplayer/;module=trunk;proto=https \
           file://Makefile-codec-cfg.patch;patch=1 \
           file://pld-onlyarm5.patch;patch=1 \
           file://makefile-nostrip.patch;patch=1 \
           file://motion-comp-pld.patch;patch=1 \
	   file://cfg-common-position.patch;patch=1 "

# This is required for the collie machine only as all stacks in that
# machine seem to be set to executable by the toolchain. If someone
# discovers this is more general than please make this more general
# ie. for all armv4 machines.
SRC_URI_append_collie = "file://disable-executable-stack-test.patch;patch=1"

PACKAGE_ARCH_collie = "collie"

PARALLEL_MAKE = ""

S = "${WORKDIR}/trunk"

PACKAGES =+ "mencoder"

FILES_${PN} = "${bindir}/mplayer ${libdir}"
FILES_mencoder = "${bindir}/mencoder"

inherit autotools pkgconfig

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
        --enable-v4l2 \
        --disable-tv-bsdbt848 \
	--enable-rtc \
        --enable-network \
        --disable-winsock2 \
	--disable-smb \
        --disable-live \
	--disable-dvdnav \
        --disable-dvdread \
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
        --enable-mad \
        --disable-toolame \
        --disable-twolame \
        --disable-xmms \
	--disable-mp3lib \
        --enable-libmpeg2 \
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

EXTRA_OECONF_append_armv6 = " --enable-armv6 --enable-arm-vfp"
EXTRA_OECONF_append_armv7a = "--enable-armv6 --enable-arm-vfp"

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


do_configure() {
	sed -i 's|/usr/include|${STAGING_INCDIR}|g' ${S}/configure
	sed -i 's|/usr/lib|${STAGING_LIBDIR}|g' ${S}/configure
	sed -i 's|/usr/\S*include[\w/]*||g' ${S}/configure
	sed -i 's|/usr/\S*lib[\w/]*||g' ${S}/configure

        ./configure ${EXTRA_OECONF}
}

do_compile () {
	oe_runmake
}

