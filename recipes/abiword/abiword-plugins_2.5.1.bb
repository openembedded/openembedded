DESCRIPTION = "AbiWord is a free word processing program similar to Microsoft(r) Word"
HOMEPAGE = "http://www.abiword.org"
SECTION = "x11/office"
LICENSE = "GPLv2"
DEPENDS = "libwpd librsvg goffice poppler libglade"
RDEPENDS = "abiword"

PR = "r1"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "http://www.abiword.org/downloads/abiword/${PV}/source/abiword-plugins-${PV}.tar.gz;name=plugins \
           http://www.abiword.org/downloads/abiword/${PV}/source/abiword-${PV}.tar.gz;name=archive \
	   "

inherit autotools

PARALLEL_MAKE=""

EXTRA_OECONF = " --without-libwmf \
                 --without-inter7eps \
		 --with-abiword=${WORKDIR}/abiword-${PV} \
		 "

PACKAGES_DYNAMIC = "abiword-plugin-*"

python populate_packages_prepend () {
	abiword_libdir    = bb.data.expand('${libdir}/abiword-2.5/plugins', d)
	do_split_packages(d, abiword_libdir, '^libAbi(.*)\.so$', 'abiword-plugin-%s', 'Abiword plugin for %s', extra_depends='')
        do_split_packages(d, abiword_libdir, '^libAbi(.*)\.la$', 'abiword-plugin-%s-dev', 'Abiword plugin for %s', extra_depends='')
}


PACKAGES =+ "abiword-plugin-collab-glade"

FILES_abiword-plugin-collab-glade += "${datadir}"
RDEPENDS_abiword-plugin-collab-glade = "abiword-plugin-collab"

FILES_${PN}-dbg += "${libdir}/abiword-2.5/plugins/.debug"


SRC_URI[plugins.md5sum] = "b1ce7ca49a0ee4e04f828e10eaebe6a9"
SRC_URI[plugins.sha256sum] = "37faf6ea346c9b6473c5b2dfd1bb599457faa06b6a7cdef58e3e9f3e2773976b"
SRC_URI[archive.md5sum] = "11d022458e0e090846b35ed4873c2e6e"
SRC_URI[archive.sha256sum] = "482891fb0e376e2aaeee25afa8b4913e6dc50f4fdc280f9f152b3ee8745d735d"
