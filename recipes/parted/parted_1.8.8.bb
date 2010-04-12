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

SRC_URI[md5sum] = "0d494591731082ec57cc18627728124a"
SRC_URI[sha256sum] = "db59b77b7ef46f00d83eddedde8a4126bffa6bff5fa94a335dd5d30bf72d4286"
