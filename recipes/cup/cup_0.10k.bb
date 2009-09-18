DESCRIPTION = "Lexical analyzer generator for Java"
AUTHOR = "Elliot Berk, A. Appel, C. Scott Ananian"

DEPENDS = "virtual/javac-native fastjar-native"
RDEPENDS = "java2-runtime"

inherit java-library

SRC_URI = "\
	http://www.cs.princeton.edu/~appel/modern/java/CUP/java_${BPN}_v10k.tar.gz \
	file://cup \
	"

S = "${WORKDIR}/java_cup"

do_configure() {
	sed -i \
		-e "s|OE_STAGING_BINDIR|${bindir}|" \
		-e "s|OE_STAGING_DATADIR_JAVA|${data_java}|" \
		-e "s|OE_CUP_JAR|${BP}.jar|" \
		${WORKDIR}/cup
}

do_compile() {
	mkdir -p build

	javac -d build `find . -name "*.java"`

	fastjar -C build -c -f ${BP}.jar .
}

do_install_append() {
	install -d ${D}${bindir}
	install -m 0755 ${WORKDIR}/cup ${D}${bindir}
}

PACKAGES = "${PN}"

FILES_${PN} += "${datadir_java}"
