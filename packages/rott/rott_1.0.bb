DESCRIPTION = "Rise of the Triad - an SDL based Doom clone - QtE based Palmtop Environments Edition"
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
DEPENDS = "virtual/libqpe libsdl-qpe libsdl-image libsdl-mixer"
PR = "r1"

SRC_URI = "http://icculus.org/rott/releases/rott-${PV}.tar.gz"
S = "${WORKDIR}/rott-${PV}/rott"

CFLAGS += "-DPLATFORM_UNIX"
EXTRA_OEMAKE = 'SDL_INC_DIR=${STAGING_INCDIR}/SDL CC="${CC}" EXTRALDFLAGS="${LDFLAGS}"'

# FIXME: Add Opie integration, i.e. a .desktop file and a logo

do_install() {
	install -d ${D}${palmtopdir}/bin/
	install -m 0755 rott ${D}${palmtopdir}/bin/
}

FILES_${PN} = "${palmtopdir}"
