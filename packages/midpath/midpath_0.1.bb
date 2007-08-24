
require midpath.inc

DEPENDS += " kxml2 midpath-cldc midpath-cldc-x11 midpath-cldc-sdl"
RSUGGESTS += " kxml2"

do_compile() {

mkdir -p ${S}/dist

# Build MP3 library
cd ${S}/external/jlayerme-cldc/src
make JAVAC=${JAVAC_CMD} JAVAC_FLAGS="-bootclasspath ${CLDC_PATH} -sourcepath ${S}/external/jlayerme-cldc/src -source 1.3 -target 1.1" || exit 1
make jar JAVAC=${JAVAC_CMD} JAVAC_FLAGS="-bootclasspath ${CLDC_PATH} -source 1.3 -target 1.1" JAR_FILE="jlayerme-cldc.jar" JAR_FLAGS="cvf" || exit 1
cp ${S}/external/jlayerme-cldc/src/jlayerme-cldc.jar ${S}/dist

# Build OGG library
cd ${S}/external/jorbis-cldc/src
make JAVAC=${JAVAC_CMD} JAVAC_FLAGS="-bootclasspath ${CLDC_PATH} -sourcepath ${S}/external/jorbis-cldc/src -source 1.3 -target 1.1" || exit 1
make jar JAVAC=${JAVAC_CMD} JAVAC_FLAGS="-bootclasspath ${CLDC_PATH} -source 1.3 -target 1.1" JAR_FILE="jorbis-cldc.jar" JAR_FLAGS="cvf" || exit 1
cp ${S}/external/jorbis-cldc/src/jorbis-cldc.jar ${S}/dist

# Build Bluetooth library
cd ${S}/external/javabluetooth/src
make JAVAC=${JAVAC_CMD} JAVAC_FLAGS="-bootclasspath ${GNU_CLASSPATH_PATH}:${CLDC_PATH}:${S}/lib/RXTXcomm.jar -sourcepath ${S}/external/javabluetooth/src -source 1.3 -target 1.1" || exit 1
make jar JAVAC=${JAVAC_CMD} JAVAC_FLAGS="-bootclasspath ${GNU_CLASSPATH_PATH}:${CLDC_PATH}:${S}/lib/RXTXcomm.jar -source 1.3 -target 1.1" JAR_FILE="jsr82-bluetooth.jar" JAR_FLAGS="cvf" || exit 1
cp ${S}/external/javabluetooth/src/jsr82-bluetooth.jar ${S}/dist

# Build MIDPath
cd ${S}/src/core
make JAVAC=${JAVAC_CMD} JAVAC_FLAGS="-bootclasspath ${CLDC_PATH}:${GNU_CLASSPATH_PATH}:${JAVA_PATH}/sdljava-cldc.jar:${JAVA_PATH}/escher-x11-cldc.jar:${S}/dist/jlayerme-cldc.jar:${S}/dist/jorbis-cldc.jar:${S}/dist/jsr82-bluetooth.jar:${JAVA_PATH}/kxml2-2.3.0.jar:${S}/lib/swt.jar -sourcepath ${S}/src/core -source 1.3 -target 1.1" || exit 1
make install JAVAC=${JAVAC_CMD} JAVAC_FLAGS="-bootclasspath ${CLDC_PATH}:${GNU_CLASSPATH_PATH}:${JAVA_PATH}/sdljava-cldc.jar:${JAVA_PATH}/dist/escher-x11-cldc.jar:${S}/dist/jlayerme-cldc.jar:${S}/dist/jorbis-cldc.jar:${S}/dist/jsr82-bluetooth.jar:${JAVA_PATH}/lib/kxml2-2.3.0.jar:${S}/lib/swt.jar -source 1.3 -target 1.1" CLASS_DIR=${S}/src/core/classes || exit 1
# Compile JVM.java separately as it can't be compiled against cldc.jar
${JAVAC_CMD} -bootclasspath ${GNU_CLASSPATH_PATH} -source 1.3 -target 1.1 -d ${S}/src/core/classes com/sun/cldchi/jvm/JVM.java
${FASTJAR_CMD} cvf ${S}/dist/midpath.jar -C ${S}/src/core/classes .

}

do_install() {
	install -d ${D}${datadir}/java
	install -m 0644 dist/midpath.jar ${D}${datadir}/java
	install -d ${D}${datadir}/java/resources-embedded
	cp -rf resources-embedded/ ${D}${datadir}/java/
}

do_stage() {
	install -d ${STAGING_DATADIR}/java
	install -m 0644 dist/midpath.jar ${STAGING_DATADIR}/java
}

PACKAGES = "${PN}"

FILES_${PN} = "${datadir}/java/midpath.jar \
	       ${datadir}/java/resources-embedded/com/sun/midp/configuration/ \
	       ${datadir}/java/resources-embedded/com/sun/midp/configuration/chameleon/ \
	       ${datadir}/java/resources-embedded/com/sun/midp/configuration/l10n/ \
	       ${datadir}/java/resources-embedded/com/sun/midp/chameleon/skins/resources/images/ \

	       ${datadir}/java/resources-embedded/org/thenesis/midpath/font/bdf/ \
	      " 
CONFFILES_${PN} = "${datadir}/java/resources-embedded/com/sun/midp/configuration/configuration.cfg"
