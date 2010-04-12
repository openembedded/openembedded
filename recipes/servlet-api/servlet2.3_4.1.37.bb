DESCRIPTION = "Servlet API 2.3 (from Tomcat 4.1)"
LICENSE = "AL2.0"
AUTHOR = "Apache Software Foundation"

SRC_URI = "http://archive.apache.org/dist/tomcat/tomcat-4/v${PV}/src/apache-tomcat-${PV}-src.tar.gz"

inherit java-library

S = "${WORKDIR}/apache-tomcat-${PV}-src/servletapi"

DEPENDS = "fastjar-native"

# Value of implementation.revision in build.xml
IMPL_REVISION = "1"

JARFILENAME = "servlet-2.3.${IMPL_REVISION}.jar"
ALTJARFILENAMES = "servlet-2.3.jar servlet2.3.jar"

do_unpackpost() {
  sed -i -e "s|@implementation.version@|${IMPL_REVISION}|" src/etc/manifest
}

addtask unpackpost after do_unpack before do_patch

do_compile() {
  mkdir -p build

  javac -sourcepath src/share -d build `find src/share/javax -name \*.java`

  # Copy extraneous files according to build.xml's compile task
  (cd src/share && find . -name "*.properties" -exec cp {} ../../build/{} \;)

  mkdir -p build/javax/servlet/resources
  cp src/share/dtd/web-app*.dtd build/javax/servlet/resources

  mkdir -p build/javax/servlet/jsp/resources
  cp src/share/dtd/web-jsptaglibrary*.dtd build/javax/servlet/jsp/resources
  cp src/share/dtd/jspxml.* build/javax/servlet/jsp/resources

  fastjar -C build -c -m src/etc/manifest -f ${JARFILENAME} .
}

SRC_URI[md5sum] = "fe50177a25a084ad1abf4a201d08c2a6"
SRC_URI[sha256sum] = "65e4cc9d3ea4a7f30044bfd6c660c772adb75ac152d775342deb6049a0d19d74"
