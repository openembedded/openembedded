require abiword-2.5.inc

EXTRA_OECONF += "--enable-embedded"

S = "${WORKDIR}/abiword-${PV}"

RCONFLICTS = "abiword"
RPROVIDES += "abiword"

SRC_URI[md5sum] = "16748b2d6e318e0e2a25581005e1943a"
SRC_URI[sha256sum] = "4d2d7a6b69b00ffe603a136a9df7ecda9f43448c7bc723503e76eaec9ab8e9fe"
