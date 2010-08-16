require python.inc
DEPENDS = "openssl-native bzip2-full-native zlib-native readline-native"
# set to 0 on every increase of INC_PR
PR = "${INC_PR}.1"

SRC_URI = "\
  http://www.python.org/ftp/python/${PV}/Python-${PV}.tar.bz2;name=archive \
  file://00-fix-bindir-libdir-for-cross.patch \
  file://04-default-is-optimized.patch \
  file://05-enable-ctypes-cross-build.patch \
  file://06-ctypes-libffi-fix-configure.patch \
  file://10-distutils-fix-swig-parameter.patch \
  file://11-distutils-never-modify-shebang-line.patch \
  file://12-distutils-prefix-is-inside-staging-area.patch \
  file://debug.patch \
  file://nohostlibs.patch \
"
S = "${WORKDIR}/Python-${PV}"

SRC_URI[archive.md5sum] = "fee5408634a54e721a93531aba37f8c1"
SRC_URI[archive.sha256sum] = "dad8d5575144a210d5cc4fdbc40b8a26386e9cdb1ef58941bec0be02c7cb9d89"

inherit native

EXTRA_OEMAKE = '\
  BUILD_SYS="" \
  HOST_SYS="" \
  LIBC="" \
  STAGING_LIBDIR=${STAGING_LIBDIR_NATIVE} \
  STAGING_INCDIR=${STAGING_INCDIR_NATIVE} \
'

do_install_append() {
	install -m 0755 Parser/pgen ${D}${bindir}/pgen
}
