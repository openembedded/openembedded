LICENSE = "GPL"
SECTION = "base"
DESCRIPTION = "The sgml-common package gathers very basic \
stuff necessary to work with SGML and XML, such as xml.dcl, \
a SGML declaration of XML; iso-entities, a list of the basic \
SGML ISO entities; and install-catalog, a script used to \
add entries to (or remove entries from) centralized catalogs \
whose entries are pointers to SGML open catalogs, \
as defined by OASIS."

FILES_sgml-common_append = " ${datadir}/sgml"

SRC_URI = "ftp://sources.redhat.com/pub/docbook-tools/new-trials/SOURCES/sgml-common-${PV}.tgz \
	   file://autohell.patch;patch=1"

inherit autotools

do_compile_append() {
    # install-catalog script contains hardcoded reference to /etc/sgml.
    sed -i -e "s|/etc/sgml|${sysconfdir}/sgml|g" bin/install-catalog
}

pkg_postinst() {
	install-catalog \
	    --add ${sysconfdir}/sgml/sgml-ent.cat \
			${datadir}/sgml/sgml-iso-entities-8879.1986/catalog
	    
	install-catalog \
	    --add ${sysconfdir}/sgml/sgml-docbook.cat \
			${sysconfdir}/sgml/sgml-ent.cat
}

pkg_postrm() {
	install-catalog \
	    --remove ${sysconfdir}/sgml/sgml-ent.cat \
			${datadir}/sgml/sgml-iso-entities-8879.1986/catalog
	    
	install-catalog \
	    --remove ${sysconfdir}/sgml/sgml-docbook.cat \
			${sysconfdir}/sgml/sgml-ent.cat
}


SRC_URI[md5sum] = "103c9828f24820df86e55e7862e28974"
SRC_URI[sha256sum] = "7dc418c1d361123ffc5e45d61f1b97257940a8eb35d0bfbbc493381cc5b1f959"
