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

