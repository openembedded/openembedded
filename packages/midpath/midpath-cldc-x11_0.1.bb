
require midpath.inc

DEPENDS += " virtual/libx11 virtual/cldc-api-1.1"

do_configure() {
	
	cd ${S}/resources-embedded/com/sun/midp/configuration
	sed -i -e "s|ui.backend:AWT|ui.backend:X11|" configuration.cfg

}

do_compile() {

# Build Escher X11 library
cd ${S}/external/escher-cldc/core
make JAVAC=${JAVAC_CMD} JAVAC_FLAGS="-bootclasspath ${CLDC_PATH} -sourcepath ${S}/external/escher-cldc/core -source 1.3 -target 1.1" || exit 1
make jar JAVAC=${JAVAC_CMD} JAVAC_FLAGS="-bootclasspath ${CLDC_PATH} -source 1.3 -target 1.1" JAR_FILE="escher-x11-cldc.jar" JAR_FLAGS="cvf" || exit 1

}

do_install() {
	install -d ${D}${datadir}
	install -m 0644 ${S}/external/escher-cldc/core/escher-x11-cldc.jar ${D}${datadir}
	install -d ${D}${datadir}/java/resources-embedded/com/sun/midp/configuration
	install -m 0644 resources-embedded/com/sun/midp/configuration/configuration.cfg ${D}${datadir}/java/resources-embedded/com/sun/midp/configuration/
}

do_stage() {
        install -d ${STAGING_DATADIR}/java
        install -m 0644 ${S}/external/escher-cldc/core/escher-x11-cldc.jar ${STAGING_DATADIR}/java
}
	
PACKAGES = "${PN}"

FILES_${PN}  = "${datadir}/java/escher-x11-cldc.jar \
		${datadir}/java/resources-embedded/com/sun/midp/configuration/configuration.cfg \
	       "
