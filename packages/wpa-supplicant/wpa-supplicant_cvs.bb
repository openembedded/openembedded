DESCRIPTION = "Client for Wi-Fi Protected Access (WPA)."
SECTION = "net"
LICENSE = "GPL"
MAINTAINER = "Holger Schurig"
HOMEPAGE = "http://hostap.epitest.fi/wpa_supplicant/"
DEPENDS = "openssl"
PR = "r1"

SRC_URI = "cvs://anonymous@hostap.epitest.fi/cvs;module=hostap \
	file://defconfig \
	file://wpa_supplicant.conf"
S = "${WORKDIR}/hostap/wpa_supplicant"

do_configure () {
	install -m 0755 ${WORKDIR}/defconfig  .config
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
	install -m644 ${WORKDIR}/wpa_supplicant.conf ${D}${sysconfdir}

	install -d ${D}${docdir}/wpa_supplicant
	install -m644 README ${D}${docdir}/wpa_supplicant
}


