DEPENDS = "python gnome-vfs libxml2 gconf popt gtk+"
LICENSE = "GPL"

inherit gnome pkgconfig python-dir

PACKAGES += "${PN}-python"
FILES_${PN} += "${datadir}/desktop-directories/"
FILES_${PN}-python = "${libdir}/python*"
FILES_${PN}-dbg += "${PYTHON_SITEPACKAGES_DIR}/*/.debug \
                    ${PYTHON_SITEPACKAGES_DIR}/.debug"

SRC_URI[archive.md5sum] = "1816a0d21ef99d5b3a8bcd033c88f732"
SRC_URI[archive.sha256sum] = "f19ac5af961be1d6244f9526311af8a67518c7403ef71209dcee94b68f77d58e"
