DEPENDS = "python gnome-vfs libxml2 gconf popt gtk+"
LICENSE = "GPL"

inherit gnome pkgconfig python-dir

do_stage() {
autotools_stage_all
}

PACKAGES += "${PN}-python"
FILES_${PN} += "${datadir}/desktop-directories/"
FILES_${PN}-python = "${libdir}/python*"
FILES_${PN}-dbg += "${PYTHON_SITEPACKAGES_DIR}/*/.debug \
                    ${PYTHON_SITEPACKAGES_DIR}/.debug"


SRC_URI[archive.md5sum] = "55fd07e67d8334de2e03e4e23c011452"
SRC_URI[archive.sha256sum] = "84a97b6d74b14e27888a0f54759e570cb701400c5b176471871bc08a6acafb15"
