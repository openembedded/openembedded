PACKAGES = task-ossie
DESCRIPTION = "Meta-package for OSSIE Software Defined Radio (SDR)"
ALLOW_EMPTY = 1
PR = "r0"

OSSIE_INSTALL = "screen procps xerces-c omniorb usrp ossiecf ossie-standardinterfaces ossie-nodebooter"

OSSIE_COMPONENTS = "ossie-gpp-device ossie-usrp-device ossie-demo ossie-channeldemo ossie-rxdemo"


RDEPENDS = "${OSSIE_INSTALL} ${OSSIE_COMPONENTS}"

IPKG_INSTALL = "${OSSIE_INSTALL}"

LICENSE = MIT
