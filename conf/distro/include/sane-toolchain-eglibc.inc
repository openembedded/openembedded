# Originally brought to you by the Angstrom Distribution

# eglibc:
# [23:00] oxo: glibc (any version) on sparc does not like (repeat me) "-Os"

FULL_OPTIMIZATION = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -Os"
FULL_OPTIMIZATION_pn-perl = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -O1"
FULL_OPTIMIZATION_sparc = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -O2"

# JaMa: I promise to report bug upstream, but as it can take a while to fix it, I'll switch to -O2 here
# Tested with gcc-4.4.2 and gcc-4.4.3 on armv4t and armv5te and it fails with -Os, with gcc-4.3.3 it works OK with -Os
# Here is testcase, but you have to rebuild whole libqtxml to test it
# http://lists.shr-project.org/pipermail/shr-devel/2010-February/002169.html
FULL_OPTIMIZATION_pn-qt4-x11-free = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -O2"
# This I've seen only on armv4t, it segfaults when called from pisi, but whole test unit suite can pass
FULL_OPTIMIZATION_pn-libsyncml = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -O2"

BUILD_OPTIMIZATION_pn-perl = "-O1"
BUILD_OPTIMIZATION_sparc = "-O2"

TARGET_LINK_HASH_STYLE = "${@['-Wl,--hash-style=gnu',''][bb.data.getVar('TARGET_ARCH',d,1) in ['mips', 'mipsel']]}"

CXXFLAGS += "-fvisibility-inlines-hidden"

