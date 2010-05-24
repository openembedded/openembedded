DESCRIPTION = "Tree-based API for processing XML with Java"
LICENSE = "LGPL"

HOMEPAGE = "http://xom.nu"

SRC_URI = "\
	http://www.cafeconleche.org/XOM/${P}-src.tar.gz;name=archive \
	http://dist.codehaus.org/jaxen/distributions/jaxen-1.1.1-src.tar.gz;name=jaxen \
	file://04_remove_sun_import.patch \
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

SRC_URI[archive.md5sum] = "e5ae82568d7b1faeb950140c34fbbcb1"
SRC_URI[archive.sha256sum] = "d648fd1f7b7437123afa63df06f6a6409a0487c99ca8f8beba75aaa474d65818"
SRC_URI[jaxen.md5sum] = "b598ae6b7e765a92e13667b0a80392f4"
SRC_URI[jaxen.sha256sum] = "f24ae604a20da87e3716bb1d441c483e56479eaef4e99888f41be06059790bca"
