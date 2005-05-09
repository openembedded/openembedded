DEFAULT_PREFERENCE = "1"
PR = "r5"

include uclibc.inc

# This patch removes the typedef of __kernel_key_t from
# include/bits/ipc.h.  Because this removes a typedef some
# packages which relied on it (erroneously - it is defined
# in include/linux/posix_types.h and is internal) may stop
# building.  The patch has only been verified on NSLU2 builds.
PATCH_ipc_h ?=
PATCH_ipc_h_nslu2 = "file://kernel-key-t-ipc.h.patch;patch=1"

SRC_URI += "http://www.uclibc.org/downloads/uClibc-${PV}.tar.bz2 \
            file://dyn-ldconfig.patch;patch=1 \
            file://nokernelheadercheck.patch;patch=1"
SRC_URI += " file://armeb-kernel-stat.h.patch;patch=1"
SRC_URI += ${PATCH_ipc_h}
S = "${WORKDIR}/uClibc-${PV}"
