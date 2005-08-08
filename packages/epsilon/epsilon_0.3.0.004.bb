DESCRIPTION = "Epsilon is a flexable and powerful image thumbnailing library \
that is complient with the freedesktop.org Thumbnail Managing Standard. \
Unlike Epeg, Epsilon has native support for PNG, and is built upon Imlib2 \
making any format supported by Imlib2 such as JPEG, PNG, XCF, TIFF and GIF. \
To provide the best possible performance Epsilon can even integrate \
with Epeg directly to harness it's speed."
SECTION = "e/libs"
LICENSE = "GPL"
DEPENDS = "epeg libpng virtual/imlib2"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"

SRC_URI = "http://enlightenment.freedesktop.org/files/epsilon-${PV}.tar.gz \
           file://compile-fix.patch;patch=1"
S = "${WORKDIR}/epsilon-${PV}"

inherit autotools pkgconfig binconfig

do_stage () {
	oe_libinstall -C src/lib libepsilon ${STAGING_LIBDIR}/
	install -m 0644 ${S}/src/lib/Epsilon.h ${STAGING_INCDIR}/
}

PACKAGES = "epsilon-examples epsilon-dev epsilon"
FILES_${PN}-dev += "${bindir}/epsilon-config"
FILES_epsilon-examples = "${bindir}/epsilon"

