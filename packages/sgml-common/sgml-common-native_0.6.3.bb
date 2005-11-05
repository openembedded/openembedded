SECTION = "base"
include sgml-common_${PV}.bb
inherit native

DEPENDS = ""
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/sgml-common-${PV}"
S = "${WORKDIR}/sgml-common-${PV}"
PACKAGES = ""

do_stage () {
	install -m 0755 bin/install-catalog ${STAGING_BINDIR}/
	install -m 0755 bin/sgmlwhich ${STAGING_BINDIR}/
	install -d ${STAGING_DIR}/etc
	install -m 0644 config/sgml.conf ${STAGING_DIR}/etc/
	install -d ${STAGING_DATADIR}/sgml
	install -m 0644 xml.dcl ${STAGING_DATADIR}/sgml/
	install -d ${STAGING_DATADIR}/xml/xml-iso-entities-8879.1986
	install -m 0644 xml-iso-entities/catalog ${STAGING_DATADIR}/xml/xml-iso-entities-8879.1986/
	install -m 0644 xml-iso-entities/*.ent ${STAGING_DATADIR}/xml/xml-iso-entities-8879.1986/
	install -d ${STAGING_DATADIR}/sgml/sgml-iso-entities-8879.1986
	install -m 0644 sgml-iso-entities/catalog ${STAGING_DATADIR}/sgml/sgml-iso-entities-8879.1986/
	install -m 0644 sgml-iso-entities/*.ent ${STAGING_DATADIR}/sgml/sgml-iso-entities-8879.1986/
}

do_install () {
	:
}
