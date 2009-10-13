require xorg-driver-video.inc
PE = "1"

DESCRIPTION = "X.Org X server -- AMD/ATI r5xx, r6xx display driver"

EXTRA_OECONF += " \
  ac_cv_file___src_AtomBios_includes_atombios_h=yes \
  ac_cv_file___src_AtomBios_includes_Decoder_h=yes \
"
