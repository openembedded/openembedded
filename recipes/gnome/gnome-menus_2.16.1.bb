DEPENDS = "python gnome-vfs libxml2 gconf popt gtk+"
LICENSE = "GPL"

PR = "r1"

inherit gnome pkgconfig python-dir

do_stage() {
autotools_stage_all
}

PACKAGES += "${PN}-python"
FILES_${PN} += "${datadir}/desktop-directories/"
FILES_${PN}-python = "${libdir}/python*"
FILES_${PN}-dbg += "${PYTHON_SITEPACKAGES_DIR}/*/.debug \
                    ${PYTHON_SITEPACKAGES_DIR}/.debug"


SRC_URI[archive.md5sum] = "a5c467abe68003d23ec09a795ebfd29f"
SRC_URI[archive.sha256sum] = "72238f33406ada505fde8555ff93c00e7fec055a41500339b434c5445b09c87b"
