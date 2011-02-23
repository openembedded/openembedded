DESCRIPTION = "parted, the GNU partition resizing program"
HOMEPAGE = "http://www.gnu.org/software/parted/parted.html"
LICENSE = "GPLv3"
SECTION = "console/tools"
DEPENDS = "readline util-linux-ng lvm2"
PR = "r1"

SRC_URI = "${GNU_MIRROR}/parted/parted-${PV}.tar.gz \
           file://use_llseek_syscall.patch \
           file://fix-MiB-handling.patch \
          "
           
EXTRA_OECONF = "--disable-Werror ac_cv_func_calloc_0_nonnull=yes"

inherit autotools pkgconfig

SRC_URI[md5sum] = "30ceb6df7e8681891e865e2fe5a7903d"
SRC_URI[sha256sum] = "e81fa140805b5cd029ff6dda5cfa94d223e83ac182ebcae94f841d62ce468829"
