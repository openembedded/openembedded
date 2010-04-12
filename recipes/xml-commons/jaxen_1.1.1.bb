DESCRIPTION = "XPath library written in Java"
LICENSE = "BSD"

HOMEPAGE = "http://jaxen.codehaus.org/

DEPENDS = "fastjar-native xerces-j xom"

SRC_URI = "\
	http://dist.codehaus.org/jaxen/distributions/jaxen-${PV}-src.tar.gz;name=archive \
	http://www.jdom.org/dist/binary/archive/jdom-1.1.tar.gz;name=jdom \
	"

inherit java-library

do_compile() {
  mkdir -p build

  oe_makeclasspath cp -s xercesImpl xom
	scp="src/java/main:${WORKDIR}/jdom-1.1/src/java"

  javac -sourcepath $scp -cp $cp -d build `find src/java/main -name "*.java" -and -not -wholename "*dom4j*"`
  (cd src && find org -name "*.properties" -exec cp {} ../build/{} \;)

	rm -rf build/org/jdom

  fastjar -C build -c -f ${JARFILENAME} .
}


SRC_URI[archive.md5sum] = "b598ae6b7e765a92e13667b0a80392f4"
SRC_URI[archive.sha256sum] = "f24ae604a20da87e3716bb1d441c483e56479eaef4e99888f41be06059790bca"
SRC_URI[jdom.md5sum] = "22745cbaaddb12884ed8ee09083d8fe2"
SRC_URI[jdom.sha256sum] = "a13549087141be24ad176b659afdc2c675f1ffa5288ff999a193d6d44a282056"
