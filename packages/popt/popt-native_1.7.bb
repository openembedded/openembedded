require popt.inc

DEPENDS = "gettext-native"

PR = "r5"

inherit native autotools

SRC_URI = "ftp://ftp.rpm.org/pub/rpm/dist/rpm-4.1.x/popt-${PV}.tar.gz \
	   file://m4.patch;patch=1 \
	   file://intl.patch;patch=1"

S = "${WORKDIR}/popt-${PV}"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/popt-${PV}"

do_install() {
	oe_libinstall -a -so libpopt ${STAGING_LIBDIR_NATIVE}
	install -m 0644 popt.h ${STAGING_INCDIR_NATIVE}
}
