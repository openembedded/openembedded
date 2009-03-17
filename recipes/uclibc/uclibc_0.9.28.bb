DEFAULT_PREFERENCE = "1"
PR = "r17"

require uclibc.inc

# This is the correct KERNEL_SOURCE location, if the uClibc
# fix_includes.sh script is run (see nokernelheader.patch below)
# this must be correct.
KERNEL_SOURCE = "${STAGING_DIR_HOST}/${exec_prefix}"
PROVIDES += "virtual/${TARGET_PREFIX}libc-for-gcc"

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
              file://uclibc-libgcc-eh.patch;patch=1 \
             "

SRC_URI_append_arm = " ${THUMBSTUFF} "

#
# This is a core change and is controversial, maybe even wrong
# on some architectures
THUMB_INTERWORK_RESOLVE_PATCH = ""
THUMB_INTERWORK_RESOLVE_PATCH_thumb-interwork = " file://thumb-resolve.patch;patch=1"
SRC_URI += " ${THUMB_INTERWORK_RESOLVE_PATCH}"


DEFAULT_PREFERENCE_avr32 = "6000"
SRC_URI_append_avr32 = " \
                        file://uclibc-makefile.patch;patch=1 \
                        file://remove-bogus-version-hack-and-just-use-asm-generic-if-it-exists.patch;patch=1 \
                        file://let-optimized-stringops-override-default-ones.patch;patch=1 \
                        file://fix-getrusage-argument-type.patch;patch=1 \
                        file://fix-__libc_fcntl64-varargs-prototype.patch;patch=1 \
                        file://fix-broken-__libc_open-declaration.patch;patch=1 \
                        file://avr32-arch-2.patch;patch=1 \
                        file://avr32-linkrelax-option.patch;patch=1 \
                        file://avr32-string-ops.patch;patch=1 \
                        file://no-create_module-on-avr32.patch;patch=1 \
                        file://ldso-always-inline-_dl_memcpy.patch;patch=1 \
                        file://ldso-define-MAP_FAILED.patch;patch=1 \
                        file://ldso-always-inline-syscalls.patch;patch=1 \
                        file://ldso-avr32-2.patch;patch=1 \
                        file://ldso-avr32-needs-CONSTANT_STRING_GOT_FIXUP.patch;patch=1 \
                        file://ldso-avr32-startup-hack.patch;patch=1 \
                        file://ldd-avr32-support.patch;patch=1 \
                        file://libpthread-avr32.patch;patch=1 \
                        file://sync-fcntl-h-with-linux-kernel.patch;patch=1 \
                       "
 
 
#file://uClibc-0.9.28-avr32-20060621.patch;patch=1 \
#file://uClibc-0.9.28-avr32-20061019.patch;patch=1 \
#file://uclibc-avr32-no-msoft-float.patch;patch=1 \

