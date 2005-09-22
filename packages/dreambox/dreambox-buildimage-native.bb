DESCRIPTION = "create Dreambox NAND boot images"
SECTION = "console/utils"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"
PV = "1.0"
PR = "r1"

SRC_URI = "file://buildimage.c"

inherit native

do_compile() {
	cp ${WORKDIR}/buildimage.c .
	${CXX} -I. -o buildimage buildimage.c
}

do_stage() {
	install -m 0755 buildimage ${STAGING_BINDIR}/
}
