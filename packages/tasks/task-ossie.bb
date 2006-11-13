PACKAGES = task-ossie
DESCRIPTION = "Meta-package for OSSIE Software Defined Radio (SDR)"
ALLOW_EMPTY = 1
PR = "r0"

OSSIE_BASE = "screen procps xerces-c omniorb usrp"

OSSIE_PLATFORM = "ossiecf ossie-standardinterfaces ossie-nodebooter ossie-c-wavloader"

OSSIE_COMPONENTS = "ossie-gpp-device ossie-usrp-device ossie-soundout-device ossie-demo ossie-channeldemo ossie-rxdemo"


RDEPENDS = "${OSSIE_BASE} ${OSSIE_PLATFORM} ${OSSIE_COMPONENTS}"

IPKG_INSTALL = "${OSSIE_BASE} ${OSSIE_PLATFORM} ${OSSIE_COMPONENTS}"

LICENSE = MIT

