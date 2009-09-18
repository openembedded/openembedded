require cup_${PV}.bb

inherit java-native

DEPENDS += "virtual/java-native"
RDEPENDS = ""

do_configure() {
	sed -i \
		-e "s|OE_STAGING_BINDIR|${STAGING_BINDIR_NATIVE}|" \
		-e "s|OE_STAGING_DATADIR_JAVA|${STAGING_DATADIR_JAVA_NATIVE}|" \
		-e "s|OE_CUP_JAR|${BP}.jar|" \
		${WORKDIR}/cup
}

do_install_append() {
	:
}

do_stage_append() {
  install -d ${STAGING_BINDIR}
  install -m 0755 ${WORKDIR}/cup ${STAGING_BINDIR}
}

