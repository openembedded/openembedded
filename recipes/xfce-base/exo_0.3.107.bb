DESCRIPTION="Xfce extensions and framework library with session management support"
DEPENDS = "libxfce4util hal liburi-perl-native python-native cairo"
SECTION = "x11"
PR = "r1"

inherit xfce46 python-dir

XFCE_VERSION = "4.6.2"

SRC_URI += " \
    file://exo-no-tests.patch \
    file://configure.patch \
"

# Note: Python checking is broken
do_configure_prepend() {
	sed -i -e s:'`$PKG_CONFIG --variable=defsdir pygtk-2.0`':\"${STAGING_DATADIR}/pygtk/2.0/defs\":g ${S}/configure.in
}

FILES_${PN} += "${datadir}/xfce4/ \
                ${PYTHON_SITEPACKAGES_DIR}/* \
                ${prefix}/share/pygtk/2.0/defs/exo-0.3/exo.defs \
"

FILES_${PN}-dbg += "${PYTHON_SITEPACKAGES_DIR}/*/.debug/*"

SRC_URI[md5sum] = "3a92cca0c99ee940db4410891c9e8498"
SRC_URI[sha256sum] = "0a12ac124bad67c8de7135f7052641239ed640884a71612930f99c425bede2a3"
