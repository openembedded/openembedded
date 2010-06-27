require xorg-driver-video.inc
DEPENDS += " drm xf86driproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "8161bbf2b100c21b609163f0010766b3"
SRC_URI[archive.sha256sum] = "3ad935ca0aa306d10d1e6125a6bd485a3948c184dcfda01670961dc4740ebf33"

EXTRA_OECONF += " \
  ac_cv_file__usr_include_xorg_dri_h=yes \
  ac_cv_file__usr_include_xorg_sarea_h=yes \
  ac_cv_file__usr_include_xorg_dristruct_h=yes \
"
