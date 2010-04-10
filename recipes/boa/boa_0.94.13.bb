DESCRIPTION = "Lightweight and High Performance WebServer"
SECTION = "console/network"
LICENSE = "GPL"
RDEPENDS = "mime-support"
RPROVIDES = "httpd"
PR = "r3"

SRC_URI = "http://www.boa.org/boa-${PV}.tar.gz \
           file://cgi.patch;patch=1;pnum=2 \
           file://debian-patch.diff;patch=1;pnum=2 \
           file://boa.conf \
           file://boa.init"

S = "${WORKDIR}/boa-${PV}/src"

inherit autotools update-rc.d

INITSCRIPT_NAME = "boa"
INITSCRIPT_PARAMS = "defaults 20"

CFLAGS_append = " -D_FILE_OFFSET_BITS=64 -D_LARGEFILE_SOURCE -D_LARGEFILE64_SOURCE"
#CFLAGS_append = " -DSERVER_ROOT=..."

do_install() {
	install -d ${D}${sbindir}
	install -d ${D}${libdir}/${PN}
	install -m 0755 boa 			${D}${sbindir}
	install -m 0755 boa_indexer 		${D}${libdir}/${PN}

	install -d ${D}${sysconfdir}/${PN}
	install -d ${D}${sysconfdir}/init.d
	install -m 0640 ${WORKDIR}/boa.conf 	${D}${sysconfdir}/${PN}
	install -m 0755 ${WORKDIR}/boa.init	${D}${sysconfdir}/init.d/boa

	install -d ${D}${mandir}/man8
	install -m 0644 ${S}/../docs/boa.8 ${D}${mandir}/man8
}

SRC_URI[md5sum] = "c8d6f46f9aa60909f171529068813fe0"
SRC_URI[sha256sum] = "e00bb50eb859c736f2afc913976e82e8fc68a1fbe34fa294e014aa95f4d87366"
