DESCRIPTION = "A simple, small, portable, fast, and secure HTTP server."
LICENSE = "BSD"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
HOMEPAGE = "http://www.acme.com/software/thttpd/"
PR="r2"

SRC_URI = "http://www.acme.com/software/thttpd/thttpd-2.25b.tar.gz \
	   file://install.patch;patch=1 \
	   file://acinclude.m4 \
	   file://init"
S = "${WORKDIR}/thttpd-${PV}"
INITSCRIPT_NAME = "thttpd"
INITSCRIPT_PARAMS = "defaults"

inherit autotools

EXTRA_OEMAKE += "'WEBDIR=${servicedir}/www'"
FILES_${PN}_append = " ${servicedir}"

do_configure () {
	install -m 0644 ${WORKDIR}/acinclude.m4 ${S}/
	autotools_do_configure
}

do_install_append () {
	install -d "${D}${sysconfdir}/init.d"
	cat ${WORKDIR}/init | sed -e 's,@@SRVDIR,${servicedir}/www,g' > ${WORKDIR}/thttpd
	install -c -m 755 ${WORKDIR}/thttpd ${D}${sysconfdir}/init.d/thttpd
}
