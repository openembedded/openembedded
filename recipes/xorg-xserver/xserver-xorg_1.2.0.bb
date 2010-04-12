MESA_VER = "6.5.2"

require xorg-xserver-common.inc
PE = "1"
PR = "${INC_PR}.1"

export LDFLAGS += " -ldl "

#DESCRIPTION = ""

#DEPENDS += " "

SRC_URI += "file://report-correct-randr10.patch;patch=1"
SRC_URI[archive.md5sum] = "ea291c89e68832d570d9d5e007218bd6"
SRC_URI[archive.sha256sum] = "e3e56b35ee13098f4ee79948beb20bfc9a06d1a7a35fb906405ff1531b92bb85"
