# uclibc:
#fix some iconv issues, needs to be adjusted when doing uclibc builds
PREFERRED_PROVIDER_virtual/libc = "uclibc"
PREFERRED_PROVIDER_virtual/libiconv ?= "libiconv"
PREFERRED_PROVIDER_virtual/libintl ?= "proxy-libintl"
PREFERRED_PROVIDER_virtual/${TARGET_PREFIX}libc-for-gcc = "uclibc"
PREFERRED_PROVIDER_virtual/arm-angstrom-linux-uclibcgnueabi-libc-for-gcc    = "uclibc-initial"
PREFERRED_PROVIDER_virtual/armeb-angstrom-linux-uclibcgnueabi-libc-for-gcc  = "uclibc-initial"

PREFERRED_PROVIDER_virtual/${TARGET_PREFIX}binutils = "binutils-cross"
PREFERRED_PROVIDER_linux-libc-headers = "linux-libc-headers"

USE_NLS ?= "no"
USE_NLS_glib-2.0 = "yes"
USE_NLS_glib-2.0-native = "yes"

TARGET_OS_UC = "linux${@['-uclibc','-uclibcgnueabi'][bb.data.getVar('TARGET_ARCH',d,1) in ['arm', 'armeb'] and bb.data.getVar('MACHINE',d) not in ['collie','h3600', 'h3800', 'simpad', 'htcwallaby']]}"
TARGET_OS = "${@['${TARGET_OS_UC}', 'uclinux-uclibc'][bb.data.getVar('TARGET_ARCH',d)  in ['bfin']]}"

#mess with compiler flags to use -Os instead of -O2
#Please see http://free-electrons.com/doc/embedded_linux_optimizations/img47.html for some more info
FULL_OPTIMIZATION = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -Os"
BUILD_OPTIMIZATION = "-Os"

#Gcc will die with 'internal consistency error when using the above optimizations
#with gcc-4.2.1-atmel.1.0.3 (and probably most other avr32 gcc ports).
#However, some packages require optimizations to compile (e.g. libmad).
#It appears the guilty optimization is "-frename-registers", leaving that one 
#out allows the build to proceed normally.  -fexpensive-optimizations may be OK,
#it was removed while debugging an issue that ultimately turned out to be due
#to the ICE fixed by gcc-pr32889.patch.  It needs to be tested again. 
#Note that this testing was done without the gcc-pr32889.patch.
FULL_OPTIMIZATION_avr32 = "-Os -fomit-frame-pointer"

TARGET_LINK_HASH_STYLE = "-Wl,--hash-style=gnu"

CXXFLAGS += "-fvisibility-inlines-hidden"

