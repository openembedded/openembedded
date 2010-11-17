DESCRIPTION = "programs to import content from external sources"
PR = "r0"
LICENSE = "MIT"

inherit task

# needs a choice between rtorrent and transmission
RDEPENDS_${PN} = "\
    rtorrent \
    transmission \
    ivman \
    cdstatus \
    gphoto2 \
    nzbget \
    streamripper \
    "

