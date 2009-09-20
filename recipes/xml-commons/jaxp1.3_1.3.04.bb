DESCRIPTION = "Java XML parser and transformer APIs (DOM, SAX, JAXP, TrAX)"
LICENSES = "AL2.0 W3C Public Domain"
AUTHOR = "Apache Software Foundation"

SRC_URI = "http://archive.apache.org/dist/xml/commons/source/xml-commons-external-${PV}-src.tar.gz"

inherit java-library

S = "${WORKDIR}"

DEPENDS = "fastjar-native"

JARFILENAME = "jaxp-1.3.jar"
ALTJARFILENAMES = "xml-apis.jar"

do_compile() {
  mkdir -p build/license
  javac -d build `find javax org -name \*.java`

  cp LICENSE.*.txt README.*.txt build/license

  fastjar -c -m manifest.commons -f ${JARFILENAME} -C build .
}

