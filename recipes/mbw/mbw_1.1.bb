DESCRIPTION = "Memory bandwidth benchmark"
AUTHOR = "Andras Horvath <Andras.Horvath@cern.ch>"

SRC_URI = "http://ahorvath.web.cern.ch/ahorvath/mbw/mbw-${PV}-1.tar.gz"

S = "${WORKDIR}/mbw/"

inherit autotools

do_install() {
        install -d ${D}${bindir} ${D}${mandir}
        install -m 755  mbw ${D}${bindir}
        install -m 644  mbw.1 ${D}${mandir}/man1/
}
