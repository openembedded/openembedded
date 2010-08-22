DESCRIPTION = "Documentation system for on-line information and printed output"
HOMEPAGE = "http://www.gnu.org/software/texinfo/"
SECTION = "console/utils"
LICENSE = "GPLv3"
DEPENDS = "ncurses"
PR = "r1"
SRC_URI = "${GNU_MIRROR}/texinfo/texinfo-${PV}.tar.gz \
           file://gettext.patch \
          "
SRC_URI[md5sum] = "71ba711519209b5fb583fed2b3d86fcb"
SRC_URI[sha256sum] = "1303e91a1c752b69a32666a407e9fbdd6e936def4b09bc7de30f416301530d68"

inherit autotools gettext

S = "${WORKDIR}/texinfo-4.13/"

do_compile_prepend() {
    oe_runmake -C tools/gnulib/lib
}

do_install_append() {
    rm -f ${D}${libdir}/charset.alias
}
