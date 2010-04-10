DESCRIPTION = "Java library for manipulating various file formats based upon Microsoft's OLE 2 Compound Document"
LICENSE = "AL2.0"
AUTHOR = "Apache Software Foundation"

SRC_URI = "http://www.apache.org/dist/jakarta/poi/release/src/${BPN}-src-${PV}-FINAL-20070503.tar.gz"

S = "${WORKDIR}/${BPN}-3.0-rc4"

inherit java-library

DEPENDS = "fastjar-native commons-collections3 commons-logging commons-lang commons-beanutils log4j1.2 xalan-j"

do_compile() {
  mkdir -p build

  oe_makeclasspath cp -s commons-collections3 commons-logging commons-lang commons-beanutils log4j-1.2 xalan2

  javac -sourcepath src/java -cp $cp -d build \
    `find src/java -name \*.java`

  (cd src/java && find . -name "*.properties" -exec cp {} ../../build/{} \;)

  fastjar -C build -c -f ${JARFILENAME} .
}

SRC_URI[md5sum] = "1fb488c4061256197a667f1c480ffc33"
SRC_URI[sha256sum] = "48a5aabb873d4cc654c95acf6576868d7a8a3ee97e1c6418e1d716698b6efa76"
