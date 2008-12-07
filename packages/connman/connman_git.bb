require connman.inc
PV       = "0.0+gitr${SRCREV}"
PR       = "r4.02"
PE       = "1"
S        = "${WORKDIR}/git"

DEPENDS  += "libgdbus hal"

SRC_URI  = "git://git.moblin.org/repos/projects/connman.git;protocol=http \
            file://use_nm_in_cross_compiling.patch;patch=1\
            file://connman "
