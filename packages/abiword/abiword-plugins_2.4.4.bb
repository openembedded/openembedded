DESCRIPTION ="AbiWord is free word processing program similar to Microsoft(r) Word""
HOMEPAGE="http://www.abiword.org""
MAINTAINER="Koen Kooi <koen@dominion.kabel.utwente.nl>"
LICENSE="GPLv2"

DEPENDS     = "abiword libwpd librsvg goffice poppler"
PR="r1"

SRC_URI = "http://www.abiword.org/downloads/abiword/${PV}/source/abiword-${PV}.tar.gz \
           file://abiword-plugin-pdf-poppler.patch;patch=1;pnum=2"
S = "${WORKDIR}/abiword-${PV}/abiword-plugins"

inherit autotools

PARALLEL_MAKE=""

EXTRA_OECONF = "--without-libwmf"

PACKAGES_DYNAMIC = "abiword-plugin-*"

python populate_packages_prepend () {
	abiword_libdir = bb.data.expand('${libdir}/AbiWord-2.4/plugins', d)

	do_split_packages(d, abiword_libdir, '^libAbi(.*)\.so$', 'abiword-plugin-%s', 'Abiword plugin for %s', extra_depends='')
}

