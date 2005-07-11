COMPILE_HERMES = "1"
DESCRIPTION = "A driver from Agera (a card manufacturer) for wireless LAN cards based on Hermes ${COMPILE_HERMES} cards."
PR = "r1"

inherit module

include wlags-modules_${PV}.inc
