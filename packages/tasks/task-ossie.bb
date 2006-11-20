DESCRIPTION = "Meta-package for OSSIE Software Defined Radio (SDR)"
LICENSE = "MIT"
RDEPENDS = "${OSSIE_BASE} ${OSSIE_PLATFORM} ${OSSIE_COMPONENTS}"
PR = "r0"

PACKAGES = "task-ossie"

ALLOW_EMPTY = "1"

IPKG_INSTALL = "${OSSIE_BASE} ${OSSIE_PLATFORM} ${OSSIE_COMPONENTS}"

OSSIE_BASE = "screen procps xerces-c omniorb usrp"
OSSIE_PLATFORM = "ossiecf ossie-standardinterfaces ossie-nodebooter ossie-c-wavloader"
OSSIE_COMPONENTS = "ossie-gpp-device ossie-usrp-device ossie-soundout-device ossie-demo ossie-channeldemo ossie-rxdemo"
