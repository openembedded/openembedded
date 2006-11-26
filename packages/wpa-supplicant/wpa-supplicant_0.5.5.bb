DESCRIPTION = "A Client for Wi-Fi Protected Access (WPA)."
SECTION = "network"
LICENSE = "GPL"
HOMEPAGE = "http://hostap.epitest.fi/wpa_supplicant/"
DEPENDS = "gnutls ${@base_contains("COMBINED_FEATURES", "pci", "madwifi-ng", "",d)}"
PACKAGE_ARCH = "${@base_contains('COMBINED_FEATURES', 'pci', ${MACHINE}, ${TARGET_ARCH}, d)}"

DEFAULT_PREFERENCE = "-2"

SRC_URI = "http://hostap.epitest.fi/releases/wpa_supplicant-${PV}.tar.gz \
	file://defconfig-gnutls \
	file://init.sh \
	file://gnutlsfix.patch;patch=1 \
	file://defaults-sane \
	file://wpa_supplicant.conf \
	file://wpa_supplicant.conf-sane"

S = "${WORKDIR}/wpa_supplicant-${PV}"

PACKAGES_prepend = "wpa-supplicant-passphrase wpa-supplicant-cli "
FILES_wpa-supplicant-passphrase = "/usr/sbin/wpa_passphrase"
FILES_wpa-supplicant-cli = "/usr/sbin/wpa_cli"

RRECOMMENDS_${PN} = "wpa-supplicant-passphrase wpa-supplicant-cli"

INITSCRIPT_NAME = "wpa"
INITSCRIPT_PARAMS = "defaults 10"
inherit update-rc.d

export HAS_PCI = "${@base_contains('COMBINED_FEATURES', 'pci', 1, 0,d)}"

do_configure () {
        install -m 0755 ${WORKDIR}/defconfig-gnutls  .config
 
        if [ "x$HAS_PCI" == "x1" ] then; do
                echo "CONFIG_DRIVER_MADWIFI=y" >> .config
                echo "CFLAGS += -I${STAGING_INCDIR}/madwifi-ng" >> .config
        fi
}

do_compile () {
	make
}

do_install () {
	install -d ${D}${sbindir}
	install -m 755 wpa_supplicant ${D}${sbindir}
	install -m 755 wpa_passphrase ${D}${sbindir}
	install -m 755 wpa_cli        ${D}${sbindir}

	install -d ${D}${localstatedir}/run/wpa_supplicant

	install -d ${D}${docdir}/wpa_supplicant
	install -m 644 README ${WORKDIR}/wpa_supplicant.conf ${D}${docdir}/wpa_supplicant

	install -d ${D}${sysconfdir}/init.d
	install -m 700 ${WORKDIR}/init.sh ${D}${sysconfdir}/init.d/wpa

	install -d ${D}${sysconfdir}/default
	install -m 600 ${WORKDIR}/defaults-sane ${D}${sysconfdir}/default/wpa
	install -m 600 ${WORKDIR}/wpa_supplicant.conf-sane ${D}${sysconfdir}/wpa_supplicant.conf
}
