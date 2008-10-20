DESCRIPTION = "Hippocanvas"
LICENSE = "LGPLv2"

DEPENDS = "librsvg python-pygtk2"

inherit gnome

DEPENDS += "librsvg"

do_configure_prepend() {
	sed -i -e s:'`$PKG_CONFIG --variable=defsdir pygtk-2.0`':\"${STAGING_DATADIR}/pygtk/2.0/defs\":g ${S}/configure.ac
}


AUTOTOOLS_STAGE_PKGCONFIG = "1"
do_stage() {
        autotools_stage_all
}

FILES_${PN} += "${libdir}/python*/site-packages"
FILES_${PN}-dbg += "${libdir}/python*/site-packages/.debug"


