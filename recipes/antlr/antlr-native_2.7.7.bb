require antlr_${PV}.bb

SRC_URI += "file://runantlr"

inherit java-native

do_configure() {
	sed -i -e"s|@JAR_FILE@|${STAGING_DATADIR_JAVA_NATIVE}/antlr.jar|" ${WORKDIR}/runantlr
}

do_stage() {
	java_stage

	install -d ${STAGING_BINDIR}

	install -m 0755 ${WORKDIR}/runantlr ${STAGING_BINDIR}
}
