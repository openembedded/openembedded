DESCRIPTION = "User space daemon for extended IEEE 802.11 management"
HOMEPAGE = "http://hostap.epitest.fi"
SECTION = "kernel/userland"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "libnl openssl"
PR = "r2"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "http://hostap.epitest.fi/releases/hostapd-${PV}.tar.gz \
	file://ldflags.patch;patch=1 \
	file://defconfig \
	file://init"

S = "${WORKDIR}/hostapd-${PV}/hostapd"

inherit update-rc.d
INITSCRIPT_NAME=hostapd

do_configure() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
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


SRC_URI[md5sum] = "83630d11fa66ade9091f1b304fccd74c"
SRC_URI[sha256sum] = "4430fe2c7a2176c6890ac3a726a8b3d234a77beb3ca987b4349c467331343e67"
