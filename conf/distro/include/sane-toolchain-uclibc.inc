# Originally brought to you by the Angstrom Distribution

# uclibc:

PREFERRED_PROVIDER_virtual/${TARGET_PREFIX}binutils = "binutils-cross"
PREFERRED_PROVIDER_virtual/${TARGET_PREFIX}libc-for-gcc = "uclibc"
PREFERRED_PROVIDER_linux-libc-headers = "linux-libc-headers"
PREFERRED_PROVIDER_virtual/libc         = "uclibc"
PREFERRED_PROVIDER_linux-libc-headers   = "linux-libc-headers"
PREFERRED_PROVIDER_virtual/libintl      = "proxy-libintl"
PREFERRED_PROVIDER_virtual/libiconv     = "libiconv"

USE_NLS ?= "no"
USE_NLS_glib-2.0-native = "yes"
USE_NLS_gcc-cross = "no"

PREFERRED_VERSION_uclibc                    ?= "${PREFERRED_UCLIBC_VERSION}"
PREFERRED_VERSION_uclibc-initial            ?= "${PREFERRED_UCLIBC_VERSION}"
PREFERRED_VERSION_uclibc-cross              ?= "${PREFERRED_UCLIBC_VERSION}"
PREFERRED_VERSION_uclibc-cross-sdk          ?= "${PREFERRED_UCLIBC_VERSION}"
PREFERRED_VERSION_uclibc-cross-initial      ?= "${PREFERRED_UCLIBC_VERSION}"
PREFERRED_VERSION_uclibc-cross-intermediate ?= "${PREFERRED_UCLIBC_VERSION}"

#mess with compiler flags to use -Os instead of -O2
#Please see http://free-electrons.com/doc/embedded_linux_optimizations/img47.html for some more info
FULL_OPTIMIZATION = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -Os -pipe"
BUILD_OPTIMIZATION += "-pipe"

# -Os compiled root file system does not boot for powerpc, root cause it still at large
# we use -O2 meanwhile
FULL_OPTIMIZATION_powerpc = "-O2 -pipe"

#Gcc will die with 'internal consistency error when using the above optimizations
#with gcc-4.2.1-atmel.1.0.3 (and probably most other avr32 gcc ports).
#However, some packages require optimizations to compile (e.g. libmad).
#It appears the guilty optimization is "-frename-registers", leaving that one 
#out allows the build to proceed normally.  -fexpensive-optimizations may be OK,
#it was removed while debugging an issue that ultimately turned out to be due
#to the ICE fixed by gcc-pr32889.patch.  It needs to be tested again. 
#Note that this testing was done without the gcc-pr32889.patch.
FULL_OPTIMIZATION_avr32 = "-Os -fomit-frame-pointer"

TARGET_LINK_HASH_STYLE = "${@['-Wl,--hash-style=gnu',''][bb.data.getVar('TARGET_ARCH',d,1) in ['mips', 'mipsel', 'mips64', 'mips64el', 'avr32']]}"

CXXFLAGS += "-fvisibility-inlines-hidden"


