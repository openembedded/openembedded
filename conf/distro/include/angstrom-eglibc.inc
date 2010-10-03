# eglibc:
require conf/distro/include/eglibc.inc

ANGSTROM_BLACKLIST_pn-libiconv = "the glibc builtin iconv replacement is used"

TARGET_OS = "linux"

# sane-toolchain.inc has this, and explains the GNU and ABI suffices:
#TARGET_OS = "${@compute_os_portion_of_target_triplet(d)}"

TARGET_OS .= "${@['','-gnueabi'][bb.data.getVar('TARGET_ARCH',d,1) in ['arm', 'armeb']]}"
TARGET_OS .= "${@['','-gnuspe'][bb.data.getVar('BASE_PACKAGE_ARCH',d,1) in ['ppce500', 'ppce500v2']]}"

# perl has some problems, see http://bugs.openembedded.net/show_bug.cgi?id=1616
# [23:00] oxo: glibc (any version) on sparc does not like (repeat me) "-Os"

FULL_OPTIMIZATION = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -O2 -ggdb2"
FULL_OPTIMIZATION_pn-eglibc_arm = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -O2 -ggdb3"
FULL_OPTIMIZATION_pn-perl = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -O1"
FULL_OPTIMIZATION_sparc = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -O2"

BUILD_OPTIMIZATION = "-O2 -g"
BUILD_OPTIMIZATION_pn-perl = "-O1"
BUILD_OPTIMIZATION_sparc = "-O2"

TARGET_LINK_HASH_STYLE = "${@['-Wl,--hash-style=gnu',''][bb.data.getVar('TARGET_ARCH',d,1) in ['mips', 'mipsel', 'mips64', 'mips64el']]}"

CXXFLAGS += "-fvisibility-inlines-hidden"

