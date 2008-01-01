DESCRIPTION = "Document type definitions for verification of SGML data files against the DocBook rule set"

DEPENDS = "sgml-common-native"

SRC_URI = "http://www.docbook.org/sgml/${PV}/docbk31.zip"

S = "${WORKDIR}"

inherit native

do_compile() {
    sed -i -e '/ISO 8879/d' -e 's|DTDDECL "-//OASIS//DTD DocBook V3.1//EN"|SGMLDECL|g' docbook.cat
}

do_stage () {
    # Refer to http://www.linuxfromscratch.org/blfs/view/stable/pst/sgml-dtd-3.html
    # for details.
    install -d -m 755 ${STAGING_DATADIR}/sgml/docbook/sgml-dtd-${PV}
    install docbook.cat ${STAGING_DATADIR}/sgml/docbook/sgml-dtd-${PV}/catalog
    cp -dpr *.dtd *.mod *.dcl ${STAGING_DATADIR}/sgml/docbook/sgml-dtd-${PV}
    
    install-catalog --add ${sysconfdir}/sgml/sgml-docbook-dtd-${PV}.cat \
      ${STAGING_DATADIR}/sgml/docbook/sgml-dtd-${PV}/catalog
	
    install-catalog --add ${sysconfdir}/sgml/sgml-docbook-dtd-${PV}.cat \
      ${sysconfdir}/sgml/sgml-docbook.cat    
}

PACKAGES = ""
