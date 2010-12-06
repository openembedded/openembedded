require xorg-driver-video.inc
DESCRIPTION = "X.Org X server -- Savage display driver"
DEPENDS += " drm xf86driproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "09782fc710a1ce5a81c27d71951234c2"
SRC_URI[archive.sha256sum] = "54bde0077a2369fbdd42b0b25803f3c7147a58792997b14e45ee0b856199ddf1"

EXTRA_OECONF += " \
  ac_cv_file__usr_include_xorg_dri_h=yes \
  ac_cv_file__usr_include_xorg_sarea_h=yes \
  ac_cv_file__usr_include_xorg_dristruct_h=yes \
"
