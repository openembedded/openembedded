DESCRIPTION = "Lexical analyzer generator for Java"

LICENSE = "GPL MPL"

DEPENDS = "fastjar-native"

inherit java-library

SRC_URI = "\
	ftp://ftp.mozilla.org/pub/mozilla.org/js/rhino1_7R1.zip \
	file://rhino \
	file://rhino-jsc \
	"

S = "${WORKDIR}/rhino1_7R1"

PACKAGES = "${JPN} rhino"

FILES_${PN} = "${bindir}/rhino ${bindir}/rhino-jsc"
RDEPENDS_${PN} = "java2-runtime ${JPN}"

do_compile() {
  mkdir -p build

	# Compatibility fix for jamvm which has non-genericised
  # java.lang classes. :(
	bcp_arg="-bootclasspath ${STAGING_DATADIR_NATIVE}/classpath/glibj.zip"

  javac $bcp_arg -source 1.5 -sourcepath src -d build `find src -name "*.java"`

	mkdir -p build/org/mozilla/javascript/resources
	cp src/org/mozilla/javascript/resources/*.properties build/org/mozilla/javascript/resources

  fastjar -m ${S}/src/manifest -C build -c -f ${JARFILENAME} .
}

do_install_append() {
	install -d ${D}${bindir}

	install -m 0755 ${WORKDIR}/rhino ${D}${bindir}
	install -m 0755 ${WORKDIR}/rhino-jsc ${D}${bindir}
}
