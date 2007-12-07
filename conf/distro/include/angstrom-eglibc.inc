# eglibc:
PREFERRED_PROVIDER_virtual/libiconv = "eglibc"
PREFERRED_PROVIDER_virtual/libintl = "eglibc"
PREFERRED_PROVIDER_virtual/libc = "eglibc"
PREFERRED_PROVIDER_virtual/${TARGET_PREFIX}libc-initial = "eglibc-initial"

PREFERRED_PROVIDER_virtual/${TARGET_PREFIX}libc-for-gcc               = "eglibc-intermediate"
PREFERRED_PROVIDER_virtual/arm${TARGET_VENDOR}-linux-gnueabi-libc-for-gcc    = "eglibc-intermediate"
PREFERRED_PROVIDER_virtual/armeb${TARGET_VENDOR}-linux-gnueabi-libc-for-gcc  = "eglibc-intermediate"
PREFERRED_PROVIDER_virtual/arm${TARGET_VENDOR}-linux-libc-for-gcc            = "eglibc-intermediate"
PREFERRED_PROVIDER_virtual/powerpc${TARGET_VENDOR}-linux-libc-for-gcc        = "eglibc-intermediate"
PREFERRED_PROVIDER_virtual/mipsel${TARGET_VENDOR}-linux-libc-for-gcc         = "eglibc-intermediate"
PREFERRED_PROVIDER_virtual/sparc${TARGET_VENDOR}-linux-libc-for-gcc          = "eglibc-intermediate"

TARGET_OS = "linux${@['','-gnueabi'][bb.data.getVar('TARGET_ARCH',d,1) in ['arm', 'armeb'] and bb.data.getVar('MACHINE',d) not in ['collie','h3600', 'h3800', 'simpad', 'htcwallaby']]}"

#mess with compiler flags to use -Os instead of -O2
#Please see http://free-electrons.com/doc/embedded_linux_optimizations/img47.html for some more info
# perl has some problems, see http://bugs.openembedded.org/show_bug.cgi?id=1616
# [23:00] oxo: glibc (any version) on sparc does not like (repeat me) "-Os"

FULL_OPTIMIZATION = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -Os"
FULL_OPTIMIZATION_pn-perl = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -O1"
FULL_OPTIMIZATION_sparc = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -O2"

BUILD_OPTIMIZATION = "-Os"
BUILD_OPTIMIZATION_pn-perl = "-O1"
BUILD_OPTIMIZATION_sparc = "-O2"

CXXFLAGS += "-fvisibility-inlines-hidden"

