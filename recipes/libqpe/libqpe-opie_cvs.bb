require ${PN}.inc

# OPIE_CVS_PV is defined in opie.bbclass
# but this recipe does not inherit opie
# so any updates to OPIE_CVS_PV should happen
# in both places.

OPIE_CVS_PV ?= "1.2.2+cvs${SRCDATE}"
PV = "${OPIE_CVS_PV}"
PR = "${INC_PR}.0"

SRC_URI = "${HANDHELDS_CVS};module=opie/library \
           file://fix-titleheight.patch;apply=yes \
           file://unbreak-logging.patch;apply=yes \
           file://citytime-path-2.patch;apply=yes \
           file://no-include-pro.patch;apply=yes \
          "
