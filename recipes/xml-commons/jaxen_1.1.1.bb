DESCRIPTION = "XPath library written in Java"
LICENSE = "BSD"

HOMEPAGE = "http://jaxen.codehaus.org/

DEPENDS = "fastjar-native xerces-j xom"

SRC_URI = "\
	http://dist.codehaus.org/jaxen/distributions/jaxen-${PV}-src.tar.gz \
	http://www.jdom.org/dist/binary/archive/jdom-1.1.tar.gz \
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

