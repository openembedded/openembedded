DESCRIPTION = "Support library for dealing with zip files"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL MPL"
DEPENDS = "zlib python-native"

PR = "r0"

SRC_URI[md5sum] = "14b5a6fc229afe9916d48358479568d3"
SRC_URI[sha256sum] = "cbc90cef60ee498319258e464895f990bb2e6e08f245264d77e44b309c8c218f"

SRC_URI = "${SOURCEFORGE_MIRROR}/zziplib/zziplib-${PV}.tar.bz2 \
		file://configure.ac.patch"

inherit autotools pkgconfig

EXTRA_OECONF += "--srcdir=${S}"
BBCLASSEXTEND = "native"

do_compile_append() {
	# Fix QA Issue with staging.
	for i in ${S}/*/*.pc ; do
		if [ ! -z "${STAGING_DIR_TARGET}" ]; then
			sed -i -e s:${STAGING_DIR_TARGET}::g $i
		fi
	done
}
