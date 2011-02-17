DESCRIPTION = "Application task package for GPE Palmtop Environment"
PR = "r7"
LICENSE = "MIT"

inherit task

RDEPENDS_${PN} = "\
    gpe-edit \
    gpe-gallery \
    gpe-calculator \
    gpe-clock \
    gpe-plucker \
    gpe-terminal \
    gpe-watch \
    gpe-what \
    matchbox-panel-hacks \
    rosetta \
    gpe-scap \
    gpe-windowlist \
    gpe-filemanager \
    gpe-soundbite \
    mbmerlin \
    starling"

