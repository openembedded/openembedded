DESCRIPTION = "Lightweight and High Performance WebServer"
SECTION = "console/network"
RPROVIDES = "httpd"
MAINTAINER = "Rene Wagner <rw@handhelds.org>"
LICENSE = "GPL"
PR = "r2"

DEPENDS = "mime-support"
RDEPENDS = "mime-support"

SRC_URI = "http://www.boa.org/boa-${PV}.tar.gz \
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
}
