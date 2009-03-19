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

