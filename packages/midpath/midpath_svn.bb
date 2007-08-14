DESCRIPTION = "MIDPath is a Java library which provides a MIDP2 implementation"
HOMEPAGE = "http://midpath.thenesis.org/"
LICENSE  = "GPL"
PRIORITY = "optional"
SECTION  = "interpreters"

SRC_URI = "svn://midpath.svn.sourceforge.net/svnroot/midpath;module=trunk;proto=https"

S = "${WORKDIR}/trunk"

DEPENDS = "ecj-native fastjar-native classpath-minimal"
RPROVIDES_midpath-cldc = "virtual/cldc-api-1.1"

JAVAC_CMD=${STAGING_BINDIR_NATIVE}/ecj

FASTJAR_CMD=${STAGING_BINDIR_NATIVE}/fastjar

GNU_CLASSPATH_PATH=${STAGING_LIBDIR}/java/classpath-minimal/glibj.zip

do_compile() {

mkdir -p ${S}/dist

# Build CLDC1.1
# Build base classes
cd ${S}/external/cldc1.1/src
make JAVAC=${JAVAC_CMD} JAVAC_FLAGS="-bootclasspath . -source 1.3 -target 1.1" || exit 1
make install JAVAC=${JAVAC_CMD} JAVAC_FLAGS="-bootclasspath . -source 1.3 -target 1.1" CLASS_DIR=${S}/external/cldc1.1/classes || exit 1
# Build CLDC extra classes for MIDP2
cd ${S}/src/cldc-glue
make JAVAC=${JAVAC_CMD} JAVAC_FLAGS="-bootclasspath ${S}/external/cldc1.1/classes -sourcepath ${S}/src/cldc-glue -source 1.3 -target 1.1"
make install JAVAC=${JAVAC_CMD} JAVAC_FLAGS="-bootclasspath ${S}/external/cldc1.1/classes -source 1.3 -target 1.1" CLASS_DIR=${S}/external/cldc1.1/classes
# Make a jar
${FASTJAR_CMD} cvf  ${S}/dist/cldc1.1.jar -C ${S}/external/cldc1.1/classes .

CLDC_PATH=${S}/dist/cldc1.1.jar

# Build SDLJava for CLDC
cd ${S}/external/sdljava-cldc
make JAVAC=${JAVAC_CMD} JAVAC_FLAGS="-bootclasspath $CLDC_PATH:${GNU_CLASSPATH_PATH} -sourcepath ${S}/external/sdljava-cldc -source 1.3 -target 1.1" || exit 1
make jar JAVAC=${JAVAC_CMD} JAVAC_FLAGS="-bootclasspath $CLDC_PATH:${GNU_CLASSPATH_PATH} -source 1.3 -target 1.1" JAR_FILE="sdljava-cldc.jar" JAR_FLAGS="cvf" || exit 1
cp ${S}/external/sdljava-cldc/sdljava-cldc.jar ${S}/dist

# Build Escher X11 library
cd ${S}/external/escher-cldc/core
make JAVAC=${JAVAC_CMD} JAVAC_FLAGS="-bootclasspath $CLDC_PATH -sourcepath ${S}/external/escher-cldc/core -source 1.3 -target 1.1" || exit 1
make jar JAVAC=${JAVAC_CMD} JAVAC_FLAGS="-bootclasspath $CLDC_PATH -source 1.3 -target 1.1" JAR_FILE="escher-x11-cldc.jar" JAR_FLAGS="cvf" || exit 1
cp ${S}/external/escher-cldc/core/escher-x11-cldc.jar ${S}/dist

# Build MP3 library
cd ${S}/external/jlayerme-cldc/src
make JAVAC=${JAVAC_CMD} JAVAC_FLAGS="-bootclasspath $CLDC_PATH -sourcepath ${S}/external/jlayerme-cldc/src -source 1.3 -target 1.1" || exit 1
make jar JAVAC=${JAVAC_CMD} JAVAC_FLAGS="-bootclasspath $CLDC_PATH -source 1.3 -target 1.1" JAR_FILE="jlayerme-cldc.jar" JAR_FLAGS="cvf" || exit 1
cp ${S}/external/jlayerme-cldc/src/jlayerme-cldc.jar ${S}/dist

# Build OGG library
cd ${S}/external/jorbis-cldc/src
make JAVAC=${JAVAC_CMD} JAVAC_FLAGS="-bootclasspath $CLDC_PATH -sourcepath ${S}/external/jorbis-cldc/src -source 1.3 -target 1.1" || exit 1
make jar JAVAC=${JAVAC_CMD} JAVAC_FLAGS="-bootclasspath $CLDC_PATH -source 1.3 -target 1.1" JAR_FILE="jorbis-cldc.jar" JAR_FLAGS="cvf" || exit 1
cp ${S}/external/jorbis-cldc/src/jorbis-cldc.jar ${S}/dist

# Build Bluetooth library
cd ${S}/external/javabluetooth/src
make JAVAC=${JAVAC_CMD} JAVAC_FLAGS="-bootclasspath ${GNU_CLASSPATH_PATH}:$CLDC_PATH:${S}/lib/RXTXcomm.jar -sourcepath ${S}/external/javabluetooth/src -source 1.3 -target 1.1" || exit 1
make jar JAVAC=${JAVAC_CMD} JAVAC_FLAGS="-bootclasspath ${GNU_CLASSPATH_PATH}:$CLDC_PATH:${S}/lib/RXTXcomm.jar -source 1.3 -target 1.1" JAR_FILE="jsr82-bluetooth.jar" JAR_FLAGS="cvf" || exit 1
cp ${S}/external/javabluetooth/src/jsr82-bluetooth.jar ${S}/dist

# Build MIDPath
cd ${S}/src/core
make JAVAC=${JAVAC_CMD} JAVAC_FLAGS="-bootclasspath $CLDC_PATH:${GNU_CLASSPATH_PATH}:${S}/dist/sdljava-cldc.jar:${S}/dist/escher-x11-cldc.jar:${S}/dist/jlayerme-cldc.jar:${S}/dist/jorbis-cldc.jar:${S}/dist/jsr82-bluetooth.jar:${S}/lib/kxml2-2.3.0.jar:${S}/lib/swt.jar -sourcepath ${S}/src/core -source 1.3 -target 1.1" || exit 1
make install JAVAC=${JAVAC_CMD} JAVAC_FLAGS="-bootclasspath $CLDC_PATH:${GNU_CLASSPATH_PATH}:${S}/dist/sdljava-cldc.jar:${S}/dist/escher-x11-cldc.jar:${S}/dist/jlayerme-cldc.jar:${S}/dist/jorbis-cldc.jar:${S}/dist/jsr82-bluetooth.jar:${S}/lib/kxml2-2.3.0.jar:${S}/lib/swt.jar -source 1.3 -target 1.1" CLASS_DIR=${S}/src/core/classes || exit 1
# Compile JVM.java separately as it can't be compiled against cldc.jar
${JAVAC_CMD} -bootclasspath ${GNU_CLASSPATH_PATH} -source 1.3 -target 1.1 -d ${S}/src/core/classes com/sun/cldchi/jvm/JVM.java
${FASTJAR_CMD} cvf ${S}/dist/midpath.jar -C ${S}/src/core/classes .

cd ${S}/tests
make JAVAC=${JAVAC_CMD} JAVAC_FLAGS="-bootclasspath ${S}/dist/midpath.jar:$CLDC_PATH -sourcepath ${S}/tests -source 1.3 -target 1.1" || exit 1
make jar JAVAC=${JAVAC_CMD} JAVAC_FLAGS="-bootclasspath ${S}/dist/midpath.jar:$CLDC_PATH -source 1.3 -target 1.1" JAR_FILE="midpath-tests.jar" JAR_FLAGS="cvf" || exit 1
cp ${S}/tests/midpath-tests.jar ${S}/dist

# Add other required libraries to the dist directory
cp ${S}/lib/kxml2-2.3.0.jar ${S}/dist
}

