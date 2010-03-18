require xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- SiS display driver"
DEPENDS += " xineramaproto xf86miscproto xf86dgaproto drm xf86driproto"
PE = "1"

EXTRA_OECONF += " \
  ac_cv_file__usr_include_xorg_dri_h=yes \
  ac_cv_file__usr_include_xorg_sarea_h=yes \
  ac_cv_file__usr_include_xorg_dristruct_h=yes \
"
SRC_URI[archive.md5sum] = "9f57c2f5ccbd8340db32da1c74083771"
SRC_URI[archive.sha256sum] = "11529f094cbdcdaba505596488eda623e0f0bd3c51139359d587ea58b6527307"
