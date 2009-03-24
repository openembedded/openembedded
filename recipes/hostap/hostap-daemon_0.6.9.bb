DESCRIPTION = "User space daemon for extended IEEE 802.11 management"
HOMEPAGE = "http://hostap.epitest.fi"
SECTION = "kernel/userland"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "libnl openssl ${@base_contains("COMBINED_FEATURES", "pci", "madwifi-ng", "",d)}"
PR = "r0"

DEFAULT_PREFERENCE = "-1"

#we introduce MY_ARCH to get 'armv5te' as arch instead of the misleading 'arm' on armv5te builds
MY_ARCH := "${PACKAGE_ARCH}"
PACKAGE_ARCH = "${@base_contains('COMBINED_FEATURES', 'pci', '${MACHINE_ARCH}', '${MY_ARCH}', d)}"

SRC_URI = "http://hostap.epitest.fi/releases/hostapd-${PV}.tar.gz \
	file://defconfig \
	file://init"

S = "${WORKDIR}/hostapd-${PV}/hostapd"

export HAS_PCI = "${@base_contains('COMBINED_FEATURES', 'pci', 1, 0,d)}"

inherit update-rc.d
INITSCRIPT_NAME=hostapd

do_configure() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
	if [ "x$HAS_PCI" = "x1" ] ; then
		echo "CONFIG_DRIVER_MADWIFI=y" >> .config
		echo "CFLAGS += -I${STAGING_INCDIR}/madwifi-ng" >> .config
	fi
}

do_compile() {
	make
}

do_install() {
	install -d ${D}${sbindir} ${D}${sysconfdir}/init.d
	install -m 0644 ${S}/hostapd.conf ${D}${sysconfdir}
	install -m 0755 ${S}/hostapd ${D}${sbindir}
	install -m 0755 ${S}/hostapd_cli ${D}${sbindir}
	install -m 755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/hostapd
}

