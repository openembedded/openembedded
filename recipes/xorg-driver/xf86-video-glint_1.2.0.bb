require xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- Glint display driver"

DEPENDS += " xf86dgaproto drm xf86driproto"

EXTRA_OECONF += " \
  ac_cv_file__usr_include_xorg_dri_h=yes \
  ac_cv_file__usr_include_xorg_sarea_h=yes \
  ac_cv_file__usr_include_xorg_dristruct_h=yes \
"
