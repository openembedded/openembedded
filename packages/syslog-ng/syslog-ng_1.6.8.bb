PR = "r4"
MAINTAINER = "Oyvind Repvik <nail@nslu2-linux.org"
DEPENDS = "libol"

SRC_URI = "http://www.balabit.com/downloads/syslog-ng/1.6/src/${PN}-${PV}.tar.gz"

S = "${WORKDIR}/${PN}-${PV}"
inherit autotools

EXTRA_OECONF = "--with-libol=${STAGING_BINDIR}/"
CONFFILES_${PN} = "${sysconfdir}/${PN}/syslog-ng.conf"

do_install_append() {
	install -d ${D}/${sysconfdir}/${PN}
	install ${S}/doc/syslog-ng.conf.sample ${D}${sysconfdir}/${PN}/syslog-ng.conf
	
}
