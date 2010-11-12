DESCRIPTION = "Cgreen is a unit test framework for C language"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPLv2"
DEPENDS = "flex-native"

S = "${WORKDIR}/${PN}-${PV}"

INC_PR = "r0"

BBCLASSEXTEND = "native sdk"

inherit cmake

