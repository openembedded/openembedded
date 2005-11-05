SRC_URI = http://www.oasis-open.org/docbook/sgml/${PV}/docbook-${PV}.zip
S = ${WORKDIR}

installfiles = calstblx.dtd ChangeLog dbgenent.mod dbnotnx.mod docbook.cat docbook.dtd README \
catalog.xml dbcentx.mod dbhierx.mod dbpoolx.mod docbook.dcl docbookx.dtd soextblx.dtd

do_stage () {
	install -d ${STAGING_DIR}/share/sgml/docbook_${PV}
	for i in ${installfiles}; do
		install -m 0644 $i ${STAGING_DIR}/share/sgml/docbook_${PV}
	done
}

do_install () {
	install -d ${D}/${datadir}/sgml/docbook_${PV}
	for i in ${installfiles}; do
		install -m 0644 $i ${D}/${datadir}/sgml/docbook_${PV}
	done
}
