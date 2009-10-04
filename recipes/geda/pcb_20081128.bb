DESCRIPTION = "PCB Designer"
LICENSE = "GPLv2"
HOMEPAGE = "http://pcb.gpleda.org/"
FILES_${PN} += " ${datadir}/icons ${datadir}/mime/packages"
# NOTE: Old KDE integration ${datadir}/mimelnk/application/*.desktop are ignored intentionally
PR = "r1"

#DEPENDS = "libgeda"
DEPENDS = "dbus gd gtk+ tcl-native tk-native"

SRC_URI = "http://geda.seul.org/dist/${P}.tar.gz"

inherit autotools mime

EXTRA_OECONF = "--disable-update-mime-database --disable-update-desktop-database --enable-dbus"
