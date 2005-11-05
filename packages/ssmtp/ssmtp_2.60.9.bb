SECTION = "console/network"
DEPENDS = "openssl"
DESCRIPTION = "Extremely simple MTA to get mail off the system to a mail hub."
LICENSE = "GPL"
SRC_URI = "${DEBIAN_MIRROR}/main/s/ssmtp/ssmtp_${PV}.tar.gz \
           file://ldflags.patch;patch=1 \
           file://configure.patch;patch=1 \
           file://ssmtp.conf"
S = "${WORKDIR}/${PN}-2.60"

inherit autotools

EXTRA_OECONF = "--enable-ssl"
do_compile () {
	oe_runmake 'LDFLAGS=${LDFLAGS}'
}

do_install () {
	oe_runmake 'prefix=${D}${prefix}' 'exec_prefix=${D}${exec_prefix}' \
		   'bindir=${D}${bindir}' 'mandir=${D}${mandir}' \
		   'etcdir=${D}${sysconfdir}' GEN_CONFIG="`which echo`" install
	install -d ${D}${sysconfdir}/ssmtp
	install -m 0644 ${WORKDIR}/ssmtp.conf ${D}${sysconfdir}/ssmtp/ssmtp.conf
}
