DESCRIPTION = "parted, the GNU partition resizing program"
HOMEPAGE = "http://www.gnu.org/software/parted/parted.html"
LICENSE = "GPLv2"
SECTION = "console/tools"
DEPENDS = "readline e2fsprogs-libs"
PR = "r2"

SRC_URI = "${GNU_MIRROR}/parted/parted-${PV}.tar.gz \
           file://syscalls.h \
           file://syscalls.patch;patch=1 \
           file://cross-gross-hack.patch;patch=1"
           
EXTRA_OECONF = "--disable-Werror"

inherit autotools pkgconfig

do_configure_prepend() {
	cp ${WORKDIR}/syscalls.h ${S}/libparted/arch/
}

do_configure() {
        gnu-configize
        libtoolize --force
        autoconf
        oe_runconf
}

do_stage() {
	autotools_stage_all
}
