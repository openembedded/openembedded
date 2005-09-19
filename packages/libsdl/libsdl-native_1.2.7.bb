DESCRIPTION = "Simple DirectMedia Layer - native Edition"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"
PR = "r0"

SRC_URI = "http://www.libsdl.org/release/SDL-${PV}.tar.gz \
	   file://extra-keys.patch;patch=1 \
	   file://acinclude.m4"
S = "${WORKDIR}/SDL-${PV}"

inherit autotools native

EXTRA_OECONF = "--disable-debug --disable-cdrom --enable-threads --enable-timers --enable-endian \
                --enable-file --disable-oss --disable-alsa --disable-esd --disable-arts \
                --disable-diskaudio --disable-nas --disable-esd-shared --disable-esdtest \
                --disable-mintaudio --disable-nasm --disable-video-x11 --disable-video-dga \
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

	cat >${STAGING_BINDIR}/sdl-config-native <<EOF
#!/bin/sh
  case "\$1" in
    --prefix)
      echo /usr
      ;;
    --exec-prefix)
      echo /usr 
      ;;
    --version)
      echo ${PV}
      ;;
    --cflags)
      echo -I${STAGING_INCDIR}/SDL -D_REENTRANT
      ;;
    --libs)
      echo -lSDLmain -lSDL-1.2 -lpthread -L${STAGING_LIBDIR}
      ;;
  esac
EOF
	chmod a+rx ${STAGING_BINDIR}/sdl-config-native
}
