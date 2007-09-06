DESCRIPTION = "Virtual Machine for several classic graphical point-and-click adventure games"
HOMEPAGE = "http://www.scummvm.org"
SECTION = "games"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r4"

SRC_URI = "${SOURCEFORGE_MIRROR}/scummvm/scummvm-${PV}.tar.bz2"

inherit autotools 

EXTRA_OECONF = "--host=${HOST_SYS} \
		--backend=sdl \
		--with-sdl-prefix=${STAGING_BINDIR_CROSS} \
		--disable-alsa \
		--prefix=${prefix} \
		--with-ogg-prefix=${STAGING_LIBDIR}/.. \
		--with-vorbis-prefix=${STAGING_LIBDIR}/.. \
		--with-mpeg2-prefix=${STAGING_LIBDIR}/.. \
		--with-mad-prefix=${STAGING_LIBDIR}/.. "

EXTRA_OEMAKE = "MANDIR=${mandir}"

do_configure() {
	./configure ${EXTRA_OECONF}
}
