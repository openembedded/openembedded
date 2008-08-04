DESCRIPTION = "Neuros qt-plugins"
LICENSE = "GPL"

PV = "0.0+${PR}+gitr${SRCREV}"
PR = "r3"

DEPENDS = "qt-embedded"

inherit qtopia4core

SRCREV = "d344957a0731d31cbe5ef5e1f64defbb1627d162"
SRC_URI = "git://git.neurostechnology.com/git/qt-plugins;protocol=git"
S = "${WORKDIR}/git/osdir"

do_install() {
	install -d ${D}/${libdir}/${QT_DIR_NAME}/plugins/kbddrivers/
	install -m 0755 ${S}/build/*plugin* ${D}/${libdir}/${QT_DIR_NAME}/plugins/kbddrivers/
}

FILES_${PN} += "${libdir}/${QT_DIR_NAME}/plugins"
FILES_${PN}-dbg += "${libdir}/${QT_DIR_NAME}/plugins/*/.debug"

