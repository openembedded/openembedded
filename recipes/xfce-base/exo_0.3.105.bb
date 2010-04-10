DESCRIPTION="XFCE extensions and framework library with session management support"
DEPENDS = "libxfce4util hal liburi-perl-native python-native cairo"
SECTION = "x11"
PR = "r1"

inherit xfce46 python-dir

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
                ${PYTHON_SITEPACKAGES_DIR}/* \
                ${prefix}/share/pygtk/2.0/defs/exo-0.3/exo.defs \
"

FILES_${PN}-dbg += "${PYTHON_SITEPACKAGES_DIR}/*/.debug/*"

SRC_URI[md5sum] = "ba87f84894498bf23ae39d849c55f98c"
SRC_URI[sha256sum] = "278f702d890c89bd3923ce1bdaf29bd9f2c800c2e4cfd9e902d99663bba337e5"
