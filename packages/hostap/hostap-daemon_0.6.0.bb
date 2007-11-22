DESCRIPTION = "User space daemon for extended IEEE 802.11 management"
HOMEPAGE = "http://hostap.epitest.fi"
SECTION = "kernel/userland"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "openssl ${@base_contains("COMBINED_FEATURES", "pci", "madwifi-ng", "",d)}"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "http://hostap.epitest.fi/releases/hostapd-${PV}.tar.gz \
	file://makefile-cross.diff;patch=1 \
	file://defconfig \
	file://init"

S = "${WORKDIR}/hostapd-${PV}/hostapd"

export HAS_PCI = "${@base_contains('COMBINED_FEATURES', 'pci', 1, 0,d)}"

inherit update-rc.d
INITSCRIPT_NAME=hostapd

do_configure() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
	if [ "x$HAS_PCI" == "x1" ] ; then
		echo "CONFIG_DRIVER_MADWIFI=y" >> .config
		echo "CFLAGS += -I${STAGING_INCDIR}/madwifi-ng" >> .config
	fi
}

do_compile() {
	CFLAGS='${CFLAGS}' CC='${CC}' make
}

do_install() {
	install -d ${D}${sbindir} ${D}${sysconfdir}/init.d
	make TARGET_PREFIX=${D}${sbindir} install
	install -m 0644 hostapd.conf ${D}${sysconfdir}
	install -m 755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/hostapd
}

