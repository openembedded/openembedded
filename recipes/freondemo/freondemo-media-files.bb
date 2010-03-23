DESCRIPTION = "FreonDemo: Media files to include on freondemo"
HOMEPAGE = "http://sourceforge.net/projects/freondemo"
LICENSE = "Unknown"
SECTION = "multimedia"
PRIORITY = "optional"

PV = "1.0"
PR = "r2"

SRC_URI = "http://downloads.sourceforge.net/project/freondemo/media_files.tar.gz;name=freonmediafiles"
SRC_URI[freonmediafiles.md5sum] = "ffc705fc5581c584d88bd88a8b9caedf"

S = "${WORKDIR}"

inherit base

do_install() {
    mkdir -p ${D}/${datadir}/mediafiles
    cp -R ${S}/*.m4a ${D}/${datadir}/mediafiles
    cp -R ${S}/*.m4v ${D}/${datadir}/mediafiles
    cp -R ${S}/*.aac ${D}/${datadir}/mediafiles
    cp -R ${S}/*.license ${D}/${datadir}/mediafiles
}

FILES_${PN} += "${datadir}/mediafiles"
