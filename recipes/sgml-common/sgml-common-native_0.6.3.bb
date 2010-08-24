SECTION = "base"
DEPENDS = ""
PR = "r1"

SRC_URI[md5sum] = "103c9828f24820df86e55e7862e28974"
SRC_URI[sha256sum] = "7dc418c1d361123ffc5e45d61f1b97257940a8eb35d0bfbbc493381cc5b1f959"

S = "${WORKDIR}/sgml-common-${PV}"
SYSROOT_PREPROCESS_FUNCS += "sgml_common_native_mangle"

require sgml-common_${PV}.bb
inherit native

do_install () {
        # For unknown reasons 'make install' does not work.
        install -d ${D}${bindir}/
        install -m 0755 bin/install-catalog ${D}${bindir}/
        install -m 0755 bin/sgmlwhich ${D}${bindir}/
        install -d ${D}${sysconfdir}/sgml/
        install -m 0644 config/sgml.conf ${D}${sysconfdir}/sgml
        install -d ${D}${datadir}/sgml
        install -m 0644 xml.dcl ${D}${datadir}/sgml/
        install -d ${D}${datadir}/sgml/xml-iso-entities-8879.1986
        install -m 0644 xml-iso-entities/catalog ${D}${datadir}/sgml/xml-iso-entities-8879.1986/
        install -m 0644 xml-iso-entities/*.ent ${D}${datadir}/sgml/xml-iso-entities-8879.1986/
        install -d ${D}${datadir}/sgml/sgml-iso-entities-8879.1986
        install -m 0644 sgml-iso-entities/catalog ${D}${datadir}/sgml/sgml-iso-entities-8879.1986/
        install -m 0644 sgml-iso-entities/*.ent ${D}${datadir}/sgml/sgml-iso-entities-8879.1986/
        # install-catalog script contains hard coded reference to {sysconfdir}. Changed it to ${D}${sysconfdir}.
        sed -i -e "s|${sysconfdir}/sgml|${D}${sysconfdir}/sgml|g" ${D}${bindir}/install-catalog
        ${D}${bindir}/install-catalog \
            --add ${D}${sysconfdir}/sgml/sgml-ent.cat ${D}${datadir}/sgml/sgml-iso-entities-8879.1986/catalog
        ${D}${bindir}/install-catalog \
            --add ${D}${sysconfdir}/sgml/sgml-docbook.cat ${D}${sysconfdir}/sgml/sgml-ent.cat
}

PACKAGES = ""

sgml_common_native_mangle () {
        # Reverte back to ${sysconfdir} path in install-catalog
        sed -i -e "s|${D}${sysconfdir}/sgml|${sysconfdir}/sgml|g" ${SYSROOT_DESTDIR}${STAGING_BINDIR}/install-catalog
        # Change path from ${D}${datadir}/sgml/sgml-iso-entities-8879.1986/catalog to ${datadir}/sgml/sgml-iso-entities-8879.1986/catalog in sgml-ent.cat
        sed -i -e "s|${D}${datadir}/sgml/sgml-iso-entities-8879.1986/catalog|${datadir}/sgml/sgml-iso-entities-8879.1986/catalog|g" ${SYSROOT_DESTDIR}${sysconfdir}/sgml/sgml-ent.cat
        # Change path from ${D}${sysconfdir}/sgml/sgml-ent.cat|${sysconfdir}/sgml/sgml-ent.cat to ${sysconfdir}/sgml/sgml-ent.cat in sgml-ent.cat
        sed -i -e "s|${D}${sysconfdir}/sgml/sgml-ent.cat|${sysconfdir}/sgml/sgml-ent.cat|g" ${SYSROOT_DESTDIR}${sysconfdir}/sgml/sgml-docbook.cat
        # Remove ${D} path from catalog file created by install-catalog script
        sed -i -e "s|${D}||g" ${SYSROOT_DESTDIR}${sysconfdir}/sgml/catalog
}

