DESCRIPTION = "GNOME menus"
SECTION = "x11/gnome"
LICENSE = "GPL"

DEPENDS = "python gnome-vfs libxml2 gconf popt gtk+"

inherit gnome pkgconfig python-dir

do_stage() {
	autotools_stage_all
}

PACKAGES += "${PN}-python"
FILES_${PN} += "${datadir}/desktop-directories/"
FILES_${PN}-python = "${libdir}/python*"
FILES_${PN}-dbg += "${PYTHON_SITEPACKAGES_DIR}/*/.debug \
                    ${PYTHON_SITEPACKAGES_DIR}/.debug"


SRC_URI[archive.md5sum] = "279316228fd84917acb9405476f74b53"
SRC_URI[archive.sha256sum] = "75e73554cd0b0a8356956e76ccb517def5382eafa7bdb14336499cd271570dbc"
