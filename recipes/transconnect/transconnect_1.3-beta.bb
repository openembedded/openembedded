SECTION = "unknown"
DESCRIPTION = "TransConnect is an implementation of function \
interposing to allow users on *nix platforms to transparenly \
tunnel all networking applications over an HTTPS proxy."
LICENSE = "GPL"
SRC_URI = "${SOURCEFORGE_MIRROR}/transconnect/transconnect-1.3-Beta.tar.gz"
S = "${WORKDIR}/transconnect-1.3-Beta"

LDFLAGS_append = " -shared"
do_compile () {
	# build with local resolv.conf and dns over tcp support
	oe_runmake localtcp
}

do_install () {
	install -d ${D}${sysconfdir}
	install -m 0644 tconn.conf ${D}${sysconfdir}/
	install -d ${D}${libdir}/tconn
	oe_libinstall -so tconn ${D}${libdir}/tconn/
}

SRC_URI[md5sum] = "50f75731e610fce00803cc7d98b301fd"
SRC_URI[sha256sum] = "404df2c479517020290be9847191523c1fcbd3e929e8bb1191a7832209d04af8"
