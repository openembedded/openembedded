DESCRIPTION = "gtk frontend for connman"
HOMEPAGE = "http://www.moblin.org/projects/projects_connman.php"
SECTION = "libs/network"
LICENSE = "GPL"
DEPENDS = "gtk+ dbus"

RRECOMMENDS_${PN} = "connman connman-plugin-ethernet connman-plugin-loopback connman-plugin-udhcp connman-plugin-wifi connman-plugin-bluetooth"

PV = "0.5+git"
PR = "r3"
PR_append = ".gitr${SRCREV}"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_angstrom = "1"

SRCREV = "bdc9164b405d18cfc5dbde2a33f070341d5ad673"

SRC_URI = "\
  git://git.kernel.org/pub/scm/network/connman/connman-gnome.git;protocol=git \
  file://connman-applet.desktop"

S = "${WORKDIR}/git"


inherit autotools gtk-icon-cache

do_install_append() {
	install -d ${D}${datadir}/applications/
	install ${WORKDIR}/connman-applet.desktop ${D}${datadir}/applications/
}

