# The DTDs of the various versions have to be installed in parallel and should
# not replace each other. The installation step is common for all versions
# and just differs in the DTD_VERSION.
#
# However the DTDs need some quirks (see LFS documentation).

DESCRIPTION = "Document type definitions for verification of SGML data files against the DocBook rule set"

DEPENDS = "sgml-common-native"

SRC_URI = "http://www.docbook.org/sgml/${DTD_VERSION}/docbook-${DTD_VERSION}.zip"

S = "${WORKDIR}"

inherit native

do_stage () {
    # Refer to http://www.linuxfromscratch.org/blfs/view/stable/pst/sgml-dtd.html
    # for details.
    install -d -m 755 ${STAGING_DATADIR}/sgml/docbook/sgml-dtd-${DTD_VERSION}
    install docbook.cat ${STAGING_DATADIR}/sgml/docbook/sgml-dtd-${DTD_VERSION}/catalog
    cp -dpr *.dtd *.mod *.dcl ${STAGING_DATADIR}/sgml/docbook/sgml-dtd-${DTD_VERSION}
    
    install-catalog --add ${sysconfdir}/sgml/sgml-docbook-dtd-${DTD_VERSION}.cat \
      ${STAGING_DATADIR}/sgml/docbook/sgml-dtd-${DTD_VERSION}/catalog
	
    install-catalog --add ${sysconfdir}/sgml/sgml-docbook-dtd-${DTD_VERSION}.cat \
      ${sysconfdir}/sgml/sgml-docbook.cat
}

PACKAGES = ""
