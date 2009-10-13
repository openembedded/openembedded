DESCRIPTION = "dom4j is a simple and flexible Java library for working with XML, XPath and XSLT"
LICENSE = "BSD"

HOMEPAGE = "http://dom4j.org

DEPENDS = "fastjar-native xerces-j xalan-j xpp2 xpp3 jaxen"

SRC_URI = "\
	${SOURCEFORGE_MIRROR}/dom4j/${P}.tar.gz \
	http://apache.org/dist/ws/jaxme/source/ws-jaxme-0.5.2-src.tar.gz \
	file://debian.patch;patch=1 \
	"

inherit java-library

do_compile() {
  mkdir -p build

  oe_makeclasspath cp -s xercesImpl xalan2 xpp2 xpp3 jaxen
	scp="src/java:${WORKDIR}/ws-jaxme-0.5.2/src/api"

  javac -sourcepath $scp -cp $cp -d build `find src/java -name "*.java" -and -not -wholename "*datatype*"`
  (cd src && find org -name "*.properties" -exec cp {} ../build/{} \;)

	rm -rf build/org/w3c
	rm -rf build/javax

  fastjar -C build -c -f ${JARFILENAME} .
}

