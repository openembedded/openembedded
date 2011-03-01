LICENSE = "MIT"
PV = "0.0.1+svnr${SRCREV}"
PR = "${INC_PR}.0"

require e-module.inc

DEPENDS += "elementary"

# Elfe is part of the enlightenment svn repository since this SRC_REV. As EFL_SRCREV is
# currently much older we need to sync it when EFL_SRCREV will change.
SRCREV = "57458"

