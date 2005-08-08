DESCRIPTION = "Edje is a complex graphical design & layout library."
DEPENDS = "freetype virtual/evas virtual/ecore embryo eet edb edje-native"
LICENSE = "MIT"
HOMEPAGE = "http://www.enlightenment.org"
SECTION = "e/libs"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
PR = "r0"

SRC_URI = "http://enlightenment.freedesktop.org/files/edje-${PV}.tar.gz"
S = "${WORKDIR}/edje-${PV}"

inherit autotools pkgconfig binconfig

EXTRA_OECONF = "--disable-edje-cc \
		--enable-fb-only"

LEAD_SONAME = "libedje.so"

do_stage () {
	oe_libinstall -C src/lib libedje ${STAGING_LIBDIR}/
	oe_libinstall -C src/lib libedje_edit ${STAGING_LIBDIR}/
	install -m 0644 ${S}/src/lib/Edje.h ${STAGING_INCDIR}/
}

BINARIES = "ejde edje_ls edje_test edje_cc edje_decc edje_thumb"

PACKAGES += "edje-examples"

FILES_${PN} = "${libdir}/libedje*.so*"
FILES_${PN}-dev += "${bindir}/edje-config ${bindir}/edje_ls ${bindir}/edje_cc ${bindir}/edje_decc ${bindir}/edje_thumb ${libdir}/pkgconfig"
FILES_${PN}-examples = "${bindir}/edje ${bindir}/edje_test ${datadir}"
