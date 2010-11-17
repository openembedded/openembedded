DESCRIPTION = "network media server functionality"
PR = "r0"
LICENSE = "MIT"

inherit task

RDEPENDS_${PN} = "\
    python-coherence \
    mediatomb \
    mpd \
    gmpc \
    icecast \
    ushare \
    ampache \
    "

