DESCRIPTION = "Connectivity task packages for GPE Palmtop Environment"
FILE_PR = "r6"
LICENSE = "MIT"

inherit task

RDEPENDS_${PN} = "\
    gpe-mini-browser \
    gpe-irc"

