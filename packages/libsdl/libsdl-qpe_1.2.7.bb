DESCRIPTION = "Simple DirectMedia Layer - QtE-based Palmtop Environments Edition"
SECTION = "opie/libs"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
DEPENDS = "virtual/libqpe libopie2"
PROVIDES = "virtual/libsdl"
LICENSE = "LGPL"

# NOTE: make sure to keep PR in sync with libsdl-x11
PR = "r7"

SRC_URI = "http://www.libsdl.org/release/SDL-${PV}.tar.gz \
           file://agawa-piro-mickey.patch;patch=1 \
           file://pygame.patch;patch=1 \
           file://gcc34.patch;patch=1 \
           file://mouse.patch;patch=1 \
	   file://kill-stdc++.patch;patch=1 \
	   file://ipaq.patch;patch=1 \
	   file://SDL-Akita.patch;patch=1 \
	   file://fixlibs.patch;patch=1"
S = "${WORKDIR}/SDL-${PV}"

inherit autotools binconfig

EXTRA_OECONF = "--disable-static --disable-debug --enable-cdrom --enable-threads --enable-timers --enable-endian \
                --enable-file --enable-oss --disable-alsa --disable-esd --disable-arts \
                --disable-diskaudio --disable-nas --disable-esd-shared --disable-esdtest \
                --disable-mintaudio --disable-nasm --disable-video-x11 --disable-video-dga \
                --disable-video-fbcon --disable-video-directfb --disable-video-ps2gs \
                --disable-video-xbios --disable-video-gem --disable-video-dummy \
                --disable-video-opengl --enable-input-events --enable-pthreads \
                --disable-video-picogui --enable-video-qtopia --enable-dlopen"

FILES_${PN} = "${libdir}/lib*.so.*"
FILES_${PN}-dev += "${bindir}/*config"

do_stage() {
	oe_libinstall -so -C src libSDL ${STAGING_LIBDIR}
	rm ${STAGING_LIBDIR}/libSDL.la
	ln -sf libSDL.so ${STAGING_LIBDIR}/libSDL-1.2.so
	install -m 0655 src/main/libSDLmain.a src/main/.libs/
	oe_libinstall -a -C src/main libSDLmain ${STAGING_LIBDIR}

	install -d ${STAGING_INCDIR}/SDL
	for f in include/*.h
	do
		install -m 0644 $f ${STAGING_INCDIR}/SDL/
	done
}
