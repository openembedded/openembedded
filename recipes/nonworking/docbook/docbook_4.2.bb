SRC_URI = http://www.oasis-open.org/docbook/sgml/${PV}/docbook-${PV}.zip
S = ${WORKDIR}

installfiles = calstblx.dtd ChangeLog dbgenent.mod dbnotnx.mod docbook.cat docbook.dtd README \
catalog.xml dbcentx.mod dbhierx.mod dbpoolx.mod docbook.dcl docbookx.dtd soextblx.dtd

do_stage () {
	install -d ${STAGING_DATADIR}/sgml/docbook_${PV}
	for i in ${installfiles}; do
		install -m 0644 $i ${STAGING_DATADIR}/sgml/docbook_${PV}
	done
}

do_install () {
	install -d ${D}/${datadir}/sgml/docbook_${PV}
	for i in ${installfiles}; do
		install -m 0644 $i ${D}/${datadir}/sgml/docbook_${PV}
	done
}

SRC_URI[md5sum] = "0dfeb94569334dd22a62d90d99fc0630"
SRC_URI[sha256sum] = "67ebd2c94b342718c6865d2de60f5d4ff02d77a7e4b0d9e72a48c45f2b2635c3"
