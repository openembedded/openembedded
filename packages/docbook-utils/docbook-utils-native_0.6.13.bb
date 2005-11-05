SECTION = "console/utils"
LICENSE = "GPL"
DEPENDS = "openjade-native"

SRC_URI = "ftp://sources.redhat.com/pub/docbook-tools/new-trials/SOURCES/docbook-utils-${PV}.tar.gz"
S = "${WORKDIR}/docbook-utils-${PV}"

inherit autotools native

do_stage () {
	for b in docbook2dvi docbook2man docbook2ps docbook2tex \
		 docbook2txt docbook2html docbook2pdf docbook2rtf \
		 docbook2texi jw; do
		install -m 0755 ${S}/bin/$b ${STAGING_BINDIR}/
	done
	for i in backends/dvi backends/html backends/man \
		 backends/pdf backends/ps backends/rtf backends/tex \
		 backends/texi backends/txt frontends/docbook \
		 helpers/docbook2man-spec.pl helpers/docbook2texi-spec.pl \
		 docbook-utils.dsl; do
		 install -d ${STAGING_DATADIR}/sgml/docbook/utils-${PV}/`dirname $i`
		 install ${S}/$i ${STAGING_DATADIR}/sgml/docbook/utils-${PV}/$i
	done
}
