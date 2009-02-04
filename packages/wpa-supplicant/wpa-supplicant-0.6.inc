DESCRIPTION = "A Client for Wi-Fi Protected Access (WPA)."
SECTION = "network"
LICENSE = "GPL"
HOMEPAGE = "http://hostap.epitest.fi/wpa_supplicant/"
DEPENDS = "dbus gnutls ${@base_contains("COMBINED_FEATURES", "pci", "madwifi-ng", "",d)}"

#we introduce MY_ARCH to get 'armv5te' as arch instead of the misleading 'arm' on armv5te builds
MY_ARCH := "${PACKAGE_ARCH}"
PACKAGE_ARCH = "${@base_contains('COMBINED_FEATURES', 'pci', '${MACHINE_ARCH}', '${MY_ARCH}', d)}"

DEFAULT_PREFERENCE = "-2"

SRC_URI = "http://hostap.epitest.fi/releases/wpa_supplicant-${PV}.tar.gz \
	file://defconfig-0.6.0-gnutls \
	file://ifupdown.sh \
	file://functions.sh"

#	file://gnutlsfix.patch;patch=1 \

S = "${WORKDIR}/wpa_supplicant-${PV}/wpa_supplicant"

PACKAGES_prepend = "wpa-supplicant-passphrase "
FILES_wpa-supplicant-passphrase = "/usr/sbin/wpa_passphrase"

RREPLACES = "wpa-supplicant-cli"

RRECOMMENDS_${PN} = "wpa-supplicant-passphrase"

export HAS_PCI = "${@base_contains('COMBINED_FEATURES', 'pci', 1, 0,d)}"

do_configure () {
        install -m 0755 ${WORKDIR}/defconfig-0.6.0-gnutls  .config

        if [ "x$HAS_PCI" == "x1" ] ; then
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
	install -m 644 README ${D}${docdir}/wpa_supplicant

	install -d ${D}${sysconfdir}/network/if-pre-up.d/
	install -d ${D}${sysconfdir}/network/if-post-down.d/
	install -d ${D}${sysconfdir}/network/if-down.d/

	install -d ${D}${sysconfdir}/wpa_supplicant
	install -m 755 ${WORKDIR}/ifupdown.sh ${D}${sysconfdir}/wpa_supplicant/
	install -m 755 ${WORKDIR}/functions.sh ${D}${sysconfdir}/wpa_supplicant

	install -d ${D}/${sysconfdir}/dbus-1/system.d
	install -m 644 ${S}/dbus-wpa_supplicant.conf ${D}/${sysconfdir}/dbus-1/system.d
	install -d ${D}/${datadir}/dbus-1/system-services
	sed -i -e s:${base_sbindir}:${sbindir}:g ${S}/dbus-wpa_supplicant.service
	install -m 644 ${S}/dbus-wpa_supplicant.service ${D}/${datadir}/dbus-1/system-services/fi.epitest.hostap.WPASupplicant.service

	ln -s /etc/wpa_supplicant/ifupdown.sh ${D}${sysconfdir}/network/if-pre-up.d/wpasupplicant
	ln -s /etc/wpa_supplicant/ifupdown.sh ${D}${sysconfdir}/network/if-post-down.d/wpasupplicant
}

FILES_${PN} += "${datadir}/dbus-1/system-services/*"
