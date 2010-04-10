require jlex_${PV}.bb

inherit java-native

DEPENDS += "virtual/java-native"
RDEPENDS = ""

do_configure() {
  sed -i \
    -e "s|OE_STAGING_BINDIR|${STAGING_BINDIR_NATIVE}|" \
    -e "s|OE_STAGING_DATADIR_JAVA|${STAGING_DATADIR_JAVA_NATIVE}|" \
    -e "s|OE_JLEX_JAR|${BP}.jar|" \
    ${WORKDIR}/jlex
}

do_install_append() {
	:
}

do_stage_append() {
	install -d ${STAGING_BINDIR}
	install -m 0755 jlex ${STAGING_BINDIR}
}

SRC_URI[md5sum] = "fe0cff5db3e2f0f5d67a153cf6c783af"
SRC_URI[sha256sum] = "aeebaece3b3a53972bb0ba0f810540386c267070ee9dca6ffa43c6ff74a54bd7"
