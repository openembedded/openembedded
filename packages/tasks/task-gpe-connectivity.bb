DESCRIPTION = "Connectivity task packages for GPE Palmtop Environment"
PR = "r7"
LICENSE = "MIT"

inherit task

RDEPENDS_${PN} = "\
    gpe-mini-browser2 \
    gpe-irc"

