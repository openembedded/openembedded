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
	install -d ${D}/usr/sbin
	install -m755 wpa_supplicant ${D}/usr/sbin
	install -m755 wpa_passphrase ${D}/usr/sbin
	install -m755 wpa_cli        ${D}/usr/sbin

	install -d ${D}/etc
	install -m644 ${WORKDIR}/wpa_supplicant.conf ${D}/etc

	install -d ${D}/usr/share/doc/wpa_supplicant
	install -m644 README ${D}/usr/share/doc/wpa_supplicant
}


