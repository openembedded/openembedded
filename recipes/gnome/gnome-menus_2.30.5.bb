DESCRIPTION = "GNOME menus"
SECTION = "x11/gnome"
LICENSE = "GPL"

DEPENDS = "python gnome-vfs libxml2 gconf popt gtk+"

inherit gnome pkgconfig python-dir

PACKAGES += "${PN}-python"
FILES_${PN} += "${datadir}/desktop-directories/"
FILES_${PN}-python = "${libdir}/python*"
FILES_${PN}-dbg += "${PYTHON_SITEPACKAGES_DIR}/*/.debug \
                    ${PYTHON_SITEPACKAGES_DIR}/.debug"

SRC_URI[archive.md5sum] = "caa6772e63ed5870cf43dc3d354e0624"
SRC_URI[archive.sha256sum] = "6dcc565006d6e8c2025ae83ab1f82edf6bd04d61c804c0dc9bf5ea50629c4caa"

