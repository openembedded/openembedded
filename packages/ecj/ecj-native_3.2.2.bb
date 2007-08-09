DESCRIPTION = "JDT Core Batch Compiler"
HOMEPAGE = "http://www.eclipse.org/"
PRIORITY = "optional"
SECTION = "devel"
LICENSE = "EPL"
PR = "r0"

inherit native

SRC_URI = "http://mirrors.ibiblio.org/pub/mirrors/eclipse/eclipse/downloads/drops/R-3.2.2-200702121330/ecj.jar \
	   file://ecj.sh"

do_stage() {
        install -d ${STAGING_BINDIR_NATIVE}
        install -m 755 ${S}/../ecj.jar ${STAGING_BINDIR_NATIVE}
	install -m 755 ${S}/../ecj.sh ${STAGING_BINDIR_NATIVE}/ecj
}
