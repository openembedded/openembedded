require xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- SiS display driver"
DEPENDS += " xineramaproto xf86miscproto xf86dgaproto drm xf86driproto"
PE = "1"

EXTRA_OECONF += " \
  ac_cv_file__usr_include_xorg_dri_h=yes \
  ac_cv_file__usr_include_xorg_sarea_h=yes \
  ac_cv_file__usr_include_xorg_dristruct_h=yes \
"
SRC_URI[archive.md5sum] = "f04baa307e49e9f0e5a5c3d2e89a5576"
SRC_URI[archive.sha256sum] = "3aad701799e355669b9027a9baedd623fe6b7ce93da9ac22b6902fd7e38128c2"
