MESA_VER = "6.5.2"

require xorg-xserver-common.inc
PE = "1"
PR = "${INC_PR}.0"

SRC_URI += "file://drmfix.patch;patch=1 \
            file://glyphstr.patch;patch=1"

export LDFLAGS += " -ldl "

#DESCRIPTION = ""

#DEPENDS += " "
