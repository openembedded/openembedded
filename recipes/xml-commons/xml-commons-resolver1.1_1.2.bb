DESCRIPTION = "Library to resolve various public or system identifiers into accessible URLs (Java)"
LICENSES = "AL2.0"
AUTHOR = "Apache Software Foundation"

SRC_URI = "http://archive.apache.org/dist/xml/commons/xml-commons-resolver-${PV}.tar.gz"

inherit java-library

S = "${WORKDIR}/xml-commons-resolver-${PV}"

DEPENDS = "fastjar-native jaxp1.3"

do_unpackpost() {
  find src -exec \
    sed -i -e "s|@impl.name@|XmlResolver|" \
           -e "s|@impl.version@|1.2|" {} \;
}

addtask unpackpost after do_unpack before do_patch

JARFILENAME = "resolver.jar"
ALTJARFILENAMES = ""

do_compile() {
  mkdir -p build

  cp=${STAGING_DATADIR_JAVA}/jaxp1.3.jar

  javac -sourcepath src -d build -classpath $cp `find src -name "*.java" -and -not  -wholename "*tests*"`

  (cd src && find org -name "*.xml" -o -name "*.txt" -o -name "*.src" -exec cp {} ../build/{} \;)

  fastjar -C build -c -m src/manifest.resolver -f ${JARFILENAME} org
}

