DESCRIPTION = "gtk frontend for connman"
HOMEPAGE = "http://www.moblin.org/projects/projects_connman.php"
SECTION = "libs/network"
LICENSE = "GPL"
DEPENDS = "gtk+ dbus"
PR = "r5"

RRECOMMENDS_${PN} = "connman"

SRC_URI = "http://repo.moblin.org/connman/releases/connman-gnome-${PV}.tar.gz \
           file://phrase-lenght.diff;patch=1 \
           file://connman-applet.desktop"

inherit autotools gtk-icon-cache

do_install_append() {
	install -d ${D}${datadir}/applications/
	install ${WORKDIR}/connman-applet.desktop ${D}${datadir}/applications/
}

