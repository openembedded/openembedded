DESCRIPTION = "A Client for Wi-Fi Protected Access (WPA)."
SECTION = "network"
LICENSE = "GPL"
MAINTAINER = "Holger Schurig"
HOMEPAGE = "http://hostap.epitest.fi/wpa_supplicant/"
DEPENDS = "gnutls"

SRC_URI = "http://hostap.epitest.fi/releases/wpa_supplicant-${PV}.tar.gz \
	file://defconfig-gnutls \
	file://wpa_supplicant.conf-gnutls"

S = "${WORKDIR}/wpa_supplicant-${PV}"

do_configure () {
	install -m 0755 ${WORKDIR}/defconfig-gnutls  .config
}

do_compile () {
	make
}

do_install () {
	install -d ${D}${sbindir}
	install -m755 wpa_supplicant ${D}${sbindir}
	install -m755 wpa_passphrase ${D}${sbindir}
	install -m755 wpa_cli        ${D}${sbindir}

	install -d ${D}${sysconfdir}
	install -m644 ${WORKDIR}/wpa_supplicant.conf-gnutls ${D}${sysconfdir}/wpa_supplicant.conf

	install -d ${D}${docdir}/wpa_supplicant
	install -m644 README ${D}${docdir}/wpa_supplicant
}
