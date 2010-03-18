require xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- Glint display driver"

DEPENDS += " xf86dgaproto drm xf86driproto"

EXTRA_OECONF += " \
  ac_cv_file__usr_include_xorg_dri_h=yes \
  ac_cv_file__usr_include_xorg_sarea_h=yes \
  ac_cv_file__usr_include_xorg_dristruct_h=yes \
"
SRC_URI[archive.md5sum] = "1f5271ac01d4475efe73ab6f2c3646f4"
SRC_URI[archive.sha256sum] = "a0edd1109c03efdb0f6defc18745f89fb3c11142381e2657f94d492ddd1e7419"
