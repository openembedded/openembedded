DESCRIPTION = "Standard etk theme for the SHR distribution"
HOMEPAGE = "http://shr-project.org/"
LICENSE = "GPL"
SECTION = "x11/data"
PV = "0.0.2+gitr${SRCPV}"
PR = "r2"

inherit autotools

SRC_URI = "git://git.shr-project.org/repo/shr.git;protocol=http;branch=master"
S = "${WORKDIR}/git/${PN}"

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

