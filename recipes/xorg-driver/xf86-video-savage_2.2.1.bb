require xorg-driver-video.inc
PE = "1"

DESCRIPTION = "X.Org X server -- Savage display driver"

DEPENDS += " drm xf86driproto"

EXTRA_OECONF += " \
  ac_cv_file__usr_include_xorg_dri_h=yes \
  ac_cv_file__usr_include_xorg_sarea_h=yes \
  ac_cv_file__usr_include_xorg_dristruct_h=yes \
"
SRC_URI[archive.md5sum] = "62b8aba48b54eaefeae87df502bf219c"
SRC_URI[archive.sha256sum] = "adf95cae0fbaf72326c51c4c9e61486eef062bb1706f6ab46d942f2c36d8a37e"
