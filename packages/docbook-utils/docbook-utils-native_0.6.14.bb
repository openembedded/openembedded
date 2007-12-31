SECTION = "console/utils"
LICENSE = "GPL"
DEPENDS = "openjade-native docbook-sgml-dtd-native docbook-dsssl-stylesheets-native"

SRC_URI = "ftp://sources.redhat.com/pub/docbook-tools/new-trials/SOURCES/docbook-utils-${PV}.tar.gz"
S = "${WORKDIR}/docbook-utils-${PV}"

inherit autotools native

do_configure_prepend() {
    # Prevents the jw script to search on the build system.
    sed -i -e "s|/etc/sgml|${sysconfdir}/sgml|g" bin/jw.in
    
    sed -i -e "s|/etc/sgml|${sysconfdir}/sgml|g" doc/man/Makefile.am
    sed -i -e "s|/etc/sgml|${sysconfdir}/sgml|g" doc/HTML/Makefile.am
}

do_stage () {
	install -d ${STAGING_BINDIR_NATIVE}/

	# Installs the binaries and a bunch of other commonly used names for them.
	for doctype in html ps dvi man pdf rtf tex texi txt
	do
		install -m 0755 ${S}/bin/docbook2$doctype ${STAGING_BINDIR_NATIVE}/
    ln -sf docbook2$doctype ${STAGING_BINDIR_NATIVE}/db2$doctype
    ln -sf docbook2$doctype ${STAGING_BINDIR_NATIVE}/docbook-to-$doctype
	done
	install -m 0755 ${S}/bin/jw ${STAGING_BINDIR_NATIVE}/

	for i in backends/dvi backends/html backends/man \
		 backends/pdf backends/ps backends/rtf backends/tex \
		 backends/texi backends/txt frontends/docbook \
		 helpers/docbook2man-spec.pl helpers/docbook2texi-spec.pl \
		 docbook-utils.dsl; do
		 install -d ${STAGING_DATADIR}/sgml/docbook/utils-${PV}/`dirname $i`
		 install ${S}/$i ${STAGING_DATADIR}/sgml/docbook/utils-${PV}/$i
	done
}
