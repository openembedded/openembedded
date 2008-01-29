DESCRIPTION = "Rage is a media center application based on EFL"
AUTHOR = "Carsten 'The Rasterman' Heitzler"
HOMEPAGE = "http://www.rasterman.com"
LICENSE = "MIT BSD"
DEPENDS = "evas ecore edje"
SECTION = "x11/multimedia"
PV = "0.3.0.042+cvs${SRCDATE}"

inherit autotools

SRC_URI = "${E_CVS};module=misc/rage"
S = "${WORKDIR}/rage"

