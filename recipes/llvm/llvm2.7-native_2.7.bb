require llvm-native.inc

PR = "r0"

SRC_URI = "\
  http://llvm.org/releases/${PV}/llvm-${PV}.tgz \
"

LLVM_RELEASE = "2.7"

SRC_URI[md5sum] = "ac322661f20e7d6c810b1869f886ad9b"
SRC_URI[sha256sum] = "99664bdc8503a306038166af33f28eb426d99e297575a59d74a1a0dcbddbbca5"
