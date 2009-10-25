DESCRIPTION="XFCE extensions and framework library with session management support"
DEPENDS = "libxfce4util hal liburi-perl-native python-native cairo"
SECTION = "x11"
PR = "r1"

inherit xfce46

XFCE_VERSION = "4.6.1"

SRC_URI += " \
    file://exo-0.3.105-iocharset.patch;patch=1 \
    file://exo-no-tests.patch;patch=1 \
    file://configure.patch;patch=1 \
"

# Note: Python checking is broken
do_configure_prepend() {
	sed -i -e s:'`$PKG_CONFIG --variable=defsdir pygtk-2.0`':\"${STAGING_DATADIR}/pygtk/2.0/defs\":g ${S}/configure.in
}

do_stage() {
    autotools_stage_all
}

FILES_${PN} += "${datadir}/xfce4/ \
                ${libdir}/python*/site-packages/* \
                ${prefix}/share/pygtk/2.0/defs/exo-0.3/exo.defs \
"

FILES_${PN}-dbg += "${libdir}/python*/site-packages/*/.debug/*"
