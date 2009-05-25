# Originally brought to you by the Angstrom Distribution

#############################################################################
# TOOLCHAIN VERSION SETTINGS
#############################################################################

# Base line versions, good for most things
PREFERRED_GCC_VERSION                ?= "4.2.4"
PREFERRED_BINUTILS                   ?= "2.18"

# Prefer glibc 2.6 and uclibc 0.9.30, these have had the most testing.
PREFERRED_VERSION_glibc             ?= "2.6.1"
PREFERRED_VERSION_glibc-initial     ?= "2.6.1"
PREFERRED_VERSION_uclibc            ?= "0.9.30"
PREFERRED_VERSION_uclibc-initial    ?= "0.9.30"

# Some systems need a special gcc version
PREFERRED_GCC_VERSION_486sx          ?= "4.3.2"
PREFERRED_GCC_VERSION_avr32          ?= "4.2.2"
PREFERRED_GCC_VERSION_armv7a         ?= "4.3.1" 
PREFERRED_GCC_VERSION_bfin           ?= "4.1.2"
PREFERRED_GCC_VERSION_ppc405         ?= "4.1.1"
PREFERRED_GCC_VERSION_xilinx-ml403   ?= "4.1.1"
PREFERRED_GCC_VERSION_xilinx-ml403   ?= "4.1.1"

# This is unrelated to the kernel version, but userspace apps (e.g. HAL) require a recent version to build against
PREFERRED_VERSION_linux-libc-headers = "2.6.23"

# Uncomment this if want need to build an armv7a kernel with CSL toolchain (<2.6.27 don't boot with mainline gcc)
#KERNEL_CCSUFFIX_armv7a= "-4.2.1+csl-arm-2007q3-53"

# Binutils
PREFERRED_VERSION_binutils           ?= "${PREFERRED_BINUTILS}"
PREFERRED_VERSION_binutils-cross     ?= "${PREFERRED_BINUTILS}"
PREFERRED_VERSION_binutils-cross-sdk ?= "${PREFERRED_BINUTILS}"

# Avr32 only has patches for binutils 2.17 in OE
PREFERRED_VERSION_binutils_avr32 =           "2.17"
PREFERRED_VERSION_binutils-cross_avr32 =     "2.17"
PREFERRED_VERSION_binutils-cross-sdk_avr32 = "2.17"

# Compiler versions
PREFERRED_VERSION_gcc                    ?= "${PREFERRED_GCC_VERSION}"
PREFERRED_VERSION_gcc-cross              ?= "${PREFERRED_GCC_VERSION}"
PREFERRED_VERSION_gcc-cross-sdk          ?= "${PREFERRED_GCC_VERSION}"
PREFERRED_VERSION_gcc-cross-initial      ?= "${PREFERRED_GCC_VERSION}"
PREFERRED_VERSION_gcc-cross-intermediate ?= "${PREFERRED_GCC_VERSION}"

# Compiler selection
PREFERRED_PROVIDER_virtual/${TARGET_PREFIX}binutils         = "binutils-cross"
PREFERRED_PROVIDER_virtual/${TARGET_PREFIX}gcc-initial      = "gcc-cross-initial"
PREFERRED_PROVIDER_virtual/${TARGET_PREFIX}gcc-intermediate = "gcc-cross-intermediate"
PREFERRED_PROVIDER_virtual/${TARGET_PREFIX}gcc              = "gcc-cross"
PREFERRED_PROVIDER_virtual/${TARGET_PREFIX}g++              = "gcc-cross"

# Others
PREFERRED_PROVIDER_linux-libc-headers = "linux-libc-headers"

#############################################################################
# TOOLCHAIN CUSTOMIZATION
#############################################################################

# Branding
TARGET_VENDOR = "-oe"

