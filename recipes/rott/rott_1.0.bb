DESCRIPTION = "Rise of the Triad - an SDL based Doom clone - QtE based Palmtop Environments Edition"
HOMEPAGE = "http://www.icculus.org/root"
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

SRC_URI[md5sum] = "c1c6cbecf00f2229cf2e0053334dcfc1"
SRC_URI[sha256sum] = "11f9cc331d0be87f0f172840e2bb6e03e27c3b8e9ecbb3eb8cffdc5b73afbd95"
