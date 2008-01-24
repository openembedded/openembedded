DEFAULT_PREFERENCE = "1"
PR = "r9"

require uclibc.inc

# This is the correct KERNEL_SOURCE location, if the uClibc
# fix_includes.sh script is run (see nokernelheader.patch below)
# this must be correct.
KERNEL_SOURCE = "${CROSS_DIR}/${TARGET_SYS}"

SRC_URI += "http://www.uclibc.org/downloads/uClibc-${PV}.tar.bz2"

S = "${WORKDIR}/uClibc-${PV}"

#*** PATCHES ***
#
# The nokernelheadercheck patch removes the check on the include
# files in ${KERNEL_SOURCE}, however this check seems to be
# functioning correct now so the patch is not included.  It may
# be necessary to add this for architectures which do not initially
# have a 'good' set of kernel header files in the cross directory.
#SRC_URI += "file://nokernelheadercheck.patch;patch=1"
#
# Thumb support
#
# Thumb interworking support
THUMBSTUFF = " \
              file://thumb-defined-arm-or-thumb.patch;patch=1 \
              file://thumb-mov-pc-bx.patch;patch=1 \
              file://thumb-swi-r7.patch;patch=1 \
              file://thumb-sysnum-h.patch;patch=1 \
              file://thumb-asm-swi.patch;patch=1 \
              file://thumb-call-via-rx.patch;patch=1 \
              file://dl-startup.h.patch;patch=1 \
              file://dl-string.h.patch;patch=1 \
              file://dl-sysdep.h.patch;patch=1 \
             "

SRC_URI_append_arm = " ${THUMBSTUFF} "

#
# This is a core change and is controversial, maybe even wrong
# on some architectures
THUMB_INTERWORK_RESOLVE_PATCH = ""
THUMB_INTERWORK_RESOLVE_PATCH_thumb-interwork = " file://thumb-resolve.patch;patch=1"
SRC_URI += " ${THUMB_INTERWORK_RESOLVE_PATCH}"


DEFAULT_PREFERENCE_avr32 = "6000"
SRC_URI_append_avr32 = " http://avr32linux.org/twiki/pub/Main/MicroClibcPatches/uClibc-0.9.28-avr1.patch.bz2;patch=1 "


