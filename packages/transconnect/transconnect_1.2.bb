SECTION = "unknown"
DESCRIPTION = "TransConnect is an implementation of function \
interposing to allow users on *nix platforms to transparenly \
tunnel all networking applications over an HTTPS proxy."

SRC_URI = "${SOURCEFORGE_MIRROR}/transconnect/transconnect-${PV}.tar.gz"
LICENSE = "GPL"
LDFLAGS_append = " -shared"
do_compile () {
	oe_runmake tconn.so
}

do_install () {
	install -d ${D}${sysconfdir}
	install -m 0644 tconn.conf ${D}${sysconfdir}/
	install -d ${D}${libdir}/tconn
	oe_libinstall -so tconn ${D}${libdir}/tconn/
}
