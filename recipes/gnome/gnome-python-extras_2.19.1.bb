LICENSE = "GPL/LGPL"
DEPENDS = "python-pygtk libwnck"

inherit gnome distutils-base

SRC_URI += "file://acinclude.m4"

do_configure_prepend() {
        install -m 0644 ${WORKDIR}/acinclude.m4 ${S}/
}

do_configure_prepend() {
	sed -i -e s:'`$PKG_CONFIG --variable=defsdir pygtk-2.0`':\"${STAGING_DATADIR}/pygtk/2.0/defs\":g ${S}/configure.ac
}	

AUTOTOOLS_STAGE_PKGCONFIG = "1"
do_stage() {
	autotools_stage_all
}	

FILES_${PN}-dev += "${datadir}/pygtk"
