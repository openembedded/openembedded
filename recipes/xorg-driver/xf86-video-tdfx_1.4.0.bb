require xorg-driver-video.inc
PE = "1"

#DESCRIPTION = ""

DEPENDS += " drm xf86driproto"

EXTRA_OECONF += " \
  ac_cv_file__usr_include_xorg_dri_h=yes \
  ac_cv_file__usr_include_xorg_sarea_h=yes \
  ac_cv_file__usr_include_xorg_dristruct_h=yes \
"
SRC_URI[archive.md5sum] = "b13132f24683ef759bfb0c1db5096496"
SRC_URI[archive.sha256sum] = "c3be06d324f2e49ece1f243b10d7180a32fbe65dbbb81e162279c8608800dead"
