DESCRIPTION = "Hippocanvas"
LICENSE = "LGPLv2"

DEPENDS = "librsvg python-pygtk2"

inherit gnome python-dir

DEPENDS += "librsvg"

do_configure_prepend() {
	sed -i -e s:'`$PKG_CONFIG --variable=defsdir pygtk-2.0`':\"${STAGING_DATADIR}/pygtk/2.0/defs\":g ${S}/configure.ac
}


AUTOTOOLS_STAGE_PKGCONFIG = "1"
do_stage() {
        autotools_stage_all
}

FILES_${PN} += "${PYTHON_SITEPACKAGES_DIR}"
FILES_${PN}-dbg += "${PYTHON_SITEPACKAGES_DIR}/.debug"


