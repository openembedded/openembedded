require xorg-driver-video.inc
PE = "1"

DESCRIPTION = "X.Org X server -- Savage display driver"

DEPENDS += " drm xf86driproto"

EXTRA_OECONF += " \
  ac_cv_file__usr_include_xorg_dri_h=yes \
  ac_cv_file__usr_include_xorg_sarea_h=yes \
  ac_cv_file__usr_include_xorg_dristruct_h=yes \
"
SRC_URI[archive.md5sum] = "66c319f610e3699c3de0f3ef630abb32"
SRC_URI[archive.sha256sum] = "2b4adcdd820a6f3acba6f3c0995f5899edc8f5e33fb4c4666c4c7a78090ddaab"
