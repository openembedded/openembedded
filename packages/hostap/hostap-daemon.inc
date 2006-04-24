DESCRIPTION = "User space daemon for extended IEEE 802.11 management"
HOMEPAGE = "http://hostap.epitest.fi"
SECTION = "kernel/userland"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
RDEPENDS = "hostap-modules hostap-utils (${PV})"
DEPENDS = "openssl"
DEPENDS_mtx-1_append = "madwifi-modules"

SRC_URI = "http://hostap.epitest.fi/releases/hostapd-${PV}.tar.gz \
	file://makefile-cross.diff;patch=1;pnum=0 \
	file://madwifi-bsd-fix.diff;patch=1;pnum=0 \
	file://defconfig \
	file://init"

S = "${WORKDIR}/hostapd-${PV}"

do_configure() {
       install -m 0644 ${WORKDIR}/defconfig ${S}/.config
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

