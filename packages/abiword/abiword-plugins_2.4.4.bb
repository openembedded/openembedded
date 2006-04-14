DESCRIPTION ="AbiWord is free word processing program similar to Microsoft(r) Word""
HOMEPAGE="http://www.abiword.org""
MAINTAINER="Koen Kooi <koen@dominion.kabel.utwente.nl>"
LICENSE="GPLv2"

DEPENDS     = "abiword libwpd gtkmathview librsvg goffice poppler"
PR="r0"

SRC_URI = "http://www.abiword.org/downloads/abiword/${PV}/source/abiword-${PV}.tar.gz"
S = "${WORKDIR}/abiword-${PV}/abiword-plugins"

FILES_${PN} += " ${datadir}/icons/* \
${datadir}/AbiSuite-2.4/ \
${libdir}/AbiWord-2.4/plugins/*.so \
"

inherit autotools

PARALLEL_MAKE=""

EXTRA_OECONF = ""



