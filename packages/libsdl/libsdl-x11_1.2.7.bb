PR = "r3"
DESCRIPTION = "Simple DirectMedia Layer - X11 Edition"
SECTION = "libs"
PRIORITY = "optional"
MAINTAINER = "Phil Blundell <pb@nexus.co.uk>"
DEPENDS = "x11 xext"
PROVIDES = "virtual/libsdl"
LICENSE = "LGPL"

SRC_URI = "http://www.libsdl.org/release/SDL-${PV}.tar.gz \
	   file://extra-keys.patch;patch=1 \
	   file://acinclude.m4"
S = "${WORKDIR}/SDL-${PV}"

inherit autotools

EXTRA_OECONF = "--disable-debug --disable-cdrom --enable-threads --enable-timers --enable-endian \
                --enable-file --enable-oss --enable-alsa --disable-esd --disable-arts \
                --disable-diskaudio --disable-nas --disable-esd-shared --disable-esdtest \
                --disable-mintaudio --disable-nasm --enable-video-x11 --disable-video-dga \
                --disable-video-fbcon --disable-video-directfb --disable-video-ps2gs \
                --disable-video-xbios --disable-video-gem --disable-video-dummy \
                --disable-video-opengl --enable-input-events --enable-pthreads \
                --disable-video-picogui --disable-video-qtopia --enable-dlopen"

do_configure_prepend() {
	rm -f ${S}/acinclude.m4
	cp ${WORKDIR}/acinclude.m4 ${S}/
}

do_configure_append () {
	cd ${S}

	# prevent libtool from linking libs against libstdc++, libgcc, ...
	cat ${TARGET_PREFIX}libtool | sed -e 's/postdeps=".*"/postdeps=""/' > ${TARGET_PREFIX}libtool.tmp
	mv ${TARGET_PREFIX}libtool.tmp ${TARGET_PREFIX}libtool
}

do_stage() {
	oe_libinstall -so -C src libSDL ${STAGING_LIBDIR}
	ln -sf libSDL.so ${STAGING_LIBDIR}/libSDL-1.2.so
	#oe_libinstall -a -C src/main libSDLmain ${STAGING_LIBDIR}
	install -m 0644 src/main/libSDLmain.a ${STAGING_LIBDIR}

	install -d ${STAGING_INCDIR}/SDL
	for f in include/*.h
	do
		install -m 0644 $f ${STAGING_INCDIR}/SDL/
	done

	cat sdl-config | sed -e "s,-I/usr/include/SDL,-I${STAGING_INCDIR}/SDL," \
	               | sed -e "s,libdirs ,mickey_is_cool ," \
                       | sed -e "s,-lSDL ,-lSDL-1.2 , "> ${STAGING_BINDIR}/sdl-config
        chmod a+rx ${STAGING_BINDIR}/sdl-config
}
