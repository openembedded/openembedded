require llvm.inc

DEPENDS = "llvm-common-native cmake-native"

inherit native

# the difference to the non-native build is that we do not need
# to declare the location of the tblgen executable.
EXTRA_OECMAKE = "\
  -DLLVM_TARGETS_TO_BUILD=${LLVM_ARCH} \
  -DCMAKE_LINKER:FILEPATH=${LD} \
  -DCMAKE_AR:FILEPATH=${AR} \
  -DCMAKE_OBJCOPY:FILEPATH=${OBJCOPY} \
  -DCMAKE_OBJDUMP:FILEPATH=${OBJDUMP} \
  -DCMAKE_RANLIB:FILEPATH=${RANLIB} \
  -DCMAKE_STRIP:FILEPATH=${STRIP} \
"

do_stage() {
  llvm_stage

  install -d ${STAGING_BINDIR}
	install -m 0755 build/bin/llvm-config${LLVM_RELEASE} ${STAGING_BINDIR}
}


