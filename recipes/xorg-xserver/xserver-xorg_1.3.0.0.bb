MESA_VER = "6.5.2"

require xorg-xserver-common.inc
PE = "1"
PR = "${INC_PR}.1"

SRC_URI += "file://drmfix.patch;patch=1 \
            file://glyphstr.patch;patch=1 \
            file://report-correct-randr12.patch;patch=1"

export LDFLAGS += " -ldl "

#DESCRIPTION = ""

#DEPENDS += " "

SRC_URI[archive.md5sum] = "a51a7d482e3c689394755bb17bda8526"
SRC_URI[archive.sha256sum] = "93c656f142f37607c15372dd24c5de9eab82cd79c5d60449174a928d345c2975"
