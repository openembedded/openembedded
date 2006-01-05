SECTION = "libs"
DESCRIPTION = "Jim Clarkes XML parser library."
LICENSE = "MIT"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/expat/expat-${PV}.tar.gz"
S = "${WORKDIR}/expat-${PV}"

inherit autotools 
export LTCC = "${CC}"

do_stage () {
	install -m 0644 ${S}/lib/expat.h ${STAGING_INCDIR}/
	oe_libinstall -so libexpat ${STAGING_LIBDIR}/
}

do_install () {
	oe_runmake prefix="${D}${prefix}" \
		bindir="${D}${bindir}" \
		libdir="${D}${libdir}" \
		includedir="${D}${includedir}" \
		install
}
