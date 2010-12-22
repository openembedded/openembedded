require xorg-doc-common.inc
DESCRIPTION = "The documentation in this package is from xc/doc in the monolithic \
source tree."
DEPENDS += " intltool"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "86101433834b485ab243f235757d7079"
SRC_URI[archive.sha256sum] = "f6b21bc486ab10fdf2bf1dfdf08f0aba22a4b87542165eeb395d0a6202f19d32"

EXTRA_OECONF += " ac_cv_file__usr_share_sgml_X11_defs_ent=no "

FILES_${PN} += " /usr/share/X11/doc"
