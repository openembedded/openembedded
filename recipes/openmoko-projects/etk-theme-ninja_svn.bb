DESCRIPTION = "Ninja - Etk theme"
HOMEPAGE = "http://ninja.projects.openmoko.org/"
SECTION = "openmoko/misc"
LICENSE = "GPL"
DEPENDS = "edje"
SRCREV = "5"
PV = "0.0.1+svnr${SRCPV}"
PR = "r1"
SRC_URI = "svn://svn.projects.openmoko.org/svnroot/ninja;module=trunk;proto=http"

S = "${WORKDIR}/trunk"

inherit autotools pkgconfig

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc"

PACKAGE_ARCH = "all"
# All of this package is just data, doesn't need dev,dbg package
PACKAGES = "${PN}"

FILES_${PN} += "${datadir}/ninja/default.edj"

pkg_postinst_${PN} () {
        update-alternatives --install ${datadir}/etk/themes/default.edj etk-default.edj ${datadir}/ninja/default.edj 50
}
pkg_postrm_${PN} () {
        update-alternatives --remove etk-default.edj ${datadir}/ninja/default.edj
}
