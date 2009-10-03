DESCRIPTION = "Graphical front-end for the gschem -> pcb workflow"
LICENSE = "GPLv2"
HOMEPAGE = "http://www.gpleda.org/"
FILES_${PN} += "${datadir}/icons"
PR = "r1"

DEPENDS = "python-native"
# python-codecs for gettext.py
RDEPENDS = "geda-gschem geda-utils pcb python-codecs python-dbus python-pygtk python-subprocess"

SRC_URI = "http://geda.seul.org/dist/${P}.tar.gz \
           file://skip-python-checks.patch;patch=1"

inherit autotools

EXTRA_OECONF = "--disable-update-desktop-database"

do_configure_prepend() {
	sed -i -e s:\\\$\(PYTHON\):${bindir}/python:g Makefile.am
}
