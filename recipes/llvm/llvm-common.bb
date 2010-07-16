DESCRIPTION = "Helper script for OE's llvm support"

PR = "r2"

BBCLASSEXTEND = "native"

SRC_URI = "file://llvm-config"

PACKAGES = ""

# For llvm-common the script should end up in STAGING_BINDIR_CROSS
# and for llvm-common-native it should be in STAGING_BINDIR. The
# script works together with a script that is installed by a
# corresponding llvm(-native) package.
DESTINATION = "${STAGING_BINDIR_CROSS}"
DESTINATION_virtclass-native = "${STAGING_BINDIR}"

do_stage() {
  install -d ${DESTINATION}
  install -m 0755 ${WORKDIR}/llvm-config ${DESTINATION}
}
