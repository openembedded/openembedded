require libwmf_0.2.8.4.bb
inherit native

SRC_URI = "${SOURCEFORGE_MIRROR}/wvware/${PN}/${PV}/libwmf-${PV}.tar.gz;name=tarball \
           file://libwmf-0.2.8.4-intoverflow.patch;patch=1                   \
           file://libwmf-0.2.8.4-useafterfree.patch;patch=1"
