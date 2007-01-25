require xorg-xserver-common.inc

PR = "r2"

#DESCRIPTION = ""

#DEPENDS += " "

SRC_URI += " file://miext_layer_shadow_h.patch;patch=1 \
	file://xpconfig-parentdir.patch;patch=1"

