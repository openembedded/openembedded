COMPILE_HERMES = "1"
DESCRIPTION = "A driver from Agera (a card manufacturer) for wireless LAN cards based on Hermes ${COMPILE_HERMES} cards."
PR = "r1"

inherit module

require wlags-modules_${PV}.inc

SRC_URI[md5sum] = "049c6c3d410e9f46884627b57485d3e7"
SRC_URI[sha256sum] = "a28c7ea94d57a5354b7de06cf5f6416d80a40596911c129d4b6a4087dc916831"
