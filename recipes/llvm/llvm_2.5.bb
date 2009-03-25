DESCRIPTION = "The Low Level Virtual Machine"
HOMEPAGE = "http://llvm.org"
LICENSE = "various"

SRC_URI = "\
  http://llvm.org/releases/${PV}/llvm-${PV}.tar.gz \
  file://fix-build.patch;patch=1 \
"

PR = "r2"

DEPENDS = "llvm-native"

inherit cmake

OECMAKE_SOURCEPATH = ".."
OECMAKE_BUILDPATH = "build"
EXTRA_OEMAKE = "-C build"
EXTRA_OECMAKE = "\
  -DLLVM_TABLEGEN=${STAGING_BINDIR_NATIVE}/tblgen \
  -DLLVM_TARGETS_TO_BUILD=${@get_llvm_arch(d)} \
  -DCMAKE_LINKER:FILEPATH=${LD} \
  -DCMAKE_AR:FILEPATH=${AR} \
  -DCMAKE_OBJCOPY:FILEPATH=${OBJCOPY} \
  -DCMAKE_OBJDUMP:FILEPATH=${OBJDUMP} \
  -DCMAKE_RANLIB:FILEPATH=${RANLIB} \
  -DCMAKE_STRIP:FILEPATH=${STRIP} \
"

do_stage() {
  oe_runmake DESTDIR="${STAGING_DIR_HOST}" install

  install -d ${STAGING_INCDIR}/llvm
	find include/llvm -name "*.h" -maxdepth 1 -exec \
    install {} ${STAGING_INCDIR}/llvm \;

  install -d ${STAGING_BINDIR_CROSS}

  # Fix some paths in the script to make it work correctly
  sed -e's^my.*ABS_RUN_DIR =.*^my $ABS_RUN_DIR = "${STAGING_DIR_TARGET}";^' \
      -e's^my.*INCLUDEDIR =.*^my $INCLUDEDIR = "${STAGING_INCDIR}";^' \
      -e's^my.*LIBDIR.*^my $LIBDIR = "${STAGING_LIBDIR}";^' \
      -e's^my.*BINDIR.*^my $BINDIR = "${STAGING_BINDIR}";^' \
      build/bin/llvm-config > ${STAGING_BINDIR_CROSS}/llvm-config

  chmod +x ${STAGING_BINDIR_CROSS}/llvm-config
}

# Retrieve the target in a way that is compatible to the arch
# value in llvm (>= 2.5)
def get_llvm_arch(d):
  import bb;

  arch = bb.data.getVar('TARGET_ARCH', d, 1)
  if arch == "x86_64" or arch == "i486" or arch == "i586" or arch == "i686":
    arch = "X86"
  elif arch == "arm":
    arch = "ARM"
  elif arch == "mipsel":
    arch = "Mips"
  elif arch == "powerpc":
    arch = "PowerPC"
  else:
    oefatal("Your target architecture is not supported by this recipe");

  return arch

