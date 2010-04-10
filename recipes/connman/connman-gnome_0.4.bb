DESCRIPTION = "gtk frontend for connman"
HOMEPAGE = "http://www.moblin.org/projects/projects_connman.php"
SECTION = "libs/network"
LICENSE = "GPL"
DEPENDS = "gtk+ dbus"
PR = "r7"

RRECOMMENDS_${PN} = "connman connman-plugin-ethernet connman-plugin-loopback connman-plugin-udhcp connman-plugin-wifi"

SRC_URI = "http://www.kernel.org/pub/linux/network/connman/connman-gnome-${PV}.tar.gz \
           file://phrase-lenght.diff;patch=1 \
           file://connman-applet.desktop"

inherit autotools gtk-icon-cache

do_install_append() {
	install -d ${D}${datadir}/applications/
	install ${WORKDIR}/connman-applet.desktop ${D}${datadir}/applications/
}


SRC_URI[md5sum] = "c9a3b384f080ed4cdf139ce9377ef2c8"
SRC_URI[sha256sum] = "d7acac8bc0a38dfcab098137a76f5e9f4ce30ca86e82b26540502658e6b4e4a7"
