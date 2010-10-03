DESCRIPTION = "The GNU Compact Disc Input and Control library (libcdio) contains a library for CD-ROM and CD image access."
HOMEPAGE = "http://www.gnu.org/software/libcdio/"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPLv3+"
DEPENDS = "ncurses"
INC_PR = "r1"

SRC_URI = "${GNU_MIRROR}/${PN}/${P}.tar.gz"

inherit autotools

EXTRA_OECONF = "ac_cv_member_struct_tm_tm_gmtoff=no"

PACKAGES += "${PN}-utils"

FILES_${PN} = "${libdir}/lib${PN}${SOLIB}"
FILES_${PN}-utils = "${bindir}/*"

python populate_packages_prepend () {
        glibdir = bb.data.expand('${libdir}', d)
        do_split_packages(d, glibdir, '^lib(.*)\.so\..*', 'lib%s', 'gstreamer %s library', extra_depends='', allow_links=True)
}
