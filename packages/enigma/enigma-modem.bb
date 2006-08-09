DEPENDS = "enigma"
DESCRIPTION = "Enigma Modem Plugin"
MAINTAINER = "Andreas Monzner <ghost@dream-multimedia-tv.de>"
LICENSE = "GPL"

SRC_URI = "http://sources.dreamboxupdate.com/download/opendreambox/enigma/enigma-modem-${PV}-r1.tar.gz"

PV = "0.1"
PN = "enigma-modem"
PR = "r1"

PACKAGES = "enigma-modem"

S = "${WORKDIR}/enigma-modem-${PV}"

inherit autotools pkgconfig

FILES_${PN} = "/usr/lib/tuxbox/plugins/enigma_modem.so \
		/usr/lib/tuxbox/plugins/enigma_modem.cfg \
		/etc/ppp/dial.modem \
		/etc/ppp/disconnect.modem \
		/etc/ppp/ip-up.d/01peerdns /etc/ppp/ip-down.d/01peerdns-remove"

EXTRA_OECONF = "--with-target=native "

PPP_FILES = "dial.modem options disconnect.modem pap-secrets"

do_install_append() {
	install -d ${D}/etc/ppp
	for i in dial.modem disconnect.modem; do
		install -m 0755 ${S}/$i ${D}/etc/ppp/
	done;
	for i in options pap-secrets; do
		install -m 0644 ${S}/$i ${D}/etc/ppp/
	done;
	install -d ${D}/etc/ppp/ip-up.d
	install -m 0755 ${S}/01peerdns ${D}/etc/ppp/ip-up.d
	install -d ${D}/etc/ppp/ip-down.d
	install -m 0755 ${S}/01peerdns-remove ${D}/etc/ppp/ip-down.d
}

