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

SRC_URI[md5sum] = "4509f034b22aec5001e1402e53353f8e"
SRC_URI[sha256sum] = "2b7d24130c4b75ac824c397a7856e68c191c196e6cafb71c2dd51ed983bf48ca"
