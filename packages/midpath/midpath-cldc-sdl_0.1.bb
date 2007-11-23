
require midpath.inc

do_configure() {
        
        cd ${S}/resources-embedded/com/sun/midp/configuration
        sed -i -e "s|ui.backend:AWT|ui.backend:SDL|" \
	       -e "s|bitsPerPixel:32|bitsPerPixel:16|" \
	       configuration.cfg

}


do_compile() {

# Build SDLJava for CLDC
cd ${S}/external/sdljava-cldc
make JAVAC=${JAVAC_CMD} JAVAC_FLAGS="-bootclasspath ${CLDC_PATH}:${GNU_CLASSPATH_PATH} -sourcepath ${S}/external/sdljava-cldc -source 1.3 -target 1.1" || exit 1
make jar JAVAC=${JAVAC_CMD} JAVAC_FLAGS="-bootclasspath ${CLDC_PATH}:${GNU_CLASSPATH_PATH} -source 1.3 -target 1.1" JAR_FILE="sdljava-cldc.jar" JAR_FLAGS="cvf" || exit 1

}

do_install() {
	install -d ${D}${datadir}/java
	install -m 0644 ${S}/external/sdljava-cldc/sdljava-cldc.jar ${D}${datadir}/java
	install -d ${D}${datadir}/java/resources-embedded/com/sun/midp/configuration
        install -m 0644 resources-embedded/com/sun/midp/configuration/configuration.cfg ${D}${datadir}/java/resources-embedded/com/sun/midp/configuration/
}

do_stage() {
	install -d ${STAGING_DATADIR}/java
	install -m 0644 ${S}/external/sdljava-cldc/sdljava-cldc.jar ${STAGING_DATADIR}/java
}
	
PACKAGES = "${PN}"

FILES_${PN}  = "${datadir}/java/sdljava-cldc.jar \
		${datadir}/java/resources-embedded/com/sun/midp/configuration/configuration.cfg \
	       "

CONFFILES_${PN} = "${datadir}/java/resources-embedded/com/sun/midp/configuration/configuration.cfg"
