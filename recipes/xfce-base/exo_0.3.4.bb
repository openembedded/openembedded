DEPENDS = "libxfce4util xfce-mcs-manager hal liburi-perl-native python-native"

inherit xfce
XFCE_VERSION = 4.4.2

SRC_URI += " file://configure.patch;patch=1"
SRC_URI += " file://exo-no-tests.patch;patch=1"

# Note: Python checking is broken
do_configure_prepend() {
	sed -i -e s:'`$PKG_CONFIG --variable=defsdir pygtk-2.0`':\"${STAGING_DATADIR}/pygtk/2.0/defs\":g ${S}/configure.in
}

do_stage() {
    autotools_stage_all
}

FILES_${PN} += "${datadir}/xfce4/ \
                ${libdir}/xfce4/mcs-plugins/exo-preferred-applications-settings.so"
FILES_${PN}-dev += "${libdir}/xfce4/mcs-plugins/exo-preferred-applications-settings.*"
FILES_${PN}-dbg += "${libdir}/xfce4/mcs-plugins/.debug/exo-preferred-applications-settings.*"

SRC_URI[md5sum] = "7a1af943b1df32b6f89ae91823118a22"
SRC_URI[sha256sum] = "a5373e9bd6055caa7cd5d06128f6236cfd2f4f6657ea4a85d7bd9eafe5bf0538"
