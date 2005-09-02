DESCRIPTION = "Ecore is the core event abstraction layer for the enlightenment \
foundation libraries. It makes makes doing selections, drag and drop, event loops, \
timeouts and idle handlers fast, optimized, and convenient."
LEAD_SONAME = "libecore.so"
LICENSE = "MIT"
# can also have openssl, dbus
DEPENDS += "virtual/evas curl eet"
PROVIDES += "virtual/ecore"

inherit efl

SRC_URI = "http://enlightenment.freedesktop.org/files/ecore-${PV}.tar.gz \
           file://configure.patch;patch=1"
S = "${WORKDIR}/ecore-${PV}"
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/ecore"

EXTRA_OECONF = "<override me>"

libraries = ""
headers = ""
parts = "<override me>"

do_stage_append() {
	for p in ${parts}; do
		dir=`echo $p|tr A-Z a-z`
		install -m 0644 ${S}/src/lib/$dir/$p*.h ${STAGING_INCDIR}/
		oe_libinstall -C src/lib/$dir lib$dir ${STAGING_LIBDIR}/
	done
	install -m 0644 ${S}/src/lib/ecore/Ecore_Data.h ${STAGING_INCDIR}/
	install -m 0644 ${S}/ecore.m4 ${STAGING_DATADIR}/aclocal/
}

FILES_${PN} += "${libdir}/libecore*.so* ${libdir}/ecore_config_ipc_ecore.so"
