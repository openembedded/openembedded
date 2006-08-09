DESCRIPTION = "Mrouted daemon" 
MAINTAINER = "Andreas Monzner <ghost@dream-multimedia-tv.de>"
LICENSE = "GPL" 
PV = "3.9-beta3" 
PR = "r0" 
PN = "mrouted" 
PACKAGES = "mrouted" 
SRC_URI = "ftp://ftp.debian.org/debian/pool/non-free/m/mrouted/mrouted_${PV}.orig.tar.gz \
	file://mrouted-3.9.diff;patch=1"

S = "${WORKDIR}/mrouted-${PV}.orig"

inherit autotools pkgconfig

bindir = "/usr/bin"
sbindir = "/usr/sbin"

do_compile_prepend() {
	if ! test -f ${S}/y.y; then \
		mv ${S}/cfparse.y y.y; \
	fi;
}

do_install_append() {
	install -d ${D}/usr/bin
	for i in mrinfo map-mbone mrouted; do \
		install ${S}/$i ${D}/usr/bin; \
	done;
}
