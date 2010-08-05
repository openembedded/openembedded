require ${PN}.inc

# OPIE_GIT_PV is defined in opie.bbclass
# but this recipe does not inherit opie
# so any updates to OPIE_GIT_PV should happen
# in both places.

OPIE_GIT_PV ?= "1.2.2+cvs${SRCDATE}"
PV = "${OPIE_GIT_PV}"
PR = "${INC_PR}.0"

DEPENDS += " sysfsutils"

SRC_URI = "${OPIE_GIT};protocol=git;subpath=library \
           file://fix-titleheight.patch \
           file://unbreak-logging-2.patch \
           file://citytime-path-2.patch \
           file://no-include-pro.patch \
          "
