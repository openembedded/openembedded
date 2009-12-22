# eglibc:
require conf/distro/include/eglibc.inc

ANGSTROM_BLACKLIST_pn-libiconv = "the glibc builtin iconv replacement is used"

TARGET_OS = "linux"

TARGET_OS .= "${@['','-gnueabi'][bb.data.getVar('TARGET_ARCH',d,1) in ['arm', 'armeb']]}"
TARGET_OS .= "${@['','-gnuspe'][bb.data.getVar('TARGET_ARCH',d,1) in ['ppc', 'powerpc'] and bb.data.getVar('MACHINE',d) in ['calamari']]}"

#TARGET_OS = "linux-gnuspe"

#mess with compiler flags to use -Os instead of -O2
#Please see http://free-electrons.com/doc/embedded_linux_optimizations/img47.html for some more info
# perl has some problems, see http://bugs.openembedded.net/show_bug.cgi?id=1616
# [23:00] oxo: glibc (any version) on sparc does not like (repeat me) "-Os"

FULL_OPTIMIZATION = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -Os -ggdb3"
FULL_OPTIMIZATION_pn-perl = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -O1"
FULL_OPTIMIZATION_sparc = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -O2"

BUILD_OPTIMIZATION = "-O2 -ggdb3"
BUILD_OPTIMIZATION_pn-perl = "-O1"
BUILD_OPTIMIZATION_sparc = "-O2"

TARGET_LINK_HASH_STYLE = "${@['-Wl,--hash-style=gnu',''][bb.data.getVar('TARGET_ARCH',d,1) in ['mips', 'mipsel']]}"

CXXFLAGS += "-fvisibility-inlines-hidden"

