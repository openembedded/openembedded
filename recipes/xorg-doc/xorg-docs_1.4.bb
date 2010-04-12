require xorg-doc-common.inc

DESCRIPTION = "The documentation in this package is from xc/doc in the monolithic \
source tree."

DEPENDS += " intltool"

PE = "1"

FILES_${PN} += " /usr/share/X11/doc"

EXTRA_OECONF += " ac_cv_file__usr_share_sgml_X11_defs_ent=no "

SRC_URI[archive.md5sum] = "4f2005bdd430a98c262901383459009e"
SRC_URI[archive.sha256sum] = "fffc67e50ce396e6ddd95e842fa8351954b8f09cb729a9a062e0496a8bda4925"
