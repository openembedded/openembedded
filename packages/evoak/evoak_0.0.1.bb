HOMEPAGE = "http://www.enlightenment.org"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "ecore evas edje embryo eet"
LICENSE = "MIT"

SRC_URI = "http://www.rasterman.com/files/evoak-${PV}.tar.gz"
S = "${WORKDIR}/evoak-${PV}"

inherit autotools binconfig

#FIXME: evoak fails to build, because it doesn't realize that
#our ecore was built without X support.  Ecore should really
#be installing a copy of its config.h, and Evoak should be
#ifdefing blocks of code based on the ecore build options.
BROKEN = "1"

do_stage () {
	oe_libinstall -C src/lib libvoak ${STAGING_LIBDIR}/
	install -m 0644 ${S}/src/lib/Evoak.h ${STAGING_INCDIR}/
}
