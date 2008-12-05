DESCRIPTION = "parted, the GNU partition resizing program"
HOMEPAGE = "http://www.gnu.org/software/parted/parted.html"
LICENSE = "GPLv3"
SECTION = "console/tools"
DEPENDS = "readline e2fsprogs-libs"

SRC_URI = "${GNU_MIRROR}/parted/parted-${PV}.tar.gz \
           file://syscalls.h \
           file://syscalls.patch;patch=1 \
"
           
EXTRA_OECONF = "--disable-Werror"

inherit autotools pkgconfig

do_configure_prepend() {
	cp ${WORKDIR}/syscalls.h ${S}/libparted/arch/
}

do_stage() {
	autotools_stage_all
}
