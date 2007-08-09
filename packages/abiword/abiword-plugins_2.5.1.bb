DESCRIPTION = "AbiWord is a free word processing program similar to Microsoft(r) Word""
HOMEPAGE = "http://www.abiword.org""
SECTION = "x11/office"
LICENSE = "GPLv2"
DEPENDS = "libwpd librsvg goffice poppler"
RDEPENDS = "abiword"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "http://www.abiword.org/downloads/abiword/${PV}/source/abiword-plugins-${PV}.tar.gz \
           http://www.abiword.org/downloads/abiword/${PV}/source/abiword-${PV}.tar.gz \
	   "

inherit autotools

PARALLEL_MAKE=""

EXTRA_OECONF = " --without-libwmf \
                 --without-inter7eps \
		 --with-abiword=${WORKDIR}/abiword-${PV} \
		 "

PACKAGES_DYNAMIC = "abiword-plugin-*"

python populate_packages_prepend () {
	abiword_libdir = bb.data.expand('${libdir}/AbiWord-2.5/plugins', d)

	do_split_packages(d, abiword_libdir, '^libAbi(.*)\.so$', 'abiword-plugin-%s', 'Abiword plugin for %s', extra_depends='')
}

