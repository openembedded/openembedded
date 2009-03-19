DESCRIPTION = "A Client for Wi-Fi Protected Access (WPA)."
SECTION = "network"
LICENSE = "GPL"
HOMEPAGE = "http://hostap.epitest.fi/wpa_supplicant/"
DEPENDS = "openssl"
RCONFLICTS_${PN} = "wpa-supplicant-nossl"
RREPLACES_${PN} = "wpa-supplicant-nossl"
PR = "r8"

SRC_URI = "http://hostap.epitest.fi/releases/wpa_supplicant-${PV}.tar.gz \
	file://madwifi-bsd-fix.diff;patch=1;pnum=0 \
	file://defconfig \
        file://driver-hermes.patch;patch=1 \
	file://driver-zd1211.patch;patch=1 \
	file://wpa-supplicant.sh \
	file://wpa_supplicant.conf"

S = "${WORKDIR}/wpa_supplicant-${PV}"

do_configure () {
	install -m 0755 ${WORKDIR}/defconfig  .config
}

do_compile () {
	make
}

do_install () {
	install -d ${D}${sbindir}
	install -m 755 wpa_supplicant ${D}${sbindir}
	install -m 755 wpa_passphrase ${D}${sbindir}
	install -m 755 wpa_cli        ${D}${sbindir}

	install -d ${D}${sysconfdir}/network/if-pre-up.d/
	install -d ${D}${sysconfdir}/network/if-post-down.d/
	install -d ${D}${sysconfdir}/network/if-down.d/
	install -m 644 ${WORKDIR}/wpa_supplicant.conf ${D}${sysconfdir}
	install -m 755 ${WORKDIR}/wpa-supplicant.sh ${D}${sysconfdir}/network/if-pre-up.d/wpa-supplicant
	cd ${D}${sysconfdir}/network/ && \
	ln -sf ../if-pre-up.d/wpa-supplicant if-post-down.d/wpa-supplicant

	install -d ${D}${docdir}/wpa_supplicant
	install -m 644 ${S}/README ${D}${docdir}/wpa_supplicant
}

CONFFILES_${PN} = "${sysconfdir}/wpa_supplicant.conf"
