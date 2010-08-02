require xorg-driver-video.inc
DESCRIPTION = "X.Org X server -- SiS display driver"
DEPENDS += " xineramaproto xf86miscproto xf86dgaproto drm xf86driproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "dd930928b5ed7fcf34e3be4d43202ec7"
SRC_URI[archive.sha256sum] = "9b39b3e22fd2adab812fea06073c37971c7235c02c7f457bf8b60c1ae351c737"

EXTRA_OECONF += " \
  ac_cv_file__usr_include_xorg_dri_h=yes \
  ac_cv_file__usr_include_xorg_sarea_h=yes \
  ac_cv_file__usr_include_xorg_dristruct_h=yes \
"
