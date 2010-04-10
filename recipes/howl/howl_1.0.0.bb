SRC_URI = "http://www.porchdogsoft.com/download/howl-${PV}.tar.gz \
	file://posix.patch;patch=1;pnum=0 \
	file://configure.patch;patch=1;pnum=0 \
	file://mdnsresponder.init"
LICENSE = "howl"

PR = "r2"

INITSCRIPT_NAME = "mdnsresponder"
INITSCRIPT_PARAMS = "defaults"

PACKAGES += "libhowl libmdnsresponder"

FILES_${PN} = "${bindir} ${sbindir} ${sysconfdir}"
FILES_libhowl = "${libdir}/libhowl.so.*"
FILES_libmdnsresponder = "${libdir}/libmDNSResponder.so.*"
FILES_${PN}-doc += "${datadir}/howl/help"

do_install_append() {
	install -d ${D}${sysconfdir}/init.d
	install -d ${D}${sbindir}
	install -m 0755 ${WORKDIR}/mdnsresponder.init ${D}${sysconfdir}/init.d/mdnsresponder
	# Debian puts it here, so let's do the same
	mv ${D}${bindir}/mDNSResponder ${D}${sbindir}
}

inherit autotools update-rc.d


SRC_URI[md5sum] = "c389d3ffba0e69a179de2ec650f1fdcc"
SRC_URI[sha256sum] = "6f0145ab1802092308adeb8dfa285f58e104f0822fa266e5ec97e9d27f0e1923"
