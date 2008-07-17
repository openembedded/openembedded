DESCRIPTION = "Neuros qt-plugins"
LICENSE = "GPL"

PR = "r1"

DEPENDS = "qt-embedded"

inherit qtopia4core

SRCREV = "6787bd510524155d783e1bce323fc5a14cf9ebd2"
SRC_URI = "git://git.neurostechnology.com/git/qt-plugins;protocol=git"
S = "${WORKDIR}/git/osdir"

do_install() {
	install -d ${D}/${libdir}/${QT_DIR_NAME}/plugins/kbddrivers/
	install -m 0755 ${S}/build/*plugin* ${D}/${libdir}/${QT_DIR_NAME}/plugins/kbddrivers/
}

FILES_${PN} += "${libdir}/${QT_DIR_NAME}/plugins"
FILES_${PN}-dbg += "${libdir}/${QT_DIR_NAME}/plugins/*/.debug"

