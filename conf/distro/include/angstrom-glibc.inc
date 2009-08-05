# glibc:
require conf/distro/include/glibc.inc

PREFERRED_PROVIDER_linux-libc-headers ?= "linux-libc-headers"

TARGET_OS = "linux${@['','-gnueabi'][bb.data.getVar('TARGET_ARCH',d,1) in ['arm', 'armeb'] and bb.data.getVar('MACHINE',d) not in ['collie','h3600', 'h3800', 'simpad', 'htcwallaby']]}"

#mess with compiler flags to use -Os instead of -O2
#Please see http://free-electrons.com/doc/embedded_linux_optimizations/img47.html for some more info
# perl has some problems, see http://bugs.openembedded.net/show_bug.cgi?id=1616
# [23:00] oxo: glibc (any version) on sparc does not like (repeat me) "-Os"

FULL_OPTIMIZATION = "-fexpensive-optimizations -frename-registers -fomit-frame-pointer -O2 -ggdb3"

FULL_OPTIMIZATION_pn-perl = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -O1"
FULL_OPTIMIZATION_pn-glibc = "-fexpensive-optimizations -fomit-frame-pointer -O2"
FULL_OPTIMIZATION_sparc = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -O2"
FULL_OPTIMIZATION_ep9312 = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -O -fno-signed-zeros"

# This is only used for -native packages
BUILD_OPTIMIZATION = "-O2 -g"
BUILD_OPTIMIZATION_pn-perl-native = "-O1 -g"

TARGET_LINK_HASH_STYLE = "${@['-Wl,--hash-style=gnu',''][bb.data.getVar('TARGET_ARCH',d,1) in ['mips', 'mipsel']]}"

CXXFLAGS += "-fvisibility-inlines-hidden"

