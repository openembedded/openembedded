DESCRIPTION = "Virtual Machine for LucasArts Adventures for Qt/Embedded based palmtop environments w/ SDL."
SECTION = "opie/games"
PRIORITY = "optional"
DEPENDS = "libsdl-qpe tremor libogg zlib \
           ${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'libmad mpeg2dec', d)}"
LICENSE = "GPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/scummvm/scummvm-${PV}.tar.bz2 \
			file://sword1.patch;patch=1 \
			file://tremor.patch;patch=1 \
			file://mouse.patch;patch=1 "
PR="r1"

inherit autotools

export SDL_CONFIG = "${STAGING_BINDIR_CROSS}/sdl-config"

EXTRA_OECONF = "--host=${HOST_SYS} \
		--backend=sdl \
		--disable-alsa \
		--with-ogg-prefix=${STAGING_LIBDIR}/.. \
		--with-vorbis-prefix=${STAGING_LIBDIR}/.. \
		${@base_conditional('ENTERPRISE_DISTRO', '1', '--disable-mpeg2', '--with-mpeg2-prefix=${STAGING_LIBDIR}/..', d)} \		
		${@base_conditional('ENTERPRISE_DISTRO', '1', '--disable-mad', '--with-mad-prefix=${STAGING_BINDIR_CROSS}/..', d)} \
		"
do_configure() {
	./configure ${EXTRA_OECONF}
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 scummvm ${D}${bindir}/scummvm
}

