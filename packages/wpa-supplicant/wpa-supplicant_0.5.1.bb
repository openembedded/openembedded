DESCRIPTION = "A Client for Wi-Fi Protected Access (WPA)."
SECTION = "network"
LICENSE = "GPL"
MAINTAINER = "Holger Schurig"
HOMEPAGE = "http://hostap.epitest.fi/wpa_supplicant/"
DEPENDS = "gnutls"
PR = "r1"

SRC_URI = "http://hostap.epitest.fi/releases/wpa_supplicant-${PV}.tar.gz \
	file://defconfig-gnutls \
	file://init.sh \
	file://defaults-gnutls \
	file://wpa_supplicant.conf-gnutls"

S = "${WORKDIR}/wpa_supplicant-${PV}"

PACKAGES_prepend = "wpa-supplicant-passphrase wpa-supplicant-cli"
FILES_wpa-supplicant-passphrase = "/usr/sbin/wpa_passphrase"
FILES_wpa-supplicant-cli = "/usr/sbin/wpa_cli"

RRECOMMENDS_${PN} = "wpa-supplicant-passphrase wpa-supplicant-cli"

INITSCRIPT_NAME = "wpa"
INITSCRIPT_PARAMS = "defaults 10"
inherit update-rc.d

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

	install -d ${D}${localstatedir}/run/wpa_supplicant

	install -d ${D}${docdir}/wpa_supplicant
	install -m644 README ${WORKDIR}/wpa_supplicant.conf ${D}${docdir}/wpa_supplicant

	install -d ${D}${sysconfdir}/init.d
	install -m700 ${WORKDIR}/init.sh ${D}${sysconfdir}/init.d/wpa

	install -d ${D}${sysconfdir}/default
	install -m600 ${WORKDIR}/defaults-gnutls ${D}${sysconfdir}/default/wpa
	install -m600 ${WORKDIR}/wpa_supplicant.conf-gnutls ${D}${sysconfdir}/wpa_supplicant.conf
}
