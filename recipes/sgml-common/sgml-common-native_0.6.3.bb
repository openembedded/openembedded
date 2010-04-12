SECTION = "base"
require sgml-common_${PV}.bb
inherit native

DEPENDS = ""
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/sgml-common-${PV}"
S = "${WORKDIR}/sgml-common-${PV}"
PACKAGES = ""

do_stage () {
	# For unknown reasons 'make install' does not work.
	install -m 0755 bin/install-catalog ${STAGING_BINDIR_NATIVE}/
	install -m 0755 bin/sgmlwhich ${STAGING_BINDIR_NATIVE}/
	
	install -d ${sysconfdir}/sgml
	install -m 0644 config/sgml.conf ${sysconfdir}/sgml
	
	install -d ${STAGING_DATADIR}/sgml
	install -m 0644 xml.dcl ${STAGING_DATADIR}/sgml/
	
	install -d ${STAGING_DATADIR}/sgml/xml-iso-entities-8879.1986
	install -m 0644 xml-iso-entities/catalog ${STAGING_DATADIR}/sgml/xml-iso-entities-8879.1986/
	install -m 0644 xml-iso-entities/*.ent ${STAGING_DATADIR}/sgml/xml-iso-entities-8879.1986/
	install -d ${STAGING_DATADIR}/sgml/sgml-iso-entities-8879.1986
	install -m 0644 sgml-iso-entities/catalog ${STAGING_DATADIR}/sgml/sgml-iso-entities-8879.1986/
	install -m 0644 sgml-iso-entities/*.ent ${STAGING_DATADIR}/sgml/sgml-iso-entities-8879.1986/

	install-catalog \
	    --add ${sysconfdir}/sgml/sgml-ent.cat ${STAGING_DATADIR}/sgml/sgml-iso-entities-8879.1986/catalog
	    
	install-catalog \
	    --add ${sysconfdir}/sgml/sgml-docbook.cat ${sysconfdir}/sgml/sgml-ent.cat
			    
}

do_install () {
	:
}

SRC_URI[md5sum] = "103c9828f24820df86e55e7862e28974"
SRC_URI[sha256sum] = "7dc418c1d361123ffc5e45d61f1b97257940a8eb35d0bfbbc493381cc5b1f959"
