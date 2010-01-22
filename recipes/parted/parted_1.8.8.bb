DESCRIPTION = "parted, the GNU partition resizing program"
HOMEPAGE = "http://www.gnu.org/software/parted/parted.html"
LICENSE = "GPLv3"
SECTION = "console/tools"
DEPENDS = "readline util-linux-ng"
PR = "r3"

SRC_URI = "${GNU_MIRROR}/parted/parted-${PV}.tar.gz \
	   file://use_llseek_syscall.patch;patch=1 \
	   file://parted-1.8.x.patch;patch=1 \
"
           
EXTRA_OECONF = "--disable-Werror ac_cv_func_calloc_0_nonnull=yes"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}
