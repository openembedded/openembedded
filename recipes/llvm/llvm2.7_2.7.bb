require llvm.inc

PR = "r6"

DEPENDS = "llvm-common llvm2.7-native"

# Force arm mode for armv4t until http://llvm.org/bugs/show_bug.cgi?id=6065 is resolved somehow
ARM_INSTRUCTION_SET_armv4t = "ARM"

SRC_URI = "\
  http://llvm.org/releases/${PV}/llvm-${PV}.tgz \
  file://arm_ppc.patch \
  file://MOVLRPC.patch \
  "

LLVM_RELEASE = "2.7"

SRC_URI[md5sum] = "ac322661f20e7d6c810b1869f886ad9b"
SRC_URI[sha256sum] = "99664bdc8503a306038166af33f28eb426d99e297575a59d74a1a0dcbddbbca5"
