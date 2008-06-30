require xorg-doc-common.inc

DESCRIPTION = "The documentation in this package is from xc/doc in the monolithic \
source tree."

DEPENDS += " intltool"

PE = "1"

FILES_${PN} += " /usr/share/X11/doc"

EXTRA_OECONF += " ac_cv_file__usr_share_sgml_X11_defs_ent=no "
