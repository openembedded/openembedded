DESCRIPTION = "A library for atomic integer operations"
LICENSE = "MIT"

PR = "r0"

SRC_URI = "${DEBIAN_MIRROR}/main/liba/libatomic-ops/libatomic-ops_7.3~alpha1+git20111031.orig.tar.gz \
           ${DEBIAN_MIRROR}/main/liba/libatomic-ops/libatomic-ops_7.3~alpha1+git20111031-1.diff.gz;name=debpatch;apply=yes \
           file://sh4_enable_can_emu.diff \
           file://no-hexagon-h.patch"

S = "${WORKDIR}/libatomic-ops-7.3~alpha1+git20111031"

ARM_INSTRUCTION_SET = "arm"
PARALLEL_MAKE = ""

inherit autotools pkgconfig

# Allow empty package to fix SDK depchains
ALLOW_EMPTY_${PN} = "1"

FILES_${PN}-doc += "${datadir}/libatomic_ops/COPYING ${datadir}/libatomic_ops/*.txt"

SRC_URI[md5sum] = "8ea12aaabef30f17f7bc090f6a52b35c"
SRC_URI[sha256sum] = "a115312c36e612dff7987011cee6e361e939ad62a6e52dd2aa323cc07127b1a6"

SRC_URI[debpatch.md5sum] = "bd626ecf9666de31329c491cc30b406b"
SRC_URI[debpatch.sha256sum] = "6cc045e68888c9d2fd9ddfad84015f02a8b91f91fb6f9764dfcb1a6af76be06f"
