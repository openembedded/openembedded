
DEPENDS = "libxfce4util xfce-mcs-manager hal liburi-perl-native python-native"

inherit pkgconfig xfce

SRC_URI = "http://www.us.xfce.org/archive/xfce-4.4.1/src/exo-0.3.2.tar.bz2"

# Note: Python checking is broken

do_stage() {
    autotools_stage_all
}

FILES_${PN} += "${datadir}/xfce4/ \
                ${libdir}/xfce4/mcs-plugins/exo-preferred-applications-settings.so"
FILES_${PN}-dev += "${libdir}/xfce4/mcs-plugins/exo-preferred-applications-settings.*"
FILES_${PN}-dbg += "${libdir}/xfce4/mcs-plugins/.debug/exo-preferred-applications-settings.*"
