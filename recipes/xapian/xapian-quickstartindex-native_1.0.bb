require xapian-quickstartindex_${PV}.bb

DEPENDS = "xapian-core-native"

inherit native

do_stage() {
        install -m 0744 ${WORKDIR}/${BINARY_NAME} ${STAGING_BINDIR}
}
