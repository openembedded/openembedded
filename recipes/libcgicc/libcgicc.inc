DESCRIPTION = "a C++ class library for writing CGI applications"
HOMEPAGE = "http://www.gnu.org/software/cgicc/"
LICENSE = "http://www.gnu.org/software/cgicc/doc/cgicc_license.html"

SRC_URI = "ftp://ftp.gnu.org/gnu/cgicc/cgicc-${PV}.tar.gz"

S = "${WORKDIR}/cgicc-${PV}"

inherit autotools

do_stage () {
	install -d ${STAGING_INCDIR}/cgicc
	cp -LR cgicc/*.h ${STAGING_INCDIR}/cgicc
	oe_libinstall -C cgicc libcgicc ${STAGING_LIBDIR}
}
