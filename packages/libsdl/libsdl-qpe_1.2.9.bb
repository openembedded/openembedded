DESCRIPTION = "Simple DirectMedia Layer - QtE-based Palmtop Environments Edition"
SECTION = "opie/libs"
PRIORITY = "optional"
DEPENDS = "virtual/libqpe1 libopie2"
PROVIDES = "virtual/libsdl"
LICENSE = "LGPL"

# NOTE: make sure to keep PR in sync with libsdl-x11
PR = "r1"

SRC_URI = "http://www.libsdl.org/release/SDL-${PV}.tar.gz \
           file://agawa-piro-mickey-1.2.9.patch;patch=1 \
           file://pygame-1.2.9.patch;patch=1 \
           file://mouse-1.2.9.patch;patch=1 \
	   file://kill-stdc++-1.2.9.patch;patch=1 \
	   file://ipaq-1.2.9.patch;patch=1 \
	   file://SDL-Akita-1.2.9.patch;patch=1 \
	   file://fixlibs-1.2.9.patch;patch=1 \
	   file://no-PAGE_SIZE.patch;patch=1 \
	   file://explicit-extern-C.patch;patch=1 \
	   file://acinclude.m4"
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

do_compile_prepend() {
        rm -f ${S}/acinclude.m4
        cp ${WORKDIR}/acinclude.m4 ${S}/
	if [ "${PALMTOP_USE_MULTITHREADED_QT}" == "yes" ]
	then
		sed -i s,-lqte,-lqte-mt, src/Makefile
	fi
}

do_configure_append () {
        cd ${S}

        # prevent libtool from linking libs against libstdc++, libgcc, ...
        cat ${TARGET_PREFIX}libtool | sed -e 's/postdeps=".*"/postdeps=""/' > ${TARGET_PREFIX}libtool.tmp
        mv ${TARGET_PREFIX}libtool.tmp ${TARGET_PREFIX}libtool
}

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

	install -m 0644 *.m4 ${STAGING_DATADIR}/aclocal/
}
