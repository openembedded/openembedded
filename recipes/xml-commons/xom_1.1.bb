DESCRIPTION = "Tree-based API for processing XML with Java"
LICENSE = "LGPL"

HOMEPAGE = "http://xom.nu"

SRC_URI = "\
	http://www.cafeconleche.org/XOM/${P}-src.tar.gz \
	http://dist.codehaus.org/jaxen/distributions/jaxen-1.1.1-src.tar.gz \
	file://04_remove_sun_import.patch;patch=1 \
	"

S = "${WORKDIR}/XOM"

inherit java-library

DEPENDS = "fastjar-native xerces-j xalan-j"

do_compile() {
  mkdir -p build

	oe_makeclasspath cp -s xercesImpl xalan2
  cp=build:$cp

	scp="${WORKDIR}/jaxen-1.1.1/src/java/main"
                 
  javac -sourcepath src:$scp -cp $cp -d build `find src -name "*.java" -and -not \( -wholename "*tests*" -or -wholename "*samples*" -or -wholename "*tools*" \)`
  javac -sourcepath fatsrc:$scp -cp $cp -d build `find fatsrc -name "*.java" -and -not \( -wholename "*tests*" -or -wholename "*samples*" -or -wholename "*tools*" \)`
  javac -sourcepath src15:$scp -cp $cp -d build `find src15 -name "*.java" -and -not \( -wholename "*tests*" -or -wholename "*samples*" -or -wholename "*tools*" \)`

  (cd src && find . -name "*.properties" -exec cp {} ../build/{} \;)

	#	Remove Jaxen classes from build
	rm -rf build/org/jaxen
	rm -rf build/org/w3c

  fastjar -C build -c -f ${JARFILENAME} .
}
