DESCRIPTION = "GNOME XSLT library"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "libxml2 (>=2.6.27)"
LICENSE = "MIT"

SRC_URI = "ftp://xmlsoft.org/libxml2/libxslt-${PV}.tar.gz"
S = "${WORKDIR}/libxslt-${PV}"

inherit autotools pkgconfig

EXTRA_OECONF = "--without-python --without-debug --without-mem-debug --without-crypto"

# Something is wrong inside configure.ac, so we need to resort to sed in this stage :(
# Koen - 20080305
do_compile_append() {
	sed -i -e s:-L${STAGING_LIBDIR}::g  libexslt.pc
	sed -i -e s:-L${STAGING_LIBDIR}::g  libxslt.pc
} 

do_stage () {
	autotools_stage_all
}

PACKAGES = "${PN}-dbg ${PN}-dev ${PN}-utils ${PN} ${PN}-doc ${PN}-locale"

FILES_${PN}-dev += "${bindir}/xslt-config"
FILES_${PN}-utils += "${bindir}"
