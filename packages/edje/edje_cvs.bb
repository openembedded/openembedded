DESCRIPTION = "edje is a complex graphical design & layout library."
DEPENDS = "freetype evas ecore embryo eet edb edje-native"
LICENSE = "MIT"
SECTION = "e/libs"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
PV = "${CVSDATE}"
PR = "r4"

SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/enlightenment;module=e17/libs/edje"
S = "${WORKDIR}/edje"

inherit autotools pkgconfig binconfig

EXTRA_OECONF = "--disable-edje-cc \
		--enable-fb-only"

LEAD_SONAME = "libedje.so"

do_stage () {
	oe_libinstall -C src/lib libedje ${STAGING_LIBDIR}/
	oe_libinstall -C src/lib libedje_edit ${STAGING_LIBDIR}/
	install -m 0644 ${S}/src/lib/Edje.h ${STAGING_INCDIR}/
}

PACKAGES += "edje-examples"

FILES_${PN} = "${libdir}/libedje*.so*"
FILES_${PN}-dev += "${bindir}/edje-config ${libdir}/pkgconfig"
FILES_${PN}-examples = "${bindir}/edje ${bindir}/edje_ls ${datadir}"

