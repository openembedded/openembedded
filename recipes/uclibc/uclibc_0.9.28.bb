require uclibc.inc
PR = "${INC_PR}.0"

# This is the correct KERNEL_SOURCE location, if the uClibc
# fix_includes.sh script is run (see nokernelheader.patch below)
# this must be correct.
KERNEL_SOURCE = "${STAGING_DIR_HOST}/${exec_prefix}"
PROVIDES += "virtual/${TARGET_PREFIX}libc-for-gcc"

S = "${WORKDIR}/uClibc-${PV}"

#*** PATCHES ***
#
# The nokernelheadercheck patch removes the check on the include
# files in ${KERNEL_SOURCE}, however this check seems to be
# functioning correct now so the patch is not included.  It may
# be necessary to add this for architectures which do not initially
# have a 'good' set of kernel header files in the cross directory.
#SRC_URI += "file://nokernelheadercheck.patch;apply=yes"
#
# Thumb support
#
# Thumb interworking support
THUMBSTUFF = " \
              file://thumb-defined-arm-or-thumb.patch;apply=yes \
              file://thumb-mov-pc-bx.patch;apply=yes \
              file://thumb-swi-r7.patch;apply=yes \
              file://thumb-sysnum-h.patch;apply=yes \
              file://thumb-asm-swi.patch;apply=yes \
              file://thumb-call-via-rx.patch;apply=yes \
              file://dl-startup.h.patch;apply=yes \
              file://dl-string.h.patch;apply=yes \
              file://dl-sysdep.h.patch;apply=yes \
              file://uclibc-libgcc-eh.patch;apply=yes \
             "

SRC_URI_append_arm = " ${THUMBSTUFF} "

#
# This is a core change and is controversial, maybe even wrong
# on some architectures
THUMB_INTERWORK_RESOLVE_PATCH = ""
THUMB_INTERWORK_RESOLVE_PATCH_thumb-interwork = " file://thumb-resolve.patch;apply=yes"
SRC_URI += " ${THUMB_INTERWORK_RESOLVE_PATCH}"


DEFAULT_PREFERENCE_avr32 = "6000"
SRC_URI_append_avr32 = " \
                        file://uclibc-makefile.patch;apply=yes \
                        file://remove-bogus-version-hack-and-just-use-asm-generic-if-it-exists.patch;apply=yes \
                        file://let-optimized-stringops-override-default-ones.patch;apply=yes \
                        file://fix-getrusage-argument-type.patch;apply=yes \
                        file://fix-__libc_fcntl64-varargs-prototype.patch;apply=yes \
                        file://fix-broken-__libc_open-declaration.patch;apply=yes \
                        file://avr32-arch-2.patch;apply=yes \
                        file://avr32-linkrelax-option.patch;apply=yes \
                        file://avr32-string-ops.patch;apply=yes \
                        file://no-create_module-on-avr32.patch;apply=yes \
                        file://ldso-always-inline-_dl_memcpy.patch;apply=yes \
                        file://ldso-define-MAP_FAILED.patch;apply=yes \
                        file://ldso-always-inline-syscalls.patch;apply=yes \
                        file://ldso-avr32-2.patch;apply=yes \
                        file://ldso-avr32-needs-CONSTANT_STRING_GOT_FIXUP.patch;apply=yes \
                        file://ldso-avr32-startup-hack.patch;apply=yes \
                        file://ldd-avr32-support.patch;apply=yes \
                        file://libpthread-avr32.patch;apply=yes \
                        file://sync-fcntl-h-with-linux-kernel.patch;apply=yes \
                       "
 
 
#file://uClibc-0.9.28-avr32-20060621.patch;apply=yes \
#file://uClibc-0.9.28-avr32-20061019.patch;apply=yes \
#file://uclibc-avr32-no-msoft-float.patch;apply=yes \

SRC_URI[uClibc-0.9.28.md5sum] = "1ada58d919a82561061e4741fb6abd29"
SRC_URI[uClibc-0.9.28.sha256sum] = "c8bc5383eafaa299e9874ae50acc6549f8b54bc29ed64a9a3387b3e4cd7f4bcb"
