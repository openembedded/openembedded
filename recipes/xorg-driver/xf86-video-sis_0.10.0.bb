require xorg-driver-video.inc

DESCRIPTION = "X.Org X server -- SiS display driver"
DEPENDS += " xineramaproto xf86miscproto xf86dgaproto drm xf86driproto"
PE = "1"

EXTRA_OECONF += " \
  ac_cv_file__usr_include_xorg_dri_h=yes \
  ac_cv_file__usr_include_xorg_sarea_h=yes \
  ac_cv_file__usr_include_xorg_dristruct_h=yes \
"
SRC_URI[archive.md5sum] = "331d432dccccca91ec7da39ff6bf1218"
SRC_URI[archive.sha256sum] = "bcc0dcde5d469cc2500676e0ad29dcd12b1370066289902387ead762260e4b40"
