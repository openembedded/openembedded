DESCRIPTION = "Convert Gnome or KDE menus to e17 menus"
DEPENDS = "virtual/ecore virtual/evas eet engrave"
LICENSE = "GPL"
HOMEPAGE = "http://sourceforge.net/projects/e17genmenu"
PR = "r0"

inherit e

SECTION = "e/utils"

SRC_URI = "${SOURCEFORGE_MIRROR}/e17genmenu/e17genmenu-${PV}.tar.gz"
S = "${WORKDIR}/${PN}"

PACKAGES += "${PN}-doc"

FILES_${PN} = "${bindir} ${datadir}"
FILES_${PN}-doc = "/usr/doc"