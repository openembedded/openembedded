DESCRIPTION = "Rise of the Triad - an SDL based Doom clone - QtE based Palmtop Environments Edition"
HOMEPAGE = "http://www.icculus.org/root"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
PR = "r2"

APPIMAGE = "${WORKDIR}/rott.jpg"

SRC_URI = "http://icculus.org/rott/releases/rott-${PV}.tar.gz \
           file://gcc4.patch;patch=1;pnum=2 \
           file://rott.jpg"
S = "${WORKDIR}/rott-${PV}/rott"

CFLAGS += "-DPLATFORM_UNIX"
EXTRA_OEMAKE = 'SDL_INC_DIR=${STAGING_INCDIR}/SDL CC="${CC}" EXTRALDFLAGS="${LDFLAGS}"'

inherit sdl

do_install() {
	install -d ${D}${bindir}
	install -m 0755 rott ${D}${bindir}
}
