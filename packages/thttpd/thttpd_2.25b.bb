DESCRIPTION = "A simple, small, portable, fast, and secure HTTP server."
LICENSE = "BSD"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
HOMEPAGE = "http://www.acme.com/software/thttpd/"

SRC_URI = "http://www.acme.com/software/thttpd/thttpd-2.25b.tar.gz \
	   file://install.patch;patch=1 \
	   file://acinclude.m4"
S = "${WORKDIR}/thttpd-${PV}"

inherit autotools

EXTRA_OEMAKE += "'WEBDIR=${servicedir}/www'"
FILES_${PN}_append = " ${servicedir}"

do_configure () {
	install -m 0644 ${WORKDIR}/acinclude.m4 ${S}/
	autotools_do_configure
}
