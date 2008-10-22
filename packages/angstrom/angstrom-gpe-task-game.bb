DESCRIPTION = "Task packages for the Angstrom distribution"
PR = "r32"

inherit task

RDEPENDS_${PN} = "\
    gpe-go \
    gpe-lights \
    gpe-othello \
    gpe-tetris \
    gsoko \
#    xdemineur \
"
