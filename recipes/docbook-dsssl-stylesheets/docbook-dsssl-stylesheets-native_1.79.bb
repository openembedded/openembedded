DESCRIPTION = "DSSSL stylesheets used to transform SGML and XML DocBook files"

# Simple persmissive
LICENSE = "DSSSL"

DEPENDS = "sgml-common-native"

SRC_URI = "${SOURCEFORGE_MIRROR}/docbook/docbook-dsssl-${PV}.tar.bz2"

S = "${WORKDIR}/docbook-dsssl-${PV}"

inherit native

do_stage () {
    # Refer to http://www.linuxfromscratch.org/blfs/view/stable/pst/docbook-dsssl.html
    # for details.
    install -d ${STAGING_BINDIR_NATIVE}
    install -m 0755 bin/collateindex.pl ${STAGING_BINDIR_NATIVE}
    
    install -d ${STAGING_DATADIR}/sgml/docbook/dsssl-stylesheets-${PV}
    install -m 0644 catalog ${STAGING_DATADIR}/sgml/docbook/dsssl-stylesheets-${PV}
    cp -dpr common ${STAGING_DATADIR}/sgml/docbook/dsssl-stylesheets-${PV}
    
    install-catalog --add ${sysconfdir}/sgml/dsssl-docbook-stylesheets.cat \
      ${STAGING_DATADIR}/sgml/docbook/dsssl-stylesheets-${PV}/catalog
	
    install-catalog --add ${sysconfdir}/sgml/dsssl-docbook-stylesheets.cat \
      ${STAGING_DATADIR}/sgml/docbook/dsssl-stylesheets-${PV}/common/catalog

    install-catalog --add ${sysconfdir}/sgml/sgml-docbook.cat \
      ${sysconfdir}/sgml/dsssl-docbook-stylesheets.cat
	
}

PACKAGES = ""

SRC_URI[md5sum] = "bc192d23266b9a664ca0aba4a7794c7c"
SRC_URI[sha256sum] = "2f329e120bee9ef42fbdd74ddd60e05e49786c5a7953a0ff4c680ae6bdf0e2bc"
