LICENSE = "MIT"
PV = "0.0.1+svnr${SRCREV}"
PR = "${INC_PR}.0"

require e-module.inc

DEPENDS += "elementary"

# We currently use another SRCREV for elfe as EFL_SRCREV as we have to change it more
# often than we want to change EFL_SRCREV.
SRCREV = "60365"

