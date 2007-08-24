
require midpath.inc

SRC_URI += "file://shellscript.patch;patch=1"

DEPENDS += " midpath"
RDEPENDS += " midpath"

CLDC_PATH = ${STAGING_DATADIR}/java/cldc1.1.jar

do_configure() {
        
        cd ${S}/bin
        sed -i -e "s|MIDPATH_HOME=|MIDPATH_HOME=${datadir}/java|" \
		   midpath-test-cacao-cldc.sh

}

do_compile() {

cd ${S}/tests
make JAVAC=${JAVAC_CMD} JAVAC_FLAGS="-bootclasspath ${STAGING_DATADIR}/java/midpath.jar:${CLDC_PATH} -sourcepath ${S}/tests -source 1.3 -target 1.1" || exit 1
make jar JAVAC=${JAVAC_CMD} JAVAC_FLAGS="-bootclasspath ${STAGING_DATADIR}/java/midpath.jar:${CLDC_PATH} -source 1.3 -target 1.1" JAR_FILE="midpath-tests.jar" JAR_FLAGS="cvf" || exit 1

}

do_install() {
	install -d ${D}${bindir}
#	install -m 0755 bin/graphical_launcher-j2se.sh ${D}${bindir}
#	install -m 0755 bin/midpath-test.sh ${D}${bindir}
	install -m 0755 bin/midpath-test-cacao-cldc.sh ${D}${bindir}
	install -d ${D}${datadir}/java
	install -m 0644 ${S}/tests/midpath-tests.jar ${D}${datadir}/java
}

do_stage() {
	:
}
	
PACKAGES = "${PN}"

FILES_${PN}  = "${datadir}/java/midpath-tests.jar \
#		${bindir}/graphical_launcher-j2se.sh \
#		${bindir}/midpath-test.sh \
		${bindir}/midpath-test-cacao-cldc.sh \
	       "
