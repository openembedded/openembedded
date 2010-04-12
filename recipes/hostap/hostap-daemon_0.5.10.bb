DESCRIPTION = "User space daemon for extended IEEE 802.11 management"
HOMEPAGE = "http://hostap.epitest.fi"
SECTION = "kernel/userland"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "openssl ${@base_contains("COMBINED_FEATURES", "madwifi", "madwifi-ng", "",d)}"
PR = "r1"
DEPENDS_append_mtx-1 = " madwifi-modules"
DEPENDS_append_mtx-2 = " madwifi-modules"
CPPFLAGS_append_mtx-1 = " -I${STAGING_INCDIR}/madwifi/"
CPPFLAGS_append_mtx-2 = " -I${STAGING_INCDIR}/madwifi/"

#we introduce MY_ARCH to get 'armv5te' as arch instead of the misleading 'arm' on armv5te builds
MY_ARCH := "${PACKAGE_ARCH}"
PACKAGE_ARCH = "${@base_contains('COMBINED_FEATURES', 'madwifi', '${MACHINE_ARCH}', '${MY_ARCH}', d)}"

SRC_URI = "http://hostap.epitest.fi/releases/hostapd-${PV}.tar.gz \
	file://makefile-cross.diff;patch=1 \
	file://defconfig \
	file://init"

S = "${WORKDIR}/hostapd-${PV}"

export HAS_MADWIFI = "${@base_contains('COMBINED_FEATURES', 'madwifi', 1, 0,d)}"

inherit update-rc.d
INITSCRIPT_NAME=hostapd

do_configure() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
	if [ "x$HAS_MADWIFI" = "x1" ] ; then
		echo "CONFIG_DRIVER_MADWIFI=y" >> .config
		echo "CFLAGS += -I${STAGING_INCDIR}/madwifi-ng" >> .config
	fi
}

do_compile() {
	make
}

do_install() {
	install -d ${D}${sbindir} ${D}${sysconfdir}/init.d
	make TARGET_PREFIX=${D}${sbindir} install
	install -m 0644 hostapd.conf ${D}${sysconfdir}
	install -m 755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/hostapd
}


SRC_URI[md5sum] = "ed669d96346dfc7d9f9fad079731853f"
SRC_URI[sha256sum] = "a99908d5765757ad6025b57d5ecf43b412aaaaf2ca379c02aafa33ca5c9d35c1"
