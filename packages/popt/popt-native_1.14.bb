require popt.inc

DEPENDS = "gettext-native"

PR = "r0"

inherit native autotools

SRC_URI = "http://rpm5.org/files/popt/popt-${PV}.tar.gz"

S = "${WORKDIR}/popt-${PV}"

do_install() {
	oe_libinstall -a -so libpopt ${STAGING_LIBDIR_NATIVE}
	install -m 0644 popt.h ${STAGING_INCDIR_NATIVE}
}
