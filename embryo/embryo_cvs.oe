DESCRIPTION = "Embryo implements a C like scripting language used in various parts \
of the Enlightenment project, namely Edje. Embryo's scripting language is based on \
CompuPhase's Small language that was introduced in Dr Dobb's Journal in 1999. \
Embryo allows scripting capabilities in places that otherwise wouldn't support \
basic programming structures such as in Edje EDCs."
SECTION = "e/libs"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
PV = "${CVSDATE}"
PR = "r2"

SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/enlightenment;module=e17/libs/embryo"
S = "${WORKDIR}/embryo"
LICENSE = "MIT"

inherit autotools pkgconfig binconfig

do_stage () {
	oe_libinstall -C src/lib libembryo ${STAGING_LIBDIR}/
	install -m 0644 ${S}/src/lib/Embryo.h ${STAGING_INCDIR}/
}

PACKAGES += "embryo-examples"

FILES_${PN} = "${libdir}/libembryo*.so*"
FILES_${PN}-dev += "${bindir} ${libdir}/pkgconfig"
FILES_${PN}-examples = "${datadir}"

