DESCRIPTION = "Reference implementation of XNI, the Xerces Native Interface, and also a fully conforming XML Schema processor."
LICENSES = "AL2.0"
AUTHOR = "Apache Software Foundation"

SRC_URI = "http://www.apache.org/dist/xerces/j/Xerces-J-src.${PV}.tar.gz"

S = "${WORKDIR}/xerces-2_9_1"

inherit java-library

JPN = "libxerces2-java"

DEPENDS = "fastjar-native jaxp1.3 xml-commons-resolver1.1"
RDEPENDS = "libjaxp1.3-java libxml-commons-resolver1.1-java"

do_unpackpost() {
  find src -exec \
    sed -i -e "s|@impl.name@|Xerces-J ${PV}|" \
           -e "s|@impl.version@|${PV}|" {} \;
}

addtask unpackpost after do_unpack before do_patch

JARFILENAME = "xercesImpl.jar"
ALTJARFILENAMES = ""

do_compile() {
  mkdir -p build

  # Prepend the bootclasspath with the earlier XML API to make
  # compilation succeed.
  oe_makeclasspath bcp -s jaxp-1.3 resolver
	bcp=$bcp:${STAGING_DATADIR_NATIVE}/classpath/glibj.zip

  javac -sourcepath src -d build -bootclasspath $bcp `find src -name "*.java"`

  (cd src && find org ! -name "*.java" -exec cp {} ../build/{} \;)

  fastjar -C build -c -m src/manifest.xerces -f ${JARFILENAME} .

  # Like Debian we provide a symlink called xmlParserAPIs.jar pointing to the JAXP
  # classes.
  ln -sf ${D}${datadir_java}/xmlParserAPIs.jar jaxp-1.3.jar

}

SRC_URI[md5sum] = "e340cba4a2abf4f0f833488380821153"
SRC_URI[sha256sum] = "13af0062a72a4a0d541ca5336391eafa4d580258cacf4a5e062ea584ca950592"
