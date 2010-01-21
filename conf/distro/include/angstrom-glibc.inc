# glibc:
require conf/distro/include/glibc-${TOOLCHAIN_TYPE}.inc

ANGSTROM_BLACKLIST_pn-libiconv = "the glibc builtin iconv replacement is used"

TARGET_OS = "linux"
TARGET_OS .= "${@['','-gnueabi'][bb.data.getVar('TARGET_ARCH',d,1) in ['arm', 'armeb']]}"

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

# Disable -Wl,as-needed for now till all the test come back OK
#require conf/distro/include/angstrom-ldflags.inc

CXXFLAGS += "-fvisibility-inlines-hidden"

