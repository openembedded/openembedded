DESCRIPTION = "Standard etk theme for the SHR distribution"
SECTION = "x11/data"
PV = "0.0.2+gitr${SRCPV}"
PR = "r1"

inherit shr autotools

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc"

pkg_postinst_${PN} () {
    update-alternatives --install ${datadir}/etk/themes/phoneguiEFL.edj etk-default.edj ${datadir}/shr-theme-brave/etk/phoneguiEFL.edj 50
    update-alternatives --install ${datadir}/elementary/themes/phoneguiEFL.edj elm-default.edj ${datadir}/shr-theme-brave/elm/phoneguiEFL.edj 50
}

pkg_postrm_${PN} () {
    update-alternatives --remove phoneguiEFL.edj ${datadir}/shr-theme-brave/etk/phoneguiEFL.edj
    update-alternatives --remove phoneguiEFL.edj ${datadir}/shr-theme-brave/elm/phoneguiEFL.edj
}

PACKAGE_ARCH = "all"

