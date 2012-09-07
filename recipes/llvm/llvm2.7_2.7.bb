require llvm.inc

PR = "r12"

DEPENDS = "llvm-common llvm2.7-native"

# Force arm mode for armv4t until http://llvm.org/bugs/show_bug.cgi?id=6065 is resolved somehow
ARM_INSTRUCTION_SET_armv4t = "ARM"

SRC_URI += "\
  file://arm_ppc.patch \
  file://r97745-llvmPR6480.patch \
  file://r104558-VFPmisc.patch \
  file://r104587-MOVimm32.patch \
  file://r104652-VFPLoadStoreMultiple.patch \
  file://r104653-BFC-BFI.patch \
  file://rawMOVLRPC.patch \
  file://include-fixes.patch \
  file://r137567-lseek64.patch \
  "

LLVM_RELEASE = "2.7"

SRC_URI[md5sum] = "ac322661f20e7d6c810b1869f886ad9b"
SRC_URI[sha256sum] = "99664bdc8503a306038166af33f28eb426d99e297575a59d74a1a0dcbddbbca5"
