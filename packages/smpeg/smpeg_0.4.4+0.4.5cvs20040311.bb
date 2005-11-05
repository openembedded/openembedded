LICENSE = "LGPL"
SECTION = "console/multimedia"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
DEPENDS = "virtual/libsdl"
PROVIDES = "smpeg"
DESCRIPTION = "SMPEG is a general purpose MPEG video/audio \
player for Linux based on the mpeg_play and SPLAY \
MPEG decoders."

SRC_URI = "cvs://anonymous:anonymous@cvs.icculus.org/cvs/cvsroot;module=smpeg;date=20040311 \
	   file://m4.patch;patch=1 \
	   file://compile.patch;patch=1"
S = "${WORKDIR}/smpeg"

inherit autotools 

CFLAGS_append = " -I${STAGING_INCDIR}/SDL"
EXTRA_OECONF = "--disable-gtktest --disable-opengl-player --without-x \
		--without-gtk --disable-gtk-player \
		--with-sdl-prefix=${STAGING_LIBDIR}/.. \
		--with-sdl-exec-prefix=${STAGING_BINDIR}/.."

do_configure_prepend () {
	touch NEWS AUTHORS ChangeLog
	rm -f acinclude.m4
}

do_stage() {
	oe_libinstall libsmpeg-0.4 ${STAGING_LIBDIR}
	ln -sf libsmpeg-0.4.so ${STAGING_LIBDIR}/libsmpeg.so

	for f in "*.h"
	do
		install -m 0644 ${f} ${STAGING_INCDIR}/SDL
	done

        cat smpeg-config | sed -e "s,-I/usr/include/SDL,-I${STAGING_INCDIR}/SDL," \
                         | sed -e "s,-I/usr/include/smpeg, ," \
                         | sed -e "s,libdirs ,mickey_is_cool ," \
                         | sed -e "s,-lSDL ,-lSDL-1.2 , "> ${STAGING_BINDIR}/smpeg-config
        chmod a+rx ${STAGING_BINDIR}/smpeg-config
}

