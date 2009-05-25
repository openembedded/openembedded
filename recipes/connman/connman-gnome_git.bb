DESCRIPTION = "gtk frontend for connman"
HOMEPAGE = "http://www.moblin.org/projects/projects_connman.php"
SECTION = "libs/network"
LICENSE = "GPL"
DEPENDS = "gtk+ dbus"

RRECOMMENDS_${PN} = "connman connman-plugin-ethernet connman-plugin-loopback connman-plugin-udhcp connman-plugin-wifi"

PV = "0.5+git"
PR_append = ".gitr${SRCREV}"

DEFAULT_PREFERENCE = "-1"

SRCREV = "0059a16915d65880e3f9892a8f0a25f65968260e"
SRC_URI = "\
  git://git.kernel.org/pub/scm/network/connman/connman-gnome.git;protocol=git \
  file://connman-applet.desktop"

S = "${WORKDIR}/git"


inherit autotools gtk-icon-cache

do_install_append() {
	install -d ${D}${datadir}/applications/
	install ${WORKDIR}/connman-applet.desktop ${D}${datadir}/applications/
}

