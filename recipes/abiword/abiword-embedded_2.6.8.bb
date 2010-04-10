require abiword-2.5.inc

EXTRA_OECONF += "--enable-embedded"

S = "${WORKDIR}/abiword-${PV}"

RCONFLICTS = "abiword"
RPROVIDES += "abiword"

SRC_URI[md5sum] = "fab04d8ef999c303f720197adf261310"
SRC_URI[sha256sum] = "b6656a0da13d94b334f02637c89d8fe13aa54752040ad1b8f14f668d8cb96e93"
