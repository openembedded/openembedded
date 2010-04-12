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

SRC_URI[md5sum] = "e192ee993b04749f82dd3e8b529d40c0"
SRC_URI[sha256sum] = "2e55067741a5f48ca6962c135fcbe6d1c1b70b95c825156c7db046277929cf28"
