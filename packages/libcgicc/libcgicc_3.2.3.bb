DESCRIPTION = "a C++ class library for writing CGI applications"
HOMEPAGE = "http://www.cgicc.org/"
LICENSE = "LGPL"
MAINTAINER = "Bruno Randolf <bruno.randolf@4g-systems.biz>"

SRC_URI = "http://www.cgicc.org/files/cgicc-${PV}.tar.bz2"
S = "${WORKDIR}/cgicc-${PV}"

inherit autotools

do_stage () {
	install -d ${STAGING_INCDIR}/cgicc
	cp --dereference -R cgicc/*.h ${STAGING_INCDIR}/cgicc
	oe_libinstall -C cgicc libcgicc ${STAGING_LIBDIR}
}
