SECTION = "console/network"
DESCRIPTION = "Point-to-Point Protocol (PPP) daemon"
HOMEPAGE = "http://samba.org/ppp/"
LICENSE = "BSD GPLv2"
PR = "r7"

SRC_URI = "http://ppp.samba.org/ftp/ppp/ppp-${PV}.tar.gz \
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

SRC_URI_append_nylon = " file://ppp-tdbread.patch;patch=1"

inherit autotools

EXTRA_OEMAKE = "STRIPPROG=${STRIP}"
EXTRA_OECONF = "--disable-strip"

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

SRC_URI[md5sum] = "fbc256801d5fcd8015039b149ae95eb0"
SRC_URI[sha256sum] = "c8f2c4f125b1b4ac1b9c76172e3215c80e123e35ae4c2d473e310bc44c1baa9e"
