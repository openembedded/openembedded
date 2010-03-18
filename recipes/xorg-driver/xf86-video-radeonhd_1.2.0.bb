require xorg-driver-video.inc
PE = "1"

DESCRIPTION = "X.Org X server -- AMD/ATI r5xx, r6xx display driver"

EXTRA_OECONF += " \
  ac_cv_file___src_AtomBios_includes_atombios_h=yes \
  ac_cv_file___src_AtomBios_includes_Decoder_h=yes \
"
SRC_URI[archive.md5sum] = "6a932ec17da9ce5a6d9000c1649c3a7e"
SRC_URI[archive.sha256sum] = "87c6353dd52bbe22d3a45f28fb39de1dd44f41568aaf8a9b0d45a7ed62313e27"
