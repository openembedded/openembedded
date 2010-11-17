require xorg-doc-common.inc
DESCRIPTION = "The documentation in this package is from xc/doc in the monolithic \
source tree."
DEPENDS += " intltool"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "a6e37aeb9fa68aed4c514a946e058f18"
SRC_URI[archive.sha256sum] = "5382270cc181e315b762706d031de9f6f382d7b96dfff1e3d05426a53411ca96"

EXTRA_OECONF += " ac_cv_file__usr_share_sgml_X11_defs_ent=no "

FILES_${PN} += " /usr/share/X11/doc"
