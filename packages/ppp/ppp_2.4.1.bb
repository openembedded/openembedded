SECTION = "console/network"
DESCRIPTION = "Point-to-Point Protocol (PPP) daemon"
HOMEPAGE = "http://samba.org/ppp/"
LICENSE = "BSD GPLv2"
PR = "r7"

SRC_URI = "ftp://ftp.samba.org/pub/ppp/ppp-2.4.1.tar.gz \
	file://pppd.patch;patch=1 \
	file://man.patch;patch=1 \
	file://cifdefroute.dif;patch=1 \
	file://pppd-resolv-varrun.patch;patch=1 \
	file://pon \
	file://poff \
	file://init \
	file://ip-up \
	file://ip-down \
	file://08setupdns \
	file://92removedns"
	
inherit autotools

EXTRA_OEMAKE = "STRIPPROG=${STRIP}"
EXTRA_OECONF = --disable-strip

do_install_append () {
	install -d ${D}${bindir}/ ${D}${sysconfdir}/init.d
 	install -m 0755 ${WORKDIR}/pon ${D}${bindir}/pon
	install -m 0755 ${WORKDIR}/poff ${D}${bindir}/poff
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/ppp
	install -m 0755 ${WORKDIR}/ip-up ${D}${sysconfdir}/ppp/
	install -m 0755 ${WORKDIR}/ip-down ${D}${sysconfdir}/ppp/
	install -d ${D}${sysconfdir}/ppp/ip-up.d/
	install -d ${D}${sysconfdir}/ppp/ip-down.d/
	install -m 0755 ${WORKDIR}/08setupdns ${D}${sysconfdir}/ppp/ip-up.d/
	install -m 0755 ${WORKDIR}/92removedns ${D}${sysconfdir}/ppp/ip-down.d/
}

CONFFILES_${PN} = "${sysconfdir}/ppp/pap-secrets ${sysconfdir}/ppp/chap-secrets ${sysconfdir}/ppp/options"

pkg_postinst() {
if test "x$D" != "x"; then
	exit 1
else
	chmod u+s ${sbindir}/pppd
fi
}
