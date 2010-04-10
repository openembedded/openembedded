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

SRC_URI[md5sum] = "bcae4dc646440ba8129854621f56acc6"
SRC_URI[sha256sum] = "5af6001401a6bc04c075474be5d8aeb2bdb2ca3e509022c2fc55ca7c7f310256"
