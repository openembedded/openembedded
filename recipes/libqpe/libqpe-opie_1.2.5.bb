require ${PN}.inc

# OPIE_GIT_PV is defined in opie.bbclass
# but this recipe does not inherit opie
# so any updates to OPIE_GIT_PV should happen
# in both places.

PR = "r0"

DEPENDS += " sysfsutils"

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_library.tar.bz2 \
           file://fix-titleheight.patch \
           file://unbreak-logging-2.patch \
           file://citytime-path-2.patch \
           file://no-include-pro.patch \
          "
