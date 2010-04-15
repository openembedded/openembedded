DEPENDS = "python gnome-vfs libxml2 gconf popt gtk+"
LICENSE = "GPL"

inherit gnome pkgconfig python-dir

PACKAGES += "${PN}-python"
FILES_${PN} += "${datadir}/desktop-directories/"
FILES_${PN}-python = "${libdir}/python*"
FILES_${PN}-dbg += "${PYTHON_SITEPACKAGES_DIR}/*/.debug \
                    ${PYTHON_SITEPACKAGES_DIR}/.debug"

SRC_URI[archive.md5sum] = "2bb185643632b28f4dba4b8201b8e230"
SRC_URI[archive.sha256sum] = "b3ef17eb05308e35e1627e5ca56b6951e9aea69cf112164ef698cdad6f44ed23"