do_install() {
	install -d ${D}${libdir}/java
	install -m 0644 dist/*.jar ${D}${libdir}/java
	install -d ${D}${libdir}/java/resources-embedded
	cp -rf resources-embedded/* ${D}${libdir}/java/resources-embedded/
	rm -rf  ${D}${libdir}/java/resources-embedded/.svn
}

do_stage() {
	install -d ${STAGING_LIBDIR}/java
	install -m 0644 dist/cldc1.1.jar ${STAGING_LIBDIR}/java
}

PACKAGES = "${PN} ${PN}-cldc"

FILES_${PN} = "${libdir}/java/midpath.jar \
	       ${libdir}/java/midpath-tests.jar \
	       ${libdir}/java/kxml2-2.3.0.jar \
	       ${libdir}/java/resources-embedded/com/sun/midp/configuration/ \
	       ${libdir}/java/resources-embedded/com/sun/midp/configuration/chameleon/ \
	       ${libdir}/java/resources-embedded/com/sun/midp/configuration/l10n/ \
	       ${libdir}/java/resources-embedded/com/sun/midp/chameleon/skins/resources/images/ \

	       ${libdir}/java/resources-embedded/org/thenesis/midpath/font/bdf/ \
	      " 
FILES_${PN}-cldc =  "${libdir}/java/cldc1.1.jar"

CONFFILES_${PN} = "${libdir}/java/resources-embedded/com/sun/midp/configuration/configuration.cfg"
