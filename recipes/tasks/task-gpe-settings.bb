DESCRIPTION = "Settings task package for GPE Palmtop Environment"
PR = "r6"
LICENSE = "MIT"

inherit task

RDEPENDS_${PN} = "\
    gpe-mininet \
    gpe-bluetooth \
    gpe-beam \
    matchbox-panel-manager \
    gpe-su \
    gpe-conf \
    gpe-clock \
    gpe-mixer \
    gpe-package \
    gpe-shield \
    gpe-taskmanager \
    keylaunch \
    minilite \
    minimix \
    xmonobut"

