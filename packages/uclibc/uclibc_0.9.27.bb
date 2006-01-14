DEFAULT_PREFERENCE = "1"
PR = "r7"

include uclibc.inc

# This patch removes the typedef of __kernel_key_t from
# include/bits/ipc.h.  Because this removes a typedef some
# packages which relied on it (erroneously - it is defined
# in include/linux/posix_types.h and is internal) may stop
# building.  The patch has only been verified on IXP4XX builds.
PATCH_ipc_h ?= ""
PATCH_ipc_h_ixp4xx = "file://kernel-key-t-ipc.h.patch;patch=1"

SRC_URI += "http://www.uclibc.org/downloads/uClibc-${PV}.tar.bz2 \
            file://dyn-ldconfig.patch;patch=1 \
            file://nokernelheadercheck.patch;patch=1"
SRC_URI += " file://armeb-kernel-stat.h.patch;patch=1"
SRC_URI += "${PATCH_ipc_h}"
SRC_URI += " file://thumb-swi.patch;patch=1"
SRC_URI += " file://thumb-swp.patch;patch=1"
SRC_URI += " file://arm-thumb-defined.patch;patch=1"

# ARM thumb interworking - these changes fix various bugs in the
# uclibc implementation of thumb interwork support, but they are
# insufficient on their own - it is also necessary (at present)
# to *disable* the uClibc ARM specific string code (the assembler
# doesn't support interworking).  Since these patches do actually
# change the non-interwork case and make things incompatible with
# older (pre armv4t) ARMs they are condition on the thumb-interwork
# override (i.e. the *distro* has to add this to OVERRIDES).
ARM_THUMB_INTERWORK_PATCHES = ""
ARM_THUMB_INTERWORK_PATCHES_thumb-interwork = ""
ARM_THUMB_INTERWORK_PATCHES_thumb-interwork += " file://thumb-ldso-dlboot.patch;patch=1"
ARM_THUMB_INTERWORK_PATCHES_thumb-interwork += " file://thumb-interwork-asm.patch;patch=1"
# See the comments in the patch - this doesn't work.
#ARM_THUMB_INTERWORK_PATCHES_thumb-interwork += " file://thumb-static-main.patch;patch=1"
SRC_URI += "${ARM_THUMB_INTERWORK_PATCHES}"

S = "${WORKDIR}/uClibc-${PV}"
