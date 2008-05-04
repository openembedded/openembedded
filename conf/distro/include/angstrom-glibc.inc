# glibc:
PREFERRED_PROVIDER_virtual/libiconv ?= "glibc"
PREFERRED_PROVIDER_virtual/libintl ?= "glibc"
PREFERRED_PROVIDER_virtual/libc ?= "glibc"
PREFERRED_PROVIDER_virtual/${TARGET_PREFIX}libc-initial ?= "glibc-initial"
PREFERRED_PROVIDER_linux-libc-headers ?= "linux-libc-headers"

#Set preferred provider for the C library that is used to build the crosscompiler (NPTL voodoo)
PREFERRED_PROVIDER_virtual/${TARGET_PREFIX}libc-for-gcc               = "glibc-intermediate"
PREFERRED_PROVIDER_virtual/arm-angstrom-linux-gnueabi-libc-for-gcc    = "glibc-intermediate"
PREFERRED_PROVIDER_virtual/armeb-angstrom-linux-gnueabi-libc-for-gcc  = "glibc-intermediate"
PREFERRED_PROVIDER_virtual/arm-angstrom-linux-libc-for-gcc            = "glibc-intermediate"
PREFERRED_PROVIDER_virtual/powerpc-angstrom-linux-libc-for-gcc        = "glibc-intermediate"
PREFERRED_PROVIDER_virtual/mipsel-angstrom-linux-libc-for-gcc         = "glibc-intermediate"
PREFERRED_PROVIDER_virtual/sparc-angstrom-linux-libc-for-gcc          = "glibc-intermediate"


TARGET_OS = "linux${@['','-gnueabi'][bb.data.getVar('TARGET_ARCH',d,1) in ['arm', 'armeb'] and bb.data.getVar('MACHINE',d) not in ['collie','h3600', 'h3800', 'simpad', 'htcwallaby']]}"

#mess with compiler flags to use -Os instead of -O2
#Please see http://free-electrons.com/doc/embedded_linux_optimizations/img47.html for some more info
# perl has some problems, see http://bugs.openembedded.org/show_bug.cgi?id=1616
# [23:00] oxo: glibc (any version) on sparc does not like (repeat me) "-Os"

FULL_OPTIMIZATION = "-fexpensive-optimizations -frename-registers -fomit-frame-pointer -Os"
FULL_OPTIMIZATION_pn-perl = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -O1"
FULL_OPTIMIZATION_pn-glibc-intermediate = "-O2"
FULL_OPTIMIZATION_pn-glibc = "-fexpensive-optimizations -fomit-frame-pointer -O2"
FULL_OPTIMIZATION_sparc = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -O2"

FULL_OPTIMIZATION_armv7a = "-fexpensive-optimizations -ftree-vectorize -fomit-frame-pointer -O2" 

BUILD_OPTIMIZATION = "-Os"
BUILD_OPTIMIZATION_pn-perl = "-O1"
BUILD_OPTIMIZATION_pn-glibc-intermediate = "-O2"
BUILD_OPTIMIZATION_pn-glibc = "-O2"
BUILD_OPTIMIZATION_sparc = "-O2"

CXXFLAGS += "-fvisibility-inlines-hidden"

