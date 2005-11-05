DESCRIPTION = "Virtual Machine for LucasArts Adventures for Qt/Embedded based palmtop environments w/ SDL."
SECTION = "games"
PRIORITY = "optional"
LICENSE = "GPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/scummvm/scummvm-${PV}.tar.bz2 \
			file://tremor.patch;patch=1"

inherit autotools 

EXTRA_OECONF = "--host=${HOST_SYS} \
		--backend=sdl \
		--with-sdl-prefix=${STAGING_BINDIR}/.. \
		--disable-alsa \
		--with-ogg-prefix=${STAGING_LIBDIR}/.. \
		--with-vorbis-prefix=${STAGING_LIBDIR}/.. \
		--with-mpeg2-prefix=${STAGING_LIBDIR}/.. \
		--with-mad-prefix=${STAGING_LIBDIR}/.. "

do_configure() {
	./configure ${EXTRA_OECONF}
}


do_install() {
	install -d ${D}${bindir}
	install -m 0755 scummvm ${D}${bindir}/scummvm
}

