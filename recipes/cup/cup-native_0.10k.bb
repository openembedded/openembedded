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


SRC_URI[md5sum] = "8b11edfec13c590ea443d0f0ae0da479"
SRC_URI[sha256sum] = "7e6dc5be74ae56c7e86e69ad0ad88dae3b2847afa9e73a76635918a6b1eb75cd"
