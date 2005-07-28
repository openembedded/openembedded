SECTION = "base"
PRIORITY = "optional"
DESCRIPTION = "Inputpipe is a network transparency layer for linux input devices"
MAINTAINER = "Micah Dowty <micah@navi.cx>"
LICENSE = "GPL"
PV = "0.5+svn-${CVSDATE}"
SRC_URI = "svn://svn.navi.cx/misc/trunk;module=inputpipe;proto=http"

S = "${WORKDIR}/inputpipe"

do_compile() {
	oe_runmake CC="${CC}" CFLAGS="-I ${WORKDIR}/inputpipe/uinput ${CFLAGS}"
}

do_install() {
        install -d ${D}${bindir}
	install	inputpipe-server ${D}${bindir}
	install	inputpipe-client ${D}${bindir}
}

PACKAGES = "inputpipe-server inputpipe-client"

FILES_inputpipe-client = "${bindir}/inputpipe-client"
FILES_inputpipe-server = "${bindir}/inputpipe-server"
