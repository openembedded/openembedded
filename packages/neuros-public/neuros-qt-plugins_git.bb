DESCRIPTION = "Neuros qt-plugins"
LICENSE = "GPL"

PV = "0.0+${PR}+gitr${SRCREV}"
PR = "r4"

DEPENDS = "qt-embedded"

inherit qtopia4core

SRCREV = "7636920455c7e963f004e394de9db39d2e9ac35f"
SRC_URI = "git://git.neurostechnology.com/git/qt-plugins;protocol=git"
S = "${WORKDIR}/git/osdir"

do_install() {
	install -d ${D}/${libdir}/${QT_DIR_NAME}/plugins/kbddrivers/
	install -m 0755 ${S}/build/*plugin* ${D}/${libdir}/${QT_DIR_NAME}/plugins/kbddrivers/
}

FILES_${PN} += "${libdir}/${QT_DIR_NAME}/plugins"
FILES_${PN}-dbg += "${libdir}/${QT_DIR_NAME}/plugins/*/.debug"

