DESCRIPTION = "Java XSLT processor"
LICENSE = "AL2.0"

AUTHOR = "Apache Software Foundation"
HOMEPAGE = "http://xml.apache.org/xalan-j

DEPENDS = "fastjar-native xerces-j regexp jlex cup jaxp1.3 bcel"

SRC_URI = "\
	http://archive.apache.org/dist/xml/${BPN}/${BPN}_2_7_1-src.tar.gz;name=archive \
	http://archive.apache.org/dist/jakarta/bsf/source/bsf-src-2.4.0.tar.gz;name=bsf \
	"

S = "${WORKDIR}/${BPN}_2_7_1"

inherit java-library

JPN = "libxalan2-java"

JARFILENAME = "xalan2-${PV}.jar"
ALTJARFILENAMES = "xalan2.jar"

do_compile() {
  mkdir -p build

  oe_makeclasspath cp -s xercesImpl regexp jlex cup bcel jaxp-1.3
	scp="src:${WORKDIR}/bsf-2.4.0/src"

  javac -J-Xmx512M -sourcepath $scp -cp $cp -d build `find src -name \*.java`
  (cd src && find org -name "*.properties" -exec cp {} ../build/{} \;)

  # Remove BSF classes
  rm -rf build-xalan/org/apache/bsf

  mkdir -p build-serializer/org/apache/xml
  mv build/org/apache/xml/serializer build-serializer/org/apache/xml

  fastjar -C build -c -f ${JARFILENAME} .
  fastjar -C build-serializer -c -f serializer-${PV}.jar .
}

do_install_append() {
  oe_jarinstall serializer-${PV}.jar serializer.jar

  # Like Debian we provide a symlink called xml-apis pointing to the JAXP
  # classes.
  ln -sf ${D}${datadir_java}/xml-apis.jar jaxp-1.3.jar
}

do_stage_append() {
	oe_jarinstall -s serializer-${PV}.jar serializer.jar
}

PACKAGES = "libxalan2-serializer-java ${JPN}"

FILES_libxalan2-serializer-java = "${datadir_java}/serializer*.jar"


SRC_URI[archive.md5sum] = "fc805051f0fe505c7a4b1b5c8db9b9e3"
SRC_URI[archive.sha256sum] = "fa52aa629bb882335d45d67401d270c3f21b5131aaea005ac0d4590f2ce8b043"
SRC_URI[bsf.md5sum] = "7e58b2a009c0f70ab36bbef420b25c07"
SRC_URI[bsf.sha256sum] = "5ab58cf5738c144f4d85a4a442c2f33be2c4c502dca6e29e0c570c2a51ae6ae9"
