###########################################################################
# Currently supports :
#   HP Jornada 620/660/680/690
#   HP Jornada 710/720/728
#   Nec Mobilepro 900c
#   Nec Mobilpro  770/880

DESCRIPTION = "2.6 Linux Development Kernel for JLime supported Machines."
SECTION = "kernel"
LICENSE = "GPLv2"

COMPATIBLE_MACHINE = "fillmein"

inherit kernel

PR = "r1"

SRC_URI = "git://filip.eu.org/jlime-current.git;protocol=git \
           git://filip.eu.org/jlime.git;protocol=git"

S = "${WORKDIR}/jlime-current"