# ARM920T and up can use thumb mode to decrease binary size at the expense of speed
# (the complete story is a bit more nuanced due to cache starvation)
# Minimal turns on thumb for armv4t machine according to this RFC:
# http://lists.linuxtogo.org/pipermail/angstrom-distro-devel/2008-October/002714.html

# We can't set ARM_INSTRUCTION_SET_<override> directly since that will un-overridable in recipes like gcc
PREFERRED_ARM_INSTRUCTION_SET         ?=  "arm"
PREFERRED_ARM_INSTRUCTION_SET_armv4t   = "thumb"
PREFERRED_ARM_INSTRUCTION_SET_armv5te  = "thumb"
PREFERRED_ARM_INSTRUCTION_SET_armv5teb = "thumb"
ARM_INSTRUCTION_SET = "${PREFERRED_ARM_INSTRUCTION_SET}"
# "arm" "thumb"
#    The instruction set the compiler should use when generating application
#    code.  The kernel is always compiled with arm code at present.  arm code
#    is the original 32 bit ARM instruction set, thumb code is the 16 bit
#    encoded RISC sub-set.  Thumb code is smaller (maybe 70% of the ARM size)
#    but requires more instructions (140% for 70% smaller code) so may be
#    slower.

THUMB_INTERWORK = "yes"
# "yes" "no"
#    Whether to compile with code to allow interworking between the two
#    instruction sets.  This allows thumb code to be executed on a primarily
#    arm system and vice versa.  It is strongly recommended that DISTROs not
#    turn this off - the actual cost is very small.

# We don't want to keep OABI compat
ARM_KEEP_OABI = "0"

# ARM EABI is softfloat by default, but let's make sure :)
# make it overridable for platforms with FPU, like ep93xx or i.mx31
TARGET_FPU_arm ?= "soft"
TARGET_FPU_armeb ?= "soft"
TARGET_FPU_ixp4xx ?= "soft"
TARGET_FPU_ppc405 ?= "soft"

TARGET_FPU_armv6 ?= "hard"
TARGET_FPU_armv6-novfp ?= "soft"
TARGET_FPU_armv7a ?= "hard"
TARGET_FPU_ppc603e ?= "hard"

# webkit-gtk and cairo have alignment issues with double instructions on armv5 so
# disable them here. TODO: This knowledge should rather be encoded in the actual
# recipes!
TARGET_CC_ARCH_pn-webkit-gtk_armv5te = "-march=armv4t"
TARGET_CC_ARCH_pn-cairo_armv5te = "-march=armv4t"

#############################################################################
# C LIBRARY SETTINGS
#############################################################################

# Can be "glibc", "eglibc" or "uclibc"
LIBC ?= "glibc"
require conf/distro/include/${LIBC}.inc
PSTAGE_EXTRAPATH = "${LIBC}"
require conf/distro/include/sane-toolchain-${LIBC}.inc

# Generate locales on the buildsystem instead of on the target. Speeds up first boot, set to "1" to enable
PREFERRED_PROVIDER_qemu-native = "qemu-native"
ENABLE_BINARY_LOCALE_GENERATION ?= "1"

# We only want to build UTF8 locales
LOCALE_UTF8_ONLY = "1"

# Qemu doesn't like armv6/eabi/vfp
ENABLE_BINARY_LOCALE_GENERATION_armv6 = "0"
ENABLE_BINARY_LOCALE_GENERATION_armv6-novfp = "0"
ENABLE_BINARY_LOCALE_GENERATION_armv7a = "0"

#qemu has taken a dislike to armeb as well
ENABLE_BINARY_LOCALE_GENERATION_armeb = "0"

# This is needed to get a correct PACKAGE_ARCH for packages that have PACKAGE_ARCH = ${MACHINE_ARCH}
ARM_ABI ?= "${@['','oabi'][bb.data.getVar('MACHINE',d) in ['collie','h3600', 'h3800', 'simpad', 'htcwallaby']]}"
include conf/distro/include/sane-toolchain-${ARM_ABI}.inc
