require xorg-driver-video.inc
PE = "1"

DESCRIPTION = "X.Org X server -- AMD/ATI r5xx, r6xx display driver"

EXTRA_OECONF += " \
  ac_cv_file___src_AtomBios_includes_atombios_h=yes \
  ac_cv_file___src_AtomBios_includes_Decoder_h=yes \
"
SRC_URI[archive.md5sum] = "7b6641aa9d836f1621b9b220ad6771b8"
SRC_URI[archive.sha256sum] = "5adad675e60e973f2e3522a01457d9214157fbb5005090fe48092e6e5e698ad5"
