MESA_VER = "6.5.2"

require xorg-xserver-common.inc
PE = "1"
PR = "${INC_PR}.1"

export LDFLAGS += " -ldl "

#DESCRIPTION = ""

#DEPENDS += " "

SRC_URI += "file://report-correct-randr10.patch;patch=1"