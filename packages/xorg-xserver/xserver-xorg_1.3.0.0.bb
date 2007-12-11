MESA_VER = "6.5.2"

require xorg-xserver-common.inc
PE = "1"
PR = "r4"

SRC_URI += "file://drmfix.patch;patch=1"

EXTRA_OECONF += " ac_cv_file__usr_share_X11_sgml_defs_ent=no "

export LDFLAGS += " -ldl "

#DESCRIPTION = ""

#DEPENDS += " "
