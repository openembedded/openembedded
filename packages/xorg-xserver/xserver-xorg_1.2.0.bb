MESA_VER = "6.5.2"

require xorg-xserver-common.inc
PE = "1"
PR = "r3"

EXTRA_OECONF += " ac_cv_file__usr_share_sgml_X11_defs_ent=no "

export LDFLAGS += " -ldl "

#DESCRIPTION = ""

#DEPENDS += " "
