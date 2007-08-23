DESCRIPTION = "Connectivity task packages for GPE Palmtop Environment"
PR = "r6"
LICENSE = "MIT"

inherit task

RDEPENDS_${PN} = "\
    gpe-mini-browser \
    gpe-irc"

