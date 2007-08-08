
require midpath_${PV}.bb

DEPENDS += "virtual/libx11 virtual/cldc-api-1.1"
RDEPENDS = "libx11"

CLDC_PATH = ${STAGING_LIBDIR}/java/cldc1.1.jar

do_configure() {
	
	cd ${S}/resources-embedded/com/sun/midp/configuration
	sed -i -e "s|ui.backend:AWT|ui.backend:X11|" configuration.cfg

}

do_compile() {

mkdir -p ${S}/dist

# Build Escher X11 library
cd ${S}/external/escher-cldc/core
make JAVAC=${JAVAC_CMD} JAVAC_FLAGS="-bootclasspath ${CLDC_PATH} -sourcepath ${S}/external/escher-cldc/core -source 1.3 -target 1.1" || exit 1
make jar JAVAC=${JAVAC_CMD} JAVAC_FLAGS="-bootclasspath ${CLDC_PATH} -source 1.3 -target 1.1" JAR_FILE="escher-x11-cldc.jar" JAR_FLAGS="cvf" || exit 1
cp ${S}/external/escher-cldc/core/escher-x11-cldc.jar ${S}/dist

}

do_install() {
	install -d ${D}${libdir}
	install -m 0644 dist/escher-x11-cldc.jar ${D}${libdir}
	install -d ${D}${libdir}/java/resources-embedded/com/sun/midp/configuration
	install -m 0644 resources-embedded/com/sun/midp/configuration/configuration.cfg ${D}${libdir}/java/resources-embedded/com/sun/midp/configuration/
}

do_stage() {
	:
}
	
PACKAGES = "${PN}"

FILES_${PN}  = "${libdir}/java/escher-x11-cldc.jar \
		${libdir}/java/resources-embedded/com/sun/midp/configuration/configuration.cfg \
	       "
