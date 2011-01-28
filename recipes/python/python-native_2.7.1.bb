require python2.7.inc
DEPENDS = "openssl-native bzip2-full-native zlib-native readline-native sqlite3-native"
PR = "${INC_PR}.2"

FILESPATHPKG .= ":python-${PV}:python"
SRC_URI = "http://www.python.org/ftp/python/${PV}/Python-${PV}.tar.bz2 \
           file://04-default-is-optimized.patch \
           file://05-enable-ctypes-cross-build.patch \
           file://06-ctypes-libffi-fix-configure.patch \
           file://10-distutils-fix-swig-parameter.patch \
           file://11-distutils-never-modify-shebang-line.patch \
           file://12-distutils-prefix-is-inside-staging-area.patch \
           file://debug.patch \
           file://nohostlibs.patch"
SRC_URI[md5sum] = "aa27bc25725137ba155910bd8e5ddc4f"
SRC_URI[sha256sum] = "80e387bcf57eae8ce26726753584fd63e060ec11682d1145af921e85fd612292"

S = "${WORKDIR}/Python-${PV}"

inherit native

EXTRA_OECONF_append = '\
  --enable-unicode=ucs4 \
'

EXTRA_OEMAKE = '\
  BUILD_SYS="" \
  HOST_SYS="" \
  LIBC="" \
  STAGING_LIBDIR=${STAGING_LIBDIR_NATIVE} \
  STAGING_INCDIR=${STAGING_INCDIR_NATIVE} \
'

do_install() {
	oe_runmake 'DESTDIR=${D}' install
	install -d ${D}${bindir}/

	# Make sure we use /usr/bin/env python
	for PYTHSCRIPT in `grep -rIl ${bindir}/python ${D}${bindir}`; do
		sed -i -e '1s|^#!.*|#!/usr/bin/env python|' $PYTHSCRIPT
	done
	install -m 0755 Parser/pgen ${D}${bindir}/
}
