require xextproto_7.0.5.bb
PR = "${INC_PR}.1"

EXTRA_OECONF += "--includedir=${includedir}/xextproto-70"

do_install_append() {
        rm -r ${D}${libdir}
}

# Build of xserver-kdrive is not possible with xextproto >= 7.1.
# This package allows to install old 7.0 includes in parallel.
BPN = "xextproto"

# No, we really do not want to install .pc file and overwrite newer one:
pkgconfig_sysroot_preprocess() {
}
